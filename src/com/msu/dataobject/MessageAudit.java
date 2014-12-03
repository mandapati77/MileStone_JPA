package com.msu.dataobject;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MCSSP_MESG_AUDIT database table.
 * 
 */
@Entity
@Table(name="MCSSP_MESG_AUDIT")
@NamedQuery(name="McsspMesgAudit.findAll", query="SELECT m FROM MessageAudit m")
public class MessageAudit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="MCSSP_AUDIT_ACTIVITY_DATE")
	private Date mcsspAuditActivityDate;

	@Column(name="MCSSP_AUDIT_MESG_ACTIVE_IND")
	private String mcsspAuditMesgActiveInd;

	@Column(name="MCSSP_AUDIT_MESG_CODE_TYPE")
	private String mcsspAuditMesgCodeType;

	@Column(name="MCSSP_AUDIT_MESG_DESC")
	private String mcsspAuditMesgDesc;

	@Column(name="MCSSP_AUDIT_MESG_EDIT_IND")
	private String mcsspAuditMesgEditInd;

	@Column(name="MCSSP_AUDIT_MESG_SEQ_NUM")
	private long mcsspAuditMesgSeqNum;

	@Column(name="MCSSP_AUDIT_MODULE_SEQ_NUM")
	private long mcsspAuditModuleSeqNum;

	@Column(name="MCSSP_AUDIT_REVISON")
	private BigDecimal mcsspAuditRevison;

	@Column(name="MCSSP_AUDIT_USER_ID")
	private String mcsspAuditUserId;

	public MessageAudit() {
	}

	public Date getMcsspAuditActivityDate() {
		return this.mcsspAuditActivityDate;
	}

	public void setMcsspAuditActivityDate(Date mcsspAuditActivityDate) {
		this.mcsspAuditActivityDate = mcsspAuditActivityDate;
	}

	public String getMcsspAuditMesgActiveInd() {
		return this.mcsspAuditMesgActiveInd;
	}

	public void setMcsspAuditMesgActiveInd(String mcsspAuditMesgActiveInd) {
		this.mcsspAuditMesgActiveInd = mcsspAuditMesgActiveInd;
	}

	public String getMcsspAuditMesgCodeType() {
		return this.mcsspAuditMesgCodeType;
	}

	public void setMcsspAuditMesgCodeType(String mcsspAuditMesgCodeType) {
		this.mcsspAuditMesgCodeType = mcsspAuditMesgCodeType;
	}

	public String getMcsspAuditMesgDesc() {
		return this.mcsspAuditMesgDesc;
	}

	public void setMcsspAuditMesgDesc(String mcsspAuditMesgDesc) {
		this.mcsspAuditMesgDesc = mcsspAuditMesgDesc;
	}

	public String getMcsspAuditMesgEditInd() {
		return this.mcsspAuditMesgEditInd;
	}

	public void setMcsspAuditMesgEditInd(String mcsspAuditMesgEditInd) {
		this.mcsspAuditMesgEditInd = mcsspAuditMesgEditInd;
	}

	public long getMcsspAuditMesgSeqNum() {
		return this.mcsspAuditMesgSeqNum;
	}

	public void setMcsspAuditMesgSeqNum(long mcsspAuditMesgSeqNum) {
		this.mcsspAuditMesgSeqNum = mcsspAuditMesgSeqNum;
	}

	public long getMcsspAuditModuleSeqNum() {
		return this.mcsspAuditModuleSeqNum;
	}

	public void setMcsspAuditModuleSeqNum(long mcsspAuditModuleSeqNum) {
		this.mcsspAuditModuleSeqNum = mcsspAuditModuleSeqNum;
	}

	public BigDecimal getMcsspAuditRevison() {
		return this.mcsspAuditRevison;
	}

	public void setMcsspAuditRevison(BigDecimal mcsspAuditRevison) {
		this.mcsspAuditRevison = mcsspAuditRevison;
	}

	public String getMcsspAuditUserId() {
		return this.mcsspAuditUserId;
	}

	public void setMcsspAuditUserId(String mcsspAuditUserId) {
		this.mcsspAuditUserId = mcsspAuditUserId;
	}

}