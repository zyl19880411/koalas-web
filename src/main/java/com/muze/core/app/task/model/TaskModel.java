package com.muze.core.app.task.model;

import java.io.Serializable;

public class TaskModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private String task_id;
	private String task_name;
	private String task_url;
	private String task_expression;
	private String task_state;
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getTask_url() {
		return task_url;
	}
	public void setTask_url(String task_url) {
		this.task_url = task_url;
	}
	public String getTask_expression() {
		return task_expression;
	}
	public void setTask_expression(String task_expression) {
		this.task_expression = task_expression;
	}
	public String getTask_state() {
		return task_state;
	}
	public void setTask_state(String task_state) {
		this.task_state = task_state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((task_expression == null) ? 0 : task_expression.hashCode());
		result = prime * result + ((task_id == null) ? 0 : task_id.hashCode());
		result = prime * result
				+ ((task_name == null) ? 0 : task_name.hashCode());
		result = prime * result
				+ ((task_state == null) ? 0 : task_state.hashCode());
		result = prime * result
				+ ((task_url == null) ? 0 : task_url.hashCode());
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
		TaskModel other = (TaskModel) obj;
		if (task_expression == null) {
			if (other.task_expression != null)
				return false;
		} else if (!task_expression.equals(other.task_expression))
			return false;
		if (task_id == null) {
			if (other.task_id != null)
				return false;
		} else if (!task_id.equals(other.task_id))
			return false;
		if (task_name == null) {
			if (other.task_name != null)
				return false;
		} else if (!task_name.equals(other.task_name))
			return false;
		if (task_state == null) {
			if (other.task_state != null)
				return false;
		} else if (!task_state.equals(other.task_state))
			return false;
		if (task_url == null) {
			if (other.task_url != null)
				return false;
		} else if (!task_url.equals(other.task_url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TaskModel [task_id=" + task_id + ", task_name=" + task_name
				+ ", task_url=" + task_url + ", task_expression="
				+ task_expression + ", task_state=" + task_state + "]";
	}

}
