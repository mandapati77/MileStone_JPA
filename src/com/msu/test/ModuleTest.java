package com.msu.test;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msu.dao.IModuleDAO;
import com.msu.dataobject.Module;

public class ModuleTest {
	
	static ApplicationContext context	=	null;
	static IModuleDAO moduleDao	=	null;
	
	static {
		context	=	new ClassPathXmlApplicationContext("com/mus/beans/msu_beans.xml");
		moduleDao	=	(IModuleDAO) context.getBean("moduleDao");
	}
	
	/*@Test
	public void testInsertModule() {
		
		Module module	=	new Module();
		module.setMcsspModuleName("Billing");
		module.setMcsspModuleDesc("Billing Module");
		module.setMcsspModuleUserId("Gopikrishna");
		module.setMcsspModuleActiveInd("Y");
		module.setMcsspModuleActivityDate(new Date());
		
		boolean insertFlag	=	moduleDao.insert(module);
		if(insertFlag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
	
	@Test
	public void testUpdateModule() {
		Module module	=	new Module();
		module.setMcsspModuleSeqNum(102);
		module.setMcsspModuleName("Billing");
		module.setMcsspModuleDesc("Billing Module 77");
		module.setMcsspModuleUserId("Gopikrishna");
		module.setMcsspModuleActiveInd("N");
		module.setMcsspModuleActivityDate(new Date());
		
		boolean updateFlag	=	moduleDao.update(module);
		if(updateFlag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}*/
	
	/*@Test
	public void getAllUserProfiles() {
		List<UserProfile> profiles	= moduleDao.getAllUserProfiles();
		for(UserProfile profile: profiles) {
			System.out.println(profile.getUserId());
			System.out.println(profile.getAdminFlag());
		}
	}
	
	@Test
	public void getUserProfileById() {
		UserProfile profile	=	moduleDao.getUserProfileById("Gopikrishna 71");
		if(null != profile ) {
			System.out.println(profile.getUserId());
			System.out.println(profile.getAdminFlag());
		}
	}
	*/
	
	@Test
	public void testDeleteModule() {
		Module deleteModuleObj	=	new Module();

		deleteModuleObj.setMcsspModuleSeqNum(1452);

		boolean deleteFlag	=	 moduleDao.delete(deleteModuleObj);
		
		if(deleteFlag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
}