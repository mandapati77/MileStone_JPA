package com.msu.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MessageVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal mcsspMesgSeqNum;

	private String mcsspMesgActiveInd;

	private Date mcsspMesgActivityDate;

	private String mcsspMesgCode;

	private String mcsspMesgCodeType;

	private String mcsspMesgDesc;

	private String mcsspMesgEditInd;

	private String mcsspMesgUserId;

	private String mcsspModuleName;

	private BigDecimal mcsspModuleSeqNum;
	
	private BigDecimal mcsspTotalRevision;

	public MessageVO(BigDecimal mcsspMesgSeqNum, String mcsspMesgActiveInd,
			Date mcsspMesgActivityDate, String mcsspMesgCode,
			String mcsspMesgCodeType, String mcsspMesgDesc,
			String mcsspMesgEditInd, String mcsspMesgUserId,
			String mcsspModuleName, BigDecimal mcsspModuleSeqNum, BigDecimal mcsspTotalRevision) {
		super();
		this.mcsspMesgSeqNum = mcsspMesgSeqNum;
		this.mcsspMesgActiveInd = mcsspMesgActiveInd;
		this.mcsspMesgActivityDate = mcsspMesgActivityDate;
		this.mcsspMesgCode = mcsspMesgCode;
		this.mcsspMesgCodeType = mcsspMesgCodeType;
		this.mcsspMesgDesc = mcsspMesgDesc;
		this.mcsspMesgEditInd = mcsspMesgEditInd;
		this.mcsspMesgUserId = mcsspMesgUserId;
		this.mcsspModuleName = mcsspModuleName;
		this.mcsspModuleSeqNum = mcsspModuleSeqNum;
		this.setMcsspTotalRevision(mcsspTotalRevision);
	}

	public BigDecimal getMcsspMesgSeqNum() {
		return this.mcsspMesgSeqNum;
	}

	public void setMcsspMesgSeqNum(BigDecimal mcsspMesgSeqNum) {
		this.mcsspMesgSeqNum = mcsspMesgSeqNum;
	}

	public String getMcsspMesgActiveInd() {
		return this.mcsspMesgActiveInd;
	}

	public void setMcsspMesgActiveInd(String mcsspMesgActiveInd) {
		this.mcsspMesgActiveInd = mcsspMesgActiveInd;
	}

	public Date getMcsspMesgActivityDate() {
		return this.mcsspMesgActivityDate;
	}

	public void setMcsspMesgActivityDate(Date mcsspMesgActivityDate) {
		this.mcsspMesgActivityDate = mcsspMesgActivityDate;
	}

	public String getMcsspMesgCode() {
		return this.mcsspMesgCode;
	}

	public void setMcsspMesgCode(String mcsspMesgCode) {
		this.mcsspMesgCode = mcsspMesgCode;
	}

	public String getMcsspMesgCodeType() {
		return this.mcsspMesgCodeType;
	}

	public void setMcsspMesgCodeType(String mcsspMesgCodeType) {
		this.mcsspMesgCodeType = mcsspMesgCodeType;
	}

	public String getMcsspMesgDesc() {
		return this.mcsspMesgDesc;
	}

	public void setMcsspMesgDesc(String mcsspMesgDesc) {
		this.mcsspMesgDesc = mcsspMesgDesc;
	}

	public String getMcsspMesgEditInd() {
		return this.mcsspMesgEditInd;
	}

	public void setMcsspMesgEditInd(String mcsspMesgEditInd) {
		this.mcsspMesgEditInd = mcsspMesgEditInd;
	}

	public String getMcsspMesgUserId() {
		return this.mcsspMesgUserId;
	}

	public void setMcsspMesgUserId(String mcsspMesgUserId) {
		this.mcsspMesgUserId = mcsspMesgUserId;
	}

	public String getMcsspModuleName() {
		return this.mcsspModuleName;
	}

	public void setMcsspModuleName(String mcsspModuleName) {
		this.mcsspModuleName = mcsspModuleName;
	}

	public BigDecimal getMcsspModuleSeqNum() {
		return this.mcsspModuleSeqNum;
	}

	public void setMcsspModuleSeqNum(BigDecimal mcsspModuleSeqNum) {
		this.mcsspModuleSeqNum = mcsspModuleSeqNum;
	}

	public BigDecimal getMcsspTotalRevision() {
		return mcsspTotalRevision;
	}

	public void setMcsspTotalRevision(BigDecimal mcsspTotalRevision) {
		this.mcsspTotalRevision = mcsspTotalRevision;
	}

	@Override
	public String toString() {
		return "MessageVO [mcsspMesgSeqNum=" + mcsspMesgSeqNum
				+ ", mcsspMesgActiveInd=" + mcsspMesgActiveInd
				+ ", mcsspMesgActivityDate=" + mcsspMesgActivityDate
				+ ", mcsspMesgCode=" + mcsspMesgCode + ", mcsspMesgCodeType="
				+ mcsspMesgCodeType + ", mcsspMesgDesc=" + mcsspMesgDesc
				+ ", mcsspMesgEditInd=" + mcsspMesgEditInd
				+ ", mcsspMesgUserId=" + mcsspMesgUserId + ", mcsspModuleName="
				+ mcsspModuleName + ", mcsspModuleSeqNum=" + mcsspModuleSeqNum
				+ ", mcsspTotalRevision=" + mcsspTotalRevision + "]";
	}

}