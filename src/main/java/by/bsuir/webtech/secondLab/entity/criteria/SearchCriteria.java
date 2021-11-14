package by.bsuir.webtech.secondLab.entity.criteria;

/**
 * SearchCriteria class.
 * Contains all search criteria.
 *
 * @author Artsiom Sharakhouiski
 * @version 1.0
 */
public final class SearchCriteria {

	public static enum Appliance {
		PRICE;
	}
	
	public static enum Oven{
		POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH, HEIGHT, WIDTH
	}
	
	public static enum Laptop{
		BATTERY_CAPACITY, OS, ROM_MEMORY, SYSTEM_MEMORY, CPU, DISPLAY_INCHES
	}
	
	public static enum Refrigerator{
		POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY, OVERALL_CAPACITY, HEIGHT, WIDTH
	}
	
	public static enum VacuumCleaner{
		POWER_CONSUMPTION, FILTER_TYPE, BAG_TYPE, WAND_TYPE, MOTOR_SPEED_REGULATION, CLEANING_WIDTH
	}
	
	public static enum TabletPC{
		BATTERY_CAPACITY, DISPLAY_INCHES, ROM_MEMORY, FLASH_MEMORY_CAPACITY, COLOR
	}
	
	public static enum Speakers{
		POWER_CONSUMPTION, SPEAKERS_NUMBER, FREQUENCY_RANGE, CORD_LENGTH
	}

	private SearchCriteria() {}
}

