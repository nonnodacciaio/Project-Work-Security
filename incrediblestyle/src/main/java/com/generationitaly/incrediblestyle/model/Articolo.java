package com.generationitaly.incrediblestyle.model;

public class Articolo {

    private int codiceArticolo;
    private String nome;
    private String foto;
    private double prezzo;
    private String colore;
    private String taglia;
    private int quantita;
    private String sesso;
    private Categoria categoria;

    public Articolo(int codiceArticolo, String nome, String foto, double prezzo, String colore, String taglia,
            int quantita, String sesso, Categoria categoria) {
        this.codiceArticolo = codiceArticolo;
        this.nome = nome;
        this.foto = foto;
        this.prezzo = prezzo;
        this.colore = colore;
        this.taglia = taglia;
        this.quantita = quantita;
        this.sesso = sesso;
        this.categoria = categoria;
    }

    public int getCodiceArticolo() {
        return this.codiceArticolo;
    }

    public void setCodiceArticolo(int codiceArticolo) {
        this.codiceArticolo = codiceArticolo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getColore() {
        return this.colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getTaglia() {
        return this.taglia;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public int getQuantita() {
        return this.quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getSesso() {
        return this.sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
