package com.msu.dataobject;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the MCSSP_MODULE database table.
 * 
 */
@Entity
@Table(name="MCSSP_MODULE")
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	//@SequenceGenerator(name="MCSSP_MODULE_MCSSPMODULESEQNUM_GENERATOR", sequenceName="MODULE_SEQ")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MCSSP_MODULE_MCSSPMODULESEQNUM_GENERATOR")
	@Id
	@GeneratedValue(generator="MCSSP_MODULE_SEQ_NO_GENERATOR")
	@TableGenerator(table="MCSSP_ID_GEN",pkColumnName="GEN_NAME", valueColumnName="GEN_VALUE",pkColumnValue="MESG_SEQ_NO",name="MCSSP_MODULE_SEQ_NO_GENERATOR", allocationSize=1)
	@Column(name="MCSSP_MODULE_SEQ_NUM")
	private long mcsspModuleSeqNum;

	@Column(name="MCSSP_MODULE_ACTIVE_IND")
	private String mcsspModuleActiveInd;

	@Temporal(TemporalType.DATE)
	@Column(name="MCSSP_MODULE_ACTIVITY_DATE")
	private Date mcsspModuleActivityDate;

	@Column(name="MCSSP_MODULE_DESC")
	private String mcsspModuleDesc;

	@Column(name="MCSSP_MODULE_NAME")
	private String mcsspModuleName;

	@Column(name="MCSSP_MODULE_USER_ID")
	private String mcsspModuleUserId;

	public Module() {
	}

	public long getMcsspModuleSeqNum() {
		return this.mcsspModuleSeqNum;
	}

	public void setMcsspModuleSeqNum(long mcsspModuleSeqNum) {
		this.mcsspModuleSeqNum = mcsspModuleSeqNum;
	}

	public String getMcsspModuleActiveInd() {
		return this.mcsspModuleActiveInd;
	}

	public void setMcsspModuleActiveInd(String mcsspModuleActiveInd) {
		this.mcsspModuleActiveInd = mcsspModuleActiveInd;
	}

	public Date getMcsspModuleActivityDate() {
		return this.mcsspModuleActivityDate;
	}

	public void setMcsspModuleActivityDate(Date mcsspModuleActivityDate) {
		this.mcsspModuleActivityDate = mcsspModuleActivityDate;
	}

	public String getMcsspModuleDesc() {
		return this.mcsspModuleDesc;
	}

	public void setMcsspModuleDesc(String mcsspModuleDesc) {
		this.mcsspModuleDesc = mcsspModuleDesc;
	}

	public String getMcsspModuleName() {
		return this.mcsspModuleName;
	}

	public void setMcsspModuleName(String mcsspModuleName) {
		this.mcsspModuleName = mcsspModuleName;
	}

	public String getMcsspModuleUserId() {
		return this.mcsspModuleUserId;
	}

	public void setMcsspModuleUserId(String mcsspModuleUserId) {
		this.mcsspModuleUserId = mcsspModuleUserId;
	}

	@Override
	public String toString() {
		return "Module [mcsspModuleSeqNum=" + mcsspModuleSeqNum
				+ ", mcsspModuleActiveInd=" + mcsspModuleActiveInd
				+ ", mcsspModuleActivityDate=" + mcsspModuleActivityDate
				+ ", mcsspModuleDesc=" + mcsspModuleDesc + ", mcsspModuleName="
				+ mcsspModuleName + ", mcsspModuleUserId=" + mcsspModuleUserId
				+ "]";
	}
	
	

}