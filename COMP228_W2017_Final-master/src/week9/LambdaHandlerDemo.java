package week9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LambdaHandlerDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		
		//Create Components
		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");
		Button btPrint = new Button("Print");
		hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);
		
		btNew.setOnAction((ActionEvent e) -> {
			
			System.out.println("Process New");
			
		});
		
		btOpen.setOnAction((e) -> {
			
			System.out.println("Process Open");
		});
		
		btSave.setOnAction(e -> {
			
			System.out.println("Process Save");
		});
		
		btPrint.setOnAction(e -> System.out.println("Process Print"));
		
		Scene scene = new Scene(hBox);
		primaryStage.setTitle("LambdaHandler");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
