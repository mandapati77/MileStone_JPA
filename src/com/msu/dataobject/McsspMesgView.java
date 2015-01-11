package com.msu.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the MCSSP_MESG_VIEW database table.
 * 
 */
@Entity
@Table(name = "MCSSP_MESG_VIEW")
@NamedQuery(name = "McsspMesgView.findAll", query = "SELECT m FROM McsspMesgView m order by m.mesgViewRevisonNum")
public class McsspMesgView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name = "MESG_VIEW_ACTIVITY_DATE")
	private Date mesgViewActivityDate;

	@Column(name = "MESG_VIEW_MESG_ACTIVE_IND")
	private String mesgViewMesgActiveInd;

	@Column(name = "MESG_VIEW_MESG_CODE")
	private String mesgViewMesgCode;

	@Column(name = "MESG_VIEW_MESG_CODE_TYPE")
	private String mesgViewMesgCodeType;

	@Column(name = "MESG_VIEW_MESG_DESC")
	private String mesgViewMesgDesc;

	@Column(name = "MESG_VIEW_MESG_EDIT_IND")
	private String mesgViewMesgEditInd;

	@Column(name = "MESG_VIEW_MESG_SEQ_NUM")
	private BigDecimal mesgViewMesgSeqNum;

	@Column(name = "MESG_VIEW_MODULE_NAME")
	private String mesgViewModuleName;

	@Column(name = "MESG_VIEW_MODULE_SEQ_NUM")
	private BigDecimal mesgViewModuleSeqNum;

	@Id
	@Column(name = "MESG_VIEW_REVISON_NUM")
	private BigDecimal mesgViewRevisonNum;

	@Column(name = "MESG_VIEW_USER_ID")
	private String mesgViewUserId;

	public McsspMesgView() {
	}

	public Date getMesgViewActivityDate() {
		return this.mesgViewActivityDate;
	}

	public void setMesgViewActivityDate(Date mesgViewActivityDate) {
		this.mesgViewActivityDate = mesgViewActivityDate;
	}

	public String getMesgViewMesgActiveInd() {
		return this.mesgViewMesgActiveInd;
	}

	public void setMesgViewMesgActiveInd(String mesgViewMesgActiveInd) {
		this.mesgViewMesgActiveInd = mesgViewMesgActiveInd;
	}

	public String getMesgViewMesgCode() {
		return this.mesgViewMesgCode;
	}

	public void setMesgViewMesgCode(String mesgViewMesgCode) {
		this.mesgViewMesgCode = mesgViewMesgCode;
	}

	public String getMesgViewMesgCodeType() {
		return this.mesgViewMesgCodeType;
	}

	public void setMesgViewMesgCodeType(String mesgViewMesgCodeType) {
		this.mesgViewMesgCodeType = mesgViewMesgCodeType;
	}

	public String getMesgViewMesgDesc() {
		return this.mesgViewMesgDesc;
	}

	public void setMesgViewMesgDesc(String mesgViewMesgDesc) {
		this.mesgViewMesgDesc = mesgViewMesgDesc;
	}

	public String getMesgViewMesgEditInd() {
		return this.mesgViewMesgEditInd;
	}

	public void setMesgViewMesgEditInd(String mesgViewMesgEditInd) {
		this.mesgViewMesgEditInd = mesgViewMesgEditInd;
	}

	public BigDecimal getMesgViewMesgSeqNum() {
		return this.mesgViewMesgSeqNum;
	}

	public void setMesgViewMesgSeqNum(BigDecimal mesgViewMesgSeqNum) {
		this.mesgViewMesgSeqNum = mesgViewMesgSeqNum;
	}

	public String getMesgViewModuleName() {
		return this.mesgViewModuleName;
	}

	public void setMesgViewModuleName(String mesgViewModuleName) {
		this.mesgViewModuleName = mesgViewModuleName;
	}

	public BigDecimal getMesgViewModuleSeqNum() {
		return this.mesgViewModuleSeqNum;
	}

	public void setMesgViewModuleSeqNum(BigDecimal mesgViewModuleSeqNum) {
		this.mesgViewModuleSeqNum = mesgViewModuleSeqNum;
	}

	public BigDecimal getMesgViewRevisonNum() {
		return this.mesgViewRevisonNum;
	}

	public void setMesgViewRevisonNum(BigDecimal mesgViewRevisonNum) {
		this.mesgViewRevisonNum = mesgViewRevisonNum;
	}

	public String getMesgViewUserId() {
		return this.mesgViewUserId;
	}

	public void setMesgViewUserId(String mesgViewUserId) {
		this.mesgViewUserId = mesgViewUserId;
	}

	@Override
	public String toString() {
		return "McsspMesgView [mesgViewActivityDate=" + mesgViewActivityDate
				+ ", mesgViewMesgActiveInd=" + mesgViewMesgActiveInd
				+ ", mesgViewMesgCode=" + mesgViewMesgCode
				+ ", mesgViewMesgCodeType=" + mesgViewMesgCodeType
				+ ", mesgViewMesgDesc=" + mesgViewMesgDesc
				+ ", mesgViewMesgEditInd=" + mesgViewMesgEditInd
				+ ", mesgViewMesgSeqNum=" + mesgViewMesgSeqNum
				+ ", mesgViewModuleName=" + mesgViewModuleName
				+ ", mesgViewModuleSeqNum=" + mesgViewModuleSeqNum
				+ ", mesgViewRevisonNum=" + mesgViewRevisonNum
				+ ", mesgViewUserId=" + mesgViewUserId + "]";
	}
	
}