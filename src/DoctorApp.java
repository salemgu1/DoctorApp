import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorApp extends JFrame implements ActionListener {
    // for login frame
    Container container = getContentPane();
    private ImageIcon image1;
    JPanel pane =new JPanel();
    JLabel la;
    JPanel pane1=new JPanel();
     JLabel lab = new JLabel("Welcome to our software that offers the treatment Best suited for the patient!");
     JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel idLabel = new JLabel("ID");
    JLabel background;
    public static JTextField userTextField = new JTextField();
    public JTextField idTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    private Icon icon = new ImageIcon("2.jpg");



    DoctorApp() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();


        addActionEvent();


    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        image1 = new ImageIcon(getClass().getResource("1.jpg"));
        la = new JLabel(image1);
        la.setBounds(650,60,700,550);
        lab.setForeground(Color.BLUE);
        lab.setBounds(30,90,600,30);
        userLabel.setBounds(50, 150, 100, 30);
        userLabel.setForeground(new Color(153,0,153));
        passwordLabel.setBounds(50, 220, 100, 30);
        passwordLabel.setForeground(new Color(153,0,153));
        idLabel.setBounds(50, 290, 100, 30);
        idLabel.setForeground(new Color(153,0,153));
        idTextField.setBounds(150, 290, 150, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 370, 100, 30);
        resetButton.setBounds(200, 370, 100, 30);

    }

    public void addComponentsToContainer() {
        pane.setBounds(50,110,300,30);
        pane.setVisible(true);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.lightGray);
        JLabel a=new JLabel("Sign in Doctor");
        a.setBackground(Color.GREEN);
        panel.setBorder(BorderFactory.createTitledBorder(a.getText()));
        panel.setForeground(Color.red);
        panel.setBounds(50, 50, 600, 600);

        panel.add(lab);
        panel.add(userLabel);
        panel.add(passwordLabel);
        panel.add(userTextField);
        panel.add(passwordField);
        panel.add(showPassword);
        panel.add(loginButton);
        panel.add(resetButton);
        panel.add(idLabel);
        panel.add(idTextField);
        container.add(la);
        container.add(panel);
        container.add(pane);
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
            String ID=idTextField.getText();
            String User1="salem12";
            String User2="ahmed12";
            int digUser1=countDigits(User1);
            int digUser2=countDigits(User2);
            String pas1="s123456!";
            int digpas1=countDigits(pas1);
            int charpas=countChars(pas1);
            String ID1="221133";
            String ID2="221122";

            if (((userText.equalsIgnoreCase(User1)&&digUser1<=2&&User1.length()>=6&&User1.length()<=8 && pwdText.equalsIgnoreCase(pas1)&&digpas1>0&&(pas1.indexOf("!")!=-1||pas1.indexOf("#")!=-1||pas1.indexOf("$")!=-1)&&charpas>0&&pas1.length()>=8&&pas1.length()<=10&&ID.equals(ID1)))) {
                setVisible(false);
                new BoxText();
            }
            else if (((userText.equalsIgnoreCase(User2)&&digUser2<=2&&User2.length()>=6&&User2.length()<=8 && pwdText.equalsIgnoreCase(pas1)&&digpas1>0&&(pas1.indexOf("!")!=-1||pas1.indexOf("#")!=-1||pas1.indexOf("$")!=-1)&&charpas>0&&pas1.length()>=8&&pas1.length()<=10&&ID.equals(ID2))))
            {
                setVisible(false);
                new BoxText();
            }
            else {
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

    public int countDigits(String s){
        int counter = 0;
        for(char c : s.toCharArray()) {
            if( c >= '0' && c<= '9') {
                ++counter;
            }
        }
        return counter;
    }

    public int countChars(String s){
        int count=0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ')
                count++;
        }
        return count;
    }
}
class Login {
    public static void main(String[] a) {
        DoctorApp frame = new DoctorApp();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}