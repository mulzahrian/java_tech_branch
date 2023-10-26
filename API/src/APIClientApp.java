import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class APIClientApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("REST API Emulator");

        // Create GUI components
        Label urlLabel = new Label("URL:");
        TextField urlField = new TextField();
        Label pathLabel = new Label("Path:");
        TextField pathField = new TextField();
        Label requestLabel = new Label("Request JSON:");
        TextArea requestArea = new TextArea();
        requestArea.setPrefRowCount(10);

        // Create a ComboBox for request types
        ComboBox<String> requestTypeComboBox = new ComboBox<>();
        requestTypeComboBox.getItems().addAll("Payment", "Check", "Refund", "Inquiry", "PaymentDebit", "PaymentReversal", "Payment Reversal Rep");
        requestTypeComboBox.setValue("Payment");

        // Create a button to send the request
        Button sendButton = new Button("Kirim");

        // Handle button click event
        sendButton.setOnAction(e -> {
            String url = urlField.getText();
            String path = pathField.getText();
            String requestType = requestTypeComboBox.getValue();
            String requestBody = requestArea.getText();

            // Send the HTTP request using Apache HttpClient
            // You need to implement this part to send the request and handle the response.

            // For example:
            // HttpClient httpClient = HttpClient.newHttpClient();
            // HttpRequest request = HttpRequest.newBuilder()
            //         .uri(URI.create(url + path))
            //         .header("Content-Type", "application/json")
            //         .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            //         .build();
            // HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Process the response and display it in the GUI

            // You can update a result TextArea with the response here.
        });

        // Create a layout for the GUI
        VBox layout = new VBox(10);
        layout.getChildren().addAll(urlLabel, urlField, pathLabel, pathField, requestTypeComboBox, requestLabel, requestArea, sendButton);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
