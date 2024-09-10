package controller;

import model.User;
import model.UserModel;
import view.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.LoginView;

public class RegisterController {
    private UserModel model;
    private RegisterView view;

    public RegisterController(UserModel model, RegisterView view) {
        this.model = model;
        this.view = view;

        this.view.addRegisterListener(new RegisterListener());
        this.view.addLoginListener(new LoginListener());
    }

    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            if (!username.isEmpty() && !password.isEmpty()) {
                model.addUser(new User(username, password));
                JOptionPane.showMessageDialog(view, "User registered successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in both fields.");
            }
        }
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            // Open the login view
            new LoginView();
        }
    }
}