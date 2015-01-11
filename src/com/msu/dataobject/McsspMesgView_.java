package com.msu.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-01-09T23:13:46.883+0530")
@StaticMetamodel(McsspMesgView.class)
public class McsspMesgView_ {
	public static volatile SingularAttribute<McsspMesgView, Date> mesgViewActivityDate;
	public static volatile SingularAttribute<McsspMesgView, String> mesgViewMesgActiveInd;
	public static volatile SingularAttribute<McsspMesgView, String> mesgViewMesgCode;
	public static volatile SingularAttribute<McsspMesgView, String> mesgViewMesgCodeType;
	public static volatile SingularAttribute<McsspMesgView, String> mesgViewMesgDesc;
	public static volatile SingularAttribute<McsspMesgView, String> mesgViewMesgEditInd;
	public static volatile SingularAttribute<McsspMesgView, BigDecimal> mesgViewMesgSeqNum;
	public static volatile SingularAttribute<McsspMesgView, String> mesgViewModuleName;
	public static volatile SingularAttribute<McsspMesgView, BigDecimal> mesgViewModuleSeqNum;
	public static volatile SingularAttribute<McsspMesgView, BigDecimal> mesgViewRevisonNum;
	public static volatile SingularAttribute<McsspMesgView, String> mesgViewUserId;
}
