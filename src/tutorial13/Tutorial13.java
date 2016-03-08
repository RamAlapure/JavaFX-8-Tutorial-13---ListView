/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial13;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Ram
 */
public class Tutorial13 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX 8 Tutorial 13 - List View");
        VBox vbox =new VBox();
        Scene scene = new Scene(vbox, 300, 250);
        
        ListView list = new ListView();
        ObservableList<String> data = FXCollections.observableArrayList(
                "red", "black", "green","yellow", "pink", 
                "blue","violet", "brown", "silver"                  
        );
        list.setItems(data);
        list.setCellFactory(e ->{
            return new ColorName();
        });
        
        Label label = new Label();
        label.setLayoutX(10);
        label.setLayoutY(100);
        label.setFont(Font.font("Arial", 20));
        
        list.getSelectionModel().selectedItemProperty().addListener((obs, ov, nv) ->{
            label.setText((String) nv);
            label.setTextFill(Color.web((String) nv));
        });
        
        vbox.getChildren().addAll(list, label);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static class ColorName extends ListCell<String>
    {
        @Override
        public void updateItem(String item, boolean empty){
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            
            if(item !=null){
                rect.setFill(Color.web(item));
                setGraphic(rect);
            }else{
                setGraphic(null);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
