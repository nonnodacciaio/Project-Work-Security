package com.generationitaly.incrediblestyle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generationitaly.incrediblestyle.dao.IDaoArticoli;
import com.generationitaly.incrediblestyle.model.Articolo;
import com.generationitaly.incrediblestyle.model.Response;

@RestController
@RequestMapping("/articoli")
public class ArticoliController {

    @Autowired
    private IDaoArticoli daoArticoli;

    @GetMapping
    public Response getAll() {
        if (daoArticoli.listaArticoli().size() > 0) {
            return new Response("200", daoArticoli.listaArticoli());
        }
        return new Response("400", null);
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable int id) {
        if (daoArticoli.articolo(id) == null) {
            return new Response("400", null);
        }
        return new Response("200", daoArticoli.articolo(id));
    }

    @PostMapping
    public void post(@RequestBody Articolo articolo) {
        daoArticoli.aggiungiArticolo(articolo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        daoArticoli.eliminaArticolo(id);
    }

    // Non so nemmeno se useremo PUT però vabb, in caso lo cancelliamo
    @PutMapping
    public void update(@RequestBody Articolo articolo) {
        daoArticoli.modificaArticolo(articolo);
    }
}
