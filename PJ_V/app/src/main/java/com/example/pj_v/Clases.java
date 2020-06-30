package com.example.pj_v;

public class Clases {
        String temaid,precio,tema;
    public Clases(String temaid,String tema,String precio){
        this.temaid=temaid;
        this.precio=precio;
        this.tema=tema;

    }

    public String getTemaid() {
        return temaid;
    }

    public String getSeccion() {
        return precio;
    }

    public String getTema() {
        return tema;
    }
}
