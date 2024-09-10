import controller.RegisterController;
import model.UserModel;
import view.RegisterView;

public class Main {
    public static void main(String[] args) {
        UserModel model = new UserModel();
        RegisterView registerView = new RegisterView();
        RegisterController registerController = new RegisterController(model, registerView);
        // Optionally, show the login view as well
        // LoginView loginView = new LoginView();
        // new LoginController(model, loginView);
    }
}