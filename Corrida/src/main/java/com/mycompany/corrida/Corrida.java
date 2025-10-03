/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.corrida;

import com.mycompany.corrida.Class.Carro;
import java.util.ArrayList;
import com.mycompany.corrida.Class.Factory;

/**
 *
 * @author alunos
 */
public class Corrida {
    
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        threads = Factory.NovosCarros();
        int vencedor = 0;
        
        for(Thread e : threads){
            e.start();
        }
        
        
        while(vencedor != 3){
        
        Thread.sleep(5000);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
        }
        
    }
}
