package DataStorage;

import DataStorage.DataDAO.ClientDAO;
import DataStorage.Single.Single;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String numero;
    private List<Ligne> lignes;
    private ClientDAO clientDAO;

    public Client(){
        this.lignes = new ArrayList<>();
        this.clientDAO = new ClientDAO(Single.getInstance());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Ligne> getLignes() {
        return lignes;
    }

    public void setLignes(List<Ligne> lignes) {
        this.lignes = lignes;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public void addLigne(Ligne ligne) {
        this.lignes.add(ligne);
    }

    public void create(String nom, String prenom, String adresse, String numero) {
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAdresse(adresse);
        client.setNumero(numero);
        this.clientDAO.create(client);
    }

    public void delete(int id) {
        this.clientDAO.delete(id);
    }

    public void update(int id,String nom, String prenom, String adresse, String numero) {
        Client client = new Client();
        client.setId(id);
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAdresse(adresse);
        client.setNumero(numero);
        this.clientDAO.update(client);
    }

    public Client find(int id) {
        return this.clientDAO.find(id);
    }

    public Client findById(int id) {
        return this.clientDAO.findById(id);
    }
    public List<Client> findAll() {
        return this.clientDAO.findAll();
    }
    public List<Client> findA() {
        return this.clientDAO.findA();
    }

    @Override
    public String toString() {
        return this.prenom + " " + this.nom;
    }
}