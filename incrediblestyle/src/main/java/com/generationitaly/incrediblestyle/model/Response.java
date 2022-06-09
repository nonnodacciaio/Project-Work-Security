package com.generationitaly.incrediblestyle.model;

/**
 * Gli oggetti di questa classe saranno quelli che saranno inviati come risposta
 * al front end. Object può essere una Categoria/Articolo/List/Map
 * 
 * @return String status, Object oggetto di ritorno
 */
public class Response {

    private String status;
    private Object object;

    public Response(String status, Object object) {
        super();
        this.status = status;
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
