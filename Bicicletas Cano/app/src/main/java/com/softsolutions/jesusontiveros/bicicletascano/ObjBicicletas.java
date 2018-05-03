package com.softsolutions.jesusontiveros.bicicletascano;

/**
 * Created by jesus on 3/20/2018.
 */

public class ObjBicicletas {
    private String marca,modelo;
    private String thumbnail;

    public ObjBicicletas() {
    }

    public ObjBicicletas(String marca, String modelo, String thumbnail) {
        this.marca = marca;
        this.modelo = modelo;
        this.thumbnail = thumbnail;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
