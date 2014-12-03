package com.msu.dao;

import java.util.List;

import com.msu.dataobject.MessageAudit;

public interface IMessageAuditDAO {
	
	public boolean insert(MessageAudit mesgAudit);

	public boolean delete(MessageAudit mesgAudit);

	public boolean update(MessageAudit mesgAudit);

	public List<MessageAudit> getAllMessages();

	public List<MessageAudit> getMessageByModuleSeqNo(long moduleSeqNo);
	
	public MessageAudit getMessageBySeqNo(long moduleSeqNo, long mesgSeqNo);
	
	public List<MessageAudit> getMessageByDesc(String messageDesc);

}
