package com.company;

import  java.io.*;

public class leerArchivo {
    private File archivo;
    private FileReader fr;
    private BufferedReader br;
    private String ruta;

    leerArchivo(String ruta) {
        this.archivo = null;
        this.fr = null;
        this.br = null;
        this.ruta = ruta;
    }

    public String returnString() {
        String finalOut = "";
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            this.archivo = new File(this.ruta);
            this.fr = new FileReader(this.archivo);
            this.br = new BufferedReader(this.fr);

            // Lectura del fichero
            String linea;

            while ((linea = br.readLine()) != null) {
                finalOut += linea;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return finalOut;
    }
}
