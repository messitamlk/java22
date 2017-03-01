package ≥Ã–Ú;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class TLYShangpinCaidan extends Application {
	public void start(final Stage primaryStage)throws Exception{
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		HBox hb0 = new HBox();
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		HBox hb3 = new HBox();
		HBox hb4 = new HBox();
		VBox vb1 = new VBox();
		
		final ComboBox<String> cbo = new ComboBox<>();
		cbo.getItems().addAll("Ã“¿Ó‘∞","»˝Àƒ ≥Ã√","”—‘∞","Ã“‘¥æ”");
		cbo.setStyle("-fx-color: white");
		cbo.setValue("Ã“¿Ó‘∞");
		hb0.getChildren().add(cbo);
		
		Image image1 = new Image("images/Ã“¿Ó‘∞/ª∆ÏÀº¶√◊∑π.jpg");
		ImageView imageview1 = new ImageView(image1);
		imageview1.setFitHeight(50);
		imageview1.setFitWidth(50);
		Label l1 = new Label("ª∆ÏÀº¶√◊∑π     £§13.00",imageview1);
		l1.setContentDisplay(ContentDisplay.RIGHT);
		Button bt1 = new Button("π∫¬Ú");
		hb1.getChildren().addAll(l1,bt1);
		
		
		Image image2 = new Image("images/Ã“¿Ó‘∞/÷ÿ«Ïº¶π´Ï“.jpg");
		ImageView imageview2 = new ImageView(image2);
		imageview2.setFitHeight(50);
		imageview2.setFitWidth(50);
		Label l2 = new Label("÷ÿ«Ïº¶π´Ï“     £§17.00",imageview2);
		l2.setContentDisplay(ContentDisplay.RIGHT);
		Button bt2 = new Button("π∫¬Ú");
		hb2.getChildren().addAll(l2,bt2);
		
		
		Image image3 = new Image("images/Ã“¿Ó‘∞/¬È¿±œ„π¯.jpg");
		ImageView imageview3 = new ImageView(image3);
		imageview3.setFitHeight(50);
		imageview3.setFitWidth(50);
		Label l3 = new Label("¬È ¿±  œ„ π¯    £§12.00",imageview3);
		l3.setContentDisplay(ContentDisplay.RIGHT);
		Button bt3 = new Button("π∫¬Ú");
		hb3.getChildren().addAll(l3,bt3);
		
		
		Image image4 = new Image("images/Ã“¿Ó‘∞/ÀÆ÷Û»‚∆¨.jpg");
		ImageView imageview4 = new ImageView(image4);
		imageview4.setFitHeight(50);
		imageview4.setFitWidth(50);
		Label l4 = new Label("ÀÆ ÷Û  »‚ ∆¨    £§12.00",imageview4);
		l4.setContentDisplay(ContentDisplay.RIGHT);
		Button bt4 = new Button("π∫¬Ú");
		hb4.getChildren().addAll(l4,bt4);
		
		hb0.setSpacing(10);
		hb1.setSpacing(10);
		hb2.setSpacing(10);
		hb3.setSpacing(10);
		hb4.setSpacing(10);
		
		vb1.getChildren().addAll(hb0,hb1,hb2,hb3,hb4);
		vb1.setSpacing(10);
		pane.getChildren().add(vb1);
		Scene scene = new Scene(pane,300,300);
		primaryStage.setTitle("…Ã∆∑¿∏");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		cbo.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				String aaa;
				aaa = cbo.getValue();
				if(aaa == "»˝Àƒ ≥Ã√"){
					SSShangpinCaidan SS = new SSShangpinCaidan();
					Stage stage = new Stage();
					try {
						SS.start(stage);
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(aaa == "”—‘∞"){
					YYShangpinCaidan YY = new YYShangpinCaidan();
					Stage stage = new Stage();
					try {
						YY.start(stage);
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(aaa == "Ã“‘¥æ”"){
					TYJShangpinCaidan TYJ = new TYJShangpinCaidan();
					Stage stage = new Stage();
					try {
						TYJ.start(stage);
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(aaa == "Ã“¿Ó‘∞"){
					TLYShangpinCaidan TLY = new TLYShangpinCaidan();
					Stage stage = new Stage();
					try {
						TLY.start(stage);
						primaryStage.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		}
		);
	}
	/*public static void main(String args[]){
		launch(args);
	}*/

}
