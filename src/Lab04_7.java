import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Lab04_7 {
    
    private static int score = 0;
    private static int questionCount = 1;
    private static int num1, num2, correctAns;
    private static String selectedOp;
    private static Random rand = new Random();

    public static void main(String[] args) {
        JFrame f = new JFrame("Easy Math Quiz - 10 Questions");
        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));


        JLabel titleLabel = new JLabel("Question " + questionCount + " of 10");
        titleLabel.setPreferredSize(new Dimension(350, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel quizLabel = new JLabel("");
        quizLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        JTextField ansField = new JTextField(5);
        JButton checkBtn = new JButton("Submit Answer");
        JLabel resultLabel = new JLabel("Good Luck!");
        resultLabel.setPreferredSize(new Dimension(350, 30));
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        generateQuestion(quizLabel);

        f.add(titleLabel);
        f.add(quizLabel);
        f.add(ansField);
        f.add(checkBtn);
        f.add(resultLabel);

        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userAns = Integer.parseInt(ansField.getText());

                 
                    if (userAns == correctAns) {
                        score++;
                        resultLabel.setText("Correct! Excellent.");
                        resultLabel.setForeground(new Color(0, 128, 0));
                    } else {
                        resultLabel.setText("Wrong! The answer was " + correctAns);
                        resultLabel.setForeground(Color.RED);
                    }

                    questionCount++;

                    if (questionCount <= 10) {
                        titleLabel.setText("Question " + questionCount + " of 10");
                        ansField.setText("");
                        generateQuestion(quizLabel);
                    } else {
                        quizLabel.setText("Quiz Finished!");
                        ansField.setVisible(false);
                        checkBtn.setEnabled(false);
                        resultLabel.setText("Your Total Score: " + score + " / 10");
                        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number!");
                }
            }
        });

        f.setVisible(true);
    }

    private static void generateQuestion(JLabel label) {
        num1 = rand.nextInt(12) + 1;
        num2 = rand.nextInt(12) + 1;
        String[] operators = {"+", "-", "*"};
        selectedOp = operators[rand.nextInt(3)];

        if (selectedOp.equals("+")) correctAns = num1 + num2;
        else if (selectedOp.equals("-")) correctAns = num1 - num2;
        else if (selectedOp.equals("*")) correctAns = num1 * num2;

        label.setText(num1 + " " + selectedOp + " " + num2 + " = ?");
    }
}
