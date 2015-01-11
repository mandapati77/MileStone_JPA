package com.msu.dataobject;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-01-09T23:13:47.014+0530")
@StaticMetamodel(Module.class)
public class Module_ {
	public static volatile SingularAttribute<Module, Long> mcsspModuleSeqNum;
	public static volatile SingularAttribute<Module, String> mcsspModuleActiveInd;
	public static volatile SingularAttribute<Module, Date> mcsspModuleActivityDate;
	public static volatile SingularAttribute<Module, String> mcsspModuleDesc;
	public static volatile SingularAttribute<Module, String> mcsspModuleName;
	public static volatile SingularAttribute<Module, String> mcsspModuleUserId;
}
