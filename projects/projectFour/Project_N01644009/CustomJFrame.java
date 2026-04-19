package unf.edu.cop3503;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * CustomJFrame class
 *
 * This class creates the GUI for the dietary survey program.
 * It allows the user to enter personal information and answer
 * dietary-related questions. When the form is submitted,
 * the data is collected and written to a CSV file.
 *
 * @author Albert Simpson
 * @version Project 4
 */
public class CustomJFrame extends JFrame {

    // Labels for the form
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

    // Text fields for personal information
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private JTextField emailTextField;

    // Radio buttons for gender selection
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton preferRadioButton;
    private ButtonGroup radioButtonGroup;

    // Input components for dietary questions
    private JSpinner waterIntakeSpinner;
    private JSlider mealSlider;

    // Check boxes for food categories
    private JCheckBox wheatCheckBox;
    private JCheckBox sugarCheckBox;
    private JCheckBox dairyCheckBox;

    // Combo box for walking distance options
    private JComboBox<String> walkComboBox;
    private String[] walkOptions;

    // Formatted text field for weight input
    private JFormattedTextField weightFormattedTextField;

    // Buttons for clearing and submitting the form
    private JButton clearButton;
    private JButton submitButton;

    // File handler used to write survey results
    private FileHandler fileHandler;

    /**
     * Default constructor.
     *
     * This constructor builds the GUI, creates all components,
     * sets up the layout, and makes the window visible.
     */
    public CustomJFrame(){

        // Set up the main frame
        setTitle("Dietary Survey");
        setSize(380,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create file handler object
        fileHandler = new FileHandler();

        // Create labels
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

        // Create text fields
        firstNameTextField = new JTextField(20);
        lastNameTextField = new JTextField(20);
        phoneNumberTextField = new JTextField(20);
        emailTextField = new JTextField(20);

        // Create radio buttons
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        preferRadioButton = new JRadioButton("Prefer not to say");

        // Make radio button backgrounds transparent
        maleRadioButton.setOpaque(false);
        femaleRadioButton.setOpaque(false);
        preferRadioButton.setOpaque(false);

        // Group radio buttons so only one can be selected
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonGroup.add(preferRadioButton);

        // Create spinner for water intake
        waterIntakeSpinner = new JSpinner(new SpinnerNumberModel(15, 0, 50, 1));

        // Create slider for number of meals
        mealSlider = new JSlider(0, 10, 3);
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setMinorTickSpacing(1);
        mealSlider.setPaintLabels(true);
        mealSlider.setPaintTicks(true);

        // Create check boxes
        dairyCheckBox = new JCheckBox("Dairy");
        wheatCheckBox = new JCheckBox("Wheat");
        sugarCheckBox = new JCheckBox("Sugar");

        // Make check box backgrounds transparent
        dairyCheckBox.setOpaque(false);
        wheatCheckBox.setOpaque(false);
        sugarCheckBox.setOpaque(false);

        // Create walking distance options
        walkOptions = new String[4];
        walkOptions[0] = "Less than 1 Mile";
        walkOptions[1] = "More than 1 mile but less than 2 miles";
        walkOptions[2] = "More than 2 miles but less than 3 miles";
        walkOptions[3] = "More than 3 miles";

        // Create combo box using the walking options
        walkComboBox = new JComboBox<>(walkOptions);

        // Create formatter so weight input only accepts valid numbers
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0);

        // Create formatted text field for weight
        weightFormattedTextField = new JFormattedTextField(numberFormatter);
        weightFormattedTextField.setColumns(20);

        // Create buttons
        clearButton = new JButton("Clear");
        submitButton = new JButton("Submit");

        // Set button colors
        clearButton.setBackground(Color.yellow);
        submitButton.setBackground(Color.green);

        // Create listener object for both buttons
        InnerActionListener buttonListener = new InnerActionListener();
        clearButton.addActionListener(buttonListener);
        submitButton.addActionListener(buttonListener);

        /// ============= START mainPanel layout with GridBagLayout =============

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setLayout(new GridBagLayout());

        // Create layout constraints
        GridBagConstraints gridConstraints = new GridBagConstraints();

        // Insets to add padding around each component
        gridConstraints.insets = new Insets(5, 5, 5, 5);

        // Stretch components horizontally
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.anchor = GridBagConstraints.WEST;

        // Add heading label
        gridConstraints.gridwidth = 2; // Occupy two columns for heading
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        mainPanel.add(headingLabel, gridConstraints);

        // Add first name label and text field
        gridConstraints.gridwidth = 1; // occupy two columns for [ label | text field ]
        gridConstraints.gridx = 0;
        gridConstraints.gridy++;    // Next row from headingLabel
        mainPanel.add(firstNameLabel, gridConstraints);
        gridConstraints.gridx++;    // Text field next column
        mainPanel.add(firstNameTextField, gridConstraints);

        // Add last name label and text field
        gridConstraints.gridy++; // Next row
        gridConstraints.gridx = 0;
        mainPanel.add(lastNameLabel, gridConstraints);
        gridConstraints.gridx++; // Next column
        mainPanel.add(lastNameTextField, gridConstraints);

        // Add phone number label and text field
        gridConstraints.gridy++; // Next row
        gridConstraints.gridx = 0;
        mainPanel.add(phoneNumberLabel, gridConstraints);
        gridConstraints.gridx++; // Next column
        mainPanel.add(phoneNumberTextField, gridConstraints);

        // Add email label and text field
        gridConstraints.gridy++; // Next row
        gridConstraints.gridx = 0;
        mainPanel.add(emailLabel, gridConstraints);
        gridConstraints.gridx++; // Next column
        mainPanel.add(emailTextField, gridConstraints);

        // Add sex label
        gridConstraints.gridy++;
        gridConstraints.gridx = 0;
        mainPanel.add(genderLabel, gridConstraints);

        // Create panel for gender radio buttons
        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(Color.lightGray);
        genderPanel.setLayout(new GridLayout(3, 1));
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderPanel.add(preferRadioButton);

        // Add radio button panel
        gridConstraints.gridx = 1;
        mainPanel.add(genderPanel, gridConstraints);

        // Add dietary questions heading
        gridConstraints.gridy++;
        gridConstraints.gridx = 0;
        gridConstraints.gridwidth = 2;
        mainPanel.add(dietaryLabel, gridConstraints);

        // Add water intake label
        gridConstraints.gridy++;
        mainPanel.add(waterLabel, gridConstraints);

        // Add spinner panel
        gridConstraints.gridy++;
        JPanel waterSpinnerPanel = new JPanel();
        waterSpinnerPanel.setBackground(Color.lightGray);
        waterSpinnerPanel.add(waterIntakeSpinner);
        mainPanel.add(waterSpinnerPanel, gridConstraints);

        // Add meals label
        gridConstraints.gridy++;
        mainPanel.add(mealsLabel, gridConstraints);

        // Add meals slider panel
        gridConstraints.gridy++;
        JPanel sliderPanel = new JPanel();
        sliderPanel.setBackground(Color.lightGray);
        mealSlider.setOpaque(false);
        sliderPanel.add(mealSlider);
        mainPanel.add(sliderPanel, gridConstraints);

        // Add diet checkbox section label
        gridConstraints.gridy++;
        mainPanel.add(checkBoxLabel, gridConstraints);

        // Add checkbox panel
        gridConstraints.gridy++;
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setBackground(Color.lightGray);
        checkBoxPanel.add(dairyCheckBox);
        checkBoxPanel.add(wheatCheckBox);
        checkBoxPanel.add(sugarCheckBox);
        mainPanel.add(checkBoxPanel, gridConstraints);

        // Add walking distance label
        gridConstraints.gridy++;
        mainPanel.add(walkLabel, gridConstraints);

        // Add walk combo box
        gridConstraints.gridy++;
        mainPanel.add(walkComboBox, gridConstraints);

        // Add weight label
        gridConstraints.gridy++;
        weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(weightLabel, gridConstraints);

        // Add weight field panel
        gridConstraints.gridy++;
        JPanel weightPanel = new JPanel();
        weightPanel.setBackground(Color.lightGray);
        weightPanel.add(weightFormattedTextField);
        mainPanel.add(weightPanel, gridConstraints);

        // Add button panel
        gridConstraints.gridy++;
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBackground(Color.lightGray);
        buttonPanel.add(clearButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, gridConstraints);

        // Add main panel to frame and show the window
        add(mainPanel);
        setVisible(true);
    }

    /**
     * InnerActionListener class
     *
     * This inner class handles button click events
     * for the Submit and Clear buttons.
     */
    private class InnerActionListener implements ActionListener {

        /**
         * Responds to button click events.
         *
         * If the Submit button is clicked, the method collects
         * all form values, formats them into a CSV string,
         * writes the results to the file, and clears the form.
         *
         * If the Clear button is clicked, the form is reset.
         *
         * @param e the ActionEvent triggered by the button click
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            // Check if the submit button was clicked
            if (e.getSource() == submitButton) {

                // Get text entered by the user
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String phoneNum = phoneNumberTextField.getText();
                String email = emailTextField.getText();

                // Determine which sex radio button was selected
                String sex = "null";
                if(maleRadioButton.isSelected()) {
                    sex = "Male";
                } else if (femaleRadioButton.isSelected()) {
                    sex = "Female";
                } else if (preferRadioButton.isSelected()) {
                    sex = "Prefer not to say";
                }

                // Get spinner and slider values
                String water = waterIntakeSpinner.getValue().toString();
                String meals = Integer.toString(mealSlider.getValue());

                /// START Food Check Boxes
                // Check which foods were selected
                // If-branching to set boolean values to capitalized
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
                /// End Food Check Boxes

                // Get selected walking distance
                String miles = walkComboBox.getSelectedItem().toString();

                // Check if weight field is empty
                String weight;
                if (weightFormattedTextField.getValue() == null) {
                    weight = "null";
                } else {
                    weight = weightFormattedTextField.getText();
                }

                // Format the current date and time
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
                String dateTime = LocalDateTime.now().format(formatter);

                // Combine all survey data into one CSV line
                String surveyData = dateTime + "," + firstName + "," + lastName  + "," + phoneNum  + "," +
                        email + "," + sex + "," + water + "," + meals  + "," +wheat  + "," + sugar  + "," +
                        dairy  + "," + miles  + "," + weight;

                // Write the survey data to the file
                fileHandler.writeResults(surveyData);

                // Reset the form after submission
                clearForm();
            } else if (e.getSource() == clearButton) { // Check if the clear button was clicked
                clearForm();
            }
        }

        /**
         * Clears and resets all form components
         * back to their default values.
         */
        private void clearForm() {

            // Clear all text fields
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            phoneNumberTextField.setText("");
            emailTextField.setText("");

            // Clear radio button selection
            radioButtonGroup.clearSelection();

            // Reset spinner and slider
            waterIntakeSpinner.setValue(15);
            mealSlider.setValue(3);

            // Uncheck all check boxes
            dairyCheckBox.setSelected(false);
            wheatCheckBox.setSelected(false);
            sugarCheckBox.setSelected(false);

            // Reset combo box and weight field
            walkComboBox.setSelectedIndex(0);
            weightFormattedTextField.setValue(null);
        }
    }
}