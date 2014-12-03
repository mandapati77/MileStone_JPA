package com.msu.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;

import com.msu.dao.IMessageAuditDAO;
import com.msu.dataobject.MessageAudit;
import com.msu.dbutil.DBManager;

public class MessageAuditDAOImpl implements IMessageAuditDAO {

	@Override
	public boolean insert(MessageAudit messageAudit) {
		boolean insertFlag	=	false;
		try {
			insertFlag	=	DBManager.insertEntity(messageAudit);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while inserted the record into the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while inserted the record into the Database", e);
		}
		return insertFlag;
	}

	@Override
	public boolean delete(MessageAudit messageAudit) {
		boolean deleteFlag	=	false;
		try {
			deleteFlag	=	DBManager.deleteEntity(messageAudit);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while deleting the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while deleting the record from the Database", e);
		}
		return deleteFlag;
	}

	@Override
	public boolean update(MessageAudit messageAudit) {
		boolean updateFlag	=	false;
		try {
			updateFlag	=	DBManager.deleteEntity(messageAudit);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while udpating the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while upating the record from the Database", e);
		}
		return updateFlag;
	}

	@Override
	public List<MessageAudit> getAllMessages() {
		EntityManager entityManager	=	DBManager.getEntityManager();
		List<MessageAudit> messageAuditList =	entityManager.createNamedQuery("McsspMesgAudit.findAll",MessageAudit.class).getResultList();
		entityManager.close();
		return messageAuditList;
	}

	@Override
	public List<MessageAudit> getMessageByModuleSeqNo(long moduleSeqNo) {
		StringBuffer mesgModuleSeqNoQuery	=	new StringBuffer();
		mesgModuleSeqNoQuery.append("SELECT m FROM McsspMesgAudit mma WHERE mma.mcsspAuditModuleSeqNum = :moduleSeqNo");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<MessageAudit> msgTypedQuery = entityManager.createQuery(mesgModuleSeqNoQuery.toString(), MessageAudit.class);
		msgTypedQuery.setParameter(":moduleSeqNo", moduleSeqNo);
		
		return msgTypedQuery.getResultList();
	}

	@Override
	public MessageAudit getMessageBySeqNo(long moduleSeqNo, long mesgSeqNo) {
		StringBuffer mesgSeqNoQuery	=	new StringBuffer();
		mesgSeqNoQuery.append(" SELECT m FROM McsspMesgAudit mma WHERE mma.mcsspAuditModuleSeqNum = :moduleSeqNo ");
		mesgSeqNoQuery.append(" and mma.mcsspAuditMesgSeqNum = :mesgSeqNo ");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<MessageAudit> query = entityManager.createQuery(mesgSeqNoQuery.toString(), MessageAudit.class);
		query.setParameter(":moduleSeqNo", moduleSeqNo);
		query.setParameter(":mesgSeqNo", mesgSeqNo);
		
		return query.getSingleResult();
	}

	@Override
	public List<MessageAudit> getMessageByDesc(String messageDesc) {
		StringBuffer mesgByDescQuery	=	new StringBuffer();
		mesgByDescQuery.append("SELECT m FROM McsspMesgAudit mma WHERE mma.mcsspAuditMesgDesc like :messageDesc");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<MessageAudit> query = entityManager.createQuery(mesgByDescQuery.toString(), MessageAudit.class);
		query.setParameter(":messageDesc", "%"+messageDesc+"%");
		
		return query.getResultList();
	}

}
