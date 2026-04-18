package unf.edu.cop3503;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomJFrame extends JFrame {
    // TODO: implement CustomJFrame and all its variables
    private JLabel headingLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel phoneNumberLabel;
    private JLabel emailLabel;
    private JLabel dietaryLabel;
    private JLabel genderLabel;
    private JLabel waterLabel;
    private JLabel mealsLabel;
    private JLabel checkBoxLabel;
    private JLabel walkLabel;
    private JLabel weightLabel;

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private JTextField emailTextField;

    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton preferRadioButton;
    private ButtonGroup radioButtonGroup;

    private JSpinner waterIntakeSpinner;
    private JSlider mealSlider;

    private JCheckBox wheatCheckBox;
    private JCheckBox sugarCheckBox;
    private JCheckBox diaryCheckBox;

    private JComboBox<String> walkComboBox;
    private String[] walkOptions;

    private JFormattedTextField weightFormattedTextField;

    private JButton clearButton;
    private JButton submitButton;

    private FileHandler fileHandler;

    public CustomJFrame(){
        // TODO: implement this method
        setTitle("Dietary Survey");
        setSize(380,620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        fileHandler = new FileHandler();

        headingLabel = new JLabel("Personal Information");
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name");
        phoneNumberLabel = new JLabel("Phone Number:");
        emailLabel = new JLabel("Email:");
        dietaryLabel = new JLabel("Dietary Questions");
        genderLabel = new JLabel("Sex:");
        waterLabel = new JLabel("How many cups of water on average do you drink a day?");
        mealsLabel = new JLabel("How many meals on average do you eat a day?");
        checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
        walkLabel = new JLabel("On average how many miles do you walk in a day?");
        weightLabel = new JLabel("How much do you weigh?");

        firstNameTextField = new JTextField(20);
        lastNameTextField = new JTextField(20);
        phoneNumberTextField = new JTextField(20);
        emailTextField = new JTextField(20);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        preferRadioButton = new JRadioButton("Prefer not to say");

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonGroup.add(preferRadioButton);

        waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 40, 1));

        mealSlider = new JSlider(0, 10, 3);
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setMinorTickSpacing(1);

        mealSlider.setPaintTicks(true);
        mealSlider.setPaintTicks(true);
        mealSlider.setLabelTable(mealSlider.createStandardLabels(1));

        diaryCheckBox = new JCheckBox("Dairy");
        wheatCheckBox = new JCheckBox("Wheat");
        sugarCheckBox = new JCheckBox("Sugar");

        walkOptions = new String[4];
        walkOptions[0] = "Less than 1 Mile";
        walkOptions[1] = "More than 1 mile but less than 2 miles";
        walkOptions[2] = "More than 2 miles but less than 3 miles";
        walkOptions[3] = "More than 3 miles";

        walkComboBox = new JComboBox<String>(walkOptions);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        NumberFormatter numberFormatter = new NumberFormatter();
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0);

        weightFormattedTextField = new JFormattedTextField(numberFormatter);
        weightFormattedTextField.setColumns(20);



        // Buttons
        clearButton = new JButton("Clear");
        submitButton = new JButton("Submit");

        clearButton.setBackground(Color.yellow);
        submitButton.setBackground(Color.green);

        // InnerAction Listener
        InnerActionListener buttonListener = new InnerActionListener();
        // clearButton.addActionListener(buttonListener);
        // submitButton.addActionListener(buttonListener);

        /// ==================== mainPanel layouts ====================

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gridConstraints = new GridBagConstraints();
        /// gridConstraints.insets = new Insets(2, 2, 2, 2);
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.anchor = GridBagConstraints.WEST;

        // headingLabel location
        gridConstraints.gridwidth = 2; // Occupy two columns for heading
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        mainPanel.add(headingLabel, gridConstraints);

        // firstName location
        gridConstraints.gridwidth = 1; // occupy two columns for [ label | text field ]
        gridConstraints.gridx = 0;
        gridConstraints.gridy++;    // Next row from headingLabel
        mainPanel.add(firstNameLabel, gridConstraints);
        gridConstraints.gridx++;    // Text field next column
        mainPanel.add(firstNameTextField, gridConstraints);

        gridConstraints.gridy++; // Next row
        gridConstraints.gridx = 0;
        mainPanel.add(lastNameLabel, gridConstraints);
        gridConstraints.gridx++; // Next column
        mainPanel.add(lastNameTextField, gridConstraints);

        gridConstraints.gridy++; // Next row
        gridConstraints.gridx = 0;
        mainPanel.add(phoneNumberLabel, gridConstraints);
        gridConstraints.gridx++; // Next column
        mainPanel.add(phoneNumberTextField, gridConstraints);

        gridConstraints.gridy++; // Next row
        gridConstraints.gridx = 0;
        mainPanel.add(emailLabel, gridConstraints);
        gridConstraints.gridx++; // Next column
        mainPanel.add(emailTextField, gridConstraints);

        gridConstraints.gridy++;
        gridConstraints.gridx = 0;
        mainPanel.add(genderLabel, gridConstraints);

        // Gender panel
        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(Color.lightGray);
        genderPanel.setLayout(new GridLayout(3, 1));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderPanel.add(preferRadioButton);

        gridConstraints.gridx = 1;
        mainPanel.add(genderPanel, gridConstraints);

        // Diet Label
        gridConstraints.gridy++;
        gridConstraints.gridx = 0;
        gridConstraints.gridwidth = 2;
        mainPanel.add(dietaryLabel, gridConstraints);

        // Water spinner Label
        gridConstraints.gridy++;
        mainPanel.add(waterLabel, gridConstraints);

        gridConstraints.gridy++;
        JPanel waterSpinnerPanel = new JPanel();
        waterSpinnerPanel.setBackground(Color.lightGray);
        waterSpinnerPanel.add(waterIntakeSpinner);
        mainPanel.add(waterSpinnerPanel, gridConstraints);

        // Meals slider Label
        gridConstraints.gridy++;
        mainPanel.add(mealsLabel, gridConstraints);

        gridConstraints.gridy++;
        JPanel sliderPanel = new JPanel();
        sliderPanel.setBackground(Color.lightGray);
        sliderPanel.add(mealSlider);
        mainPanel.add(sliderPanel, gridConstraints);

        // Diet checkbox Label
        gridConstraints.gridy++;
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setBackground(Color.lightGray);
        checkBoxPanel.add(diaryCheckBox);
        checkBoxPanel.add(wheatCheckBox);
        checkBoxPanel.add(sugarCheckBox);
        mainPanel.add(checkBoxPanel, gridConstraints);

        // Walk Label
        gridConstraints.gridy++;
        mainPanel.add(walkLabel, gridConstraints);

        gridConstraints.gridy++;
        mainPanel.add(walkComboBox, gridConstraints);

        // Weight Label
        gridConstraints.gridy++;
        weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(weightLabel, gridConstraints);

        gridConstraints.gridy++;
        JPanel weightPanel = new JPanel();
        weightPanel.setBackground(Color.LIGHT_GRAY);
        weightPanel.add(weightFormattedTextField);
        mainPanel.add(weightPanel, gridConstraints);

        gridConstraints.gridy++;
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.add(clearButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, gridConstraints);

        add(mainPanel);
        setVisible(true);
    }

    private class InnerActionListener  {
        // TODO: implement InnerActionListener & ActionPerformed & clearForm inside.
    }
}