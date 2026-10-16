    import javax.swing.*;
    import java.awt.*;
    import java.util.ArrayList;
    import java.util.List;

    public class latihan {
        public static void main(String[] args) {
            String appName = "login register latihan";
            int width = 600;
            int height = 400;

            JFrame frame = new JFrame(appName);

            List<User> userList = new ArrayList<>();
            userList.add(new User("admin", "123"));

            CardLayout cardLayout = new CardLayout();
            frame.setLayout(cardLayout);

            // login
            JPanel loginPanel = new JPanel(new FlowLayout());
            JLabel loginUserLabel = new JLabel("Username:");
            JTextField loginUserField = new JTextField(15);
            JLabel loginPassLabel = new JLabel("Password:");
            JPasswordField loginPassField = new JPasswordField(15);
            JButton loginBtn = new JButton("Login");
            JButton goToRegisterBtn = new JButton("Register");


            loginPanel.add(loginUserLabel);
            loginPanel.add(loginUserField);
            loginPanel.add(loginPassLabel);
            loginPanel.add(loginPassField);
            loginPanel.add(loginBtn);
            loginPanel.add(goToRegisterBtn);

            //
            JPanel registerPanel = new JPanel();

            JLabel regUserLabel = new JLabel("Register username :");
            JTextField regUserField = new JTextField(15);
            JLabel regPassLabel = new JLabel("Password :");
            JPasswordField regPassField = new JPasswordField(15);
            JButton registerBtn = new JButton("Register");
            JButton goToLoginBtn = new JButton("Kembali ke Login");

            registerPanel.add(regUserLabel);
            registerPanel.add(regUserField);
            registerPanel.add(regPassLabel);
            registerPanel.add(regPassField);
            registerPanel.add(registerBtn);
            registerPanel.add(goToLoginBtn);
            //
            JPanel helloPanel = new JPanel();

            JLabel helloLabel = new JLabel("Hello!");
            JButton logoutBtn = new JButton("Logout");

            helloPanel.add(helloLabel);
            helloPanel.add(logoutBtn);
            //


            // 
            loginBtn.addActionListener(e -> {
                String inputUser = loginUserField.getText();
                String inputPass = new String(loginPassField.getPassword());

                boolean match = false;
                for (User u : userList) {
                    if (u.getUsername().equals(inputUser) && u.getPassword().equals(inputPass)) {
                        match = true;
                        break;
                    }
                }

                if (match) {
                    helloLabel.setText("halow   " + inputUser);
                    cardLayout.show(frame.getContentPane(), "HelloPage");
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Gagal!", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            goToRegisterBtn.addActionListener(e -> {
                cardLayout.show(frame.getContentPane(), "RegisterPage");
            });

            registerBtn.addActionListener(e -> {
                String newUser = regUserField.getText();
                String newPass = new String(regPassField.getPassword());

                userList.add(new User(newUser, newPass));
                JOptionPane.showMessageDialog(frame, "Berhasil Daftar!", "Info", JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(frame.getContentPane(), "LoginPage");
            });

            goToLoginBtn.addActionListener(e -> {
                cardLayout.show(frame.getContentPane(), "LoginPage");
            });

            logoutBtn.addActionListener(e -> {
                cardLayout.show(frame.getContentPane(), "LoginPage");
            });

            frame.add(loginPanel, "LoginPage");
            frame.add(registerPanel, "RegisterPage");
            frame.add(helloPanel, "HelloPage");

            cardLayout.show(frame.getContentPane(), "LoginPage");

            // batas
            frame.setSize(width, height);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }