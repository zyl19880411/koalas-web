package com.muze.core.app.org.model;

public class OrgModel {

	private String org_id;
	private String _parentId;
	private String org_name;
	private String tel;
	private String link_name;
	private String link_phone;
	private String address;
	private String create_time;
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String get_parentId() {
		return _parentId;
	}
	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLink_name() {
		return link_name;
	}
	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}
	public String getLink_phone() {
		return link_phone;
	}
	public void setLink_phone(String link_phone) {
		this.link_phone = link_phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_parentId == null) ? 0 : _parentId.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result
				+ ((link_name == null) ? 0 : link_name.hashCode());
		result = prime * result
				+ ((link_phone == null) ? 0 : link_phone.hashCode());
		result = prime * result + ((org_id == null) ? 0 : org_id.hashCode());
		result = prime * result
				+ ((org_name == null) ? 0 : org_name.hashCode());
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
		OrgModel other = (OrgModel) obj;
		if (_parentId == null) {
			if (other._parentId != null)
				return false;
		} else if (!_parentId.equals(other._parentId))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (link_name == null) {
			if (other.link_name != null)
				return false;
		} else if (!link_name.equals(other.link_name))
			return false;
		if (link_phone == null) {
			if (other.link_phone != null)
				return false;
		} else if (!link_phone.equals(other.link_phone))
			return false;
		if (org_id == null) {
			if (other.org_id != null)
				return false;
		} else if (!org_id.equals(other.org_id))
			return false;
		if (org_name == null) {
			if (other.org_name != null)
				return false;
		} else if (!org_name.equals(other.org_name))
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
		return "OrgModel [org_id=" + org_id + ", _parentId=" + _parentId
				+ ", org_name=" + org_name + ", tel=" + tel + ", link_name="
				+ link_name + ", link_phone=" + link_phone + ", address="
				+ address + ", create_time=" + create_time + "]";
	}
	
	
}
