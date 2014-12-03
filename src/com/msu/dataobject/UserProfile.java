package com.msu.dataobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the user_profile database table.
 * 
 */
@Entity
@Table(name = "user_profile")
@NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "admin_flag")
	private String adminFlag;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "message_admin_flag")
	private String messageAdminFlag;

	@Column(name = "modify_user")
	private String modifyUser;

	@Column(name = "pay_agent_locator_flag")
	private String payAgentLocatorFlag;

	@Column(name = "screen_management")
	private String screenManagement;

	public UserProfile() {
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdminFlag() {
		return this.adminFlag;
	}

	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getMessageAdminFlag() {
		return this.messageAdminFlag;
	}

	public void setMessageAdminFlag(String messageAdminFlag) {
		this.messageAdminFlag = messageAdminFlag;
	}

	public String getModifyUser() {
		return this.modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getPayAgentLocatorFlag() {
		return this.payAgentLocatorFlag;
	}

	public void setPayAgentLocatorFlag(String payAgentLocatorFlag) {
		this.payAgentLocatorFlag = payAgentLocatorFlag;
	}

	public String getScreenManagement() {
		return this.screenManagement;
	}

	public void setScreenManagement(String screenManagement) {
		this.screenManagement = screenManagement;
	}

}