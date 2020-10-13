package com.muze.core.app.hflisten.model;

import com.muze.core.app.hforder.model.HfOrder;

import java.util.Date;
import java.util.List;

public class HfListen {

    private HfOrder hfOrder;

    public HfOrder getHfOrder() {
        return hfOrder;
    }

    public void setHfOrder(HfOrder hfOrder) {
        this.hfOrder = hfOrder;
    }

    public List<String> getDocids() {
        return docids;
    }

    public void setDocids(List<String> docids) {
        this.docids = docids;
    }

    private String hforderisme;

    public String getHforderisme() {
        return hforderisme;
    }

    public void setHforderisme(String hforderisme) {
        this.hforderisme = hforderisme;
    }

    private List<String> docids;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.order_id
     *
     * @mbggenerated
     */
    private Long orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.area
     *
     * @mbggenerated
     */
    private String area;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.nj
     *
     * @mbggenerated
     */
    private String nj;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.listen_subject
     *
     * @mbggenerated
     */
    private String listenSubject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.listen_time
     *
     * @mbggenerated
     */
    private Date listenTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.teacher
     *
     * @mbggenerated
     */
    private String teacher;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.teacher_phone
     *
     * @mbggenerated
     */
    private String teacherPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.if_bounced
     *
     * @mbggenerated
     */
    private Boolean ifBounced;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.ifbounced_time
     *
     * @mbggenerated
     */
    private Date ifbouncedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.c_time
     *
     * @mbggenerated
     */
    private Date cTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.u_time
     *
     * @mbggenerated
     */
    private Date uTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.valid
     *
     * @mbggenerated
     */
    private Integer valid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hf_listen.teacher_info
     *
     * @mbggenerated
     */
    private String teacherInfo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.id
     *
     * @return the value of hf_listen.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.id
     *
     * @param id the value for hf_listen.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.order_id
     *
     * @return the value of hf_listen.order_id
     *
     * @mbggenerated
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.order_id
     *
     * @param orderId the value for hf_listen.order_id
     *
     * @mbggenerated
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.area
     *
     * @return the value of hf_listen.area
     *
     * @mbggenerated
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.area
     *
     * @param area the value for hf_listen.area
     *
     * @mbggenerated
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.nj
     *
     * @return the value of hf_listen.nj
     *
     * @mbggenerated
     */
    public String getNj() {
        return nj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.nj
     *
     * @param nj the value for hf_listen.nj
     *
     * @mbggenerated
     */
    public void setNj(String nj) {
        this.nj = nj == null ? null : nj.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.listen_subject
     *
     * @return the value of hf_listen.listen_subject
     *
     * @mbggenerated
     */
    public String getListenSubject() {
        return listenSubject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.listen_subject
     *
     * @param listenSubject the value for hf_listen.listen_subject
     *
     * @mbggenerated
     */
    public void setListenSubject(String listenSubject) {
        this.listenSubject = listenSubject == null ? null : listenSubject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.listen_time
     *
     * @return the value of hf_listen.listen_time
     *
     * @mbggenerated
     */
    public Date getListenTime() {
        return listenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.listen_time
     *
     * @param listenTime the value for hf_listen.listen_time
     *
     * @mbggenerated
     */
    public void setListenTime(Date listenTime) {
        this.listenTime = listenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.teacher
     *
     * @return the value of hf_listen.teacher
     *
     * @mbggenerated
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.teacher
     *
     * @param teacher the value for hf_listen.teacher
     *
     * @mbggenerated
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.teacher_phone
     *
     * @return the value of hf_listen.teacher_phone
     *
     * @mbggenerated
     */
    public String getTeacherPhone() {
        return teacherPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.teacher_phone
     *
     * @param teacherPhone the value for hf_listen.teacher_phone
     *
     * @mbggenerated
     */
    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone == null ? null : teacherPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.if_bounced
     *
     * @return the value of hf_listen.if_bounced
     *
     * @mbggenerated
     */
    public Boolean getIfBounced() {
        return ifBounced;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.if_bounced
     *
     * @param ifBounced the value for hf_listen.if_bounced
     *
     * @mbggenerated
     */
    public void setIfBounced(Boolean ifBounced) {
        this.ifBounced = ifBounced;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.ifbounced_time
     *
     * @return the value of hf_listen.ifbounced_time
     *
     * @mbggenerated
     */
    public Date getIfbouncedTime() {
        return ifbouncedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.ifbounced_time
     *
     * @param ifbouncedTime the value for hf_listen.ifbounced_time
     *
     * @mbggenerated
     */
    public void setIfbouncedTime(Date ifbouncedTime) {
        this.ifbouncedTime = ifbouncedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.c_time
     *
     * @return the value of hf_listen.c_time
     *
     * @mbggenerated
     */
    public Date getcTime() {
        return cTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.c_time
     *
     * @param cTime the value for hf_listen.c_time
     *
     * @mbggenerated
     */
    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.u_time
     *
     * @return the value of hf_listen.u_time
     *
     * @mbggenerated
     */
    public Date getuTime() {
        return uTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.u_time
     *
     * @param uTime the value for hf_listen.u_time
     *
     * @mbggenerated
     */
    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.valid
     *
     * @return the value of hf_listen.valid
     *
     * @mbggenerated
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.valid
     *
     * @param valid the value for hf_listen.valid
     *
     * @mbggenerated
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hf_listen.teacher_info
     *
     * @return the value of hf_listen.teacher_info
     *
     * @mbggenerated
     */
    public String getTeacherInfo() {
        return teacherInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hf_listen.teacher_info
     *
     * @param teacherInfo the value for hf_listen.teacher_info
     *
     * @mbggenerated
     */
    public void setTeacherInfo(String teacherInfo) {
        this.teacherInfo = teacherInfo == null ? null : teacherInfo.trim();
    }
}