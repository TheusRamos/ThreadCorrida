/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.corrida.Class;

import java.util.ArrayList;

/**
 *
 * @author alunos
 */
public class Factory {

    private static ArrayList<Thread> carros = new ArrayList<>();
    private static final double distanciaTotalCorrida = 20;

    public static ArrayList<Thread> NovosCarros() {
        Runnable carro1 = new Carro("Supra MK4", distanciaTotalCorrida);
        Runnable carro2 = new Carro("Ferrari Purosangue", distanciaTotalCorrida);
        Runnable carro3 = new Carro("Nissan GTR", distanciaTotalCorrida);
        Runnable carro4 = new Carro("Buggati Veyron", distanciaTotalCorrida);
        Runnable carro5 = new Carro("Dodge Challenger", distanciaTotalCorrida);
        Runnable carro6 = new Carro("Lamborghini Aventador", distanciaTotalCorrida);
        Runnable carro7 = new Carro("Nissan Skyline R34", distanciaTotalCorrida);
        Runnable carro8 = new Carro("Rx7", distanciaTotalCorrida);

        Thread thread1 = new Thread(carro1);
        Thread thread2 = new Thread(carro2);
        Thread thread3 = new Thread(carro3);
        Thread thread4 = new Thread(carro4);
        Thread thread5 = new Thread(carro5);
        Thread thread6 = new Thread(carro6);
        Thread thread7 = new Thread(carro7);
        Thread thread8 = new Thread(carro8);

        Factory.carros.add(thread1);
        Factory.carros.add(thread2);
        Factory.carros.add(thread3);
        Factory.carros.add(thread4);
        Factory.carros.add(thread5);
        Factory.carros.add(thread6);
        Factory.carros.add(thread7);
        Factory.carros.add(thread8);
        

        return carros;
    }
}
