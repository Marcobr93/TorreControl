package com.company.Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by joaquinjimenezgarcia on 4/5/17.
 */
public class ListaAviones {
    private ArrayList<Avion> aviones;

    public ListaAviones(){
        aviones = new ArrayList<>();
    }

    public void sumarAvion(Avion avion){
        if (avion != null){
            aviones.add(avion);
        }
    }

    public void mostrarAviones(){
        Collections.sort(aviones, Avion.comparadorPorDistancia);

        for (Avion avion: aviones){
            System.out.println(avion);
        }
    }

    public int longitud(){
        return aviones.size();
    }
}