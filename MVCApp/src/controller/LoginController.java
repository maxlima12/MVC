package controller;

import model.UserModel;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.RegisterView;

public class LoginController {
    private UserModel model;
    private LoginView view;

    public LoginController(UserModel model, LoginView view) {
        this.model = model;
        this.view = view;

        this.view.addLoginListener(new LoginListener());
        this.view.addRegisterListener(new RegisterListener());
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            if (model.authenticate(username, password) != null) {
                JOptionPane.showMessageDialog(view, "Login successful!");
                // You might want to open a new view here or proceed further
            } else {
                JOptionPane.showMessageDialog(view, "Invalid username or password.");
            }
        }
    }

    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            // Open the register view
            new RegisterView();
        }
    }
}