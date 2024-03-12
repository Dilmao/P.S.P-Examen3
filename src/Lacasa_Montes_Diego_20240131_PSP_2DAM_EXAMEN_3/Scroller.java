package Lacasa_Montes_Diego_20240131_PSP_2DAM_EXAMEN_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scroller {
    // TODO problemas:
    //  la banca no comprueba que un numero ya haya sido seleccionado
    //  los jugadores siguen el mismo orden, este es aleatorio al inicio
    public static final int NUM_HILOS = 5;

    public static void main(String[] args) {
        ExecutorService l_Executor = Executors.newFixedThreadPool(NUM_HILOS);
        Buzon l_Buzon = new Buzon();

        Banca l_Banca = new Banca(l_Buzon);
        Jugador l_Jugador1 = new Jugador(l_Buzon, "J1");
        Jugador l_Jugador2 = new Jugador(l_Buzon, "J2");
        Jugador l_Jugador3 = new Jugador(l_Buzon, "J3");
        Jugador l_Jugador4 = new Jugador(l_Buzon, "J4");

        l_Executor.submit(l_Banca);
        l_Executor.submit(l_Jugador1);
        l_Executor.submit(l_Jugador2);
        l_Executor.submit(l_Jugador3);
        l_Executor.submit(l_Jugador4);
    }   // main()
}   // Scroller()