import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Operacion {
    public static void setImprimePromedios() throws FileNotFoundException {
        // Creamos el obj. Scanner que recibe el archivo .csv
        Scanner entrada = new Scanner(new File("tabula-FWC_2018_Squadlists_4.csv") );

        // Creamos e inicializamos las var. a utilizar: promedioHeight, promedioGoals, sumaHeight, sumaGoals y numJugadores, valen 0. los 2 primeros no hace falta inici.
        double promedioHeight;
        double promedioGoals;
        double sumaHeight = 0;
        double sumaGoals = 0;
        int numJugadores = 0;

        // Intentamos leer el archivo
        try {
            // Este while se ejecutara mientras queden caracteres por leer (usamos Scanner.hashNext() )
            while (entrada.hasNext()){
                // Almacenamos la primera linea del archivo
                String linea = entrada.nextLine();
                String [] cadenaDividida = linea.split("\\|");

                // La primera linea almacena los caracteres de la cadena y los separa segun el caracter |
                ArrayList<String> lineaDivididida = new ArrayList<>(Arrays.asList(cadenaDividida));

                // Extrae la posicion 9 y la suma a la var. sumaHeight
                sumaHeight += Double.parseDouble( lineaDivididida.get(9) );

                // Extrae la posicion 11 y la suma a la var. sumaGoals
                sumaGoals += Double.parseDouble( lineaDivididida.get(11) );

                // Al final de while aumenta en 1 el contador numJugadores
                numJugadores++;

            }

            // Calcula el promedio usando ambas var. promedioHeight, promedioGoals y dividiendolas entre el num
            promedioGoals = getPromedio(sumaGoals, numJugadores);
            promedioHeight = getPromedio(sumaHeight, numJugadores);

            System.out.println( "Las suma de Golas es de " +  sumaGoals + " y su promedio es de " + promedioGoals + "\n" +
                                "La suma de Height es de " + sumaHeight + " y su promedio es de " + promedioHeight);

        }catch(Exception e) {
            System.err.println("Error al leer del archivo.");
            e.printStackTrace();
            System.exit(1);
        }

    }

    public static double getPromedio(double sumaTotal, double numElementos){
        return sumaTotal / numElementos;
    }
}
