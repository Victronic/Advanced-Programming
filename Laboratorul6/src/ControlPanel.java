// From here we can save,load,reset,and exit the frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    //creating each button
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){
        this.frame=frame;
        init();
    }

    private void init(){
        //add them to tge frame
        setLayout(new GridLayout(1,4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //add functionality
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(java.awt.event.ActionEvent e){
        try{
            ImageIO.write(frame.canvas.image,"PNG",new File("C:/Users/Platon/Desktop/test.png"));
        } catch(IOException ex) {System.err.println(ex);}
    }
    //the load will work if you draw something after you press it
    private void load(java.awt.event.ActionEvent e){
            try {
                BufferedImage image = ImageIO.read(new File("C:/Users/Platon/Desktop/test1.png"));
                //frame.canvas.graphics = (Graphics2D) image.getGraphics();
                frame.canvas.graphics.drawImage(image,0,0,this);
            } catch (IOException ex) {
                System.err.println(ex);
            }
    }
    //the reset will reset the image if you again draw something
    private void reset(java.awt.event.ActionEvent e){
        repaint();
        setPreferredSize(new Dimension(DrawingPanel.W,DrawingPanel.H));
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0,0, DrawingPanel.W, DrawingPanel.H);
    }
    private void exit(java.awt.event.ActionEvent e){
        System.exit(0);
    }
}