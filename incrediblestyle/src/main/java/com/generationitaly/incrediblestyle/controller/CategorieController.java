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

import com.generationitaly.incrediblestyle.dao.IDaoCategorie;
import com.generationitaly.incrediblestyle.model.Categoria;
import com.generationitaly.incrediblestyle.model.Response;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private IDaoCategorie daoCategorie;

    @GetMapping
    public Response getAll() {
        if (daoCategorie.listaCategorie().size() > 0) {
            return new Response("200", daoCategorie.listaCategorie());
        }
        return new Response("400", null);
    }

    @GetMapping("/{id}")
    public Response getOne(@PathVariable int id) {
        if (daoCategorie.categoria(id) == null) {
            return new Response("400", null);
        }
        return new Response("200", daoCategorie.categoria(id));
    }

    @PostMapping
    public void post(@RequestBody Categoria categoria) {
        daoCategorie.aggiungiCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        daoCategorie.eliminaCategoria(id);
    }

    // Non so nemmeno se useremo PUT però vabb, in caso lo cancelliamo
    @PutMapping
    public void update(@RequestBody Categoria categoria) {
        daoCategorie.modificaCategoria(categoria);
    }

}
