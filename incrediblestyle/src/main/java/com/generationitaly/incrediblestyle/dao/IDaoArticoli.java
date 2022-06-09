package com.generationitaly.incrediblestyle.dao;

import java.util.List;

import com.generationitaly.incrediblestyle.model.Articolo;

public interface IDaoArticoli {

    List<Articolo> listaArticoli();

    Articolo articolo(int codiceArticolo);

    boolean aggiungiArticolo(Articolo articolo);

    boolean modificaArticolo(Articolo articolo);

    boolean eliminaArticolo(int codiceArticolo);

}
