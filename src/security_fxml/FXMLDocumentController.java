/**
 *
 * @author saed_
 */
package security_fxml;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author saed_
 */
public class FXMLDocumentController implements Initializable {
    Caeaser caeaser = new Caeaser();
    PlayFair playfair = new PlayFair();
  ObservableList list= FXCollections.observableArrayList();
    @FXML
    private Label label;
    
        // plainText TextField 
@FXML
private TextField plain;
@FXML
private TextField ciper;
@FXML
private TextField key;
public String S_plain ;//   plain text
public String S_ciper ; 
public String S_key ;
public int I_key;
@FXML
private ChoiceBox <String> choise_algorithm ;


    // encryption button 
    @FXML
    private void Encryption(ActionEvent event) {
         S_plain = plain.getText();
         S_key = key.getText();
         I_key=BasisLibrary.stringToInt(S_key);
        //  ciper.appendText(S_plain);
          
          String algorithm =choise_algorithm.getValue();
          if(algorithm ==null){
         ciper.setText("Select a algorithm first!");
}
          else if(algorithm == "Ceaser"){
          S_ciper = caeaser.encrypt_caeaser(S_plain,I_key);
           ciper.setText(S_ciper);
}
 else if(algorithm == "PlayFair"){
     if (S_plain.length() % 2 == 0)
        {
             playfair.setKey(S_key);
     playfair.KeyGen();
     S_ciper=playfair.encrypt_playfair(S_plain);
           ciper.setText(S_ciper);
        }
        else
        {
             ciper.setText("Message length should be even");
        }
    
}         
    }
    // Decryption button 
    @FXML
    private void Decryption(ActionEvent event) {
        String algorithm =choise_algorithm.getValue();
          if(algorithm ==null){
         ciper.setText("Select a algorithm first!");
}
          else if(algorithm == "Ceaser"){
            //  caeaser.encrypt_caeaser(S_plain,3);
           ciper.setText(caeaser.decrypt_caeaser(S_ciper,I_key));
}
 else if(algorithm == "PlayFair"){
            if (S_plain.length() % 2 == 0)
        {
             playfair.setKey(S_key);
     playfair.KeyGen();
     S_ciper=playfair.decrypt_playfair(S_ciper);
           ciper.setText(S_ciper);
        }
        else
        {
             ciper.setText("Message length should be even");
        }
} 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       loaddata(); 
     //    textA.textProperty();
    }    
    private void loaddata(){
String a="Ceaser";
String b="PlayFair";
list.addAll(a,b);
choise_algorithm.getItems().setAll(list);
}
}
