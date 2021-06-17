import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;


public class addData {

    JFrame f = new JFrame();
    static JComboBox comboBox1;
    static String[] str;
    static int i = 1;
    JButton button;


    addData() {
        button = new JButton("Show details for "+addPatient.firstName.getText());
        str = new String[i];
        addName(str, addPatient.firstName.getText());
//        comboBox1 = new JComboBox(str);
//        comboBox1.setBounds(100, 50, 100, 20);
        button.setBounds(100, 150, 200, 20);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
//        f.add(comboBox1);
        f.add(button);
        f.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                BoxText.box.setText("Patient name: "+addPatient.firstName.getText()+" "+addPatient.lastName.getText()+" ID: "+addPatient.idNumber.getText()+" age: "+addPatient.age.getText()+"\n"+checkWBC() + checkHCT() + checkNeut() + checkLymph() + checkRBC() + checkHCT() + checkUrea() + checkHb() + checkCreatinine() + checkIron() + checkHDL() + checkAlkaline_Phosphatase());
                String name = addPatient.firstName.getText() + " " + addPatient.lastName.getText() + ".txt";
//                System.out.println(name);
                try {
                    FileWriter f = new FileWriter(name);
                    f.write("Patient name: "+addPatient.firstName.getText()+" "+addPatient.lastName.getText()+" ID: "+addPatient.idNumber.getText()+" age: "+addPatient.age.getText()+"\n"+checkWBC() + checkHCT() + checkNeut() + checkLymph() + checkRBC() + checkHCT() + checkUrea() + checkHb() + checkCreatinine() + checkIron() + checkHDL() + checkAlkaline_Phosphatase());
                    f.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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
        if (Integer.parseInt(addPatient.age.getText()) >= 18 && Integer.parseInt(Questions.WBC.getText()) >= 4500 && Integer.parseInt(Questions.WBC.getText()) <= 1100) {
            return "WBC:\n\n Normal WBC";
        } else if (Integer.parseInt(addPatient.age.getText()) >= 18 && Integer.parseInt(Questions.WBC.getText()) < 4500) {
            return "WBC:\n\n Indicate viral disease, immune system failure and in very rare cases cancer\n";
        } else if (Integer.parseInt(addPatient.age.getText()) > 18 && Integer.parseInt(Questions.WBC.getText()) > 1100) {
            if (addPatient.Fever.getSelectedItem() == "yes")
                return "WBC:\n\n Most often indicate the presence of an infection, if there is a fever. In other, extremely rare cases, very high values may indicate blood disease or cancer.\n Therapy is Dedicated antibiotics\n";
            else {
                return "WBC:\n\n Most often indicate the presence of an infection, if there is a fever. In other, extremely rare cases, very high values may indicate blood disease or cancer.\n";
            }
        } else if (Integer.parseInt(addPatient.age.getText()) >= 4 && Integer.parseInt(addPatient.age.getText()) <= 17 && Integer.parseInt(Questions.WBC.getText()) >= 5500 && Integer.parseInt(Questions.WBC.getText()) < 15500) {
            return "WBC:\n\n Normal WBC";
        } else if (Integer.parseInt(addPatient.age.getText()) >= 4 && Integer.parseInt(addPatient.age.getText()) <= 17 && Integer.parseInt(Questions.WBC.getText()) < 4500) {
            return "WBC:\n\n Indicate viral disease, immune system failure and in very rare cases cancer\n";
        } else if (Integer.parseInt(addPatient.age.getText()) >= 4 && Integer.parseInt(addPatient.age.getText()) <= 17 && Integer.parseInt(Questions.WBC.getText()) > 15500) {
            if (addPatient.Fever.getSelectedItem() == "yes")
                return "WBC:\n\n Most often indicate the presence of an infection, if there is a fever. In other, extremely rare cases, very high values may indicate blood disease or cancer.\n Therapy is Dedicated antibiotics\n";
            else {
                return "WBC:\n\n Most often indicate the presence of an infection, if there is a fever. In other, extremely rare cases, very high values may indicate blood disease or cancer.\n";
            }
        } else if (Integer.parseInt(addPatient.age.getText()) >= 0 && Integer.parseInt(addPatient.age.getText()) <= 3 && Integer.parseInt(Questions.WBC.getText()) >= 6000 && Integer.parseInt(Questions.WBC.getText()) < 17500) {
            return "WBC:\n\n Normal WBC";
        } else if (Integer.parseInt(addPatient.age.getText()) >= 0 && Integer.parseInt(addPatient.age.getText()) <= 3 && Integer.parseInt(Questions.WBC.getText()) < 6000) {
            return "WBC:\n\n Indicate viral disease, immune system failure and in very rare cases cancer\n";
        } else if (Integer.parseInt(addPatient.age.getText()) >= 0 && Integer.parseInt(addPatient.age.getText()) <= 3 && Integer.parseInt(Questions.WBC.getText()) > 17500) {
            if (addPatient.Fever.getSelectedItem() == "yes")
                return "WBC:\n\n Most often indicate the presence of an infection, if there is a fever. In other, extremely rare cases, very high values may indicate blood disease or cancer.\n Therapy is Dedicated antibiotics\n";
            else {
                return "WBC:\n\n Most often indicate the presence of an infection, if there is a fever. In other, extremely rare cases, very high values may indicate blood disease or cancer.\n";
            }
        }
        return "";

    }

    //The amount of white blood cells that are primarily responsible for eliminating the bacteria.
    // The amount of white blood cells that are primarily responsible for eliminating the bacteria.
    public String checkNeut() {
        int wbc = Integer.parseInt(Questions.WBC.getText());
        int neut = Integer.parseInt(Questions.Neut.getText());
        if (neut > wbc * 0.28 && neut < wbc * 0.54) {
            return "Neut:\n\n Normal Neut\n";
        } else if (neut > wbc * 0.54) {
            return "Neut:\n\n Most often indicate a bacterial infection\n Therapy is Dedicated antibiotics\n";
        } else
            return "Neut:\n\n Indicate a disorder in the formation of blood, a tendency to bacterial infections and in rare cases - a process Cancer\n Therapy is 10 mg pill of B12 a day for a month, 5 mg pill of folic acid a day for a month\n";
    }

    //White blood cells that are responsible for killing viruses or bacteria that are in the body for a long time
    public String checkLymph() {
        int neut = Integer.parseInt(Questions.Neut.getText());
        int lymph = Integer.parseInt(Questions.Lymph.getText());
        if (lymph > neut * 0.36 && neut < lymph * 0.52) {
            return "Lymph:\n\n Normal Lymph\n";
        } else if (lymph > neut * 0.52) {
            return "Lymph:\n\n May indicate a prolonged bacterial infection or lymphoma cancer\n Therapy is Dedicated antibiotics, Entrectinib\n";
        } else
            return "Lymph:\n\n Indicate a disorder in the formation of blood, a tendency to bacterial infections and in rare cases - a process Cancer\n Therapy is 10 mg pill of B12 a day for a month ,5 mg pill of folic acid a day for a month\n";
    }

    /*
    Red blood cells are responsible for binding oxygen from the lungs, transporting it to body tissues, and absorbing carbon dioxide.
    From the various cells of the body and its excretion back to the lungs
    */
    public String checkRBC() {
        int rbc = Integer.parseInt(Questions.RBC.getText());
        if (rbc >= 4.5 && rbc <= 6)
            return "RBC:\n\n Normal RBC\n";
        else if (rbc < 4.5)
            return "RBC:\n\n May indicate anemia or severe bleeding\n Therapy is Two 10 mg B12 pills a day for a month ,Urgently evacuate to the hospital\n";
        else if (rbc > 6 && addPatient.Smoke.getSelectedItem() == "yes" && addPatient.LungDiseases.getSelectedItem() == "yes") {
            return "RBC:\n\n May indicate a disturbance in the blood production system. High levels were also observed in smokers and in patients In lung diseases.\n Therapy is 10 mg pill of B12 a day for a month ,5 mg pill of folic acid a day for a month\n";
        } else return "";
    }

    //The volume of red blood cells within the whole blood fluid
    public String checkHCT() {
        int hct = Integer.parseInt(Questions.HCT.getText());
        if (((addPatient.comboBox.getSelectedItem() == "Male") && hct >= 37 && hct <= 54) || (addPatient.comboBox.getSelectedItem() == "Female" && hct >= 33 && hct <= 47)) {
            return "HCT:\n\n Normal HCT\n";
        } else if (((addPatient.comboBox.getSelectedItem() == "Male") && hct > 54) || (addPatient.comboBox.getSelectedItem() == "Female" && hct > 47)) {
            return "HCT:\n\n Common in smokers\n";
        } else if (((addPatient.comboBox.getSelectedItem() == "Male") && hct < 37) || (addPatient.comboBox.getSelectedItem() == "Female" && hct < 33))
            return "HCT:\n\n Most often indicate bleeding or anemia\n ";
        else return "";
    }

    //The level of urination in the blood. Urine is the end product of the metabolic process of proteins in the body.
    public String checkUrea() {
        int urea = Integer.parseInt(Questions.Urea.getText());
        if (urea >= 17 && urea <= 43) {
            return "Urea:\n\n Normal Urea\n";
        } else if (urea > 43) {
            return "Urea:\n\n May indicate kidney disease, dehydration or a high protein diet\n";
        } else
            return "Urea:\n\n Malnutrition,low-protein diet or liver disease. It should be noted that during pregnancy the level of urination decreases\n";
    }

    //Hemoglobin is a component inside the red blood cell, which is responsible for the binding and release of oxygen and carbon dioxide Oxygen
    public String checkHb() {
        int hb = Integer.parseInt(Questions.Hb.getText());
        int age = Integer.parseInt(addPatient.age.getText());
        if (((addPatient.comboBox.getSelectedItem() == "Male") && hb >= 12 && hb <= 18) || (addPatient.comboBox.getSelectedItem() == "Female" && hb >= 12 && hb <= 16) || (age >= 0 && age <= 17 && hb >= 11.5 && hb <= 15.5))
            return "KHb:\n\n Normal Hb\n";
        else
            return "KHb:\n\n Indicates anemia. This can be due to hematological disorder, iron deficiency and bleeding\n Therapy is Two 10 mg pills of B12 a day for a month, to be urgently evacuated to the hospital\n";
    }

    //A breakdown product of an ingredient produced in the body and found in a muscle called "creatinine phosphate". Creatinine testing is extremely important direction That it gives a criterion regarding kidney function
    public String checkCreatinine() {
        int age = Integer.parseInt(addPatient.age.getText());
        float creatinine = Float.parseFloat(Questions.Creatinine.getText());
        if ((age >= 0 && age <= 2 && creatinine >= 11.5 && creatinine <= 15.5) || (age >= 3 && age <= 17 && creatinine >= 0.5 && creatinine <= 1) || (age >= 18 && age <= 59 && creatinine >= 0.6 && creatinine <= 1) || (age >= 60 && creatinine >= 0.6 && creatinine <= 1.2)) {
            return "Creatinine:\n\n Normal Creatinine";
        } else
            return "Creatinine:\n\n Are most commonly seen in patients with very poor muscle mass and malnourished people who do not consume enough protein";
    }

    //Iron is essential for the formation of hemoglobin - the protein carries oxygen in the blood.
    //In addition it is used to make many other enzymes.
    public String checkIron() {
        int iron = Integer.parseInt(Questions.Iron.getText());
        if ((addPatient.comboBox.getSelectedItem() == "Male" && iron >= 60 && iron <= 160)) {
            return "Iron:\n\n Normal Iron\n";
        } else if (iron > 160) {
            return "Iron:\n\n May indicate iron poisoning.\n Therapy is To be evacuated to the hospital\n";
        } else if (iron < 60)
            return "Iron:\n\n Usually indicates an inadequate diet or an increase in the need for iron (for example during pregnancy) or blood loss Following bleeding.\nSchedule an appointment with a nutritionist, evacuate to the hospital \n";
        else return "";
    }

    //DL, also called 'good cholesterol', is a protein-like molecule that carries cholesterol from the body's cells to the liver.
    //There is a breakdown of cholesterol. In this way, HDL helps the body get rid of excess fat.
    public String checkHDL() {
        int hdl = Integer.parseInt(Questions.HDL.getText());
        if ((addPatient.comboBox.getSelectedItem() == "Male" && hdl >= 29 && hdl <= 62) || (addPatient.comboBox.getSelectedItem() == "Female" && hdl >= 34 && hdl <= 82)) {
            return "HDL:\n\n Normal HDL";
        } else if ((addPatient.comboBox.getSelectedItem() == "Male" && hdl >= 62) || (addPatient.comboBox.getSelectedItem() == "Female" && hdl >= 82)) {
            return "HDL:\n\n Are usually harmless. Exercise raises good cholesterol levels.\n";
        } else if ((addPatient.comboBox.getSelectedItem() == "Male" && hdl < 29) || (addPatient.comboBox.getSelectedItem() == "Female" && hdl < 34))
            return "HDL:\n\n May indicate risk of heart disease, hyperlipidemia (hyperlipidemia) or adult-onset diabetes\nTo schedule an appointment with a nutritionist, to schedule an appointment with a nutritionist, 5 mg of Simobil pill per day for a week, adjusting insulin for the patient\n";
        else return "";
    }

    //
    public String checkAlkaline_Phosphatase() {
        int ap = Integer.parseInt(Questions.AP.getText());
        if (addPatient.mizrahi.getSelectedItem() == "mizrahi" && ap >= 60 && ap <= 120 || addPatient.mizrahi.getSelectedItem() != "mizrahi" && ap >= 30 && ap <= 90) {
            return "Alkaline Phosphatase:\n\n checkAlkaline_Phosphatase\n";
        }
        else if (addPatient.mizrahi.getSelectedItem() == "mizrahi" && ap > 120 || addPatient.mizrahi.getSelectedItem() != "mizrahi" && ap > 90) {
            return "Alkaline Phosphatase:\n\n May indicate liver disease, biliary tract disease, pregnancy, hypothyroidism or Use of various medications.\nReferral to a specific diagnosis for treatment, referral to surgical treatment, Propylthiouracil to reduce thyroid activity\n";
        } else if (addPatient.mizrahi.getSelectedItem() == "mizrahi" && ap < 60 || addPatient.mizrahi.getSelectedItem() != "mizrahi" && ap < 30)
            return "Alkaline Phosphatase:\n\n May indicate a poor diet that lacks protein. Deficiency in vitamins like vitamin, vitamin B12, Vitamin B6, folic acid\n.";
        else return "";
    }
}