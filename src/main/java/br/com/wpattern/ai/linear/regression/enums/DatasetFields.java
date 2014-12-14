package br.com.wpattern.ai.linear.regression.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Possible field of dataset.
 * 
 * @author Branquinho
 */
public enum DatasetFields {

	/**
	 * Per capita crime rate by town.
	 */
	PER_CAPITA_CRIME(0),

	/**
	 * Proportion of residential land zoned for lots over 25,000 sq.ft.
	 */
	PROPORTIONAL_RESIDENTIAL_LAND(1),

	/**
	 * Proportion of non-retail business acres per town.
	 */
	PROPORTIONAL_NONRETAIL_BUSINESS(2),

	/**
	 * Charles River dummy variable (= 1 if tract bounds river; 0 otherwise).
	 */
	RIVER_BOUNDS(3),

	/**
	 * Nitric oxides concentration (parts per 10 million).
	 */
	NITRIC_OXIDES_CONCENTRATION(4),

	/**
	 * Average number of rooms per dwelling.
	 */
	ROOMS_PER_DWELLING(5),

	/**
	 * Proportion of owner-occupied units built prior to 1940.
	 */
	PROPORTION_OWNER(6),

	/**
	 * Weighted distances to five Boston employment centres.
	 */
	WEIGHTED_DISTANCES(7),

	/**
	 *  Index of accessibility to radial highways.
	 */
	INDEX_ACCESSIBILITY(8),

	/**
	 * Full-value property-tax rate per $10,000.
	 */
	PROPERTY_TAX_RATE(9),

	/**
	 * Pupil-teacher ratio by town.
	 */
	PUPIL_TEACHER_RATIO(10),

	/**
	 * % lower status of the population.
	 */
	LOWER_STATUS(12),

	/**
	 * Median value of owner-occupied homes in $1000's.
	 */
	MEDIAN_VALUE(13),

	/**
	 * Field not mapped.
	 */
	UNKNOWN_FIELD(null);

	private static final Map<Integer, DatasetFields> mapFields = new HashMap<Integer, DatasetFields>();

	/**
	 * Position of field on dataset.
	 */
	private Integer fieldPosition;

	static {
		for (DatasetFields value : values()) {
			mapFields.put(value.fieldPosition, value);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTORS
	//////////////////////////////////////////////////////////////////////////////

	private DatasetFields(Integer fieldPosition) {
		this.fieldPosition = fieldPosition;
	}

	//////////////////////////////////////////////////////////////////////////////
	// PUBLIC METHODS
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * Get the value of dataset/enum based on position of field on dataset.
	 * 
	 * @param position
	 * 			Position of field on dataset.
	 * 
	 * @return
	 * 			Enum value from "position".
	 */
	public static DatasetFields parse(Integer position) {
		DatasetFields mappedField = mapFields.get(position);

		if (mappedField == null) {
			return UNKNOWN_FIELD;
		}

		return mappedField;
	}

	public int getFieldPosition() {
		return this.fieldPosition;
	}

}
