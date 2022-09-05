package DataStorage;

import DataStorage.DataDAO.ProduitDAO;
import DataStorage.Single.Single;

public class Produit {
    private int id;
    private String designation;
    private double prix;
    private ProduitDAO produitDAO;

    public Produit() {
        this.produitDAO = new ProduitDAO(Single.getInstance());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public ProduitDAO getProduitDAO() {
        return produitDAO;
    }

    public void setProduitDAO(ProduitDAO produitDAO) {
        this.produitDAO = produitDAO;
    }

    public void create(String designation, Double prix) {
        Produit produit = new Produit();
        produit.setDesignation(designation);
        produit.setPrix(prix);
        this.produitDAO.create(produit);
    }

    public void delete(int id) {
        this.produitDAO.delete(id);
    }

    public void update(int id, String designation, Double prix) {
        Produit produit = new Produit();
        produit.setId(id);
        produit.setDesignation(designation);
        produit.setPrix(prix);
        this.produitDAO.update(produit);
    }

    public Produit find(int id) {
        return this.produitDAO.find(id);
    }
    public Produit find(String prod) {
        return this.produitDAO.find(prod);
    }
}
