package com.mycompany.corrida.Class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author alunos
 */
public class Podio {

   
    private final List<String> resultadosPodio = Collections.synchronizedList(new ArrayList<>());
    
  
    public synchronized void registrarVencedor(String nome, long tempoFinal) {
      
        if (resultadosPodio.size() < 3) {
            String resultado = String.format("%dº Lugar: %s em %.3f segundos", 
                                                (resultadosPodio.size() + 1), 
                                                nome, 
                                                tempoFinal / 1000.0);
            resultadosPodio.add(resultado);
            System.out.println("\n Vencedor registrado: " + resultado);
        }
    }

   
    public List<String> getResultadosPodio() {
     
        return resultadosPodio;    
    }
}
