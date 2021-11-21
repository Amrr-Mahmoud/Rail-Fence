
package railfen;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RailFen extends Application {
    
    public static int getIntFromTextField(TextField textField) {
        String text = textField.getText();
        return Integer.parseInt(text);
    }
    
    @Override
    public void start(Stage primaryStage) {
    Label ltitle=new Label("Rail Fence");
        Label lr=new Label("Result");
        Button encryptButton=new Button();
        Text t1=new Text("Text");
        TextField tf1=new TextField();
        Button decryptButton=new Button();
        Text t2=new Text("Depth");
        TextField tf2=new TextField();
        TextArea ta=new TextArea();
        Text terror=new Text();
        int m_row,m_col,len;
        len=t1.getText().length();
        String text="",key="";
        GridPane GP=new GridPane();
        
        //  button encrypt
        encryptButton.setText("Encrypt");
        encryptButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String str1=tf1.getText();
                String str2=tf2.getText();
                if(str1.equals("") || str2.equals("")){
                    terror.setText("string or key is empty please enter it");
                }else{
                    ta.clear();
                    ta.appendText("Cipher text \t");
                    ta.appendText(RailClass.enc(str1, str2));
                    terror.setText("");
                    tf1.clear();
                    tf2.clear();
                }
            }
        });
        
        decryptButton.setText("Decrypt");
        decryptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str1=tf1.getText();
                String str2=tf2.getText();
                if(str1.equals("") || str2.equals("")){
                    terror.setText("Text or Depth is empty please enter it");
                }else{
                    ta.clear();
                    ta.appendText("Plain text  \t");
                    //ta.appendText(RT.Decrypt(tf1.getText(), tf2.getText()));
                    ta.appendText(RailClass.dec(str1, str2));
                    terror.setText("");
                    tf1.clear();
                    tf2.clear();
                    
                }
                
            }
        });
     
        
        
        GP.setAlignment(Pos.CENTER);
        GP.add(terror, 1, 0);
        GP.add(t1, 0, 1);
        GP.add(tf1, 1, 1);
        GP.add(t2, 0, 2);
        GP.add(tf2, 1, 2);
        GP.add(encryptButton, 0, 3);
        GP.add(decryptButton, 1, 3);
        GP.add(lr, 0, 4);
        GP.add(ta, 1, 4);
        Scene scene = new Scene(GP, 550, 450);
        primaryStage.setTitle("Rail Fence");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
