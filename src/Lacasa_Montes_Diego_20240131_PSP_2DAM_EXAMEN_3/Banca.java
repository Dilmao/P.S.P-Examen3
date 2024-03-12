package Lacasa_Montes_Diego_20240131_PSP_2DAM_EXAMEN_3;

import java.util.HashMap;
import java.util.Map;

class Banca implements Runnable {
    private final Buzon a_Buzon;
    public Banca(Buzon p_Buzon) {
        this.a_Buzon = p_Buzon;
    }

    public void run() {
        // Variables
        int l_Contador = 0;
        int l_NumTiradas = 0;
        int l_NumAleatorio = 0;
        Map<Integer, String> l_mapaBanca = HashMap.newHashMap(10);

        // Bucle para generar la lista de la banca
        for (l_Contador = 0; l_Contador < 10; l_Contador++) {
            l_NumAleatorio = (int) Math.floor(Math.random() * 100 + 1);
            l_mapaBanca.put(l_NumAleatorio, null);
        }

        // Bucle mientras aún queden números por descubrir
        while (l_mapaBanca.containsValue(null)) {
            try {
                a_Buzon.a_SemaforoBanca.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            l_NumTiradas++;

            // Si la tirada del jugador coindice con un numero en el mapa y no hay un ganador, se ejecuta el siguiente codigo
            if (l_mapaBanca.containsKey(a_Buzon.a_Tirada)) { // si añado '&& l_mapaBanca.get(a_Buzon.a_Tirada).equals(null)' peta
                // Se cambia el mapa para añadir al jugador que ha acertado
                l_mapaBanca.put(a_Buzon.a_Tirada, a_Buzon.a_Jugador);

                // Se imprime la lista de números y el numero de tiradas
                System.out.println(l_mapaBanca);
                System.out.println("T = " + l_NumTiradas);
            }

            // Se asegura que el juego no haya terminado antes de que un jugador tire
            if (l_mapaBanca.containsValue(null)) {
                a_Buzon.a_SemaforoJugadores.release(1);
            }
        }
    }
}
