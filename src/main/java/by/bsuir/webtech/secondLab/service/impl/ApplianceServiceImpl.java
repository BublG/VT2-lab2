package by.bsuir.webtech.secondLab.service.impl;

import by.bsuir.webtech.secondLab.dao.ApplianceDAO;
import by.bsuir.webtech.secondLab.dao.DAOFactory;
import by.bsuir.webtech.secondLab.entity.Appliance;
import by.bsuir.webtech.secondLab.entity.criteria.Criteria;
import by.bsuir.webtech.secondLab.service.ApplianceService;
import by.bsuir.webtech.secondLab.service.validation.Validator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * ApplianceServiceImpl class
 * Implements ApplianceService.
 *
 * @author Artsiom Sharakhouski
 * @version 1.0
 */
public class ApplianceServiceImpl implements ApplianceService {

    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final ApplianceDAO applianceDAO = daoFactory.getApplianceDAO();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Appliance> find(Criteria criteria) {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }
        List<Appliance> appliances = null;
        try {
            appliances = applianceDAO.find(criteria);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return appliances;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance findTheCheapest(Criteria criteria) {
        List<Appliance> appliances = find(criteria);
        if (appliances == null || appliances.isEmpty()) {
            return null;
        }
        return appliances.stream()
                .min((a, b) -> (int) (a.getPrice() - b.getPrice()))
                .get();
    }
}
