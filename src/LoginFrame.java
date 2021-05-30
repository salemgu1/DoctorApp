import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    //for box text
    public TextArea box;
    JButton b;
    JFrame frame=new JFrame();

    //for add patient
    JTextField firstName;
    JTextField lastName;
    JTextField idNumber;
    JTextField age;

    JLabel furstnamelabel = new JLabel("First Name");
    JLabel lastnamelabel = new JLabel("Last Name");
    JLabel idlabel = new JLabel("ID Number");
    JLabel agelabel = new JLabel("Age");
    JLabel Genderlabel = new JLabel("Gender");
    JFrame frame1;
    JButton button;
    JComboBox comboBox;

    //for Questions
    JTextField WBC = new JTextField();
    JTextField Neut = new JTextField();
    JTextField Lymph = new JTextField();
    JTextField RBC = new JTextField();
    JTextField HCT = new JTextField();
    JTextField Urea = new JTextField();
    JTextField Hb = new JTextField();
    JTextField Creatinine = new JTextField();
    JTextField Iron = new JTextField();
    JTextField HDL = new JTextField();
    JTextField AP = new JTextField();
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


    // for login frame
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    public JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    //    JButton b=new JButton("ss");
    JCheckBox showPassword = new JCheckBox("Show Password");
//    JFrame f;

    // add data
    JFrame f = new JFrame();
    JComboBox comboBox1;
    String[] str;
    static int i = 0;


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if ((userText.equalsIgnoreCase("salem") && pwdText.equalsIgnoreCase("12345"))||(userText.equalsIgnoreCase("ahmed") && pwdText.equalsIgnoreCase("12345"))) {
                setVisible(false);
                new BoxText();
//                new addPatient();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

//    public void BoxText(){
//        frame.setSize(1200,500);
//        box=new TextArea();
//        box.setBounds(10,200,600,300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
//        frame.add(box);

//        b=new JButton("add patient");
//        b.setBounds(200,1000,40,20);
//        frame.add(b);
//        frame.setVisible(true);
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addData();
////                addPatient a=new addPatient();
////                System.out.println((new addPatient()).field1.getText());
////                System.out.println(box.getText());
//
//            }
//        });
//    }
//
//
//    public void addPatient(){
//        JTextField firstName = new JTextField();
//        JTextField lastName = new JTextField();
//        JTextField idNumber = new JTextField();
//        JTextField age = new JTextField();
//        frame1 = new JFrame("Add Patient");
//        frame1.setSize(400, 400);
//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame1.setLayout(null);
//
//        JPanel panel = new JPanel(null);
//        panel.setBorder(BorderFactory.createTitledBorder("Add Patient"));
//        panel.setBounds(50, 30, 290, 300);
//
//
//        frame1.add(panel);
//
//
////        JLabel label6 = new JLabel("ID");
////        JLabel label7 = new JLabel("Gender");
//        comboBox = new JComboBox(new String[]{"Male", "Female"});
//        button = new JButton("Patient Info");
//
//        furstnamelabel.setBounds(30, 50, 100, 25);
//        lastnamelabel.setBounds(30, 90, 100, 25);
//        idlabel.setBounds(30, 130, 100, 25);
//        agelabel.setBounds(30, 170, 100, 25);
//        Genderlabel.setBounds(30, 210, 100, 25);
//        firstName.setBounds(120, 50, 130, 25);
//        lastName.setBounds(120, 90, 130, 25);
//        idNumber.setBounds(120, 130, 130, 25);
//        age.setBounds(120, 170, 130, 25);
//        comboBox.setBounds(120, 210, 130, 25);
//        button.setBounds(120, 255, 130, 25);
//
//        panel.add(furstnamelabel);
//        panel.add(lastnamelabel);
//        panel.add(idlabel);
//        panel.add(agelabel);
//        panel.add(Genderlabel);
//        panel.add(firstName);
//        panel.add(lastName);
//        panel.add(idNumber);
//        panel.add(age);
//        panel.add(comboBox);
//        panel.add(button);
//
//        frame1.setVisible(true);
//
//
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame1.setVisible(false);
//                Questions();
//            }
//        });
//
//    }
//fdf
//
//    public void Questions(){
//
//        JFrame frame = new JFrame("add patient");
//        frame.setSize(400, 800);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(null);
//
//        JPanel panel = new JPanel(null);
//        panel.setBorder(BorderFactory.createTitledBorder("Patient"));
//        panel.setBounds(50, 30, 290, 600);
//
//        label1.setBounds(30, 50, 100, 25);
//        label2.setBounds(30, 90, 100, 25);
//        label3.setBounds(30, 130, 100, 25);
//        label4.setBounds(30, 170, 100, 25);
//        label5.setBounds(30, 210, 100, 25);
//        label6.setBounds(30, 250, 100, 25);
//        label7.setBounds(30, 290, 100, 25);
//        label8.setBounds(30, 330, 100, 25);
//        label9.setBounds(30, 370, 100, 25);
//        label10.setBounds(30, 410, 100, 25);
//        label11.setBounds(30, 450, 100, 25);
//        WBC.setBounds(120, 50, 130, 25);
//        Neut.setBounds(120, 90, 130, 25);
//        Lymph.setBounds(120, 130, 130, 25);
//        RBC.setBounds(120, 170, 130, 25);
//        HCT.setBounds(120, 210, 130, 25);
//        Urea.setBounds(120, 250, 130, 25);
//        Hb.setBounds(120, 290, 130, 25);
//        Creatinine.setBounds(120, 330, 130, 25);
//        Iron.setBounds(120, 370, 130, 25);
//        HDL.setBounds(120, 410, 130, 25);
//        AP.setBounds(120, 450, 130, 25);
//        button_toAddDitails.setBounds(120, 535, 130, 25);
//
//        panel.add(label1);
//        panel.add(label2);
//        panel.add(label3);
//        panel.add(label4);
//        panel.add(label5);
//        panel.add(label6);
//        panel.add(label7);
//        panel.add(label8);
//        panel.add(label9);
//        panel.add(label10);
//        panel.add(label11);
//        panel.add(WBC);
//        panel.add(Neut);
//        panel.add(Lymph);
//        panel.add(RBC);
//        panel.add(HCT);
//        panel.add(Urea);
//        panel.add(Hb);
//        panel.add(Creatinine);
//        panel.add(Iron);
//        panel.add(HDL);
//        panel.add(AP);
//        panel.add(button_toAddDitails);
//
//
//        frame.add(panel);
//        frame.setVisible(true);
//
//        button_toAddDitails.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addData();
//            }
//        });
//    }
//
//    public void addData(){
//        str = new String[i];
//        //        System.out.println(str.length);
////        System.out.println(str.toString());
//        comboBox1 = new JComboBox(str);
//        comboBox1.setBounds(100, 50, 100, 20);
//        f.setSize(400, 400);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setLayout(null);
//        f.add(comboBox1);
//        f.setVisible(true);
//    }

}
class Login {
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}