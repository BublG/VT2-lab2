package by.bsuir.webtech.secondLab.entity.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * Criteria class with properties <b>criteria</b>, <b>groupSearchName</b>.
 *
 * @author Artsiom Sharakhouski
 * @version 1.0
 */
public class Criteria {

	private final String groupSearchName;
	private final Map<String, Object> criteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}

	public Map<String, Object> getCriteria() {
		return criteria;
	}

	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}
}
