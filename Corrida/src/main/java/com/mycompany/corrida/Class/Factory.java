package com.mycompany.corrida.Class;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author alunos
 */
public class Factory {

    private static final double distanciaTotalCorrida = 200;
   
    
   
    public static ArrayList<Thread> NovosCarros(Podio podio, CountDownLatch latch) {
        
        ArrayList<Thread> threads = new ArrayList<>();
        
     
        Runnable carro1 = new Carro("Supra MK4", distanciaTotalCorrida, podio, latch);
        Runnable carro2 = new Carro("Ferrari Purosangue", distanciaTotalCorrida, podio, latch);
        Runnable carro3 = new Carro("Nissan GTR", distanciaTotalCorrida, podio, latch);
        Runnable carro4 = new Carro("Buggati Veyron", distanciaTotalCorrida, podio, latch);
        Runnable carro5 = new Carro("Dodge Challenger", distanciaTotalCorrida, podio, latch);
        Runnable carro6 = new Carro("Lamborghini Aventador", distanciaTotalCorrida, podio, latch);
        Runnable carro7 = new Carro("Nissan Skyline R34", distanciaTotalCorrida, podio, latch);
        Runnable carro8 = new Carro("Rx7", distanciaTotalCorrida, podio, latch);

        threads.add(new Thread(carro1));
        threads.add(new Thread(carro2));
        threads.add(new Thread(carro3));
        threads.add(new Thread(carro4));
        threads.add(new Thread(carro5));
        threads.add(new Thread(carro6));
        threads.add(new Thread(carro7));
        threads.add(new Thread(carro8));
        
        return threads;
    }
}