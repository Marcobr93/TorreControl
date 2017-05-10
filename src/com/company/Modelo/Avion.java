package com.company.Modelo;


import java.util.Comparator;
import java.util.Date;


public class Avion {
    private String codigoVuelo;
    private String aerolinea;
    private int velocidad;
    private Date fechaHora;
    private double distancia;
    private boolean llegada;

    // Constructores

    public Avion() {
        this.codigoVuelo = "Código de vuelo desconocido";
        this.aerolinea = "Aerolínea desconocida";
        this.velocidad = 0;
        this.fechaHora = new Date();
        this.distancia = 0;
    }

    public Avion(String codVuelo, String aerolinea, int velocidad, Date fechaHora, double distancia) {
        this.setCodVuelo(codVuelo);
        this.setAerolinea(aerolinea);
        this.setVelocidad(velocidad);
        this.setFechaHora();
        this.setDistancia(distancia);
    }

    // Accesores

    public String getCodVuelo() {
        return codigoVuelo;
    }

    public void setCodVuelo(String codVuelo) {
        if (codVuelo.equals("")){
            this.codigoVuelo = "Desconocido";
        }else {
            this.codigoVuelo = codVuelo;
        }
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        if (aerolinea.equals("")){
            this.aerolinea = "Desconocido";
        }else {
            this.aerolinea = aerolinea;
        }
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        if (velocidad < 0){
            this.velocidad = 100;
        }else {
            this.velocidad = velocidad;
        }
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora() {
        this.fechaHora = new Date();
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        if (distancia<=0){
            this.distancia = 0;
        }else {
            this.distancia = distancia;
        }
    }

    // Métodos
    /**
     * Método para comparar la distancia a pista de  los aviones que vamos añadiendo para saber cuál está más próximo
     * y poder ordenarlos
     */
    public static Comparator<Avion> comparadorDistancia = new Comparator<Avion>() {
        @Override
        public int compare(Avion avion1, Avion avion2) {
            return (int)avion1.getDistancia() - (int)avion2.getDistancia();
        }
    };

    /**
     * Método booleano que nos sirve para indicar si un avión está de camino a pista o ha llegado a su destino.
     * @return
     */
    private String haLlegado(){
        if (llegada){
            return "el avión ha llegado a su destino";
        }else{
            return "avión en camino.";
        }
    }

    @Override
    public String toString() {
        return "Avion: " +
                "código de vuelo: " + codigoVuelo +
                ", aerolínea: " + aerolinea +
                ", velocidad: " + velocidad + " km/h" +
                ", fecha y hora: " + fechaHora +
                ", distancia: " + distancia + " km" +
                ", " + haLlegado();
    }
}

