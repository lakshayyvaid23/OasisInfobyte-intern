package OasisInfobyte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class
public class OnlineExamination {
    public static void main(String[] args) {
        new Login();
    }
}

// Login class
class Login {
    private JFrame frame;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;

    public Login() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#000000")); // black background

        JLabel nameLabel = new JLabel("Online Examination System");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setForeground(Color.decode("#ffffff")); // white color
        frame.add(nameLabel, BorderLayout.NORTH);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.decode("#00ff00")); // green color
        frame.add(usernameLabel);
        usernameField = new JTextField(20);
        frame.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.decode("#00ff00")); // green color
        frame.add(passwordLabel);
        passwordField = new JTextField(20);
        frame.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginListener());
        loginButton.setBackground(Color.decode("#008000")); // green background
        loginButton.setForeground(Color.decode("#ffffff")); // white color
        frame.add(loginButton);
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            if (username.equals("admin") && password.equals("password")) {
                frame.dispose();
                new UpdateProfile();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

// Update Profile class
class UpdateProfile {
    private JFrame frame;
    private JLabel currentPasswordLabel;
    private JLabel newPasswordLabel;
    private JLabel confirmPasswordLabel;
    private JTextField currentPasswordField;
    private JTextField newPasswordField;
    private JTextField confirmPasswordField;
    private JButton updateProfileButton;
    private JButton skipButton;

    public UpdateProfile() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Update Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#000000")); // black background

        JLabel nameLabel = new JLabel("Update Profile");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setForeground(Color.decode("#ffffff")); // white color
        frame.add(nameLabel, BorderLayout.NORTH);

        currentPasswordLabel = new JLabel("Current Password:");
        currentPasswordLabel.setForeground(Color.decode("#ff0000")); // red color
        frame.add(currentPasswordLabel);
        currentPasswordField = new JTextField(20);
        frame.add(currentPasswordField);

        newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setForeground(Color.decode("#ff0000")); // red color
        frame.add(newPasswordLabel);
        newPasswordField = new JTextField(20);
        frame.add(newPasswordField);

        confirmPasswordLabel = new JLabel("Confirm New Password:");
        confirmPasswordLabel.setForeground(Color.decode("#ff0000")); // red color
        frame.add(confirmPasswordLabel);
        confirmPasswordField = new JTextField(20);
        frame.add(confirmPasswordField);

        updateProfileButton = new JButton("Update Profile");
        updateProfileButton.addActionListener(new UpdateProfileListener());
        updateProfileButton.setBackground(Color.decode("#008000")); // green background
        updateProfileButton.setForeground(Color.decode("#ffffff")); // white color
        frame.add(updateProfileButton);

        skipButton = new JButton("Skip");
        skipButton.addActionListener(new SkipListener());
        skipButton.setBackground(Color.decode("#008000")); // green background
        skipButton.setForeground(Color.decode("#ffffff")); // white color
        frame.add(skipButton);
    }

    private class UpdateProfileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentPassword = currentPasswordField.getText();
            String newPassword = newPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            if (currentPassword.equals("password") && newPassword.equals(confirmPassword)) {
                frame.dispose();
                new Timer();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid current password or new password mismatch", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class SkipListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new Timer();
        }
    }
}


// Timer class
class Timer {
    private JFrame frame;
    private JLabel timerLabel;

    public Timer() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#000000")); // black background

        JLabel nameLabel = new JLabel("Timer");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setForeground(Color.decode("#ffffff")); // white color
        frame.add(nameLabel, BorderLayout.NORTH);

        // Create a new font with bold style and larger size
        Font font = new Font("Arial", Font.BOLD, 24);

        // Create a JLabel with the new font
        JLabel goodLuckLabel = new JLabel("GOOD LUCK FOR YOUR QUIZ");
        goodLuckLabel.setFont(font);
        goodLuckLabel.setForeground(Color.decode("#ffffff")); // white color
        goodLuckLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the JLabel to the frame
        frame.add(goodLuckLabel, BorderLayout.CENTER);

        timerLabel = new JLabel("Time: 5 seconds");
        timerLabel.setForeground(Color.decode("#ffff00")); // yellow color
        frame.add(timerLabel, BorderLayout.SOUTH);

        // Start timer
        Thread thread = new Thread(new TimerThread());
        thread.start();
    }

    private class TimerThread implements Runnable {
        @Override
        public void run() {
            for (int i = 10; i >= 0; i--) {
                timerLabel.setText("Time: " + i + " seconds");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            frame.dispose();
            new Quiz();
        }
    }
}
// Quiz class
class Quiz {
    private JFrame frame;
    private JLabel questionLabel;
    private JLabel option1Label;
    private JLabel option2Label;
    private JLabel option3Label;
    private JLabel option4Label;
    private JRadioButton option1RadioButton;
    private JRadioButton option2RadioButton;
    private JRadioButton option3RadioButton;
    private JRadioButton option4RadioButton;
    private ButtonGroup buttonGroup;
    private JButton submitButton;
    private JLabel timerLabel;
    private int currentQuestion = 0;
    private String[] questions = {
            "What is the capital of France?",
            "What is the largest planet in our solar system?",
            "What is the smallest country in the world?",
            "What is the largest mammal on Earth?"
    };
    private String[][] options = {
            {"A) Paris", "B) London", "C) Berlin", "D) Rome"},
            {"A) Earth", "B) Saturn", "C) Jupiter", "D) Uranus"},
            {"A) Vatican City", "B) Monaco", "C) Nauru", "D) Tuvalu"},
            {"A) Blue whale", "B) Fin whale", "C) Humpback whale", "D) Sperm whale"}
    };
    private String[] correctAnswers = {"A) Paris", "C) Jupiter", "A) Vatican City", "A) Blue whale"};

    public Quiz() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#000000")); // black background

        JLabel nameLabel = new JLabel("Quiz");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setForeground(Color.decode("#ffffff")); // white color
        frame.add(nameLabel, BorderLayout.NORTH);

        questionLabel = new JLabel(questions[currentQuestion]);
        questionLabel.setForeground(Color.decode("#ff0000")); // red color
        frame.add(questionLabel);

        option1Label = new JLabel(options[currentQuestion][0]);
        option1Label.setForeground(Color.decode("#ff0000")); // red color
        frame.add(option1Label);
        option1RadioButton = new JRadioButton();
        option1RadioButton.setBackground(Color.decode("#000000")); // black background
        frame.add(option1RadioButton);

        option2Label = new JLabel(options[currentQuestion][1]);
        option2Label.setForeground(Color.decode("#ff0000")); // red color
        frame.add(option2Label);
        option2RadioButton = new JRadioButton();
        option2RadioButton.setBackground(Color.decode("#000000")); // black background
        frame.add(option2RadioButton);

        option3Label = new JLabel(options[currentQuestion][2]);
        option3Label.setForeground(Color.decode("#ff0000")); // red color
        frame.add(option3Label);
        option3RadioButton = new JRadioButton();
        option3RadioButton.setBackground(Color.decode("#000000")); // black background
        frame.add(option3RadioButton);

        option4Label = new JLabel(options[currentQuestion][3]);
        option4Label.setForeground(Color.decode("#ff0000")); // red color
        frame.add(option4Label);
        option4RadioButton = new JRadioButton();
        option4RadioButton.setBackground(Color.decode("#000000")); // black background
        frame.add(option4RadioButton);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(option1RadioButton);
        buttonGroup.add(option2RadioButton);
        buttonGroup.add(option3RadioButton);
        buttonGroup.add(option4RadioButton);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitListener());
        submitButton.setBackground(Color.decode("#008000")); // green background
        submitButton.setForeground(Color.decode("#ffffff")); // white color
        frame.add(submitButton);

        timerLabel = new JLabel("Time: 30 seconds");
        timerLabel.setForeground(Color.decode("#ffff00")); // yellow color
        frame.add(timerLabel);

        // Start timer
        Thread thread = new Thread(new TimerThread());
        thread.start();
    }

    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedAnswer = getSelectedAnswer();
            if (selectedAnswer.equals(correctAnswers[currentQuestion])) {
                JOptionPane.showMessageDialog(frame, "Correct answer!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect answer!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            currentQuestion++;
            if (currentQuestion < questions.length) {
                updateQuestion();
            } else {
                frame.dispose();
                new Exit();
            }
        }
    }

    private String getSelectedAnswer() {
        if (option1RadioButton.isSelected()) {
            return options[currentQuestion][0];
        } else if (option2RadioButton.isSelected()) {
            return options[currentQuestion][1];
        } else if (option3RadioButton.isSelected()) {
            return options[currentQuestion][2];
        } else if (option4RadioButton.isSelected()) {
            return options[currentQuestion][3];
        } else {
            return "";
        }
    }

    private void updateQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        option1Label.setText(options[currentQuestion][0]);
        option2Label.setText(options[currentQuestion][1]);
        option3Label.setText(options[currentQuestion][2]);
        option4Label.setText(options[currentQuestion][3]);
        buttonGroup.clearSelection();
    }

    private class TimerThread implements Runnable {
        @Override
        public void run() {
            for (int i = 30; i >= 0; i--) {
                timerLabel.setText("Time: " + i + " seconds");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            frame.dispose();
            new Exit();
        }
    }
}
// Exit class
class Exit {
    private JFrame frame;
    private JButton exitButton;

    public Exit() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Exit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(200, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.decode("#000000")); // black background

        JLabel nameLabel = new JLabel("Exit");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setForeground(Color.decode("#ffffff")); // white color
        frame.add(nameLabel, BorderLayout.NORTH);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());
        exitButton.setBackground(Color.decode("#008000")); // green background
        exitButton.setForeground(Color.decode("#ffffff")); // white color
        frame.add(exitButton);
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}