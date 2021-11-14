package by.bsuir.webtech.secondLab.service;

import by.bsuir.webtech.secondLab.entity.Appliance;
import by.bsuir.webtech.secondLab.entity.criteria.Criteria;

import java.util.List;

/**
 * ApplianceService interface of an ApplianceService class.
 *
 * @author Artsiom Sharakhouski
 * @version 1.0
 */
public interface ApplianceService {
    /**
     *
     * @param criteria search criteria
     * @return List of Appliance
     */
    List<Appliance> find(Criteria criteria);

    /**
     *
     * @param criteria search criteria
     * @return {@link Appliance}
     */
    Appliance findTheCheapest(Criteria criteria);
}
