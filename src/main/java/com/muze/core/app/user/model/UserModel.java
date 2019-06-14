package com.muze.core.app.user.model;

//用户实体类
public class UserModel {

	// 医生编号
	private String doc_id;
	// 医生名称
	private String doc_name;
	//登录名称
	private String login_name;
	// 性别
	private String gender;
	// 生日
	private String birth_date;
	// 身份证号
	private String cardid;
	// 注册时间
	private String req_time;
	// qq
	private String qq;
	// 电话
	private String tel;
	// 电话
	private String phone;
	// 所属机构
	private String org_name;
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getReq_time() {
		return req_time;
	}
	public void setReq_time(String req_time) {
		this.req_time = req_time;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birth_date == null) ? 0 : birth_date.hashCode());
		result = prime * result + ((cardid == null) ? 0 : cardid.hashCode());
		result = prime * result + ((doc_id == null) ? 0 : doc_id.hashCode());
		result = prime * result
				+ ((doc_name == null) ? 0 : doc_name.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((login_name == null) ? 0 : login_name.hashCode());
		result = prime * result
				+ ((org_name == null) ? 0 : org_name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
		result = prime * result
				+ ((req_time == null) ? 0 : req_time.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (birth_date == null) {
			if (other.birth_date != null)
				return false;
		} else if (!birth_date.equals(other.birth_date))
			return false;
		if (cardid == null) {
			if (other.cardid != null)
				return false;
		} else if (!cardid.equals(other.cardid))
			return false;
		if (doc_id == null) {
			if (other.doc_id != null)
				return false;
		} else if (!doc_id.equals(other.doc_id))
			return false;
		if (doc_name == null) {
			if (other.doc_name != null)
				return false;
		} else if (!doc_name.equals(other.doc_name))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (login_name == null) {
			if (other.login_name != null)
				return false;
		} else if (!login_name.equals(other.login_name))
			return false;
		if (org_name == null) {
			if (other.org_name != null)
				return false;
		} else if (!org_name.equals(other.org_name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		if (req_time == null) {
			if (other.req_time != null)
				return false;
		} else if (!req_time.equals(other.req_time))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDto [doc_id=" + doc_id + ", doc_name=" + doc_name
				+ ", login_name=" + login_name + ", gender=" + gender
				+ ", birth_date=" + birth_date + ", cardid=" + cardid
				+ ", req_time=" + req_time + ", qq=" + qq + ", tel=" + tel
				+ ", phone=" + phone + ", org_name=" + org_name + "]";
	}

}
