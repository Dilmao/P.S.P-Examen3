package Lacasa_Montes_Diego_20240131_PSP_2DAM_EXAMEN_3;

import java.util.concurrent.Semaphore;
class Buzon {
    // COMENTARIO.
    public static final int TOKENS_BANCA = 0;
    public static final int TOKENS_JUGADORES = 1;

    // COMENTARIO.
    int a_Tirada = 0;
    String a_Jugador = "";

    // COMENTARIO.
    final Semaphore a_SemaforoBanca = new Semaphore(TOKENS_BANCA);
    final Semaphore a_SemaforoJugadores = new Semaphore(TOKENS_JUGADORES, true);
}
