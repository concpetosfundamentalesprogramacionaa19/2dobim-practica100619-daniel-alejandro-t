import java.io.FileNotFoundException;

public class Main {
/*
Relizar un programa que permita leer e imprimir el promedio
Goals
y
Height

del conjunto de datos

Las cabeceras de cada columna son:

# Posicion
0       1               2           3       4       5       6    7    8     9     10    11
Numero|FIFADisplayName|Country|LastName|FirstName|ShirtName|DOB|POS|Club|Height|Caps|Goals
 */
    public static void main(String[] args) {
        try {
            Operacion.setImprimePromedios();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
