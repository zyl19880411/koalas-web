package com.muze.core.app.user.model;

import com.muze.core.app.utils.RandomIDUtil;

public class UserRolesModel {

	private String id = RandomIDUtil.getRandomID(32);
	private String role_id;
	private String doc_id;
	private String role_name;
	private String role_remark;
	private String ischecked;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_remark() {
		return role_remark;
	}
	public void setRole_remark(String role_remark) {
		this.role_remark = role_remark;
	}
	public String getIschecked() {
		return ischecked;
	}
	public void setIschecked(String ischecked) {
		this.ischecked = ischecked;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doc_id == null) ? 0 : doc_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ischecked == null) ? 0 : ischecked.hashCode());
		result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
		result = prime * result
				+ ((role_name == null) ? 0 : role_name.hashCode());
		result = prime * result
				+ ((role_remark == null) ? 0 : role_remark.hashCode());
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
		UserRolesModel other = (UserRolesModel) obj;
		if (doc_id == null) {
			if (other.doc_id != null)
				return false;
		} else if (!doc_id.equals(other.doc_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ischecked == null) {
			if (other.ischecked != null)
				return false;
		} else if (!ischecked.equals(other.ischecked))
			return false;
		if (role_id == null) {
			if (other.role_id != null)
				return false;
		} else if (!role_id.equals(other.role_id))
			return false;
		if (role_name == null) {
			if (other.role_name != null)
				return false;
		} else if (!role_name.equals(other.role_name))
			return false;
		if (role_remark == null) {
			if (other.role_remark != null)
				return false;
		} else if (!role_remark.equals(other.role_remark))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserRolesDto [id=" + id + ", role_id=" + role_id + ", doc_id="
				+ doc_id + ", role_name=" + role_name + ", role_remark="
				+ role_remark + ", ischecked=" + ischecked + "]";
	}
	
	
	
}
