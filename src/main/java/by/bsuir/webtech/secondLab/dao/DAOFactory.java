package by.bsuir.webtech.secondLab.dao;

import by.bsuir.webtech.secondLab.dao.impl.ApplianceDAOImpl;

/**
 * DAOFactory class with properties <b>instance</b> and <b>applianceDAO</b>.
 *
 * @author Artsiom Sharakhouski
 * @version 1.0
 */
public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();
	
	private DAOFactory() {}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}
}
