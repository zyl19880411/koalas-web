package com.muze.core.app.hforder.dao;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.BaseDao;
import com.muze.core.app.hferror.model.HfOrderError;
import com.muze.core.app.hflisten.model.HfListen;
import com.muze.core.app.hforder.model.HfOrder;
import com.muze.core.app.hfsucess.model.HfSuccess;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

public interface HfOrderMapper extends BaseDao<HfOrder, Long> {

    public PageList<HfOrder> selectResult(HfOrder request, PageBounds pageBounds);

    @Select("select count(1) from hf_order a where a.student_id = #{code} limit 1")
    public int selectByCode(@Param("code") String code);

    @Select("select count(1) from hf_order a where a.student_id = #{code} and a.id != #{id} limit 1")
    public int selectByCodeForUpdate(@Param("code") String code, @Param("id") long id);

    @Update(" update hf_order set student_id=#{studentId}," +
            " student_name = #{studentName}," +
            " student_phone = #{studentPhone}," +
            " gaokao_year = #{gaokaoYear,jdbcType=DATE}," +
            " love_subject = #{loveSubject,jdbcType=VARCHAR}," +
            " channel = #{channel,jdbcType=VARCHAR}," +
            " backup =  #{backup,jdbcType=LONGVARCHAR}," +
            " u_time =  now()" +
            " where  id = #{id,jdbcType=BIGINT}")
    public int updateOrder(HfOrder hfOrder);

    @Update("update hf_order set valid = 0 where id = #{id}")
    public int delOrder(@Param("id") long id);

    @Update("update hf_order_error set valid = 0 where order_id = #{id}")
    public int delErrOrder(@Param("id") long id);

    @Update("update hf_listen set valid = 0,u_time=now() where order_id = #{id}")
    public int dellistenerOrder(@Param("id") long id);

    @Update("update hf_success set valid = 0 where order_id = #{id}")
    public int delsuccessOrder(@Param("id") long id);

    //试听
    @Update("update hf_order set if_listener = 1 where id = #{id}")
    public int updateOrder2Lis(@Param("id") long id);

    @InsertProvider(type = OrderBuildSqlClass.class, method = "insertOrderLinsten")
    public int insertOrderLinsten(HfListen hfListen);

    //成单
    @Update("update hf_order set if_success = 1 where id = #{id}")
    public int updateOrder2success(@Param("id") long id);

    @Select("select count(1) from hf_success where contract_numbe = #{contractNumbe} limit 1")
    public int checkSuccesContract(@Param("contractNumbe") String contractNumbe);

    @InsertProvider(type = OrderBuildSqlClass.class, method = "insertOrderSuceess")
    public int insertOrderSuceess(HfSuccess hfSuccess);

    //转介绍
    @Update("update hf_order set if_introduction =1,introduction_type =#{introductionType},introduction_name=#{introductionId} where id = #{id}")
    public int updateOrderintroduction(HfOrder hfOrder);

    //失去单号
    @Update("update hf_order set if_error = 0   where id = #{orderId}")
    public int updateOrderError(HfOrderError hfOrderError);

    @InsertProvider(type = OrderBuildSqlClass.class, method = "insertOrderError")
    public int insertOrderError(HfOrderError hfOrderError);

    public static class OrderBuildSqlClass {

        public String insertOrderLinsten(final HfListen hfListen) {

            return new SQL() {{
                INSERT_INTO("hf_listen");
                VALUES("order_id", "#{orderId,jdbcType=BIGINT}");
                VALUES("listen_subject", "#{listenSubject,jdbcType=VARCHAR}");
                VALUES("listen_time", "#{listenTime,jdbcType=TIMESTAMP}");
                VALUES("teacher", "#{teacher,jdbcType=VARCHAR}");
                VALUES("teacher_phone", "#{teacherPhone,jdbcType=VARCHAR}");
                VALUES("c_time", "now()");
                VALUES("if_bounced","1");
                VALUES("valid", "1");

                if (hfListen.getArea() != null) {
                    VALUES("area", "#{area,jdbcType=VARCHAR}");
                }
                if (hfListen.getNj() != null) {
                    VALUES("nj", "#{nj,jdbcType=VARCHAR}");
                }
                if (hfListen.getTeacherInfo() != null) {
                    VALUES("teacher_info", "#{teacherInfo,jdbcType=LONGVARCHAR}");
                }

            }}.toString();
        }

        public String insertOrderSuceess(final HfSuccess hfSuccess) {

            return new SQL() {
                {
                    INSERT_INTO("hf_success");
                    VALUES("order_id", "#{orderId,jdbcType=BIGINT}");
                    VALUES("close_v_time", "#{closeVTime,jdbcType=TIMESTAMP}");
                    VALUES("contract_numbe", " #{contractNumbe,jdbcType=VARCHAR}");
                    VALUES("class_hour", "#{classHour,jdbcType=INTEGER}");
                    VALUES("order_money", "#{orderMoney,jdbcType=DECIMAL}");
                    if (hfSuccess.getGift() != null) {
                        VALUES("gift", "#{gift,jdbcType=VARCHAR}");
                    }
                    VALUES("pay_status", "#{payStatus,jdbcType=VARCHAR}");
                    VALUES("c_time", "now()");
                    VALUES("pay_time", "#{payTime,jdbcType=TIMESTAMP}");
                    VALUES("valid", "1");
                }

            }.toString();

        }

        public String insertOrderError(final HfOrderError hfOrderError) {

            return new SQL() {
                {
                    INSERT_INTO("hf_order_error");
                    VALUES("order_id", "#{orderId}");
                    VALUES("error_id", "#{errorId}");
                    VALUES("c_time", "now()");
                    VALUES("valid", "1");
                }
            }.toString();
        }
    }
}