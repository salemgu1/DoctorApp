import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Questions {

    static JTextField WBC = new JTextField();
    static JTextField Neut = new JTextField();
    static JTextField Lymph = new JTextField();
    static JTextField RBC = new JTextField();
    static JTextField HCT = new JTextField();
    static JTextField Urea = new JTextField();
    static JTextField Hb = new JTextField();
    static JTextField Creatinine = new JTextField();
    static JTextField Iron = new JTextField();
    static JTextField HDL = new JTextField();
    static JTextField AP = new JTextField();
    JLabel label1 = new JLabel("WBC");
    JLabel label2 = new JLabel("Neut");
    JLabel label3 = new JLabel("Lymph");
    JLabel label4 = new JLabel("RBC");
    JLabel label5 = new JLabel("HCT(%)");
    JLabel label6 = new JLabel("Urea");
    JLabel label7 = new JLabel("Hb");
    JLabel label8 = new JLabel("Creatinine");
    JLabel label9 = new JLabel("Iron");
    JLabel label10 = new JLabel("HDL");
    JLabel label11 = new JLabel("AP");
    JButton button_toAddDitails = new JButton("Add User");

    Questions(){

        JFrame frame = new JFrame("add patient");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel l=new JLabel("Hello Doctor "+DoctorApp.userTextField.getText()+" Please Enter Tests for the patient "+addPatient.firstName.getText());
        l.setForeground(Color.BLUE);
        l.setBounds(10,30,500,30);

        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createTitledBorder("Patient"));
        panel.setBackground(Color.lightGray);
        panel.setBounds(50, 30, 500, 600);

        label1.setBounds(30, 80, 100, 25);
        label1.setForeground(new Color(153,0,153));
        label2.setBounds(30, 120, 100, 25);
        label2.setForeground(new Color(153,0,153));
        label3.setBounds(30, 160, 100, 25);
        label3.setForeground(new Color(153,0,153));
        label4.setBounds(30, 200, 100, 25);
        label4.setForeground(new Color(153,0,153));
        label5.setBounds(30, 240, 100, 25);
        label5.setForeground(new Color(153,0,153));
        label6.setBounds(30, 280, 100, 25);
        label6.setForeground(new Color(153,0,153));
        label7.setBounds(30, 320, 100, 25);
        label7.setForeground(new Color(153,0,153));
        label8.setBounds(30, 360, 100, 25);
        label8.setForeground(new Color(153,0,153));
        label9.setBounds(30, 400, 100, 25);
        label9.setForeground(new Color(153,0,153));
        label10.setBounds(30, 440, 100, 25);
        label10.setForeground(new Color(153,0,153));
        label11.setBounds(30, 480, 100, 25);
        label11.setForeground(new Color(153,0,153));
        WBC.setBounds(120, 80, 130, 25);
        Neut.setBounds(120, 120, 130, 25);
        Lymph.setBounds(120, 160, 130, 25);
        RBC.setBounds(120, 200, 130, 25);
        HCT.setBounds(120, 240, 130, 25);
        Urea.setBounds(120, 280, 130, 25);
        Hb.setBounds(120, 320, 130, 25);
        Creatinine.setBounds(120, 360, 130, 25);
        Iron.setBounds(120, 400, 130, 25);
        HDL.setBounds(120, 440, 130, 25);
        AP.setBounds(120, 480, 130, 25);
        button_toAddDitails.setBounds(120, 565, 130, 25);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);
        panel.add(label11);
        panel.add(WBC);
        panel.add(Neut);
        panel.add(Lymph);
        panel.add(RBC);
        panel.add(HCT);
        panel.add(Urea);
        panel.add(Hb);
        panel.add(Creatinine);
        panel.add(Iron);
        panel.add(HDL);
        panel.add(AP);
        panel.add(button_toAddDitails);
        panel.add(l);


        frame.add(panel);
        frame.setVisible(true);

        button_toAddDitails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new addData();
            }
        });
    }
}