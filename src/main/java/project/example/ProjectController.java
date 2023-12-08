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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
        columns.add("1");
        columns.add("2");

        ArrayList<String> tasks = new ArrayList<String>();
        tasks.add("task1");
        tasks.add("task2");
        tasks.add("task3");

        lbl_projectName.setText("ProjectName");
        ScrollPane scroll = new ScrollPane();
        project_layout.getChildren().add(scroll);
        
        HBox hbox = new HBox();
        hbox.setMaxWidth(850);
        hbox.setMaxHeight(480);
        scroll.setContent(hbox);
        scroll.setMinHeight(570);
        scroll.setTranslateY(-60);

        //project_layout.getChildren().add(hbox);
        for(int i=0;i<columns.size();i++)
        {
            Label label = new Label(columns.get(i));
            //hbox.getChildren().addAll(label);
            VBox vbox = new VBox();
            String cssLayout="-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n" +
            "-fx-border-style: solid;\n";
            vbox.setStyle(cssLayout);
            vbox.setMinHeight(550);
            vbox.setMinWidth(250);
            //vbox.setTranslateX(i*100);
            vbox.setAlignment(Pos.TOP_CENTER);
            hbox.getChildren().add(vbox);
            vbox.getChildren().add(label);

        }

    }

}