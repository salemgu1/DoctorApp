import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class addData {

    JFrame f = new JFrame();
    static JComboBox comboBox1;
    static String[] str;
    static int i = 1;
    JButton button;


    addData() {
        button = new JButton("Show details");
        str = new String[i];
        addName(str, addPatient.firstName.getText());
        comboBox1 = new JComboBox(str);
        comboBox1.setBounds(100, 50, 100, 20);
        button.setBounds(100, 300, 100, 20);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.add(comboBox1);
        f.add(button);
        f.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                BoxText.box.setText(checkWBC()+checkHCT()+checkNeut()+checkLymph()+checkRBC()+checkHCT()+checkUrea()+checkHb()+checkCreatinine()+checkIron()+checkHDL()+checkAlkaline_Phosphatase());
            }
        });
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
            return "Normal WBC";
        } else if (Integer.parseInt(addPatient.age.getText()) > 18 && Integer.parseInt(Questions.WBC.getText()) < 4500) {
            return "Indicate viral disease, immune system failure and in very rare cases cancer\n";
        }
        if (Integer.parseInt(addPatient.age.getText()) > 18 && Integer.parseInt(Questions.WBC.getText()) > 1100) {
            return "Most often indicate the presence of an infection, if there is a fever. In other, extremely rare cases, very high values may indicate blood disease or cancer.\n";
        }
        return " ";
    }

    //The amount of white blood cells that are primarily responsible for eliminating the bacteria.
    // The amount of white blood cells that are primarily responsible for eliminating the bacteria.
    public String checkNeut() {
        int wbc = Integer.parseInt(Questions.WBC.getText());
        int neut = Integer.parseInt(Questions.Neut.getText());
        if (neut > wbc * 0.28 && neut < wbc * 0.54) {
            return "Normal Neut\n";
        } else if (neut > wbc * 0.54) {
            return "Most often indicate a bacterial infection\n";
        } else
            return "Indicate a disorder in the formation of blood, a tendency to bacterial infections and in rare cases - a process\n" +
                    "Cancer";
    }

    //White blood cells that are responsible for killing viruses or bacteria that are in the body for a long time
    public String checkLymph() {
        int neut = Integer.parseInt(Questions.Neut.getText());
        int lymph = Integer.parseInt(Questions.Lymph.getText());
        if (lymph > neut * 0.36 && neut < lymph * 0.52) {
            return "Normal Lymph\n";
        } else if (lymph > neut * 0.52) {
            return "May indicate a prolonged bacterial infection or lymphoma cancer\n";
        } else
            return "Indicate a disorder in the formation of blood, a tendency to bacterial infections and in rare cases - a process\n" +
                    "Cancer";
    }

    /*
    Red blood cells are responsible for binding oxygen from the lungs, transporting it to body tissues, and absorbing carbon dioxide.
    From the various cells of the body and its excretion back to the lungs
    */
    public String checkRBC() {
        int rbc = Integer.parseInt(Questions.RBC.getText());
        if (rbc > 4.5 && rbc < 6)
            return "Normal RBC\n";
        else if (rbc < 4.5)
            return "May indicate anemia or severe bleeding\n";
        else
            return "May indicate a disturbance in the blood production system. High levels were also observed in smokers and in patients In lung diseases.\n";
    }

    //The volume of red blood cells within the whole blood fluid
    public String checkHCT() {
        int hct = Integer.parseInt(Questions.HCT.getText());
        if (((addPatient.comboBox.getSelectedItem() == "Male") && hct >= 37 && hct <= 54) || (addPatient.comboBox.getSelectedItem() == "Female" && hct >= 33 && hct <= 47)) {
            return "Normal HCT\n";
        } else if (((addPatient.comboBox.getSelectedItem() == "Male") && hct > 54) || (addPatient.comboBox.getSelectedItem() == "Female" && hct > 47)) {
            return "Common in smokers\n";
        } else
            return "Most often indicate bleeding or anemia\n";
    }

    //The level of urination in the blood. Urine is the end product of the metabolic process of proteins in the body.
    public String checkUrea() {
        int urea = Integer.parseInt(Questions.Urea.getText());
        if (urea >= 17 && urea <= 43) {
            return "Normal Urea\n";
        } else if (urea > 43) {
            return "May indicate kidney disease, dehydration or a high protein diet\n";
        } else
            return "Malnutrition,low-protein diet or liver disease. It should be noted that during pregnancy the level of urination decreases\n";
    }

    //Hemoglobin is a component inside the red blood cell, which is responsible for the binding and release of oxygen and carbon dioxide Oxygen
    public String checkHb() {
        int hb = Integer.parseInt(Questions.Hb.getText());
        int age = Integer.parseInt(addPatient.age.getText());
        if (((addPatient.comboBox.getSelectedItem() == "Male") && hb >= 12 && hb <= 18) || (addPatient.comboBox.getSelectedItem() == "Female" && hb >= 12 && hb <= 16) || (age >= 0 && age <= 17 && hb >= 11.5 && hb <= 15.5))
            return "Normal Hb\n";
        else
            return "Indicates anemia. This can be due to hematological disorder, iron deficiency and bleeding\n";
    }

    //A breakdown product of an ingredient produced in the body and found in a muscle called "creatinine phosphate". Creatinine testing is extremely important direction That it gives a criterion regarding kidney function
    public String checkCreatinine() {
        int age = Integer.parseInt(addPatient.age.getText());
        int creatinine = Integer.parseInt(Questions.Creatinine.getText());
        if ((age >= 0 && age <= 2 && creatinine >= 11.5 && creatinine <= 15.5) || (age >= 3 && age <= 17 && creatinine >= 0.5 && creatinine <= 1) || (age >= 18 && age <= 59 && creatinine >= 0.6 && creatinine <= 1) || (age >= 60 && creatinine >= 0.6 && creatinine <= 1.2)) {
            return "Normal Creatinine";
        } else
            return "Are most commonly seen in patients with very poor muscle mass and malnourished people who do not consume enough protein";
    }

    //Iron is essential for the formation of hemoglobin - the protein carries oxygen in the blood.
    //In addition it is used to make many other enzymes.
    public String checkIron() {
        int iron = Integer.parseInt(Questions.Iron.getText());
        if ((addPatient.comboBox.getSelectedItem() == "Male" && iron >= 60 && iron <= 160)) {
            return "Normal Iron\n";
        } else if (iron > 160) {
            return "May indicate iron poisoning.\n";
        } else
            return "Usually indicates an inadequate diet or an increase in the need for iron (for example during pregnancy) or blood loss\n" +
                    "Following bleeding.";
    }
    //DL, also called 'good cholesterol', is a protein-like molecule that carries cholesterol from the body's cells to the liver.
    //There is a breakdown of cholesterol. In this way, HDL helps the body get rid of excess fat.
    public String checkHDL() {
        int hdl = Integer.parseInt(Questions.HDL.getText());
        if ((addPatient.comboBox.getSelectedItem() == "Male" && hdl >= 29 && hdl <= 62) || (addPatient.comboBox.getSelectedItem() == "Female" && hdl >= 34 && hdl <= 82)) {
            return "Normal HDL";
        } else if ((addPatient.comboBox.getSelectedItem() == "Male" && hdl > 62) || (addPatient.comboBox.getSelectedItem() == "Female" && hdl > 82)) {
            return "Are usually harmless. Exercise raises \"good\" cholesterol levels.\n";
        } else
            return "May indicate risk of heart disease, hyperlipidemia (hyperlipidemia) or adult-onset diabetes\n";
    }
    //
    public String checkAlkaline_Phosphatase() {
        int ap = Integer.parseInt(Questions.AP.getText());
        if (addPatient.mizrahi.getSelectedItem() == "mizrahi" && ap >= 60 && ap <= 120 || addPatient.mizrahi.getSelectedItem() != "mizrahi" && ap >= 30 && ap <= 90) {
            return "checkAlkaline_Phosphatase\n";
        }
        if (addPatient.mizrahi.getSelectedItem() == "mizrahi" && ap > 120 || addPatient.mizrahi.getSelectedItem() != "mizrahi" && ap > 90) {
            return "May indicate liver disease, biliary tract disease, pregnancy, hypothyroidism or Use of various medications.\n";
        } else
            return "May indicate a poor diet that lacks protein. Deficiency in vitamins like vitamin, vitamin B12, Vitamin B6, folic acid\n.";

    }
}
