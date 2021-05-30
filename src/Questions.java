import javax.swing.*;
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
    JLabel label5 = new JLabel("HCT");
    JLabel label6 = new JLabel("Urea");
    JLabel label7 = new JLabel("Hb");
    JLabel label8 = new JLabel("Creatinine");
    JLabel label9 = new JLabel("Iron");
    JLabel label10 = new JLabel("HDL");
    JLabel label11 = new JLabel("AP");
    JButton button_toAddDitails = new JButton("Add User");

    Questions(){

        JFrame frame = new JFrame("add patient");
        frame.setSize(400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createTitledBorder("Patient"));
        panel.setBounds(50, 30, 290, 600);

        label1.setBounds(30, 50, 100, 25);
        label2.setBounds(30, 90, 100, 25);
        label3.setBounds(30, 130, 100, 25);
        label4.setBounds(30, 170, 100, 25);
        label5.setBounds(30, 210, 100, 25);
        label6.setBounds(30, 250, 100, 25);
        label7.setBounds(30, 290, 100, 25);
        label8.setBounds(30, 330, 100, 25);
        label9.setBounds(30, 370, 100, 25);
        label10.setBounds(30, 410, 100, 25);
        label11.setBounds(30, 450, 100, 25);
        WBC.setBounds(120, 50, 130, 25);
        Neut.setBounds(120, 90, 130, 25);
        Lymph.setBounds(120, 130, 130, 25);
        RBC.setBounds(120, 170, 130, 25);
        HCT.setBounds(120, 210, 130, 25);
        Urea.setBounds(120, 250, 130, 25);
        Hb.setBounds(120, 290, 130, 25);
        Creatinine.setBounds(120, 330, 130, 25);
        Iron.setBounds(120, 370, 130, 25);
        HDL.setBounds(120, 410, 130, 25);
        AP.setBounds(120, 450, 130, 25);
        button_toAddDitails.setBounds(120, 535, 130, 25);

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


        frame.add(panel);
        frame.setVisible(true);

        button_toAddDitails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addData();
            }
        });
    }
//    public static void main(String[] a) {
//        new Questions();
//    }
}
