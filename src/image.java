import javax.swing.*;
import java.awt.*;

public class image extends JFrame {
    private ImageIcon image1;
    private JLabel label1;

    image() {
        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource("1.jpg"));
        label1 = new JLabel(image1);
        add(label1);
    }
    public static void main (String arg[]){
        image gui=new image();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("imagenrew");
    }
    }