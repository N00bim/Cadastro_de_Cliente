package ex.trabalho3;

import javafx.scene.control.TextField;
//import java.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaController {
    @FXML
    private void initialize(){
        buscadorDeCEP = new Buscador();
        clientes = new ArrayList<>();
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        colunaCidade.setCellValueFactory(cid -> {
            return new SimpleStringProperty(cid.getValue().getEndereco().getCidade());
           }
        );
        
        colunaEstado.setCellValueFactory(cid -> {
            return new SimpleStringProperty(cid.getValue().getEndereco().getEstado());
           }
        );
    }
    private ArrayList<Cliente> clientes;
    private Buscador buscadorDeCEP;
    
    @FXML
    private TextField campoNome;
    
    @FXML
    private TextField campoCEP;
    
    @FXML
    private TextField campoRua;
    
    @FXML
    private TextField campoNumero;
    
    @FXML
    private TextField campoCidade;
    
    @FXML
    private TextField campoEstado;
    
    @FXML
    private TextField campoTelefone;
    
    
    @FXML
    private TableView<Cliente> tabelaClientes;
    @FXML
    private TableColumn<Cliente, Integer> colunaCodigo;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaCidade;
    @FXML
    private TableColumn<Cliente, String> colunaTelefone;
    @FXML
    private TableColumn<Cliente, String> colunaEstado;
    
    @FXML
    private void buscarCEP (){
        if(campoCEP.getText().isBlank()) return;
        try{
        Endereco endereco = buscadorDeCEP.buscar(campoCEP.getText());
        campoRua.setText(endereco.getRua());
        campoCidade.setText(endereco.getCidade());
        campoEstado.setText(endereco.getEstado());
        }catch(IllegalArgumentException e1){
            Alert alerta1 = new Alert(Alert.AlertType.ERROR);
            alerta1.setHeaderText(null);
            alerta1.setContentText(e1.getMessage());
            alerta1.show();
        }catch(IOException e){
            Alert alerta2 = new Alert(Alert.AlertType.ERROR);
            alerta2.setHeaderText(null);
            alerta2.setContentText(e.getMessage());
            alerta2.show();
        }
       
    }
    
    @FXML
    private void limpar(){
        campoCEP.clear();
        campoNome.clear();
        campoRua.clear();
        campoRua.clear();
        campoNumero.clear();
        campoCidade.clear();
        campoEstado.clear();
        campoTelefone.clear();
    }
    
    @FXML
    private void gravar(){
        Endereco e = new Endereco(campoCEP.getText(),campoRua.getText(),
        campoNumero.getText(),campoCidade.getText(),campoEstado.getText());
        
        Cliente c = new Cliente(campoNome.getText(),e,campoTelefone.getText());
        clientes.add(c);
        
        tabelaClientes.setItems(FXCollections.observableArrayList(clientes));
        
        limpar();
    }
    
    
}
