package project.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.ProjectFACADE;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import model.*;

public class ProjectController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private VBox project_layout;

    @FXML
    private Label lbl_projectName;

    @FXML
    private void btnBackClicked() throws IOException{
        //save everything? at least projects and tasks?
        App.setRoot("projectBoard");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        //lbl_projectName.setText(projectFACADE.getProject().getProjectName());

        ArrayList<String> columns = new ArrayList<String>();
        columns.add("To Do");
        columns.add("Doing");
        columns.add("Done");

        lbl_projectName.setText("ProjectName");
        HBox hbox = new HBox();
        hbox.setMaxWidth(850);
        hbox.setMaxHeight(480);
        hbox.setTranslateY(-40);
        project_layout.getChildren().add(hbox);
        for(int i=0;i<columns.size();i++)
        {
            Label label = new Label(columns.get(i));
            //hbox.getChildren().addAll(label);
            VBox vbox = new VBox();
            vbox.setMinHeight(480);
            vbox.setMinWidth(250);
            //vbox.setTranslateX(i*100);
            vbox.setAlignment(Pos.TOP_CENTER);
            hbox.getChildren().add(vbox);
            vbox.getChildren().add(label);
        }
        

    }

}