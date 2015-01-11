package com.msu.dataobject;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-01-09T23:13:47.012+0530")
@StaticMetamodel(MessageAuditPK.class)
public class MessageAuditPK_ {
	public static volatile SingularAttribute<MessageAuditPK, Long> mcsspAuditMesgSeqNum;
	public static volatile SingularAttribute<MessageAuditPK, Long> mcsspAuditModuleSeqNum;
	public static volatile SingularAttribute<MessageAuditPK, BigDecimal> mcsspAuditRevison;
}
