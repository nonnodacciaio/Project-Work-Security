package com.generationitaly.incrediblestyle.model;

public class Categoria {

    private int id;
    private String tipo;

    public Categoria(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}