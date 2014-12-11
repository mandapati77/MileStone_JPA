package com.msu.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.msu.dao.IMessageDAO;
import com.msu.dataobject.Message;
import com.msu.dbutil.DBManager;

public class MessageDAOImpl implements IMessageDAO {

	@Override
	public boolean insert(Message message) {
		boolean insertFlag	=	false;
		try {
			insertFlag	=	DBManager.insertEntity(message);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while inserted the record into the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while inserted the record into the Database", e);
		}
		return insertFlag;
	}

	@Override
	public boolean delete(Message message) {
		boolean deleteFlag	=	false;
		try {
			deleteFlag	=	DBManager.deleteEntity(message);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while deleting the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while deleting the record from the Database", e);
		}
		return deleteFlag;
	}

	@Override
	public boolean update(Message message) {
		boolean updateFlag	=	false;
		try {
			updateFlag	=	DBManager.updateEntity(message);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while udpating the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while upating the record from the Database", e);
		}
		return updateFlag;
	}

	@Override
	public List<Message> getAllMessages() {
		EntityManager entityManager	=	DBManager.getEntityManager();
		List<Message> messageList =	entityManager.createNamedQuery("Message.findAll",Message.class).getResultList();
		entityManager.close();
		return messageList;
	}

	@Override
	public List<Message> getMessageByModuleSeqNo(long moduleSeqNo) {
		StringBuffer mesgSeqNoQuery	=	new StringBuffer();
		mesgSeqNoQuery.append(" SELECT m FROM Message m WHERE m.mcsspModuleSeqNum = :moduleSeqNo ");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<Message> query = entityManager.createQuery(mesgSeqNoQuery.toString(), Message.class);
		query.setParameter(":moduleSeqNo", moduleSeqNo);
		
		return query.getResultList();
	}

	@Override
	public Message getMessageBySeqNo(long seqNo) {
		StringBuffer mesgSeqNoQuery	=	new StringBuffer();
		mesgSeqNoQuery.append(" SELECT m FROM Message m WHERE m.mcsspMesgSeqNum = :seqNo ");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<Message> query = entityManager.createQuery(mesgSeqNoQuery.toString(), Message.class);
		query.setParameter(":seqNo", seqNo);
		
		return query.getSingleResult();
	}

	@Override
	public List<Message> getMessageByDesc(String messageDesc) {
		EntityManager entityManager	=	DBManager.getEntityManager();
		String messageQueryByLike	=	"SELECT m FROM Message m WHERE m.mcsspMesgDesc like :messageDesc ";
		
		Query query = entityManager.createQuery(messageQueryByLike,Message.class);
	    query.setParameter("messageDesc", "%"+messageDesc+"%");
	    
	    List<Message> messageList	=	query.getResultList();
	    
		entityManager.close();
		return messageList;
	}

}
