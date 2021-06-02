import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BoxText extends JFrame implements ActionListener {
    public static TextArea box;
    JButton b;
    public static JButton bot;
    public JFrame frame=new JFrame();
    JButton button;
    JComboBox comboBox;

    BoxText(){
        frame.setSize(1200,500);
        box=new TextArea();
        box.setBounds(113, 44, 226, 96);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(box);
        b=new JButton("add patient");
        b.setBounds(200,1000,40,20);
        frame.add(b);
        frame.setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addPatient();

            }
        });
    }
    public void addPatient(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
//            File f=new File("/Users/salemgod/Desktop/salemmm.txt");

            frame.setVisible(false);
            new addPatient();
        }
    }


    public static void main(String args[]){
        new BoxText();
    }
}
