package project.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.*;
public class SettingsController {
    
    @FXML
    private Button HomeButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField txt_changeEmail;

    @FXML
    private TextField txt_changeFirstName;

    @FXML
    private TextField txt_changeLastName;

    @FXML
    private TextField txt_changePassword;

    @FXML
    private TextField txt_changePasswordConfirm;

    @FXML
    private void btnHomeClicked()throws IOException {
        //go back to projectBoard
        App.setRoot("projectBoard");
    }

    @FXML
    private void btnLogoutClicked()throws IOException {
        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        //save users projects etc
        //facade logout
        projectFACADE.logout();
        App.setRoot("login");
    }

    @FXML
    private void btnSaveClicked()throws IOException{
        //save user info
        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        String email = projectFACADE.getUser.getEmailID();
        String password = projectFACADE.getUser.getPassword();
        projectFACADE.logout();
        projectFACADE.login(email,password);
        //facade to change user info
    }
    
}
