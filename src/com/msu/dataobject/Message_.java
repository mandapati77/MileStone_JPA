package com.msu.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-01-09T23:13:47.008+0530")
@StaticMetamodel(Message.class)
public class Message_ {
	public static volatile SingularAttribute<Message, Long> mcsspMesgSeqNum;
	public static volatile SingularAttribute<Message, String> mcsspMesgActiveInd;
	public static volatile SingularAttribute<Message, Date> mcsspMesgActivityDate;
	public static volatile SingularAttribute<Message, String> mcsspMesgCode;
	public static volatile SingularAttribute<Message, String> mcsspMesgCodeType;
	public static volatile SingularAttribute<Message, String> mcsspMesgDesc;
	public static volatile SingularAttribute<Message, String> mcsspMesgEditInd;
	public static volatile SingularAttribute<Message, String> mcsspMesgUserId;
	public static volatile SingularAttribute<Message, String> mcsspModuleName;
	public static volatile SingularAttribute<Message, BigDecimal> mcsspModuleSeqNum;
}
