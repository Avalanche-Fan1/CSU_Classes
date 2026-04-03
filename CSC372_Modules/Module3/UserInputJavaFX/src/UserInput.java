import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInput extends Application  {
    TextField outputField = new TextField();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Menu Example");

        // Create Menu Options to go into Main Menu //
        MenuItem dateMenu = new MenuItem("Date/Time");
        MenuItem fileMenu = new MenuItem("Write File");
        MenuItem colorMenu = new MenuItem("Change Background");
        MenuItem exitMenu = new MenuItem("Exit");

        // Create Main Menu and insert Menu Options //
        MenuButton menuButton = new MenuButton("Main Menu", null, dateMenu, fileMenu, colorMenu, exitMenu);
        VBox vbox = new VBox(menuButton, outputField);
        vbox.setSpacing(15);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
        outputField.setPrefWidth(150);
        outputField.setMaxWidth(150);

        // Action for Menu Date & Time //
        dateMenu.setOnAction(event -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            String formattedDateTime = now.format(formatter);

            // Print the result //
            outputField.setText(formattedDateTime);
        });

        // Action for Writing to file log.txt //
        fileMenu.setOnAction(event -> {
            try {
                FileWriter writer = new FileWriter("log.txt", true); // true = append
                writer.write(outputField.getText() + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Action to Change background color to random Green Hue //
        colorMenu.setOnAction(event -> {
            double hue = 100 + Math.random() * 40;   // green range (100°–140°)
            double saturation = 0.8;                 // strong color
            double brightness = 0.8;                 // not too dark

            Color greenHue = Color.hsb(hue, saturation, brightness);
            vbox.setBackground(new Background(
                    new BackgroundFill(greenHue, null, null)));

            // Display Hex Value of color into TextField //
            int r = (int)(greenHue.getRed() * 255);
            int g = (int)(greenHue.getGreen() * 255);
            int b = (int)(greenHue.getBlue() * 255);
            String hex = String.format("#%02X%02X%02X", r, g, b);
            outputField.setText(hex);
        });

        // Action to Exits Application //
        exitMenu.setOnAction(event -> {
            System.exit(0);
        });

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
