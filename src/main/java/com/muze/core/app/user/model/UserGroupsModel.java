package com.muze.core.app.user.model;

import com.muze.core.app.utils.RandomIDUtil;

public class UserGroupsModel {

	private String id = RandomIDUtil.getRandomID(32);
	
	private String doc_id;
	
	private String group_id;
	
	private String group_name;
	
	private String remarks;
	
	private String ischecked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		result = prime * result
				+ ((group_id == null) ? 0 : group_id.hashCode());
		result = prime * result
				+ ((group_name == null) ? 0 : group_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ischecked == null) ? 0 : ischecked.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
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
		UserGroupsModel other = (UserGroupsModel) obj;
		if (doc_id == null) {
			if (other.doc_id != null)
				return false;
		} else if (!doc_id.equals(other.doc_id))
			return false;
		if (group_id == null) {
			if (other.group_id != null)
				return false;
		} else if (!group_id.equals(other.group_id))
			return false;
		if (group_name == null) {
			if (other.group_name != null)
				return false;
		} else if (!group_name.equals(other.group_name))
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
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserGroupsModel [id=" + id + ", doc_id=" + doc_id
				+ ", group_id=" + group_id + ", group_name=" + group_name
				+ ", remarks=" + remarks + ", ischecked=" + ischecked + "]";
	}
}
