package com.muze.core.app.hflisten.dao;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.muze.core.app.common.dao.BaseDao;
import com.muze.core.app.hflisten.model.HfListen;
import com.muze.core.app.hforder.model.HfOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;

public interface HfListenMapper extends BaseDao<HfListen,Long> {

    public PageList<HfListen> selectResult(HfOrder request, PageBounds pageBounds);

    @Update("update hf_listen set valid=0 where order_id = #{id}")
    public int deleteListen(@Param("id") String id);

    @Update("update hf_order set if_listener=0 where id =#{id}")
    public int deleteOrder(@Param("id") String id);

    @Update("update hf_listen set if_bounced=0,ifbounced_time=now() where id=#{id}")
    public int bounced(@Param("id") String id);

    @Update("update hf_listen set if_bounced=1,ifbounced_time=null where id=#{id}")
    public int unbounced(@Param("id") String id);

    @UpdateProvider(type =OrderBuildSqlClass.class,method="UpdateOrderLinsten")
    public int updatelisten(HfListen hfListen);

    public static class OrderBuildSqlClass {
        public String UpdateOrderLinsten(final HfListen hfListen) {

            return new SQL() {{
                UPDATE("hf_listen");
                SET("listen_subject=#{listenSubject,jdbcType=VARCHAR}");
                SET("listen_time=#{listenTime,jdbcType=TIMESTAMP}");
                SET("teacher=#{teacher,jdbcType=VARCHAR}");
                SET("teacher_phone=#{teacherPhone,jdbcType=VARCHAR}");
                SET("u_time=now()");
                SET("area=#{area,jdbcType=VARCHAR}");
                SET("nj=#{nj,jdbcType=VARCHAR}");
                SET("teacher_info=#{teacherInfo,jdbcType=LONGVARCHAR}");
                WHERE("id=#{id}");


            }}.toString();

        }
    }
}