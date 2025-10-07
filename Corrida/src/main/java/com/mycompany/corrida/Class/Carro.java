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
                    System.out.println(this.nome + " PAROU. A corrida já tem 3 vencedores.");
                    return;
                }

                if(distanciaPercorrida >= distanciaTotalCorrida / 2 && pitstop == false){
                    System.out.println("O carro " + this.nome + " entrou no PitStop.");
                    Thread.currentThread().sleep(3000);
                    this.pitstop = true;
                   
                } 
                
                
                distanciaPercorrida += (int) (Math.random() * 6);
                Thread.sleep((long) (Math.random() * 100)); 

                System.out.println(this.nome + ": " + String.format("%.0f", distanciaPercorrida) + "m");

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
