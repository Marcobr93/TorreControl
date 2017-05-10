package com.company.Modelo;

import java.util.ArrayList;
import java.util.Collections;


public class ListaAviones {
    private ArrayList<Avion> aviones;

    public ListaAviones(){
        aviones = new ArrayList<>();
    }

    /**
     * Método para añadir aviones
     * @param avion
     */
    public void añadirAvion(Avion avion){
        if (avion != null){
            aviones.add(avion);
        }
    }

    /**
     * Método para mostrar los aviones
     */
    public void mostrarAviones(){
        Collections.sort(aviones, Avion.comparadorDistancia);

        for (Avion avion: aviones){
            System.out.println(avion);
        }
    }

    public int longitud(){
        return aviones.size();
    }
}