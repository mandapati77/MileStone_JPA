package com.msu.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;

import com.msu.dao.IModuleDAO;
import com.msu.dataobject.Module;
import com.msu.dbutil.DBManager;

public class ModuleDAOImpl implements IModuleDAO {

	@Override
	public boolean insert(Module module) {
		boolean insertFlag	=	false;
		try {
			insertFlag	=	DBManager.insertEntity(module);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while inserted the record into the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while inserted the record into the Database", e);
		}
		return insertFlag;
	}

	@Override
	public boolean delete(Module module) {
		boolean deleteFlag	=	false;
		try {
			deleteFlag	=	DBManager.deleteEntity(module);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while deleting the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while deleting the record from the Database", e);
		}
		return deleteFlag;
	}

	@Override
	public boolean update(Module module) {
		boolean updateFlag	=	false;
		try {
			updateFlag	=	DBManager.updateEntity(module);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while udpating the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while upating the record from the Database", e);
		}
		return updateFlag;
	}

	@Override
	public List<Module> getAllModules() {
		EntityManager entityManager	=	DBManager.getEntityManager();
		List<Module> moduleList =	entityManager.createNamedQuery("Module.findAll",Module.class).getResultList();
		entityManager.close();
		return moduleList;
	}

	@Override
	public Module getModuleBySeqNo(long moduleSeqNo) {
		StringBuffer mesgSeqNoQuery	=	new StringBuffer();
		mesgSeqNoQuery.append(" SELECT m FROM Module m WHERE m.mcsspModuleSeqNum = :moduleSeqNo ");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<Module> query = entityManager.createQuery(mesgSeqNoQuery.toString(), Module.class);
		query.setParameter(":moduleSeqNo", moduleSeqNo);
		
		return query.getSingleResult();
	}

	@Override
	public List<Module> getModuleByName(String moduleName) {
		StringBuffer mesgSeqNoQuery	=	new StringBuffer();
		mesgSeqNoQuery.append(" SELECT m FROM Module m WHERE m.mcsspModuleDesc like :moduleName ");
		
		EntityManager entityManager	=	DBManager.getEntityManager(); 
		TypedQuery<Module> query = entityManager.createQuery(mesgSeqNoQuery.toString(), Module.class);
		query.setParameter(":moduleName", "%"+moduleName+"%");
		
		return query.getResultList();
	}

}
