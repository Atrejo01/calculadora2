package mx.utng.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mx.utng.dao.UsuarioDAO;

public class LoginController {
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private CheckBox chkRecordar;
    @FXML
    private Label lblMensaje;
    
    /* 
    @FXML
    private void ingresar(){
        String usuario= txtUsuario.getText();
        String password = txtPassword.getText();
        if(usuario.isBlank() || password.isBlank()){
            lblMensaje.setText("Complete ambos campos.");
            return;
        }
        lblMensaje.setText("Validando usuario...");
        

    }*/

    @FXML
    private void ingresar() {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        if(usuario.isBlank() || password.isBlank()){
            lblMensaje.setText("Complete todos los campos.");
            return;
        }
        lblMensaje.setText("Validando usuario...");
        UsuarioDAO dao = new UsuarioDAO();

        if(dao.validar(usuario,password)){

            //Abrir menú principal
            try {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/mx/utng/view/fx_menu.fxml"));

                Parent root = loader.load();

                Stage stage = (Stage) txtUsuario.getScene().getWindow();

                stage.setScene(new Scene(root));
                stage.setTitle("Sistema de Gestión de Biblioteca");
                stage.setResizable(true);
                stage.centerOnScreen();
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Usuario válido");
        }else{

            //Mostrar mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.showAndWait();
            System.out.println("Usuario NO válido");

        }
    }


    
}
