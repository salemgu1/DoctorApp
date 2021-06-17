import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BoxText extends JFrame implements ActionListener {
    public static TextArea box;
    JButton b;
    public JFrame frame=new JFrame();
    private ImageIcon image1;
    JLabel la;

    BoxText(){
        image1 = new ImageIcon(getClass().getResource("2.jpg"));
        la = new JLabel(image1);
        la.setBounds(40,250,400,400);
        setSize(1200,500);
        box=new TextArea();
        box.setBounds(0, 44, 226, 96);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(box);
        add(la);
        b=new JButton("add patient");
        b.setBounds(200,1000,40,20);
        add(b);
        setVisible(true);
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
