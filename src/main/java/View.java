import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {

    private JPanel termsPanel, operationsPanel, errorPanel;
    public JTextField termOneField, termTwoField, resultField;
    private JLabel errorLabel;
    private JButton addButton, subtractButton, multiplyButton,
            divideButton, deriveButton, integrateButton;

    public View(){
       // JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout mainPanelLayout = new GridLayout(3,1);
        mainPanelLayout.setVgap(15);
        JPanel mainPanel = new JPanel(mainPanelLayout);

        termsPanel = initializeTermsPanel();
        operationsPanel = initializeOperationsPanel();
        errorPanel = initializeErrorPanel();

        mainPanel.add(termsPanel);
        mainPanel.add(operationsPanel);
        mainPanel.add(errorPanel);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30 ,30 ,30));

        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private JPanel initializeTermsPanel(){
        GridLayout termsPanelLayout = new GridLayout(3,2);
        termsPanelLayout.setVgap(10);
        JPanel termsPanel = new JPanel(termsPanelLayout);
        JLabel termOneLabel = new JLabel("First term: ");
        JLabel termTwoLabel = new JLabel("Second term: ");
        JLabel resultLabel = new JLabel("Result: ");
        termOneField = new JTextField(20);
        termTwoField = new JTextField(20);
        resultField = new JTextField(20);
        resultField.setEditable(false);
        termsPanel.add(termOneLabel);
        termsPanel.add(termOneField);
        termsPanel.add(termTwoLabel);
        termsPanel.add(termTwoField);
        termsPanel.add(resultLabel);
        termsPanel.add(resultField);

        return termsPanel;

    }

    private JPanel initializeOperationsPanel(){
        this.addButton = new JButton("ADD");
        this.subtractButton = new JButton("SUBTRACT");
        this.multiplyButton = new JButton("MULTIPLY");
        this.divideButton = new JButton("DIVIDE");
        this.deriveButton = new JButton("DERIVE");
        this.integrateButton = new JButton("INTEGRATE");

        JPanel operationsPanel = new JPanel(new GridLayout(2,3));
        operationsPanel.add(addButton);
        operationsPanel.add(subtractButton);
        operationsPanel.add(multiplyButton);
        operationsPanel.add(divideButton);
        operationsPanel.add(deriveButton);
        operationsPanel.add(integrateButton);

        return operationsPanel;
    }

    private JPanel initializeErrorPanel(){
        JPanel errorPanel = new JPanel(new FlowLayout());
        errorLabel = new JLabel("Aici apare eroarea");
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        errorPanel.add(errorLabel);
        return errorPanel;
    }

    public String getTermOne(){return termOneField.getText();}
    public String getTermTwo(){
        return termTwoField.getText();
    }
    public void setResult(String result){
        resultField.setText(result);
    }
    public void setError(String error){
        this.errorLabel.setText(error);
    }

    // Action Listener setters
    public void setAddButtonActionListener(ActionListener addButtonActionListener) {
        addButton.addActionListener(addButtonActionListener);
    }
    public void setSubstractButtonActionListener(ActionListener subtractButtonActionListener) {
        this.subtractButton.addActionListener(subtractButtonActionListener);
    }
    public void setMultiplyButtonActionListener(ActionListener multiplyButtonActionListener) {
        this.multiplyButton.addActionListener(multiplyButtonActionListener);
    }
    public void setDivideButtonActionListener(ActionListener divideButtonActionListener) {
        this.divideButton.addActionListener(divideButtonActionListener);
    }
    public void setDeriveButtonActionListener(ActionListener deriveButtonActionListener) {
        this.deriveButton.addActionListener(deriveButtonActionListener);
    }
    public void setIntegrateButtonActionListener(ActionListener integrateButtonActionListener) {
        this.integrateButton.addActionListener(integrateButtonActionListener);
    }
}
