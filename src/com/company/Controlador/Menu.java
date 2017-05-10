package com.company.Controlador;


import com.company.Modelo.Avion;
import com.company.Modelo.ListaAviones;

import java.util.Date;
import java.util.Scanner;

public class Menu {
    ListaAviones listaAviones;

    public Menu(){
        listaAviones = new ListaAviones();
    }

    /**
     * Método para iniciar el programa
     */
    public void run(){
        int option;

        while ((option = mostrarMenu())!= 0){
            switch (option) {
                case 1:
                    listaAviones.añadirAvion(leerAvion());
                    break;
                case 2:
                    if (listaAviones.longitud()>0){
                        listaAviones.mostrarAviones();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Método para introducir los datos del avión
     * @return
     */
    public Avion leerAvion(){
        Scanner input = new Scanner (System.in);
        String codVuelo;
        String aerolinea;
        int velocidad;
        Date fechaHora;
        double distancia;
        Avion avion;

        do {
            System.out.println("Inserte código de vuelo: ");
            codVuelo = input.next();
        }while (codVuelo.equals(""));

        do {
            System.out.println("Inserte aerolínea: ");
            aerolinea = input.next();
        }while (aerolinea.equals(""));

        do {
            System.out.println("Inserte la velocidad del avión: ");
            velocidad = input.nextInt();
        }while (velocidad <= 0);

        fechaHora = new Date();

        do {
            System.out.println("Inserte la distancia faltante a pista: ");
            distancia = input.nextDouble();
        }while (distancia <= 0.0);

        avion = new Avion(codVuelo,aerolinea,velocidad,fechaHora,distancia);

        return avion;
    }

    /**
     * Método para imprimir el menú utilizado para registrar y mostrar los aviones introducidos
     * @return
     */
    public int mostrarMenu(){
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("****************************");
        System.out.println("* 1. Registrar avión    *");
        if (listaAviones.longitud()>0) {
            System.out.println("* 2. Aviones registrados *");
        }
        System.out.println("* 0. Salir                 *");
        System.out.println("****************************");

        System.out.println("Opción: ");
        option = input.nextInt();

        return option;
    }
}