package project.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label errorlabel;

    @FXML
    private void btnHomeClicked()throws IOException {
        //go back to projectBoard
        App.setRoot("projectBoard");
    }

    @FXML
    private void btnLogoutClicked()throws IOException {
        //ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        //projectFACADE.logout();
        App.setRoot("login");
    }

    @FXML
    private void btnSaveClicked()throws IOException{
        //save user info
        String firstname = txt_changeFirstName.getText();
        String lastName = txt_changeLastName.getText();
        String email = txt_changeEmail.getText();
        String password = txt_changePassword.getText();
        String passwordConfirm = txt_changePasswordConfirm.getText();
        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();

        if(!(password.equals(passwordConfirm)))
        {
            errorlabel.setText("passwords must match");
            projectFACADE.getUser().setPassword(password);
            return;
        }
        if(!(firstname.equals("")))
        {
            projectFACADE.getUser().setName(firstname);
        }
        if(!(lastName.equals("")))
        {
            projectFACADE.getUser().setLastname(lastName);
        }
        if(!(email.equals("")))
        {
            projectFACADE.getUser().setEmail(email);
        }
        //create account
        email = projectFACADE.getUser().getEmailID();
        password = projectFACADE.getUser().getPassword();
        projectFACADE.logout();
        projectFACADE.login(email,password);
        App.setRoot("projectBoard"); //go to project board of the user logged inz
        //facade to change user info
    }
    
}
