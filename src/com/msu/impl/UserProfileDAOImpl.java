package com.msu.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import com.msu.dao.IUserProfileDAO;
import com.msu.dataobject.UserProfile;
import com.msu.dbutil.DBManager;

public class UserProfileDAOImpl implements IUserProfileDAO {
	
	//MSULogger log	=	MSULogger.getLogger(UserProfileDAOImpl.class);
	//static MSULogger log = MSULogger.getLogger(UserProfileDAOImpl.class.getName());
	
	public UserProfileDAOImpl() {
	}
	
	@Override
	public boolean insert(UserProfile userProfile) {
		boolean insertFlag	=	false;
		try {
			insertFlag	=	DBManager.insertEntity(userProfile);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while inserted the record into the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while inserted the record into the Database", e);
		}
		return insertFlag;
	}

	@Override
	public boolean delete(UserProfile userProfile) {
		boolean deleteFlag	=	false;
		try {
			deleteFlag	=	DBManager.deleteEntity(userProfile);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while deleting the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while deleting the record from the Database", e);
		}
		return deleteFlag;
	}

	@Override
	public boolean update(UserProfile userProfile) {
		boolean updateFlag	=	false;
		try {
			updateFlag	=	DBManager.deleteEntity(userProfile);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while udpating the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while upating the record from the Database", e);
		}
		return updateFlag;
	}

	@Override
	public List<UserProfile> getAllUserProfiles() {
		EntityManager entityManager	=	DBManager.getEntityManager();
		List<UserProfile> userProfilesList =	entityManager.createNamedQuery("UserProfile.findAll",UserProfile.class).getResultList();
		entityManager.close();
		return userProfilesList;
	}

	@Override
	public UserProfile getUserProfileById(UserProfile userProfile) {
		UserProfile userProfileResult	=	null;
		try {
			userProfileResult	=	(UserProfile) DBManager.findEntity(userProfile);
		} catch(EntityNotFoundException e) {
			//log.logError("Exception occured while fetching the record from the Database, the Object which is passed is not an Entity.", e);
		} catch(Exception e) {
			//log.logError("Exception occured while fetching the record from the Database", e);
		}
		return userProfileResult;
	}

	@Override
	public UserProfile getUserProfileById(String userId) {
		UserProfile profile	=	new UserProfile();
		profile.setUserId(userId);
		return getUserProfileById(profile);
	}

}
