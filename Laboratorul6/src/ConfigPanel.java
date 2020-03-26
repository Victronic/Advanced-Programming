//from here we can specify some characteristic for our shapes

import javax.swing.*;

public class ConfigPanel extends JPanel  {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }
    //a spinner for sides and a combobox for color
    private void init(){
        label = new JLabel("number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(1,3,100,1));
        sidesField.setValue(6);
        String[] colorString = {"Random","Black"};
        colorCombo = new JComboBox(colorString);
        add(label);
        add(sidesField);
        add(colorCombo);

    }
}
