package com.example.facturation_phn;

import DataStorage.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddClientView {
    @FXML
    public TextField iptNom;
    @FXML
    public TextField iptPrenom;
    @FXML
    public TextField ipnAdresse;
    @FXML
    public TextField iptNumero;
    @FXML
    public Button btnValider;

    @FXML
    public void onValider(ActionEvent actionEvent) throws IOException {
        Client client = new Client();
        client.create(this.iptNom.getText(), this.iptPrenom.getText(), this.ipnAdresse.getText(), this.iptNumero.getText());

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage window = (Stage) btnValider.getScene().getWindow();
        window.setScene(new Scene(root));
        this.refresh();
    }

    public void refresh() {
        this.iptNom.setText(null);
        this.ipnAdresse.setText(null);
        this.iptNumero.setText(null);
        this.iptPrenom.setText(null);
    }
}
