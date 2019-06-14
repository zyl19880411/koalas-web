package com.muze.core.app.permission.model;

public class PermissionModel {

	private String id;
	private String org_id;
	private String org_name;
	private String permissionID;
	private String _parentId;
	private String name;
	private String code;
	private String iconCls;
	private String url;
	private String elementType;
	private String create_time;
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getPermissionID() {
		return permissionID;
	}
	public void setPermissionID(String permissionID) {
		this.permissionID = permissionID;
	}
	public String get_parentId() {
		return _parentId;
	}
	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getElementType() {
		return elementType;
	}
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_parentId == null) ? 0 : _parentId.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result
				+ ((elementType == null) ? 0 : elementType.hashCode());
		result = prime * result + ((iconCls == null) ? 0 : iconCls.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((org_id == null) ? 0 : org_id.hashCode());
		result = prime * result
				+ ((org_name == null) ? 0 : org_name.hashCode());
		result = prime * result
				+ ((permissionID == null) ? 0 : permissionID.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		PermissionModel other = (PermissionModel) obj;
		if (_parentId == null) {
			if (other._parentId != null)
				return false;
		} else if (!_parentId.equals(other._parentId))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (elementType == null) {
			if (other.elementType != null)
				return false;
		} else if (!elementType.equals(other.elementType))
			return false;
		if (iconCls == null) {
			if (other.iconCls != null)
				return false;
		} else if (!iconCls.equals(other.iconCls))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (permissionID == null) {
			if (other.permissionID != null)
				return false;
		} else if (!permissionID.equals(other.permissionID))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PermissionModel [id=" + id + ", org_id=" + org_id
				+ ", org_name=" + org_name + ", permissionID=" + permissionID
				+ ", _parentId=" + _parentId + ", name=" + name + ", code="
				+ code + ", iconCls=" + iconCls + ", url=" + url
				+ ", elementType=" + elementType + ", create_time="
				+ create_time + ", remark=" + remark + "]";
	}
	
}
