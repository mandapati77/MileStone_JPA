package com.msu.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class DBManager {

	/**
	 * Use annotation @PersistenceContext when we this class deployed as a WEB
	 * Application, EJB sort of intializing, the container itself will take care
	 * of Object creation when we use annotation PersistenceContext, comment out
	 * the EntityManagerFactory variable.
	 * */
	@PersistenceContext(unitName = "MileStone_JPA")
	private static EntityManager em;

	// TODO Need to check how we will rollback the Connection when system throws
	// an Exception
	// TODO remove the following variable if this class deployed as EAR.
	private static EntityManagerFactory emf;
	
	//private static MSULogger log	=	MSULogger.getLogger(DBManager.class);
	//static MSULogger log = MSULogger.getLogger(DBManager.class.getName());
	
	
	public static EntityManager getEntityManager() {
		emf = Persistence.createEntityManagerFactory(DBConstants.PERSISTENCE_UNIT);
		em = emf.createEntityManager();
		return em;
	}

	public static void closeEntityManager() {

		if (em != null && em.isOpen())
			em.close();

		if (emf != null && emf.isOpen())
			emf.close();
	}

	public static boolean insertEntity(Object entity) throws EntityNotFoundException {

		if (!isObjectNotAnEntity(entity)) {
			throw new EntityNotFoundException(entity.getClass().getName());
		}

		boolean insertReturnFlag = false;
		EntityManager em = DBManager.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			insertReturnFlag = true;
		} catch (Exception e) {
			System.out.println("Error while inserting the Record into the DB");
			//log.logError("Error while inserting the Record into the DB", e);
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return insertReturnFlag;
	}

	public static Object findEntity(Object entity) throws EntityNotFoundException {

		if (!isObjectNotAnEntity(entity)) {
			throw new EntityNotFoundException(entity.getClass().getName());
		}

		EntityManager em = DBManager.getEntityManager();
		Object searchObjects = null;
		try {
			Object primaryKeyId = emf.getPersistenceUnitUtil().getIdentifier(entity);
			System.out.println(primaryKeyId);

			System.out.println(entity.getClass().getName());

			searchObjects = em.find(entity.getClass(), primaryKeyId);

		} catch (Exception e) {
			System.out.println("Error while finding the Record from the DB");
			//log.logError("Error while finding the Record from the DB", e);
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return searchObjects;
	}

	public static boolean updateEntity(Object entity) throws EntityNotFoundException {

		if (!isObjectNotAnEntity(entity)) {
			throw new EntityNotFoundException(entity.getClass().getName());
		}

		boolean updateReturnFlag = false;
		EntityManager em = DBManager.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			updateReturnFlag = true;
		} catch (Exception e) {
			System.out.println("Error while updating the Record into the DB");
			//log.logError("Error while updating the Record into the DB", e);
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return updateReturnFlag;
	}

	public static boolean deleteEntity(Object entity) throws EntityNotFoundException {

		if (!isObjectNotAnEntity(entity)) {
			throw new EntityNotFoundException(entity.getClass().getName());
		}

		boolean deleteReturnFlag = false;
		EntityManager em = null;
		try {
			em = DBManager.getEntityManager();
			em.getTransaction().begin();

			Object id = emf.getPersistenceUnitUtil().getIdentifier(entity);
			System.out.println(id);

			System.out.println(entity.getClass().getName());

			Object o = em.find(entity.getClass(), id);

			em.remove(o);
			em.getTransaction().commit();

			deleteReturnFlag = true;
		} catch (Exception e) {
			System.out.println("Error while deleting the Record from the DB");
			//log.logError("Error while deletig the Record from the DB", e);
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}
		return deleteReturnFlag;
	}

	public static ResultSet executeNativeQuery(String query) {
		ResultSet rs = null;
		try {
			Statement stmt = DBManager.getStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			//log.logError("Error while Execute Query ", e);
			System.out.println("Error while Execute Query ");
			e.printStackTrace();
		}
		return rs;
	}

	public static Statement getStatement() {
		Statement stmt = null;
		try {
			Connection conn = DBManager.getConnection();
			stmt = conn.createStatement();
		} catch (SQLException e) {
			//log.logError("Exception while Creating the Statement", e);
			System.out.println("Exception while Creating the Statement");
			e.printStackTrace();
		}
		return stmt;
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DBConstants.DB_DRIVER);
			conn = DriverManager.getConnection(DBConstants.DB_URL, DBConstants.DB_USERNAME, DBConstants.DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class not found ");
			e.printStackTrace();
		} catch (SQLException e) {
			//log.logError("Exception while Creating the Connection", e);
			System.out.println("Exception while Creating the Connection");
			e.printStackTrace();
		}
		return conn;
	}

	//TODO Need to implement this
	public static boolean isObjectNotAnEntity(Object entity) {
		return true;
	}
}