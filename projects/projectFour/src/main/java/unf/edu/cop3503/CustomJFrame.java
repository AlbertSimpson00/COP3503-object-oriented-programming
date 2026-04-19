package unf.edu.cop3503;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JCheckBox dairyCheckBox;

    private JComboBox<String> walkComboBox;
    private String[] walkOptions;

    private JFormattedTextField weightFormattedTextField;

    private JButton clearButton;
    private JButton submitButton;

    private FileHandler fileHandler;

    public CustomJFrame(){
        // TODO: implement this method
        setTitle("Dietary Survey");
        setSize(380,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        fileHandler = new FileHandler();

        headingLabel = new JLabel("Personal Information", SwingConstants.CENTER);
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        phoneNumberLabel = new JLabel("Phone Number:");
        emailLabel = new JLabel("Email:");
        dietaryLabel = new JLabel("Dietary Questions", SwingConstants.CENTER);
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

        maleRadioButton.setOpaque(false);
        femaleRadioButton.setOpaque(false);
        preferRadioButton.setOpaque(false);

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonGroup.add(preferRadioButton);

        waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));

        mealSlider = new JSlider(0, 10, 3);
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setMinorTickSpacing(1);

        mealSlider.setPaintLabels(true);
        mealSlider.setPaintTicks(true);

        dairyCheckBox = new JCheckBox("Dairy");
        wheatCheckBox = new JCheckBox("Wheat");
        sugarCheckBox = new JCheckBox("Sugar");

        dairyCheckBox.setOpaque(false);
        wheatCheckBox.setOpaque(false);
        sugarCheckBox.setOpaque(false);

        walkOptions = new String[4];
        walkOptions[0] = "Less than 1 Mile";
        walkOptions[1] = "More than 1 mile but less than 2 miles";
        walkOptions[2] = "More than 2 miles but less than 3 miles";
        walkOptions[3] = "More than 3 miles";

        walkComboBox = new JComboBox<String>(walkOptions);

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
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
        clearButton.addActionListener(buttonListener);
        submitButton.addActionListener(buttonListener);

        /// ==================== mainPanel layouts ====================

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints gridConstraints = new GridBagConstraints();

        // Insets to add padding between each label
        gridConstraints.insets = new Insets(5, 5, 5, 5);

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
        mealSlider.setOpaque(false);
        sliderPanel.add(mealSlider);
        mainPanel.add(sliderPanel, gridConstraints);

        // Diet checkbox Label
        gridConstraints.gridy++;
        mainPanel.add(checkBoxLabel, gridConstraints);

        gridConstraints.gridy++;
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setBackground(Color.lightGray);
        checkBoxPanel.add(dairyCheckBox);
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
        weightPanel.setBackground(Color.lightGray);
        weightPanel.add(weightFormattedTextField);
        mainPanel.add(weightPanel, gridConstraints);

        gridConstraints.gridy++;
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBackground(Color.lightGray);
        buttonPanel.add(clearButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, gridConstraints);

        add(mainPanel);
        setVisible(true);
    }

    private class InnerActionListener implements ActionListener {
        // TODO: implement InnerActionListener & ActionPerformed & clearForm inside.

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton) {
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String phoneNum = phoneNumberTextField.getText();
                String email = emailTextField.getText();

                String sex = "null";
                if(maleRadioButton.isSelected()) {
                    sex = "Male";
                } else if (femaleRadioButton.isSelected()) {
                    sex = "Female";
                } else if (preferRadioButton.isSelected()) {
                    sex = "Prefer not to say";
                }

                String water = waterIntakeSpinner.getValue().toString();
                String meals = Integer.toString(mealSlider.getValue());

                String wheat;
                if (wheatCheckBox.isSelected()) {
                    wheat = "TRUE";
                } else {
                    wheat = "FALSE";
                }

                String sugar;
                if (sugarCheckBox.isSelected()) {
                    sugar = "TRUE";
                } else {
                    sugar = "FALSE";
                }

                String dairy;
                if (dairyCheckBox.isSelected()) {
                    dairy = "TRUE";
                } else {
                    dairy = "FALSE";
                }

                String miles = walkComboBox.getSelectedItem().toString();

                String weight;
                if (weightFormattedTextField.getValue() == null) {
                    weight = "null";
                } else {
                    weight = weightFormattedTextField.getText();
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                String dateTime = LocalDateTime.now().format(formatter);

                String surveyData = dateTime + "," + firstName + "," + lastName  + "," + phoneNum  + "," +
                        email + "," + sex + "," + water + "," + meals  + "," +wheat  + "," + sugar  + "," +
                        dairy  + "," + miles  + "," + weight;

                fileHandler.writeResults(surveyData);
                clearForm();
            } else if (e.getSource() == clearButton) {
                clearForm();
            }
        }

        private void clearForm() {
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            phoneNumberTextField.setText("");
            emailTextField.setText("");

            radioButtonGroup.clearSelection();

            waterIntakeSpinner.setValue(15);
            mealSlider.setValue(3);

            dairyCheckBox.setSelected(false);
            wheatCheckBox.setSelected(false);
            sugarCheckBox.setSelected(false);

            walkComboBox.setSelectedIndex(0);
            weightFormattedTextField.setValue(null);
        }
    }
}