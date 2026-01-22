import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Lab04_6 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Easy Math Quiz 68160042");
        f.setSize(350, 180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        Random rand = new Random();
        int num1 = rand.nextInt(12) + 1; 
        int num2 = rand.nextInt(12) + 1;
        
    
        String[] operators = {"+", "-", "*"};
        int opIndex = rand.nextInt(3);
        String selectedOp = operators[opIndex];

        JLabel n1 = new JLabel(String.valueOf(num1));
        JLabel opLabel = new JLabel(" " + selectedOp + " ");
        JLabel n2 = new JLabel(String.valueOf(num2));
        JLabel equal = new JLabel(" = ");
        JTextField ans = new JTextField(5);
        JButton check = new JButton("Check Answer");
        JLabel result = new JLabel("");

        f.add(n1);
        f.add(opLabel);
        f.add(n2);
        f.add(equal);
        f.add(ans);
        f.add(check);
        f.add(result);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userAns = Integer.parseInt(ans.getText());
                    int correct = 0;

                    if (selectedOp.equals("+")) correct = num1 + num2;
                    else if (selectedOp.equals("-")) correct = num1 - num2;
                    else if (selectedOp.equals("*")) correct = num1 * num2;

                    if (userAns == correct) {
                        result.setText("Correct Answer :D");
                        result.setForeground(new Color(0, 128, 0));
                    } else {
                        result.setText("Wrong Answer :( (Correct: " + correct + ")");
                        result.setForeground(Color.RED);
                    }
                } catch (NumberFormatException ex) {
                    result.setText("Please enter a number!");
                }
            }
        });

        f.setVisible(true);
    }
}
