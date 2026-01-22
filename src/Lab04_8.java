import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Lab04_8 {
   public static void main(String[] args) {
       JFrame f = new JFrame("BMI Calculator");
       f.setSize(300, 250);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setLayout(new GridLayout(5, 2, 10, 10));
      
       JLabel wLabel = new JLabel(" Weight (kg):");
       JTextField wField = new JTextField();
      
       JLabel hLabel = new JLabel(" Height (cm):");
       JTextField hField = new JTextField();
      
       JButton calcBtn = new JButton("Calculate");
       JLabel bmiResult = new JLabel("BMI: -");
      
       JLabel statusLabel = new JLabel("Status:");
       JLabel statusResult = new JLabel("-");
     
       f.add(wLabel);     f.add(wField);
       f.add(hLabel);     f.add(hField);
       f.add(new JLabel("")); f.add(calcBtn);
       f.add(bmiResult);  f.add(new JLabel(""));
       f.add(statusLabel); f.add(statusResult);
       calcBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   double weight = Double.parseDouble(wField.getText());
                   double heightCm = Double.parseDouble(hField.getText());
                   double heightM = heightCm / 100;
                  
                   double bmi = weight / (heightM * heightM);
                  
               
                   bmiResult.setText(String.format("BMI: %.2f", bmi));
                  
                 
                   if (bmi < 18.5) {
                       statusResult.setText("Underweight (ผอม)");
                       statusResult.setForeground(Color.BLUE);
                   } else if (bmi < 23) {
                       statusResult.setText("Normal (ปกติ)");
                       statusResult.setForeground(new Color(0, 128, 0));
                   } else if (bmi < 25) {
                       statusResult.setText("Overweight (ท้วม)");
                       statusResult.setForeground(Color.ORANGE);
                   } else if (bmi < 30) {
                       statusResult.setText("Obese (อ้วน)");
                       statusResult.setForeground(Color.RED);
                   } else {
                       statusResult.setText("Extremely Obese (อ้วนมาก)");
                       statusResult.setForeground(new Color(139, 0, 0));
                   }
                  
               } catch (NumberFormatException ex) {
                   JOptionPane.showMessageDialog(f, "กรุณากรอกเฉพาะตัวเลขครับ!", "Error", JOptionPane.ERROR_MESSAGE);
               }
           }
       });
       f.setVisible(true);
   }
}
