package com.msu.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msu.dao.IMessageDAO;
import com.msu.dataobject.Message;
import com.msu.dataobject.MessageVO;
import com.msu.dbutil.DBManager;

public class MessageDAOImpl implements IMessageDAO {

	private static final Logger logger = LoggerFactory.getLogger(MessageDAOImpl.class);
	
	@Override
	public boolean insert(Message message) {
		logger.debug("Inside DAO class - insertion method");
		boolean insertFlag	=	false;
		try {
			insertFlag	=	DBManager.insertEntity(message);
		} catch(EntityNotFoundException e) {
			logger.error("Exception occured while inserted the record into the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			logger.error("Exception occured while inserted the record into the Database", e);
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
		query.setParameter("moduleSeqNo", moduleSeqNo);
		
		return query.getResultList();
	}

	@Override
	public Message getMessageBySeqNo(long seqNo) {
		
		StringBuffer mesgSeqNoQuery	=	new StringBuffer();
		mesgSeqNoQuery.append(" SELECT m FROM Message m WHERE m.mcsspMesgSeqNum = :seqNo ");
		
		try {
			EntityManager entityManager	=	DBManager.getEntityManager(); 
			TypedQuery<Message> typedQuery = entityManager.createQuery(mesgSeqNoQuery.toString(), Message.class);
			typedQuery.setParameter("seqNo", seqNo);
			return typedQuery.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MessageVO> getMessageByDesc(String messageDesc) {
		EntityManager entityManager	=	DBManager.getEntityManager();
		/*String messageQueryByLike	=	"SELECT m FROM Message m WHERE m.mcsspMesgDesc like :messageDesc ";
		
		Query query = entityManager.createQuery(messageQueryByLike,Message.class);
	    query.setParameter("messageDesc", "%"+messageDesc+"%");
	    
	    List<Message> messageList	=	query.getResultList();
	    */

		List<MessageVO> messageList	=	new ArrayList<MessageVO>();
		
		StringBuffer SQL	=	new StringBuffer();
		
		/*"mcsspMesgCodeType": "E",
        "mcsspMesgCode": "GK123",
        "mcsspMesgActivityDate": "Dec 27, 2014 12:00:00 AM",
        "mcsspMesgSeqNum": 11,
        "mcsspModuleName": "ACCOUNT NOTIFICATIONS",
        "mcsspMesgUserId": "Gopi",
        "mcsspMesgDesc": "Hello Worlds!",
        "mcsspMesgActiveInd": " ",
        "mcsspMesgEditInd": " ",
        "mcsspModuleSeqNum": 255,
        "mcsspTotalRevision":1*/
		
		SQL.append("SELECT mm.MCSSP_MESG_SEQ_NUM as \"mcsspMesgSeqNum\", \n");
		SQL.append("  mm.MCSSP_MESG_ACTIVE_IND as \"mcsspMesgActiveInd\", \n");
		SQL.append("  mm.MCSSP_MESG_ACTIVITY_DATE as \"mcsspMesgActivityDate\", \n");
		SQL.append("  mm.MCSSP_MESG_CODE as \"mcsspMesgCode\", \n");
		SQL.append("  mm.MCSSP_MESG_CODE_TYPE as \"mcsspMesgCodeType\", \n");
		SQL.append("  mm.MCSSP_MESG_DESC as \"mcsspMesgDesc\", \n");
		SQL.append("  mm.MCSSP_MESG_EDIT_IND as \"mcsspMesgEditInd\", \n");
		SQL.append("  mm.MCSSP_MESG_USER_ID as \"mcsspMesgUserId\", \n");
		SQL.append("  mm.MCSSP_MODULE_NAME as \"mcsspModuleName\", \n");
		SQL.append("  mm.MCSSP_MODULE_SEQ_NUM as \"mcsspModuleSeqNum\", \n");
		SQL.append("  COALESCE(b.total_revisions,0) as \"mcsspTotalRevision\" \n");
		SQL.append("FROM MCSSP_MESG mm \n");
		SQL.append("LEFT JOIN \n");
		SQL.append("  (SELECT mm.MCSSP_MESG_CODE, \n");
		SQL.append("    COUNT(mmv.MCSSP_AUDIT_REVISON) AS total_revisions \n");
		SQL.append("  FROM MCSSP_MESG mm, \n");
		SQL.append("    MCSSP_MESG_AUDIT mmv \n");
		SQL.append("  WHERE mm.MCSSP_MODULE_SEQ_NUM = mmv.MCSSP_AUDIT_MODULE_SEQ_NUM \n");
		SQL.append("  AND mm.MCSSP_MESG_CODE        = mmv.MCSSP_AUDIT_MESG_CODE \n");
		SQL.append("  AND mm.MCSSP_MESG_SEQ_NUM     = mmv.MCSSP_AUDIT_MESG_SEQ_NUM \n");
		SQL.append("  AND mm.MCSSP_MESG_CODE        = mmv.MCSSP_AUDIT_MESG_CODE \n");
		SQL.append("  GROUP BY mm.MCSSP_MESG_CODE \n");
		SQL.append("  ) b \n");
		SQL.append("ON MCSSP_MESG_DESC LIKE '%%' \n");
		SQL.append("AND mm.MCSSP_MESG_CODE = b.MCSSP_MESG_CODE \n");
		SQL.append("ORDER BY mm.MCSSP_MESG_CODE, \n");
		SQL.append("  mm.MCSSP_MESG_SEQ_NUM ");

		Query query = entityManager.createNativeQuery(SQL.toString());
	    //query.setParameter("messageDesc", "%"+messageDesc+"%");
	    
	    try {
	    	List<Object[]> rawResultList	=	query.getResultList();
	    	//System.out.println(messageList);
	    	if(null != rawResultList && rawResultList.size() > 0) {
	    		for (Object[] resultElement : rawResultList) {
	    			
	    			/*
	    			 long mcsspMesgSeqNum, String mcsspMesgActiveInd,
			Date mcsspMesgActivityDate, String mcsspMesgCode,
			String mcsspMesgCodeType, String mcsspMesgDesc,
			String mcsspMesgEditInd, String mcsspMesgUserId,
			String mcsspModuleName, BigDecimal mcsspModuleSeqNum, BigDecimal mcsspTotalRevision 
	    			 * */
	    			/*
	    			System.out.println((BigDecimal)resultElement[0]);
	    			System.out.println((String)resultElement[1]);
	    			System.out.println((Date)resultElement[2]);
	    			System.out.println((String)resultElement[3]);
	    			System.out.println((String)resultElement[4]);
	    			System.out.println((String)resultElement[5]);
	    			System.out.println((String)resultElement[6]);
	    			System.out.println((String)resultElement[7]);
	    			System.out.println((String)resultElement[8]);
	    			System.out.println((BigDecimal)resultElement[9]);
	    			System.out.println((BigDecimal)resultElement[10]);*/
	    			
					MessageVO messageVO = new MessageVO((BigDecimal)resultElement[0],
							(String)resultElement[1], (Date)resultElement[2],
							(String)resultElement[3], (String)resultElement[4],
							(String)resultElement[5], (String)resultElement[6],
							(String)resultElement[7], (String)resultElement[8],
							(BigDecimal)resultElement[9], (BigDecimal)resultElement[10]);
	    			//AnnouncementDeliveryLog adl = new AnnouncementDeliveryLog(getAnnouncementById(announcementId), (String)resultElement[1], (String)resultElement[2], "TO_SEND");
	    	        //persistAnnouncementDeliveryLog(messageVO);
					
					messageList.add(messageVO);
					
					System.out.println(messageList);
	    	    }		
	    	}
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
		
	    
		
		entityManager.close();
		return messageList;
	}
	
	public static void main(String[] args) {
		MessageDAOImpl daoImpl	=	new MessageDAOImpl();
		daoImpl.getMessageByMesgCode("C_1000");
	}

	//@Override
	public List<Message> getMessageByMesgCode(String mesgCode) {
		EntityManager entityManager	=	DBManager.getEntityManager();
		
		String messageQueryByCode	=	"SELECT m FROM Message m WHERE m.mcsspMesgCode = :mcsspMesgCode ";
		
		Query query = entityManager.createQuery(messageQueryByCode,Message.class);
	    query.setParameter("mcsspMesgCode", mesgCode);
	    
	    List<Message> messageList	=	null;
	    messageList	=	query.getResultList();
	    System.out.println(" messageList XXX :"+messageList);
	    System.out.println(messageList.isEmpty());
	    System.out.println(messageList == null);
	    /*if(null != messageList && messageList.size() > 0) {
	    	message	=	messageList.get(0);
	    }*/
		entityManager.close();
		return messageList;
	}

	@Override
	public List<Message> getMessageByApplicationName(String appName) {
		EntityManager entityManager	=	DBManager.getEntityManager();
		
		String messageQueryByLike	=	"SELECT m FROM Message m WHERE m.mcsspModuleName = :mcsspModuleName ";
		
		Query query = entityManager.createQuery(messageQueryByLike,Message.class);
	    query.setParameter("mcsspModuleName", appName.toUpperCase());
	    
	    List<Message> messageList	=	query.getResultList();
	    System.out.println(" messageList :"+messageList);
	   
	    entityManager.close();
		return messageList;
	}

	@Override
	public List<Message> getMessageByDateRange(String dateRange) {
		EntityManager entityManager	=	DBManager.getEntityManager();
		
		CriteriaBuilder criteriaBuilder	=	entityManager.getCriteriaBuilder();
		CriteriaQuery<Message> criteriaQuery	=	criteriaBuilder.createQuery(Message.class);
		Root<Message> messageRoot	=	criteriaQuery.from(Message.class);
		List<Predicate> predicateList	=	new ArrayList<Predicate>();
		Predicate[] predicates			=	null;	
		Expression currentDate			=	criteriaBuilder.currentDate();
				
		criteriaQuery.select(messageRoot);
		
		if(dateRange.trim().equals("D")) {
			Expression activityDate	=	messageRoot.get("mcsspMesgActivityDate");
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(activityDate, criteriaBuilder.diff(currentDate, 1)));
			predicates	=	predicateList.toArray(new Predicate[predicateList.size()]);
		} else if(dateRange.trim().equals("W")) {
			Expression activityDate	=	messageRoot.get("mcsspMesgActivityDate");
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(activityDate, criteriaBuilder.diff(currentDate, 7)));
			predicates	=	predicateList.toArray(new Predicate[predicateList.size()]);
		} else if(dateRange.trim().equals("M")) {
			Expression activityDate	=	messageRoot.get("mcsspMesgActivityDate");
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(activityDate, criteriaBuilder.diff(currentDate, 31)));
			predicates	=	predicateList.toArray(new Predicate[predicateList.size()]);
		} else if(dateRange.trim().equals("A")) {
			Expression activityDate	=	messageRoot.get("mcsspMesgActivityDate");
			//predicateList.add(criteriaBuilder.greaterThanOrEqualTo(currentDate));
			predicates	=	predicateList.toArray(new Predicate[predicateList.size()]);
		}
		
		criteriaQuery.where(predicates);
		
		/*String messageQueryByLike	=	"SELECT m FROM Message m WHERE m.mcsspMesgActivityDate >= CURRENT_DATE - :mcsspDateRange ";
		
		Query query = entityManager.createQuery(messageQueryByLike,Message.class);
	    if(dateRange.trim().equals("D") ) {
	    	dateRange	=	"CURRENT_DATE";
	    }
		
		query.setParameter("mcsspDateRange", 1);*/
	    
		Query query = entityManager.createQuery(criteriaQuery);
		
	    List<Message> messageList	=	query.getResultList();
	    System.out.println(" messageList :"+messageList);
	   
	    entityManager.close();
		return messageList;
	}

}
