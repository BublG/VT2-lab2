package by.bsuir.webtech.secondLab.dao.impl;

import by.bsuir.webtech.secondLab.dao.ApplianceDAO;
import by.bsuir.webtech.secondLab.entity.*;
import by.bsuir.webtech.secondLab.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ApplianceDAOImpl class
 * Implements ApplianceDAO.
 *
 * @author Artsiom Sharakhouski
 * @version 1.0
 */
public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String DBPath = "src\\main\\resources\\appliances_db.xml";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Appliance> find(Criteria criteria) throws ParserConfigurationException, IOException, SAXException {
        Document document = getDocument();
        return getResultAppliances(document.getElementsByTagName(criteria.getGroupSearchName()), criteria);
    }

    private Document getDocument() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.parse(new File(DBPath));
    }

    private boolean isMatches(NodeList fields, Criteria criteria) {
        boolean isMatches = true;
        for (int j = 0; j < fields.getLength() && isMatches; j++) {
            if (fields.item(j).getNodeType() == Node.ELEMENT_NODE) {
                String name = fields.item(j).getNodeName();
                String value = fields.item(j).getTextContent();
                if (criteria.getCriteria().containsKey(name) &&
                        !criteria.getCriteria().get(name).toString().equals(value)) {
                    isMatches = false;
                }
            }
        }
        return isMatches;
    }

    private List<Appliance> getResultAppliances(NodeList nodeList, Criteria criteria) {
        List<Appliance> appliances = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (isMatches(node.getChildNodes(), criteria)) {
                appliances.add(mapNodeToAppliance(node));
            }
        }
        return appliances;
    }

    private Appliance mapNodeToAppliance(Node node) {
        String[] fields = getFieldsArray(node.getChildNodes());
        if (node.getNodeName().equals(Oven.class.getSimpleName())) {
            return new Oven(fields);
        } else if (node.getNodeName().equals(Laptop.class.getSimpleName())) {
            return new Laptop(fields);
        } else if (node.getNodeName().equals(Refrigerator.class.getSimpleName())) {
            return new Refrigerator(fields);
        } else if (node.getNodeName().equals(TabletPC.class.getSimpleName())) {
            return new TabletPC(fields);
        } else if (node.getNodeName().equals(Speakers.class.getSimpleName())) {
            return new Speakers(fields);
        } else {
            return new VacuumCleaner(fields);
        }
    }

    private String[] getFieldsArray(NodeList fieldsNodes) {
        String[] fields = new String[fieldsNodes.getLength() / 2];
        int i = 0;
        for (int j = 0; j < fieldsNodes.getLength(); j++) {
            if (fieldsNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                fields[i++] = fieldsNodes.item(j).getTextContent();
            }
        }
        return fields;
    }
}
