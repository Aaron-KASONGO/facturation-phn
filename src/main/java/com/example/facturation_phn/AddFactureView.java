package com.example.facturation_phn;

import DataStorage.Client;
import DataStorage.Ligne;
import DataStorage.Produit;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddFactureView implements Initializable {
    public TextField iptProduit;
    public TextField iptPrix;
    public TextField iptQte;
    public Button btnValider;
    public ComboBox<Client> iptClient;
    public Label btnAddClient;

    public void onValider(ActionEvent actionEvent) throws IOException {
        Client client = iptClient.getSelectionModel().getSelectedItem();
        System.out.println(client.getId());
        Produit produit = new Produit();
        produit.create(iptProduit.getText(), Double.parseDouble(iptPrix.getText()));

        Ligne ligne = new Ligne();
        ligne.create(Integer.parseInt(iptQte.getText()), Date.valueOf(LocalDate.now()), produit.find(iptProduit.getText()).getId(), client.getId());

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) btnAddClient.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void onAddClient(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("add-client-view.fxml"));

        Stage window = (Stage) btnAddClient.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iptProduit.setText(null);
        iptPrix.setText(null);
        iptQte.setText(null);

        Client client = new Client();
        for (Client cl : client.findA()) {
            iptClient.getItems().add(cl);
        }
        iptClient.getSelectionModel().select(0);
    }
}
