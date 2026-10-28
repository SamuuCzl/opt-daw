package com.ejerRepaso2.ejerRepaso2.modelo;

public class Prestamo {
    public Integer libroId;
    public String nombreSocio;
    public Integer diasPrestamo;
    public Boolean carnetPremio;


    public Prestamo() {
    }

    public Prestamo(Integer libroId, String nombreSocio, Integer diasPrestamo, Boolean carnetPremio) {
        this.libroId = libroId;
        this.nombreSocio = nombreSocio;
        this.diasPrestamo = diasPrestamo;
        this.carnetPremio = carnetPremio;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public Integer getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(Integer diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public Boolean getCarnetPremio() {
        return carnetPremio;
    }

    public void setCarnetPremio(Boolean carnetPremio) {
        this.carnetPremio = carnetPremio;
    }
}
