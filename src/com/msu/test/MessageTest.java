package com.msu.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msu.dao.IMessageDAO;
import com.msu.dataobject.Message;
import com.msu.dataobject.MessageVO;

public class MessageTest {

	static ApplicationContext context	=	null;
	static IMessageDAO messageDao	=	null;
	
	static {
		context	=	new ClassPathXmlApplicationContext("com/mus/beans/msu_beans.xml");
		messageDao	=	(IMessageDAO) context.getBean("messageDao");
	}
	
	@Test
	public void testInsert() {

		Message message	=	new Message();
		message.setMcsspModuleSeqNum(new BigDecimal(255));
		message.setMcsspModuleName("Account Notifications");
		message.setMcsspMesgCode("RJT-00001");
		message.setMcsspMesgCodeType("E");
		message.setMcsspMesgActiveInd("Y");
		message.setMcsspMesgEditInd("Y");
		message.setMcsspMesgDesc("The city and / or zip code you entered is not valid according to the U.S. Post Office. Please verify the information and try again. The city and / or zip code you entered is not valid according to the U.S. Post Office. Please verify the information and try again.");
		message.setMcsspMesgUserId("Gopikrishna");
		message.setMcsspMesgActivityDate(new Date());
		
		boolean insertFlag	=	messageDao.insert(message);
		if(insertFlag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
	
	public void testDelete() {
		Message message	=	new Message();
		message.setMcsspModuleSeqNum(new BigDecimal(255));
		message.setMcsspModuleName("Account Notifications");
		message.setMcsspMesgCode("RJT-00001");
		message.setMcsspMesgSeqNum(2);
		
		boolean deleteFlag	=	messageDao.delete(message);
		if(deleteFlag) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
	
	@Test
	public void tesGetMessageBySeqNo() {
		
		Message messageObj	=	messageDao.getMessageBySeqNo(2);
		if(null != messageObj) {
			System.out.println(messageObj);
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
	
	@Test
	public void testGetMessageByModuleSeqNo() {
		long moduleSeqNo	=	255;
		List<Message> messageList	=	messageDao.getMessageByModuleSeqNo(moduleSeqNo);
		if(null != messageList) {
			System.out.println(messageList);
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}

	@Test
	public void testGetMessageByDesc() {
		String messageDesc	=	"The city";
		List<MessageVO> messageList	=	messageDao.getMessageByDesc(messageDesc);
		if(null != messageList) {
			System.out.println(messageList);
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}
	
}
