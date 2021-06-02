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
    JLabel pregnantlabel = new JLabel("pregnant");
    JLabel mizrahilabel = new JLabel("mizrahi");
    JLabel smoker = new JLabel("smoker");
    JLabel labbel = new JLabel("information");
    JLabel Feverlabel = new JLabel("Fever");
    JLabel LungDiseaseslabel = new JLabel("Lung Diseases");
    JFrame frame1 = new JFrame("Add Patient");
    JButton button;
    static JComboBox comboBox;
    static JComboBox pragnant;
    static JComboBox mizrahi;
    static JComboBox Smoke;
    static JComboBox Fever;
    static JComboBox LungDiseases;
    static JComboBox BodyImmunity;

    addPatient() {
        startScreen();
    }

    public void startScreen() {
        frame1.setSize(600, 1000);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);

        JPanel panel = new JPanel(null);
        panel.setBorder(BorderFactory.createTitledBorder("Add Patient"));
        panel.setBounds(50, 30, 290, 800);


        frame1.add(panel);

        comboBox = new JComboBox(new String[]{"Male", "Female"});
        pragnant = new JComboBox(new String[]{"yes", "No"});
        mizrahi = new JComboBox(new String[]{"mizrahi", "tyopi","other"});
        Smoke = new JComboBox(new String[]{"yes", "No"});
        Fever = new JComboBox(new String[]{"yes", "No"});
        LungDiseases = new JComboBox(new String[]{"yes", "No"});

        button = new JButton("Patient Info");

        furstnamelabel.setBounds(30, 50, 100, 25);
        lastnamelabel.setBounds(30, 90, 100, 25);
        idlabel.setBounds(30, 130, 100, 25);
        agelabel.setBounds(30, 170, 100, 25);
        Genderlabel.setBounds(30, 210, 100, 25);
        pregnantlabel.setBounds(30, 250, 100, 25);
        mizrahilabel.setBounds(30, 290, 100, 25);
        Feverlabel.setBounds(30, 370, 100, 25);
        LungDiseaseslabel.setBounds(30, 410, 100, 25);
        smoker.setBounds(30, 330, 100, 25);
        firstName.setBounds(120, 50, 130, 25);
        lastName.setBounds(120, 90, 130, 25);
        idNumber.setBounds(120, 130, 130, 25);
        age.setBounds(120, 170, 130, 25);
        comboBox.setBounds(120, 210, 130, 25);
        pragnant.setBounds(120, 250, 130, 25);
        mizrahi.setBounds(120, 290, 130, 25);
        Smoke.setBounds(120, 330, 130, 25);
        Fever.setBounds(120, 370, 130, 25);
        LungDiseases.setBounds(120, 410, 130, 25);
        labbel.setBounds(120, 340, 130, 25);

        button.setBounds(120, 755, 130, 25);

        panel.add(furstnamelabel);
        panel.add(lastnamelabel);
        panel.add(idlabel);
        panel.add(agelabel);
        panel.add(Genderlabel);
        panel.add(pregnantlabel);
        panel.add(mizrahilabel);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(idNumber);
        panel.add(age);
        panel.add(comboBox);
        panel.add(pragnant);
        panel.add(mizrahi);
        panel.add(smoker);
        panel.add(Smoke);
        panel.add(button);
        panel.add(Fever);
        panel.add(Feverlabel);
        panel.add(LungDiseases);
        panel.add(LungDiseaseslabel);

        frame1.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                new Questions();
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String arg[]){
        new addPatient();
    }
}
