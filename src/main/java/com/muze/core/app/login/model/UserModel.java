package com.muze.core.app.login.model;

import java.io.Serializable;
import java.util.Objects;

public class UserModel implements Serializable{
	
	private static final long serialVersionUID = -5181145797060585804L;
	private String userName;
	private String userCode;
	private String userPassword;
	private String type;
    private String id;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(userName, userModel.userName) &&
                Objects.equals(userCode, userModel.userCode) &&
                Objects.equals(userPassword, userModel.userPassword) &&
                Objects.equals(type, userModel.type) &&
                Objects.equals(id, userModel.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, userCode, userPassword, type, id);
    }

}
