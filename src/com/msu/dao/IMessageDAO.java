package com.msu.dao;

import java.util.List;

import com.msu.dataobject.Message;
import com.msu.dataobject.MessageVO;

public interface IMessageDAO {

	public boolean insert(Message message);

	public boolean delete(Message message);

	public boolean update(Message message);

	public List<Message> getAllMessages();

	public List<Message> getMessageByModuleSeqNo(long moduleSeqNo);

	public Message getMessageBySeqNo(long mesgSeqNo);
	
	public List<Message> getMessageByMesgCode(String mesgCode);

	public List<MessageVO> getMessageByDesc(String messageDesc);
	
	public List<Message> getMessageByApplicationName(String appName);
	
	public List<Message> getMessageByDateRange(String dateRange);

}
