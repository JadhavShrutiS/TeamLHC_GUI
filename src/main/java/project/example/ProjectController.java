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
        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        //projectFACADE.saveAll();
        App.setRoot("projectBoard");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ProjectFACADE projectFACADE = ProjectFACADE.getInstance();
        lbl_projectName.setText(projectFACADE.getProjectName());

        ArrayList<String> columns = new ArrayList<String>();
        columns.add("Backlog");
        columns.add("To Do");
        columns.add("Doing");
        columns.add("Done");

        ArrayList<String> backlog = new ArrayList<String>();
        backlog.add("Finalize presentation items");
        backlog.add("Discard unused items");

        ArrayList<String> toDo = new ArrayList<String>();
        toDo.add("Read instructions");
        toDo.add("Prep for task");

        ArrayList<String> doing = new ArrayList<String>();
        doing.add("Order Items");
        
        ArrayList<String> done = new ArrayList<String>();
        done.add("Create Plan");
        done.add("Finalize Measurements");

        ScrollPane scroll = new ScrollPane();
        project_layout.getChildren().add(scroll);
        HBox hbox = new HBox();
        hbox.setMaxWidth(850);
        hbox.setMaxHeight(480);
        scroll.setContent(hbox);
        scroll.setMinHeight(570);
        scroll.setTranslateY(-60);
        for(int i=0;i<columns.size();i++)
        {
            Label label = new Label(columns.get(i));
            String cssLabel = "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 1;\n" +
            "-fx-border-style: solid;\n";
            label.setAlignment(Pos.TOP_CENTER);
            label.setMinWidth(200);
            label.setTranslateY(-7);
            label.setStyle(cssLabel);
            VBox vbox = new VBox();
            String cssVbox="-fx-border-color: black;\n" +
            "-fx-border-insets: 3;\n" +
            "-fx-border-width: 2;\n" +
            "-fx-border-style: solid;\n";
            vbox.setStyle(cssVbox);
            vbox.setAlignment(Pos.TOP_CENTER);
            vbox.setMinHeight(540);
            vbox.setMinWidth(250);
            
            hbox.getChildren().add(vbox);
            vbox.getChildren().add(label);

            vbox.setSpacing(10);

            ArrayList<String> var;
            if(i==0)
            {
                var=backlog;
            }
            else if(i==1)
            {
                var=toDo;
            }
            else if(i==2)
            {
                var=doing;
            }
            else{var=done;}

            for(int j=0;j<var.size();j++)
            {
                Label taskLabel = new Label(var.get(j));
                taskLabel.setAlignment(Pos.TOP_LEFT);
                taskLabel.wrapTextProperty().set(true);
                String cssTaskLabel = "-fx-border-color: black;\n" +
                "-fx-border-insets: 1;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: solid;\n"+
                "-fx-background-color: #E4F5D3;\n";
                taskLabel.setStyle(cssTaskLabel);
                taskLabel.setMinHeight(100);
                taskLabel.setMaxWidth(200);
                vbox.getChildren().add(taskLabel);
            }
            Button addTaskButton = new Button("+");
            vbox.getChildren().add(addTaskButton);

            addTaskButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println(addTaskButton.getText()+ "was clicked");
                    try {
                        App.setRoot("addTask");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        VBox vbox = new VBox();
        String cssVbox="-fx-border-color: grey;\n" +
            "-fx-border-insets: 3;\n" +
            "-fx-border-width: 2;\n" +
            "-fx-border-style: dashed;\n"+
            "-fx-background-color: #BCC0B7;\n"+
            "-fx-background-radius: 15;\n";
        vbox.setStyle(cssVbox);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setMinHeight(540);
        vbox.setMinWidth(250);
        hbox.getChildren().add(vbox);
        Button addColumnButton=new Button("+");
        String cssButton="-fx-background-color:#BCC0B7;\n"+
            "-fx-border-color: black;\n"+
            "-fx-border-radius: 5;\n";
        addColumnButton.setStyle(cssButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(addColumnButton);

        addColumnButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(addColumnButton.getText()+ "was clicked");
                try {
                    App.setRoot("addColumn");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }); 
        
    }

}