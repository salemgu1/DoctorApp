import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    // for login frame
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel idLabel = new JLabel("ID");
    public JTextField userTextField = new JTextField();
    public JTextField idTextField = new JTextField();
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
        idLabel.setBounds(50, 290, 100, 30);
        idTextField.setBounds(150, 290, 150, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 370, 100, 30);
        resetButton.setBounds(200, 370, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(idLabel);
        container.add(idTextField);
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
            if ((userText.equalsIgnoreCase(User1)&&digUser1<=2&&User1.length()>=6&&User1.length()<=8 && pwdText.equalsIgnoreCase(pas1)&&digpas1>0&&pas1.indexOf("!")!=-1||pas1.indexOf("#")!=-1||pas1.indexOf("$")!=-1&&charpas>0&&pas1.length()>=8&&pas1.length()<=10&&ID.equals(ID1))||(userText.equalsIgnoreCase(User2) &&digUser1<=2&&User1.length()>=6&&User1.length()<=8 && pwdText.equalsIgnoreCase(pas1)&&digpas1>0&&pas1.indexOf("!")!=-1&&pas1.indexOf("#")!=-1&&pas1.indexOf("$")!=-1&&charpas>0&&pas1.length()>=8&&pas1.length()<=10&&ID.equals(ID2))) {
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
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}