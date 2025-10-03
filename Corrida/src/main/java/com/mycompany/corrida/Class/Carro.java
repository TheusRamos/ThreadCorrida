/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.corrida.Class;

import com.mycompany.corrida.Interfaces.IsRunner;

/**
 *
 * @author alunos
 */
public class Carro implements IsRunner, Runnable {

    private String nome;
    private double distanciaTotalCorrida;
    private double distanciaPercorrida;
    private long tempo = 0;

    public Carro(String nome, double distanciaTotalCorrida){
        this.nome = nome;
        this.distanciaTotalCorrida = distanciaTotalCorrida;
    }
    
    @Override
    public synchronized void run() {
        this.tempo = System.currentTimeMillis();
        try {
            while(distanciaPercorrida != distanciaTotalCorrida){
                distanciaPercorrida += (int)(Math.random() * 6);
                Thread.sleep((long) (Math.random() * 1000));
                if(distanciaPercorrida >= distanciaTotalCorrida){
                    distanciaPercorrida = distanciaTotalCorrida;
                }
                System.out.println(this.nome + ": " + distanciaPercorrida + "m");
                Thread.sleep(5000);
                
                
                
            }
            System.out.println("Passou a linha de chegada em " + tempo/1000 + " segundos!");
           
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getDistanciaTotalCorrida() {
        return distanciaTotalCorrida;
    }

    public synchronized double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }
    
    
    
}
