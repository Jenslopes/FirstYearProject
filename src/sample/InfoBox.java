package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * Created by Julius on 03-11-2016.
 */
public class InfoBox {
    public static void info(String message) {
        Stage stage = new Stage();
        stage.setTitle("Info Box");
        stage.initModality(Modality.APPLICATION_MODAL); //Blokerer alt indtil du har taget dig af den her
        stage.setMinWidth(300);
        //
        Label label1 = new Label();
        label1.setText(message);
        //
        Button ok = new Button("OK");
        ok.setOnAction(e-> stage.close());
        //
        VBox layout = new VBox(20); // FUCK VBOX
        layout.getChildren().addAll(label1, ok);
        layout.setAlignment(Pos.CENTER);
        //
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait(); // Venter på at den bliver lukket indtil den kan gå tilbage
    }
}
