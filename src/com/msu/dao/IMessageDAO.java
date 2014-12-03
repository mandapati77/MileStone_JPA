package com.msu.dao;

import java.util.List;

import com.msu.dataobject.Message;

public interface IMessageDAO {

	public boolean insert(Message message);

	public boolean delete(Message message);

	public boolean update(Message message);

	public List<Message> getAllMessages();

	public List<Message> getMessageByModuleSeqNo(long moduleSeqNo);

	public Message getMessageBySeqNo(long mesgSeqNo);

	public List<Message> getMessageByDesc(String messageDesc);

}
