package by.bsuir.webtech.secondLab.dao;

import by.bsuir.webtech.secondLab.entity.Appliance;
import by.bsuir.webtech.secondLab.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * ApplianceDAO interface of an applianceDao class.
 *
 * @author Artsiom Sharakhouski
 * @version 1.0
 */
public interface ApplianceDAO {
	/**
	 * Finds all Appliance that match the given criteria.
	 *
	 * @param criteria search criteria
	 * @return List of Appliance
	 * @throws ParserConfigurationException exception when problems with parsing xml
	 * @throws IOException ioexception
	 * @throws SAXException exception when problems with parsing xml
	 */
	List<Appliance> find(Criteria criteria) throws ParserConfigurationException, IOException, SAXException;
}
