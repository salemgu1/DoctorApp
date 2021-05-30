import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addPatient implements ActionListener {
    JButton b;
    TextArea box;
    JLabel label;
    static JTextField firstName = new JTextField();
    static JTextField lastName = new JTextField();
    static JTextField idNumber = new JTextField();
    static JTextField age = new JTextField();

    JLabel furstnamelabel = new JLabel("First Name");
    JLabel lastnamelabel = new JLabel("Last Name");
    JLabel idlabel = new JLabel("ID Number");
    JLabel agelabel = new JLabel("Age");
    JLabel Genderlabel = new JLabel("Gender");
    JFrame frame1 = new JFrame("Add Patient");
    JButton button;
    static JComboBox comboBox;

    addPatient() {
        startScreen();
    }

    public void startScreen() {
        frame1.setSize(400, 400);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);

        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createTitledBorder("Add Patient"));
        panel.setBounds(50, 30, 290, 300);


        frame1.add(panel);


//        JLabel label6 = new JLabel("ID");
//        JLabel label7 = new JLabel("Gender");
        comboBox = new JComboBox(new String[]{"Male", "Female"});
        button = new JButton("Patient Info");

        furstnamelabel.setBounds(30, 50, 100, 25);
        lastnamelabel.setBounds(30, 90, 100, 25);
        idlabel.setBounds(30, 130, 100, 25);
        agelabel.setBounds(30, 170, 100, 25);
        Genderlabel.setBounds(30, 210, 100, 25);
        firstName.setBounds(120, 50, 130, 25);
        lastName.setBounds(120, 90, 130, 25);
        idNumber.setBounds(120, 130, 130, 25);
        age.setBounds(120, 170, 130, 25);
        comboBox.setBounds(120, 210, 130, 25);
        button.setBounds(120, 255, 130, 25);

        panel.add(furstnamelabel);
        panel.add(lastnamelabel);
        panel.add(idlabel);
        panel.add(agelabel);
        panel.add(Genderlabel);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(idNumber);
        panel.add(age);
        panel.add(comboBox);
        panel.add(button);

        frame1.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                new Questions();
            }
        });

    }

//    public JTextField getField1() {
//        return field1;
//    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
