/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.time.Duration;
import java.time.Instant;

/**
* UNIDAD 3: Optimización (hacer mas eficiente el código
* en términos de recuros --mas rápido y con menos recursos )
* @author Gualuma baby
* 
* Medir el tiempo que tarda la ejecución código cuando
* todo el código forma parte de la misma rutina
* Medir el tiempo que tarda en ejecución el mismo código
* pero llamando una rutina
* Objetivo, descubrir si tendría sentido optimizar el código
* eliminando llamadas a rutinas cuando se a posible
*/
public class Principal {
  //  final static int TOPE=1234000000;
      final static long TOPE=40000;
    public static void main(String[] args) {

   //4.- INVOCANDO A FUNCION POTENCIA RECURSIVA 
      Instant start4 = Instant.now();
            double sum4=0;
            for(int i=0; i<=TOPE;i++) {
                  double pot4 = potenciaRecursiva( ((double)i), i);
                  sum4+=pot4;
            }
     Instant end4 = Instant.now();
     Duration timeElapsed4 = Duration.between(start4, end4);
     System.out.println("Tiempo 4 funcion recursiva: "+
        timeElapsed4.toMillis()+ " milisegundos" + " res:"+sum4);  

   //5.- INVOCANDO A FUNCION POTENCIA  CICLO 
      Instant start5 = Instant.now();
            double sum5=0;
            for(int i=0; i<=TOPE;i++) {
                  double pot5 = potenciaCiclo( ((double)i), i);
                  sum5+=pot5;
            }
     Instant end5 = Instant.now();
     Duration timeElapsed5 = Duration.between(start5, end5);
     System.out.println("Tiempo 5 funcion ciclica: "+
       timeElapsed5.toMillis()+ " milisegundos"+ " res:"+sum5); 
    } // del main



    static double potenciaRecursiva(double base, long exp){
        if (exp==0) return  1.0;
        else return base * potenciaRecursiva(base, (exp-1) );
    }

    static double potenciaCiclo(double base, long exp){
        double pot=1;
        for (long i=exp; i>0; i--){
            pot=pot*base;
        }
        return pot;
    }

}