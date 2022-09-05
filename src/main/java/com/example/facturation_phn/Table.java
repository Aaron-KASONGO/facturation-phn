package com.example.facturation_phn;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Table {
    private Integer idColumn;
    private String clientColumn;
    private String produitColumn;
    private Integer qteColumn;
    private Double prixColumn;
    private Double totColumn;
    private String dateColumn;
    private int idLigne;

    public Table(Integer idColumn, String clientColumn, String produitColumn, Integer qteColumn, Double prixColumn, Double totColumn, String dateColumn) {
        this.idColumn = idColumn;
        this.clientColumn = clientColumn;
        this.produitColumn = produitColumn;
        this.qteColumn = qteColumn;
        this.prixColumn = prixColumn;
        this.totColumn = totColumn;
        this.dateColumn = dateColumn;
    }

    public int getIdLigne() {
        return idLigne;
    }

    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }

    public Integer getIdColumn() {
        return idColumn;
    }

    public void setIdColumn(Integer idColumn) {
        this.idColumn = idColumn;
    }

    public String getClientColumn() {
        return clientColumn;
    }

    public void setClientColumn(String clientColumn) {
        this.clientColumn = clientColumn;
    }

    public String getProduitColumn() {
        return produitColumn;
    }

    public void setProduitColumn(String produitColumn) {
        this.produitColumn = produitColumn;
    }

    public Integer getQteColumn() {
        return qteColumn;
    }

    public void setQteColumn(Integer qteColumn) {
        this.qteColumn = qteColumn;
    }

    public Double getPrixColumn() {
        return prixColumn;
    }

    public void setPrixColumn(Double prixColumn) {
        this.prixColumn = prixColumn;
    }

    public Double getTotColumn() {
        return totColumn;
    }

    public void setTotColumn(Double totColumn) {
        this.totColumn = totColumn;
    }

    public String getDateColumn() {
        return dateColumn;
    }

    public void setDateColumn(String dateColumn) {
        this.dateColumn = dateColumn;
    }

    @Override
    public String toString() {
        return this.getIdColumn() + "       " + this.getClientColumn() + "      " + this.produitColumn + "      " + this.getQteColumn() + "     " + this.getPrixColumn() + "        " + this.getTotColumn() + "     " + getDateColumn();
    }
}
