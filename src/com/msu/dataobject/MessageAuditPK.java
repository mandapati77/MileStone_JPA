package com.msu.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MessageAuditPK implements Serializable{

	@Column(name="MCSSP_AUDIT_MESG_SEQ_NUM")
	private long mcsspAuditMesgSeqNum;

	@Column(name="MCSSP_AUDIT_MODULE_SEQ_NUM")
	private long mcsspAuditModuleSeqNum;

	@Column(name="MCSSP_AUDIT_REVISON")
	private BigDecimal mcsspAuditRevison;

	@Override
	public String toString() {
		return "MessageAuditPK [mcsspAuditMesgSeqNum=" + mcsspAuditMesgSeqNum
				+ ", mcsspAuditModuleSeqNum=" + mcsspAuditModuleSeqNum
				+ ", mcsspAuditRevison=" + mcsspAuditRevison + "]";
	}

	public MessageAuditPK() {
		
	}
	
	public MessageAuditPK(long mcsspAuditMesgSeqNum,
			long mcsspAuditModuleSeqNum, BigDecimal mcsspAuditRevison) {
		super();
		this.mcsspAuditMesgSeqNum = mcsspAuditMesgSeqNum;
		this.mcsspAuditModuleSeqNum = mcsspAuditModuleSeqNum;
		this.mcsspAuditRevison = mcsspAuditRevison;
	}
	
}
