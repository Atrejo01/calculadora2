package mx.utng.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import mx.utng.dao.LibroDAO;
import mx.utng.model.Libro;


public class LibroController {


    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtEditorial;

    @FXML
    private TextField txtAnio;

    @FXML
    private TextField txtExistencias;

    @FXML
    private TextField txtDisponibles;

    @FXML
    private TextField txtBuscar;

    //tabView
    @FXML
    private TableView<Libro> tblLibros;

    @FXML
    private TableColumn<Libro,String> colISBN;

    @FXML
    private TableColumn<Libro,String> colTitulo;

    @FXML
    private TableColumn<Libro,String> colAutor;

    @FXML
    private TableColumn<Libro,String> colEditorial;

    @FXML
    private TableColumn<Libro,Integer> colAnio;

    @FXML
    private TableColumn<Libro,Integer> colExistencias;


    private LibroDAO dao = new LibroDAO();


//<<<<<<<<<<<<
    @FXML
    public void initialize() {

        colISBN.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colExistencias.setCellValueFactory(new PropertyValueFactory<>("existencias"));

        cargarLibros();
    }

    @FXML
    private void nuevo() {

        txtISBN.clear();
        txtTitulo.clear();
        txtAutor.clear();
        txtEditorial.clear();
        txtAnio.clear();
        txtExistencias.clear();
        txtDisponibles.clear();

    }

    private void cargarLibros(){

        ObservableList<Libro> lista =
                FXCollections.observableArrayList(
                        dao.listar()
                );

        // aquí conectaremos el TableView
                tblLibros.setItems(lista);      //<---
    }





    @FXML
    private void guardar(){

        Libro libro = new Libro();

        libro.setIsbn(txtISBN.getText());
        libro.setTitulo(txtTitulo.getText());
        libro.setAutor(txtAutor.getText());
        libro.setEditorial(txtEditorial.getText());

        libro.setAnio(Integer.parseInt(txtAnio.getText())
        );

        libro.setExistencias(
            Integer.parseInt(txtExistencias.getText())
        );

        libro.setDisponibles(
            Integer.parseInt(txtDisponibles.getText())
        );


        if(dao.insertar(libro)){

            mostrarMensaje("Libro guardado correctamente");
            limpiar();
            cargarLibros();

        }

        //<---
        mostrarTabla();
    }


    @FXML
    private void actualizar(){
        System.out.println("Actualizando...");
    }

    @FXML
    private void eliminar(){
        System.out.println("Eliminando...");
    }

    @FXML
    private void limpiar(){

        txtISBN.clear();
        txtTitulo.clear();
        txtAutor.clear();
        txtEditorial.clear();
        txtAnio.clear();
        txtExistencias.clear();
        txtDisponibles.clear();

    }

    @FXML
    private void buscar(){
        System.out.println("Buscando...");
        Libro libro = new Libro();

        libro.setId(Integer.parseInt(txtBuscar.getText()));

        if(dao.insertar(libro)){

            mostrarMensaje("Libro guardado correctamente");
            limpiar();
            cargarLibros();

        }
    }


    private void mostrarMensaje(String mensaje){

        Alert alerta =
                new Alert(Alert.AlertType.INFORMATION);

        alerta.setContentText(mensaje);
        alerta.show();

    }

    public void mostrarTabla() {

        colISBN.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colExistencias.setCellValueFactory(new PropertyValueFactory<>("existencias"));

        cargarLibros();
    }
    

}