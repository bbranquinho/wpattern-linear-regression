package br.com.wpattern.ai.linear.regression.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import br.com.wpattern.ai.linear.regression.DescentGradient;
import br.com.wpattern.ai.linear.regression.enums.DatasetFields;
import br.com.wpattern.ai.linear.regression.interfaces.IDescentGradient;

public class MainWindow {

	private JFrame frame;

	private JCheckBox chckbxPerCapitaCrime;

	private JCheckBox chckbxProportionalResidentialLand;

	private JCheckBox chckbxProportionalNonrentailBusiness;

	private JCheckBox chckbxRiverBounds;

	private JCheckBox chckbxNitricOxidesConcentration;

	private JCheckBox chckbxRoomsPerDwelling;

	private JCheckBox chckbxProportionalOwner;

	private JCheckBox chckbxWeightedDistances;

	private JCheckBox chckbxIndexAccessibility;

	private JCheckBox chckbxPropertyTaxRate;

	private JCheckBox chckbxPupilTeacherRatio;

	private JCheckBox chckbxLowerStatus;

	private IDescentGradient descentGradient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 754, 450);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new MigLayout("", "[124.00,grow][][][130.00]", "[][][][][129.00]"));

		this.chckbxPerCapitaCrime = new JCheckBox("Per Capita Crime");
		this.chckbxPerCapitaCrime.setToolTipText("Per capita crime rate by town.");
		this.frame.getContentPane().add(this.chckbxPerCapitaCrime, "cell 0 0");

		this.chckbxProportionalResidentialLand = new JCheckBox("Proportional Residential Land");
		this.chckbxProportionalResidentialLand.setToolTipText("Proportion of residential land zoned for lots over 25,000 sq.ft.");
		this.frame.getContentPane().add(this.chckbxProportionalResidentialLand, "cell 1 0");

		this.chckbxProportionalNonrentailBusiness = new JCheckBox("Proportional Non-rentail Business");
		this.chckbxProportionalNonrentailBusiness.setToolTipText("Proportion of non-retail business acres per town.");
		this.frame.getContentPane().add(this.chckbxProportionalNonrentailBusiness, "cell 2 0");

		this.chckbxRiverBounds = new JCheckBox("River Bounds");
		this.chckbxRiverBounds.setToolTipText("Charles River dummy variable (= 1 if tract bounds river; 0 otherwise).");
		this.frame.getContentPane().add(this.chckbxRiverBounds, "cell 3 0");

		this.chckbxNitricOxidesConcentration = new JCheckBox("Nitric Oxides Concentration");
		this.chckbxNitricOxidesConcentration.setToolTipText("Nitric oxides concentration (parts per 10 million).");
		this.frame.getContentPane().add(this.chckbxNitricOxidesConcentration, "cell 0 1");

		this.chckbxRoomsPerDwelling = new JCheckBox("Rooms Per Dwelling");
		this.chckbxRoomsPerDwelling.setToolTipText("Average number of rooms per dwelling.");
		this.frame.getContentPane().add(this.chckbxRoomsPerDwelling, "cell 1 1");

		this.chckbxProportionalOwner = new JCheckBox("Proportional Owner");
		this.chckbxProportionalOwner.setToolTipText("Proportion of owner-occupied units built prior to 1940.");
		this.frame.getContentPane().add(this.chckbxProportionalOwner, "cell 2 1");

		this.chckbxWeightedDistances = new JCheckBox("Weighted Distances");
		this.chckbxWeightedDistances.setToolTipText("Weighted distances to five Boston employment centres.");
		this.frame.getContentPane().add(this.chckbxWeightedDistances, "cell 3 1");

		this.chckbxIndexAccessibility = new JCheckBox("Index Accessibility");
		this.chckbxIndexAccessibility.setToolTipText("Index of accessibility to radial highways.");
		this.frame.getContentPane().add(this.chckbxIndexAccessibility, "cell 0 2");

		this.chckbxPropertyTaxRate = new JCheckBox("Property Tax Rate");
		this.chckbxPropertyTaxRate.setToolTipText("Full-value property-tax rate per $10,000.");
		this.frame.getContentPane().add(this.chckbxPropertyTaxRate, "cell 1 2");

		this.chckbxPupilTeacherRatio = new JCheckBox("Pupil Teacher Ratio");
		this.chckbxPupilTeacherRatio.setToolTipText("Pupil-teacher ratio by town.");
		this.frame.getContentPane().add(this.chckbxPupilTeacherRatio, "cell 2 2");

		this.chckbxLowerStatus = new JCheckBox("Lower Status");
		this.chckbxLowerStatus.setToolTipText("% lower status of the population.");
		this.frame.getContentPane().add(this.chckbxLowerStatus, "cell 3 2");

		JButton btnFindLinearRegression = new JButton("Find Linear Regression");
		btnFindLinearRegression.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainWindow.this.executeLinearRegression();
			}
		});
		this.frame.getContentPane().add(btnFindLinearRegression, "cell 0 3");

		JEditorPane editorPaneLog = new JEditorPane();
		this.frame.getContentPane().add(editorPaneLog, "cell 0 4 4 1,grow");
	}

	private void executeLinearRegression() {
		Set<DatasetFields> availableFields = new HashSet<DatasetFields>();

		if (this.chckbxPerCapitaCrime.isSelected()) {
			availableFields.add(DatasetFields.PER_CAPITA_CRIME);
		}

		if (this.chckbxProportionalResidentialLand.isSelected()) {
			availableFields.add(DatasetFields.PROPORTIONAL_RESIDENTIAL_LAND);
		}

		if (this.chckbxProportionalNonrentailBusiness.isSelected()) {
			availableFields.add(DatasetFields.PROPORTIONAL_NONRETAIL_BUSINESS);
		}

		if (this.chckbxRiverBounds.isSelected()) {
			availableFields.add(DatasetFields.RIVER_BOUNDS);
		}

		if (this.chckbxNitricOxidesConcentration.isSelected()) {
			availableFields.add(DatasetFields.NITRIC_OXIDES_CONCENTRATION);
		}

		if (this.chckbxRoomsPerDwelling.isSelected()) {
			availableFields.add(DatasetFields.ROOMS_PER_DWELLING);
		}

		if (this.chckbxProportionalOwner.isSelected()) {
			availableFields.add(DatasetFields.PROPORTION_OWNER);
		}

		if (this.chckbxWeightedDistances.isSelected()) {
			availableFields.add(DatasetFields.WEIGHTED_DISTANCES);
		}

		if (this.chckbxIndexAccessibility.isSelected()) {
			availableFields.add(DatasetFields.INDEX_ACCESSIBILITY);
		}

		if (this.chckbxPropertyTaxRate.isSelected()) {
			availableFields.add(DatasetFields.PROPERTY_TAX_RATE);
		}

		if (this.chckbxPupilTeacherRatio.isSelected()) {
			availableFields.add(DatasetFields.PUPIL_TEACHER_RATIO);
		}

		if (this.chckbxLowerStatus.isSelected()) {
			availableFields.add(DatasetFields.LOWER_STATUS);
		}

		this.descentGradient = new DescentGradient(availableFields);

		this.descentGradient.executeLinearRegression();
	}

}
