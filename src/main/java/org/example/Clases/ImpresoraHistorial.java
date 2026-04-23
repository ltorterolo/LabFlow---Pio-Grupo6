package org.example.Clases;

import java.io.*;

public class ImpresoraHistorial {
    
    public static void imprimir(String texto){
        try (BufferedWriter br = new BufferedWriter(new FileWriter("src\\main\\resources\\historialExperimentos.txt", true))) 
        {
        br.write(texto);
        br.newLine(); // Agrega un salto de línea dependiente del sistema
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

}
