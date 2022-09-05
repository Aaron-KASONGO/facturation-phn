package com.example.facturation_phn;

import DataStorage.Client;
import DataStorage.Ligne;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    public Button updateFact;
    public Button btnAddFact;
    public Button removeFact;
    public Button btnAddClient;
    public TableView<Table> tableView;
    public TableColumn<Table, Integer> idColumn;
    public TableColumn<Table, String> clientColumn;
    public TableColumn<Table, String> produitColumn;
    public TableColumn<Table, Integer> qteColumn;
    public TableColumn<Table, Double> prixColumn;
    public TableColumn<Table, String> dateColumn;
    public TableColumn<Table, Double> totColumn;


    public void onUpdateFact(ActionEvent actionEvent) {
    }

    public void onAddFact(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("add-facture-view.fxml"));

        Stage window = (Stage) btnAddClient.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void onRemoveFact(ActionEvent actionEvent) {
        Table table = this.tableView.getSelectionModel().getSelectedItem();
        Ligne linge = new Ligne();
        linge.delete(table.getIdLigne());

        refresh();
    }

    public void onAddClient(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("add-client-view.fxml"));

        Stage window = (Stage) btnAddClient.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.idColumn.setCellValueFactory(new PropertyValueFactory<Table, Integer>("idColumn"));
        this.clientColumn.setCellValueFactory(new PropertyValueFactory<Table, String>("clientColumn"));
        this.produitColumn.setCellValueFactory(new PropertyValueFactory<Table, String>("produitColumn"));
        this.qteColumn.setCellValueFactory(new PropertyValueFactory<Table, Integer>("qteColumn"));
        this.prixColumn.setCellValueFactory(new PropertyValueFactory<Table, Double>("prixColumn"));
        this.dateColumn.setCellValueFactory(new PropertyValueFactory<Table, String>("dateColumn"));
        this.totColumn.setCellValueFactory(new PropertyValueFactory<Table, Double>("totColumn"));

        this.refresh();
    }

    public void refresh() {
        this.tableView.getItems().clear();
        Client client = new Client();
        int count = 1;
        for (Client cl : client.findAll()) {
            Table table = new Table(count, cl.getNom() + " " + cl.getPrenom(), cl.getLignes().get(0).getProduit().getDesignation(), cl.getLignes().get(0).getQte(), cl.getLignes().get(0).getProduit().getPrix(), cl.getLignes().get(0).getQte() * cl.getLignes().get(0).getProduit().getPrix(), cl.getLignes().get(0).getDate().toString());
            table.setIdLigne(cl.getLignes().get(0).getId());
            this.tableView.getItems().add(table);
            count++;
        }
    }
}
