package com.mycompany.corrida;

import com.mycompany.corrida.Class.Podio;
import com.mycompany.corrida.Class.Factory;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author alunos
 */
public class Corrida {

    public static void main(String[] args) throws InterruptedException {
        Podio podio = new Podio();
        CountDownLatch latch = new CountDownLatch(3);
        ArrayList<Thread> threads = Factory.NovosCarros(podio, latch);

        System.out.println("------------------------------------------");
        System.out.println("     INÍCIO DA GRANDE CORRIDA DE CARROS    ");
        System.out.println("------------------------------------------\n");

        for (Thread e : threads) {
            e.start();
        }

        latch.await();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("===========================================");
        System.out.println("              PÓDIO OFICIAL                ");
        System.out.println("===========================================");

        for (String resultado : podio.getResultadosPodio()) {
            System.out.println(resultado);
        }

    }
}
