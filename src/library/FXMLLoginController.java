package library;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Melinna
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private JFXTextField userLogin;
    @FXML
    private JFXPasswordField passwordLogin;
    @FXML
    private JFXButton btn_SignIn;
    
    private double xOffset = 0;
    private double yOffset = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void sign_in(MouseEvent event) throws IOException {
        String user = userLogin.getText();
        String password = passwordLogin.getText();
        System.out.println(password);
        boolean result;
        result = Querys.validar_login(user, password);

        if (!result) {
            JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado "
                    + "satisfactoriamente al sistema", "Mensaje de bienvenida",
                    JOptionPane.INFORMATION_MESSAGE);
            
          /*  ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent main = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            
            main.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            main.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });

            Scene scene = new Scene(main);
            stage.setScene(scene);
            stage.show();*/
        } else {
            JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                    + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
            userLogin.setText("");
            passwordLogin.setText("");
        }

    }

}
