import javax.swing.*;
//import addPatient;

public class addData {

    JFrame f = new JFrame();
    static JComboBox comboBox1;
    static String[] str;
    static int i = 1;


    addData() {
        str = new String[i];
        addName(str, addPatient.firstName.getText());
//        System.out.println(str.toString());
        comboBox1 = new JComboBox(str);
        comboBox1.setBounds(100, 50, 100, 20);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.add(comboBox1);
        f.setVisible(true);


    }


    public void addName(String[] str, String name) {
        int n = str.length;
        String newArr[] = new String[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i] = str[i];
        }
        newArr[n] = name;

        this.str = newArr;
    }

    public String checkWBC() {
        if (Integer.parseInt(addPatient.age.getText()) > 18 && Integer.parseInt(Questions.WBC.getText()) > 4500 && Integer.parseInt(Questions.WBC.getText()) < 1100) {
            return "proper WBC";
        }
        else if (Integer.parseInt(addPatient.age.getText()) > 18 && Integer.parseInt(Questions.WBC.getText()) < 4500 ) {
            return "Indicate viral disease, immune system failure and in very rare cases cancer";
        }
        if (Integer.parseInt(addPatient.age.getText()) > 18 && Integer.parseInt(Questions.WBC.getText()) > 1100) {
            return "Most often indicate the presence of an infection, if there is a fever. In other, extremely rare cases, very high values may indicate blood disease or cancer.";
        }
        return " ";
    }
}
