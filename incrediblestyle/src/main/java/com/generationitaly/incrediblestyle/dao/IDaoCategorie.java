package com.generationitaly.incrediblestyle.dao;

import java.util.List;

import com.generationitaly.incrediblestyle.model.Categoria;

public interface IDaoCategorie {

    List<Categoria> listaCategorie();

    Categoria categoria(int id);

    boolean aggiungiCategoria(Categoria categoria);

    boolean modificaCategoria(Categoria categoria);

    boolean eliminaCategoria(int id);

}
