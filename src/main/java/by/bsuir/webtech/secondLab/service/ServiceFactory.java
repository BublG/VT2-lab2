package by.bsuir.webtech.secondLab.service;

import by.bsuir.webtech.secondLab.service.impl.ApplianceServiceImpl;

/**
 * ServiceFactory class with properties <b>instance</b> and <b>ApplianceService</b>.
 *
 * @author Artsiom Sharakhouski
 * @version 1.0
 */
public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	private final ApplianceService applianceService = new ApplianceServiceImpl();
	
	private ServiceFactory() {}

	public ApplianceService getApplianceService() {
		return applianceService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

}
