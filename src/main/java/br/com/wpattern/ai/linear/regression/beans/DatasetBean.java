package br.com.wpattern.ai.linear.regression.beans;

/**
 * Record of boston housing data.
 * 
 * @author Branquinho
 * @since December 4, 2012.
 */
public class DatasetBean extends BaseBeans {

	/**
	 * Serial version ID.
	 */
	private static final long serialVersionUID = 2012120401080109L;

	/**
	 * Per capita crime rate by town.
	 */
	private double perCapitaCrime;

	/**
	 * Proportion of residential land zoned for lots over 25,000 sq.ft.
	 */
	private double proportionalResidentialLand;

	/**
	 * Proportion of non-retail business acres per town.
	 */
	private double proportionalNonretailBusiness;

	/**
	 * Charles River dummy variable (= 1 if tract bounds river; 0 otherwise).
	 */
	private double riverBounds;

	/**
	 * Nitric oxides concentration (parts per 10 million).
	 */
	private double nitricOxidesConcentration;

	/**
	 * Average number of rooms per dwelling.
	 */
	private double roomsPerDwelling;

	/**
	 * Proportion of owner-occupied units built prior to 1940.
	 */
	private double proportionOwner;

	/**
	 * Weighted distances to five Boston employment centres.
	 */
	private double  weightedDistances;

	/**
	 *  Index of accessibility to radial highways.
	 */
	private double indexAccessibility;

	/**
	 * Full-value property-tax rate per $10,000.
	 */
	private double propertyTaxRate;

	/**
	 * Pupil-teacher ratio by town.
	 */
	private double pupilTeacherRatio;

	/**
	 * % lower status of the population.
	 */
	private double lowerStatus;

	/**
	 * Median value of owner-occupied homes in $1000's.
	 */
	private double medianValue;

	//////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTORS
	//////////////////////////////////////////////////////////////////////////////

	public DatasetBean() {
	}

	/**
	 * Constructor with all attributes.
	 * 
	 * @param perCapitaCrime
	 * 			Per capita crime rate by town.
	 * @param proportionalResidentialLand
	 * 			Proportion of residential land zoned for lots over 25,000 sq.ft.
	 * @param proportionalNonretailBusiness
	 * 			Proportion of non-retail business acres per town.
	 * @param riverBounds
	 * 			Charles River dummy variable (= 1 if tract bounds river; 0 otherwise).
	 * @param nitricOxidesConcentration
	 * 			Nitric oxides concentration (parts per 10 million).
	 * @param roomsPerDwelling
	 * 			Average number of rooms per dwelling.
	 * @param proportionOwner
	 * 			Proportion of owner-occupied units built prior to 1940.
	 * @param weightedDistances
	 * 			Weighted distances to five Boston employment centres.
	 * @param indexAccessibility
	 * 			Index of accessibility to radial highways.
	 * @param propertyTaxRate
	 * 			Full-value property-tax rate per $10,000.
	 * @param pupilTeacherRatio
	 * 			Pupil-teacher ratio by town.
	 * @param lowerStatus
	 * 			% lower status of the population.
	 * @param medianValue
	 * 			Median value of owner-occupied homes in $1000's.
	 */
	public DatasetBean(double perCapitaCrime, double proportionalResidentialLand,
			double proportionalNonretailBusiness, double riverBounds,
			double nitricOxidesConcentration, double roomsPerDwelling,
			double proportionOwner, double weightedDistances,
			double indexAccessibility, double propertyTaxRate,
			double pupilTeacherRatio, double lowerStatus, double medianValue) {
		super();
		this.perCapitaCrime = perCapitaCrime;
		this.proportionalResidentialLand = proportionalResidentialLand;
		this.proportionalNonretailBusiness = proportionalNonretailBusiness;
		this.riverBounds = riverBounds;
		this.nitricOxidesConcentration = nitricOxidesConcentration;
		this.roomsPerDwelling = roomsPerDwelling;
		this.proportionOwner = proportionOwner;
		this.weightedDistances = weightedDistances;
		this.indexAccessibility = indexAccessibility;
		this.propertyTaxRate = propertyTaxRate;
		this.pupilTeacherRatio = pupilTeacherRatio;
		this.lowerStatus = lowerStatus;
		this.medianValue = medianValue;
	}

	//////////////////////////////////////////////////////////////////////////////
	// GET AND SET METHODS
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * Per capita crime rate by town.
	 */
	public double getPerCapitaCrime() {
		return this.perCapitaCrime;
	}

	/**
	 * Per capita crime rate by town.
	 */
	public void setPerCapitaCrime(double perCapitaCrime) {
		this.perCapitaCrime = perCapitaCrime;
	}

	/**
	 * Proportion of residential land zoned for lots over 25,000 sq.ft.
	 */
	public double getProportionalResidentialLand() {
		return this.proportionalResidentialLand;
	}

	/**
	 * Proportion of residential land zoned for lots over 25,000 sq.ft.
	 */
	public void setProportionalResidentialLand(double proportionalResidentialLand) {
		this.proportionalResidentialLand = proportionalResidentialLand;
	}

	/**
	 * Proportion of non-retail business acres per town.
	 */
	public double getProportionalNonretailBusiness() {
		return this.proportionalNonretailBusiness;
	}

	/**
	 * Proportion of non-retail business acres per town.
	 */
	public void setProportionalNonretailBusiness(
			double proportionalNonretailBusiness) {
		this.proportionalNonretailBusiness = proportionalNonretailBusiness;
	}

	/**
	 * Charles River dummy variable (= 1 if tract bounds river; 0 otherwise).
	 */
	public double getRiverBounds() {
		return this.riverBounds;
	}

	/**
	 * Charles River dummy variable (= 1 if tract bounds river; 0 otherwise).
	 */
	public void setRiverBounds(double riverBounds) {
		this.riverBounds = riverBounds;
	}

	/**
	 * Nitric oxides concentration (parts per 10 million).
	 */
	public double getNitricOxidesConcentration() {
		return this.nitricOxidesConcentration;
	}

	/**
	 * Nitric oxides concentration (parts per 10 million).
	 */
	public void setNitricOxidesConcentration(double nitricOxidesConcentration) {
		this.nitricOxidesConcentration = nitricOxidesConcentration;
	}

	/**
	 * Average number of rooms per dwelling.
	 */
	public double getRoomsPerDwelling() {
		return this.roomsPerDwelling;
	}

	/**
	 * Average number of rooms per dwelling.
	 */
	public void setRoomsPerDwelling(double roomsPerDwelling) {
		this.roomsPerDwelling = roomsPerDwelling;
	}

	/**
	 * Proportion of owner-occupied units built prior to 1940.
	 */
	public double getProportionOwner() {
		return this.proportionOwner;
	}

	/**
	 * Proportion of owner-occupied units built prior to 1940.
	 */
	public void setProportionOwner(double proportionOwner) {
		this.proportionOwner = proportionOwner;
	}

	/**
	 * Weighted distances to five Boston employment centres.
	 */
	public double getWeightedDistances() {
		return this.weightedDistances;
	}

	/**
	 * Weighted distances to five Boston employment centres.
	 */
	public void setWeightedDistances(double weightedDistances) {
		this.weightedDistances = weightedDistances;
	}

	/**
	 * Index of accessibility to radial highways.
	 */
	public double getIndexAccessibility() {
		return this.indexAccessibility;
	}

	/**
	 * Index of accessibility to radial highways.
	 */
	public void setIndexAccessibility(double indexAccessibility) {
		this.indexAccessibility = indexAccessibility;
	}

	/**
	 * Full-value property-tax rate per $10,000.
	 */
	public double getPropertyTaxRate() {
		return this.propertyTaxRate;
	}

	/**
	 * Full-value property-tax rate per $10,000.
	 */
	public void setPropertyTaxRate(double propertyTaxRate) {
		this.propertyTaxRate = propertyTaxRate;
	}

	/**
	 * Pupil-teacher ratio by town.
	 */
	public double getPupilTeacherRatio() {
		return this.pupilTeacherRatio;
	}

	/**
	 * Pupil-teacher ratio by town.
	 */
	public void setPupilTeacherRatio(double pupilTeacherRatio) {
		this.pupilTeacherRatio = pupilTeacherRatio;
	}

	/**
	 * % lower status of the population.
	 */
	public double getLowerStatus() {
		return this.lowerStatus;
	}

	/**
	 * % lower status of the population.
	 */
	public void setLowerStatus(double lowerStatus) {
		this.lowerStatus = lowerStatus;
	}

	/**
	 * Median value of owner-occupied homes in $1000's.
	 */
	public double getMedianValue() {
		return this.medianValue;
	}

	/**
	 * Median value of owner-occupied homes in $1000's.
	 */
	public void setMedianValue(double medianValue) {
		this.medianValue = medianValue;
	}

}
