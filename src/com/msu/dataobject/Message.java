package com.msu.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

/**
 * The persistent class for the MCSSP_MESG database table.
 * 
 */
@Entity
@Table(name = "MCSSP_MESG")
@NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	//@SequenceGenerator(name = "MCSSP_MESG_MCSSPMESGSEQNUM_GENERATOR", sequenceName = "MESSAGE_SEQ")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MCSSP_MESG_MCSSPMESGSEQNUM_GENERATOR")
	@Id
	@GeneratedValue(generator="MESG_SEQ_NO")
	@TableGenerator(name="MESG_SEQ_NO",table="MCSSP_ID_GEN", valueColumnName="GEN_NAME",pkColumnName="GEN_NAME",pkColumnValue="MESG_SEQ_NO")
	@Column(name = "MCSSP_MESG_SEQ_NUM")
	private long mcsspMesgSeqNum;

	@Column(name = "MCSSP_MESG_ACTIVE_IND")
	private String mcsspMesgActiveInd;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "MCSSP_MESG_ACTIVITY_DATE")
	private Date mcsspMesgActivityDate;

	@NotNull
	@Column(name = "MCSSP_MESG_CODE")
	private String mcsspMesgCode;

	@Column(name = "MCSSP_MESG_CODE_TYPE")
	private String mcsspMesgCodeType;

	@Column(name = "MCSSP_MESG_DESC")
	private String mcsspMesgDesc;

	@Column(name = "MCSSP_MESG_EDIT_IND")
	private String mcsspMesgEditInd;

	@Column(name = "MCSSP_MESG_USER_ID")
	private String mcsspMesgUserId;

	@Column(name = "MCSSP_MODULE_NAME")
	private String mcsspModuleName;

	@Column(name = "MCSSP_MODULE_SEQ_NUM")
	private BigDecimal mcsspModuleSeqNum;
	
	@Transient
	private BigDecimal mcsspTotalRevision;

	public Message() {
	}

	public long getMcsspMesgSeqNum() {
		return this.mcsspMesgSeqNum;
	}

	public void setMcsspMesgSeqNum(long mcsspMesgSeqNum) {
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

	@Override
	public String toString() {
		return "Message [mcsspMesgSeqNum=" + mcsspMesgSeqNum
				+ ", mcsspMesgActiveInd=" + mcsspMesgActiveInd
				+ ", mcsspMesgActivityDate=" + mcsspMesgActivityDate
				+ ", mcsspMesgCode=" + mcsspMesgCode + ", mcsspMesgCodeType="
				+ mcsspMesgCodeType + ", mcsspMesgDesc=" + mcsspMesgDesc
				+ ", mcsspMesgEditInd=" + mcsspMesgEditInd
				+ ", mcsspMesgUserId=" + mcsspMesgUserId + ", mcsspModuleName="
				+ mcsspModuleName + ", mcsspModuleSeqNum=" + mcsspModuleSeqNum
				+ "]";
	}

	public BigDecimal getMcsspTotalRevision() {
		return mcsspTotalRevision;
	}

	public void setMcsspTotalRevision(BigDecimal mcsspTotalRevision) {
		this.mcsspTotalRevision = mcsspTotalRevision;
	}

	
}