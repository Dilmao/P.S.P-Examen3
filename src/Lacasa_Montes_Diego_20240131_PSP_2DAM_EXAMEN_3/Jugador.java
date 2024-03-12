package Lacasa_Montes_Diego_20240131_PSP_2DAM_EXAMEN_3;

class Jugador implements Runnable {
    private final Buzon a_Buzon;
    private final String a_Jugador;
    public Jugador(Buzon p_Buzon, String p_Jugador) {
        this.a_Buzon = p_Buzon;
        this.a_Jugador = p_Jugador;
    }

    public void run() {
        // Variables
        int l_Tirada = 0;

        // Bucle infinito
        while (true) {
            try {
                a_Buzon.a_SemaforoJugadores.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Se le da un valor aleatorio del 1 al 100 a 'l_Tirada'
            l_Tirada = (int) Math.floor(Math.random() * 100 + 1);

            // Se imprime el jugador + el valor aleatorio
            System.out.println(a_Jugador + ": " + l_Tirada);

            // Se envia el jugador y la tirada al buzon
            a_Buzon.a_Jugador = a_Jugador;
            a_Buzon.a_Tirada = l_Tirada;

            a_Buzon.a_SemaforoBanca.release(1);
        }
    }   // run()
}   //Jugador()