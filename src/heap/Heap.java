
package heap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Heap {

    public static void main(String[] args) {
        List<Integer> numbersCien = new ArrayList<>();
        List<Integer> numbersMil = new ArrayList<>();
        List<Integer> numbersDiezMil = new ArrayList<>();

        // Rutas relativas de los tres archivos
        String filePath1 = "./src/heap/DataCien.txt";
        String filePath2 = "./src/heap/DataMil.txt";
        String filePath3 = "./src/heap/DataDiezMil.txt";

        // -----------------LECTURA DE LOS CIEN DATOS-----------------------
        try {
            File file = new File(filePath1);
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Leer el archivo línea por línea
            String line;
            while ((line = br.readLine()) != null) {
                // Convierte la línea a número y añádelo a la lista
                int numberCien = Integer.parseInt(line);
                // Agregar cada línea al ArrayList
                numbersCien.add(numberCien);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a número: " + e.getMessage());
        }

        // Convertir la lista con los CIEN DATOS a un arreglo de enteros
        int[] numbersArrayCien = new int[numbersCien.size()];
        for (int i = 0; i < numbersCien.size(); i++) {
            numbersArrayCien[i] = numbersCien.get(i);
        }
        // -----------------LECTURA DE LOS MIL DATOS-----------------------
        try {
            File file = new File(filePath2);
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Leer el archivo línea por línea
            String line;
            while ((line = br.readLine()) != null) {
                // Convierte la línea a número y añádelo a la lista
                int numberMil = Integer.parseInt(line);
                // Agregar cada línea al ArrayList
                numbersMil.add(numberMil);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a número: " + e.getMessage());
        }

        // Convertir la lista de los MIL DATOS a un arreglo de enteros
        int[] numbersArrayMil = new int[numbersMil.size()];
        for (int i = 0; i < numbersMil.size(); i++) {
            numbersArrayMil[i] = numbersMil.get(i);
        }

        // -----------------LECTURA DE LOS DIEZ MIL DATOS-----------------------
        try {
            File file = new File(filePath3);
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Leer el archivo línea por línea
            String line;
            while ((line = br.readLine()) != null) {
                // Convierte la línea a número y añádelo a la lista
                int numberDiezMil = Integer.parseInt(line);
                // Agregar cada línea al ArrayList
                numbersDiezMil.add(numberDiezMil);
            }

            br.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a número: " + e.getMessage());
        }

        // Convertir la lista de los DIEZ MIL DATOS a un arreglo de enteros
        int[] numbersArrayDiezMil = new int[numbersDiezMil.size()];
        for (int i = 0; i < numbersDiezMil.size(); i++) {
            numbersArrayDiezMil[i] = numbersDiezMil.get(i);
        }

        // Ejecucion del ordenamiento por insercion
        // insercion(numbersArrayMil);
        int aprueba[] = { 1, 8, 2, 5, 7, 9, 3, 4, 6 };
        heap(numbersArrayCien);
    }

    // Este ordenamiento funciona a través del uso de un grafo binario completo

    public static void heap(int aprueba[]) {
        int n = aprueba.length;
    
        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(aprueba, n, i);
    
        // Extraer un elemento del montículo uno por uno
        for (int i = n - 1; i >= 0; i--) {
            // Mover el nodo raíz actual al final
            int temp = aprueba[0];
            aprueba[0] = aprueba[i];
            aprueba[i] = temp;
    
            // Llamar a max heapify en el montículo reducido
            heapify(aprueba, i, 0);
        }
    
        System.out.println("El arreglo ordenado por monticulo(heap) es : " + "\n");
        for (int k = 0; k < aprueba.length; k++) {
            System.out.print(aprueba[k] + " ");
        }
    }
    
    // Para hacer el montículo de un subarreglo de aprueba con nodo i
    static void heapify(int aprueba[], int n, int i) {
        int mayor = i; // Inicializar el mayor como raíz
        int izq = 2 * i + 1; // izquierda = 2*i + 1
        int der = 2 * i + 2; // derecha = 2*i + 2
    
        // Si el hijo izquierdo es mayor que la raíz
        if (izq < n && aprueba[izq] > aprueba[mayor])
            mayor = izq;
    
        // Si el hijo derecho es mayor que el mayor hasta ahora
        if (der < n && aprueba[der] > aprueba[mayor])
            mayor = der;
    
        // Si el mayor no es la raíz
        if (mayor != i) {
            int intercambiar = aprueba[i];
            aprueba[i] = aprueba[mayor];
            aprueba[mayor] = intercambiar;
    
            // Recursivamente hacer el montículo del subarreglo afectado
            heapify(aprueba, n, mayor);
        }
    }
    }
    

