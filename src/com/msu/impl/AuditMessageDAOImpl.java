package com.msu.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.msu.dao.IAuditMessageDAO;
import com.msu.dataobject.MessageAudit;
import com.msu.dbutil.DBManager;

public class AuditMessageDAOImpl implements IAuditMessageDAO {

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
		mesgModuleSeqNoQuery.append("SELECT mma FROM McsspMesgAudit mma WHERE mma.mcsspAuditModuleSeqNum = :moduleSeqNo");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<MessageAudit> msgTypedQuery = entityManager.createQuery(mesgModuleSeqNoQuery.toString(), MessageAudit.class);
		msgTypedQuery.setParameter(":moduleSeqNo", moduleSeqNo);
		
		return msgTypedQuery.getResultList();
	}

	@Override
	public MessageAudit getMessageBySeqNo(long moduleSeqNo, long mesgSeqNo) {
		StringBuffer mesgSeqNoQuery	=	new StringBuffer();
		mesgSeqNoQuery.append(" SELECT mma FROM McsspMesgAudit mma WHERE mma.mcsspAuditModuleSeqNum = :moduleSeqNo ");
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
		mesgByDescQuery.append("SELECT mma FROM McsspMesgAudit mma WHERE mma.mcsspAuditMesgDesc like :messageDesc");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<MessageAudit> query = entityManager.createQuery(mesgByDescQuery.toString(), MessageAudit.class);
		query.setParameter(":messageDesc", "%"+messageDesc+"%");
		
		return query.getResultList();
	}

	
	public static void main(String[] args) {
		AuditMessageDAOImpl auditDAOImpl	=	new AuditMessageDAOImpl();
		List<MessageAudit> audit	=	auditDAOImpl.getMessageByVersionId(1, "GK123111");
		System.out.println(audit); 
	}
	
	@Override
	public List<MessageAudit> getMessageByVersionId(int versionSeqNo, String mesgCode) {
		StringBuffer mesgByDescQuery	=	new StringBuffer();
		//mesgByDescQuery.append("SELECT mma FROM MessageAudit mma WHERE mma.mcsspAuditMesgCode = :mesgCode order by mma.mcsspAuditRevison");
		
		mesgByDescQuery.append("SELECT * \n");
		mesgByDescQuery.append("FROM \n");
		mesgByDescQuery.append("  (SELECT ROW_NUMBER() over(ORDER BY MCSSP_AUDIT_REVISON) AS row_num, \n");
		mesgByDescQuery.append("    m.* \n");
		mesgByDescQuery.append("  FROM mcssp_mesg_audit m \n");
		mesgByDescQuery.append("  WHERE (m.MCSSP_AUDIT_MESG_CODE = \'").append(mesgCode).append("\')");
		mesgByDescQuery.append("  ) \n");
		mesgByDescQuery.append("WHERE row_num = ").append(versionSeqNo);
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		//TypedQuery<MessageAudit> query = entityManager.createNativeQuery(mesgByDescQuery.toString(), MessageAudit.class);
		Query query	=	entityManager.createNativeQuery(mesgByDescQuery.toString(), MessageAudit.class);
		/*query.setParameter("mesgCode", mesgCode);
		query.setParameter("versionSeqNo",versionSeqNo);*/
		
		List<MessageAudit> messageAudit	=	query.getResultList();
		if(null != messageAudit && messageAudit.size() > 0) {
			System.out.println("Audit Message :"+messageAudit);
			return messageAudit;
		} else {
			return  null;
		}
	}

}
