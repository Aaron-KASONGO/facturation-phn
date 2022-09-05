package DataStorage;

import DataStorage.DataDAO.LigneDAO;
import DataStorage.Single.Single;

import java.sql.Date;

public class Ligne {
    private int id;
    private int qte;
    private int idProduit;
    private Produit produit;
    private int idClient;
    private Date date;
    private LigneDAO ligneDAO;

    public Ligne() {
        this.ligneDAO = new LigneDAO(Single.getInstance());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public LigneDAO getLigneDAO() {
        return ligneDAO;
    }

    public void setLigneDAO(LigneDAO ligneDAO) {
        this.ligneDAO = ligneDAO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int id_produit) {
        this.idProduit = id_produit;
    }

    public void create(int qte, Date date, int id_produit, int id_client) {
        Ligne ligne = new Ligne();
        ligne.setQte(qte);
        ligne.setDate(date);
        ligne.setIdProduit(id_produit);
        ligne.setIdClient(id_client);
        this.ligneDAO.create(ligne);
    }

    public void delete(int id) {
        this.ligneDAO.delete(id);
    }

    public void update(int id, int qte, Date date) {
        Ligne ligne = new Ligne();
        ligne.setId(id);
        ligne.setQte(qte);
        ligne.setDate(date);
        this.ligneDAO.update(ligne);
    }

    public Ligne find(int id) {
        return this.ligneDAO.find(id);
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
