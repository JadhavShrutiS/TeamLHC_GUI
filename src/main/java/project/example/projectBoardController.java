package project.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.*;

public class ProjectBoardController implements Initializable {

    @FXML
    private Label lbl_title;

    @FXML
    private Button logoutButton;

    @FXML
    private Button settingsButton;

    @FXML
    private VBox project_layout;


    @FXML
    private void btnLogoutClicked() throws IOException{
        //save users projects etc
        //basically facade logout
        App.setRoot("login");
    }
    
    @FXML
    private void btnSettingsClicked() throws IOException{
        App.setRoot("settings");
    }
    //need to have other projects that can be clicked on

    @FXML
    private void btnCreateClicked() throws IOException{
        App.setRoot("project");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        User user = projectFACADE.getUser();
        lbl_title.setText("Welcome " + user.getFirstName() + " " + user.getLastName()+"!");
        String email = user.getEmailID();
        ArrayList<Project> projects = projectFACADE.getProjectByUser(email);
        
        GridPane projectGrid = new GridPane();
        project_layout.getChildren().add(projectGrid);
    
        if (projects != null) {
            for(int i=0; i < projects.size(); i++) {
                Button button = new Button(projects.get(i).getProjectName());
                projectGrid.add(button, i, 0);
            }
        }



        


    }

}