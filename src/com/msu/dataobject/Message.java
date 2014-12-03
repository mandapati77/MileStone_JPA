package com.msu.dataobject;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the MCSSP_MESG database table.
 * 
 */
@Entity
@Table(name = "MCSSP_MESG")
@NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MCSSP_MESG_MCSSPMESGSEQNUM_GENERATOR", sequenceName = "MESSAGE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MCSSP_MESG_MCSSPMESGSEQNUM_GENERATOR")
	@Column(name = "MCSSP_MESG_SEQ_NUM")
	private long mcsspMesgSeqNum;

	@Column(name = "MCSSP_MESG_ACTIVE_IND")
	private String mcsspMesgActiveInd;

	@Temporal(TemporalType.DATE)
	@Column(name = "MCSSP_MESG_ACTIVITY_DATE")
	private Date mcsspMesgActivityDate;

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

}