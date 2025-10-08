package com.mycompany.corrida.Class;

import com.mycompany.corrida.Interfaces.IsRunner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author alunos
 */
public class Carro implements IsRunner, Runnable {

    private String nome;
    private double distanciaTotalCorrida;
    private double distanciaPercorrida;
    private final long inicioCorrida;

    private final Podio podio;
    private final CountDownLatch latch;
    
    private long tempo = 3000 + (int) Math.random() * 250;
    private boolean pitstop = false;

    public Carro(String nome, double distanciaTotalCorrida, Podio podio, CountDownLatch latch) {
        this.nome = nome;
        this.distanciaTotalCorrida = distanciaTotalCorrida;
        this.podio = podio;
        this.latch = latch;
        this.inicioCorrida = System.currentTimeMillis();
    }

    @Override
    public void run() {
        try {
            while (distanciaPercorrida < distanciaTotalCorrida) {

                if (podio.getResultadosPodio().size() >= 3) {
                    return;
                }

                if (distanciaPercorrida >= distanciaTotalCorrida / 2 && pitstop == false) {
                    
                    System.out.println("O carro " + this.nome + " entrou no PitStop.");
                    Thread.currentThread().sleep((tempo));
                    
                    System.out.println("Tempo de PitStop do carro" + this.nome + " foi de " + tempo);
                    this.pitstop = true;

                }

                distanciaPercorrida += (int) (Math.random() * 6);
                Thread.sleep((long) (Math.random() * 100));
                long tempoFinal = System.currentTimeMillis() - this.inicioCorrida;
                System.out.println(this.nome + ": " + String.format("%.0f", distanciaPercorrida) + "m" + " com um tempo de " +String.format("%.3f", tempoFinal/1000.0) + " segundos");

            }

            long tempoFinal = System.currentTimeMillis() - this.inicioCorrida;

            podio.registrarVencedor(this.nome, tempoFinal);

            latch.countDown();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getDistanciaTotalCorrida() {
        return distanciaTotalCorrida;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

}
