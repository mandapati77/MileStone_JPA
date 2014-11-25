package com.msu.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msu.dao.IUserProfileDAO;
import com.msu.dataobject.UserProfile;

public class UserProfileTest {
	
	static ApplicationContext context	=	null;
	static IUserProfileDAO userprofileDao	=	null;
	
	static {
		context	=	new ClassPathXmlApplicationContext("com/mus/beans/msu_beans.xml");
		userprofileDao	=	(IUserProfileDAO) context.getBean("userProfileDao");
	}
	
	@Test
	public void testInsertUserProfile() {
		UserProfile insertUserProfileObj	=	new UserProfile();
		insertUserProfileObj.setUserId("Gopikrishna75");
		insertUserProfileObj.setAdminFlag("N");
		insertUserProfileObj.setMessageAdminFlag("N");
		insertUserProfileObj.setPayAgentLocatorFlag("N");
		insertUserProfileObj.setScreenManagement("N");
		insertUserProfileObj.setCreateUser("TestUser");
		
		boolean insertFlag	=	userprofileDao.insert(insertUserProfileObj);
		if(insertFlag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
	
	@Test
	public void testUpdateUserProfile() {
		UserProfile updateUserProfileObj	=	new UserProfile();
		updateUserProfileObj.setUserId("Gopikrishna75");
		updateUserProfileObj.setAdminFlag("Y");
		updateUserProfileObj.setMessageAdminFlag("Y");
		updateUserProfileObj.setPayAgentLocatorFlag("Y");
		updateUserProfileObj.setScreenManagement("Y");
		
		boolean updateFlag	=	 userprofileDao.update(updateUserProfileObj);
		
		if(updateFlag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
	
	@Test
	public void getAllUserProfiles() {
		List<UserProfile> profiles	= userprofileDao.getAllUserProfiles();
		for(UserProfile profile: profiles) {
			System.out.println(profile.getUserId());
			System.out.println(profile.getAdminFlag());
		}
	}
	
	@Test
	public void getUserProfileById() {
		UserProfile profile	=	userprofileDao.getUserProfileById("Gopikrishna 71");
		if(null != profile ) {
			System.out.println(profile.getUserId());
			System.out.println(profile.getAdminFlag());
		}
	}
	
	@Test
	public void testDeleteUserProfile() {
		UserProfile deleteUserProfileObj	=	new UserProfile();
		deleteUserProfileObj.setUserId("Gopikrishna75");
		boolean deleteFlag	=	 userprofileDao.delete(deleteUserProfileObj);
		
		if(deleteFlag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
}