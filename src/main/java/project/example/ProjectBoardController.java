package project.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.*;

public class ProjectBoardController implements Initializable {

    @FXML
    private Label lbl_title;

    @FXML
    private Button logoutButton;

    @FXML
    private Button settingsButton;

    @FXML
    private VBox projectboard_layout;

    @FXML
    private Button createProject;


    @FXML
    private void btnLogoutClicked() throws IOException{
        //save users projects etc
        //basically facade logout
        //ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        //projectFACADE.logout();
        App.setRoot("login");
    }
    
    @FXML
    private void btnSettingsClicked() throws IOException{
        App.setRoot("settings");
    }
    //need to have other projects that can be clicked on

    @FXML
    private void btnCreateClicked() throws IOException{
        App.setRoot("newProject");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        User user = projectFACADE.getUser();
        lbl_title.setText("Welcome " + user.getFirstName() + " " + user.getLastName()+"!");
        
        //get user projects
        //String email = user.getEmailID();
        //ArrayList<Project> projects = projectFACADE.getProjectByUser(email);
        
        //test project buttons
        ArrayList<String> test = new ArrayList<String>();
        test.add("1st project");
        test.add("2nd project");
        test.add("3rd project");
        //test.add("4th project");
        //test.add("5th project");
        //test.add("6th project");
        //test.add("7th project");

        GridPane projectGrid = new GridPane();
        projectGrid.setTranslateY(-180);
        projectGrid.setMaxWidth(700);
        projectGrid.setHgap(150);
        projectGrid.setVgap(100);

        projectboard_layout.getChildren().add(projectGrid);
    
        int rowIndex = 0;
        if (test != null) {
            for(int i=0; i < test.size(); i++) {
                //Button button = new Button(projects.get(i).getProjectName());
                Button button = new Button(test.get(i));
                Label label = new Label(test.get(i));
                //Rectangle rectangle = new Rectangle(150,150,Color.LAVENDER);
                //rectangle.setTranslateY(80);
                //rectangle.setArcHeight(50);
                //rectangle.setArcWidth(50);
                //System.out.println(projects.get(i).getProjectName());
                
                int columnIndex=i-(3*rowIndex);
                //projectGrid.add(rectangle,columnIndex,rowIndex);
                projectGrid.add(button,columnIndex, rowIndex);
                
                if((i+1)%3 == 0)
                {
                    rowIndex++;
                }
                button.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println(button.getText()+ "was clicked");

                        //set current project in facade by project name
                        //projectFACADE.setCurrentProject(button.getText());
                        
                        //change screen
                        try {
                            App.setRoot("project");
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });
                
            }
        }
    }

}