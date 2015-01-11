package com.msu.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-01-09T23:57:57.456+0530")
@StaticMetamodel(MessageAudit.class)
public class MessageAudit_ {
	public static volatile SingularAttribute<MessageAudit, Date> mcsspAuditActivityDate;
	public static volatile SingularAttribute<MessageAudit, String> mcsspAuditMesgActiveInd;
	public static volatile SingularAttribute<MessageAudit, String> mcsspAuditMesgCode;
	public static volatile SingularAttribute<MessageAudit, String> mcsspAuditMesgCodeType;
	public static volatile SingularAttribute<MessageAudit, String> mcsspAuditMesgDesc;
	public static volatile SingularAttribute<MessageAudit, String> mcsspAuditMesgEditInd;
	public static volatile SingularAttribute<MessageAudit, Long> mcsspAuditMesgSeqNum;
	public static volatile SingularAttribute<MessageAudit, Long> mcsspAuditModuleSeqNum;
	public static volatile SingularAttribute<MessageAudit, BigDecimal> mcsspAuditRevison;
	public static volatile SingularAttribute<MessageAudit, String> mcsspAuditUserId;
}
