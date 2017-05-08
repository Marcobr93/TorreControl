package com.company.Model;


import java.util.Comparator;
import java.util.Date;

/**
 * Created by joaquinjimenezgarcia on 4/5/17.
 */
public class Avion {
    private String codigoVuelo;
    private String aerolinea;
    private int velocidad;
    private Date fechaHora;
    private double distancia;
    private boolean llegada;

    public Avion() {
        this.codigoVuelo = "Desconocida";
        this.aerolinea = "Desconocida";
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

    @Override
    public String toString() {
        return "Avion: " +
                "código de vuelo: " + codigoVuelo +
                ", aerolínea: " + aerolinea +
                ", velocidad: " + velocidad + " km/h" +
                ", fecha y hora: " + fechaHora +
                ", distancia: " + actualizarDistancia() + " km" +
                ", " + haLlegado();
    }

    public static Comparator<Avion> comparadorPorDistancia = new Comparator<Avion>() {
        @Override
        public int compare(Avion avion1, Avion avion2) {
            return (int)avion1.getDistancia() - (int)avion2.getDistancia();
        }
    };

    public double actualizarDistancia(){
        double nuevaDistancia;
        double velocidadSegundos;
        Date actual = new Date();

        double distanciaAntes = this.getFechaHora().getTime();
        double distanciaAhora = actual.getTime();

        double diff = (distanciaAhora - distanciaAntes)/(1000*60);

        velocidadSegundos = (double)this.getVelocidad() / 3600;

        nuevaDistancia = this.getDistancia() - (diff * velocidadSegundos);

        if (nuevaDistancia > 0) {
            this.setDistancia(nuevaDistancia);
            return nuevaDistancia;
        }else{
            this.setDistancia(0);
            llegada = true;
            return 0.0;
        }
    }

    private String haLlegado(){
        if (llegada){
            return "el avión ha llegado a su destino";
        }else{
            return "avión en camino.";
        }
    }
}
