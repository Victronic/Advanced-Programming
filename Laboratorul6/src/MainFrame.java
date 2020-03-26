//the main class for frame, here we have each component of the frame: control config and draw
//each of them are coded as shown in the lab slides
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    int width = screenSize.width/2;
    int height = screenSize.height/2;

    public MainFrame(){
        super("My Drawing App");
        rootPane.setBorder(BorderFactory.createTitledBorder("Canvas"));
        rootPane.setPreferredSize(new Dimension(width, height));
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Create components
        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        //arrange
        add(canvas, BorderLayout.CENTER);
        add(configPanel,BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);
        //invoke
        pack();
    }
}
