package com.ejerRepaso2.ejerRepaso2.modelo;

public class Prestamo {

    private Integer libroId;
    private String nombreSocio;
    private Integer diasPrestamo;
    private boolean carnetPremium;

    public Prestamo() {
    }

    public Prestamo(Integer libroId, String nombreSocio, Integer diasPrestamo, boolean carnetPremium) {
        this.libroId = libroId;
        this.nombreSocio = nombreSocio;
        this.diasPrestamo = diasPrestamo;
        this.carnetPremium = carnetPremium;
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

    public boolean isCarnetPremium() {
        return carnetPremium;
    }

    public void setCarnetPremium(boolean carnetPremium) {
        this.carnetPremium = carnetPremium;
    }
}
