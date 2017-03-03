/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea2.Models;

import edu.uniandes.ecos.tarea2.Common.DTO.Archivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;

/**
* <h1>ArchivoModel</h1>
* Clase encargada de hacer operaciones de interacción
* directa con los archivos de extensión JAVA del programa.
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-02-20
 */
public class ArchivoModel 
{
    /**
     * Dado la ubicación de un directorio retorna cadena de archivos
     * donde están todos los archivos JAVA que la componen.
     * 
     * @param path directorio donde buscar
     * @return cadena de archivos que están dentro del directorio
     * @throws IOException excepción que no se ha encontrado nada o problemas
     * en la lectura del archivo
     */
    public Archivo getArchivo(String path) 
            throws IOException
    {
        Archivo archivo = null;
        
        File directorio = new File(path);
        File[] listaArchivos = directorio.listFiles();
        
        for (int i = 0; i < listaArchivos.length; i++) 
        {
            if (listaArchivos[i].isFile() && !listaArchivos[i].isHidden())                        
            {   
                
                if(listaArchivos[i].getName().substring(listaArchivos[i].getName().lastIndexOf(".") + 1).toUpperCase().equals("JAVA"))
                {
                    int cantidadComponentes = 0;
                    int cantidadLineas = 0;
                    
                    Archivo archivoInsert = new Archivo();
                    archivoInsert.setPath(path);
                    archivoInsert.setNombreArchivo(listaArchivos[i].getName());
                    this.getContenidoArchivo(path + "\\" + archivoInsert.getNombreArchivo(), archivoInsert);
                    
                    if(null == archivo)
                        archivo = archivoInsert;
                    else
                    {
                        Archivo archivoPadre = archivo;
                        while(archivoPadre.getArchivoSiguiente() != null)
                            archivoPadre = archivoPadre.getArchivoSiguiente();
                        
                        archivoPadre.setArchivoSiguiente(archivoInsert);
                    }
                }
            }
        }
        return archivo;
    }
    
    /**
     * actualiza la información de la definición de la clase que conforma el archivo,
     * número de componentes que la conforma y el número de líneas que lo 
     * componen.
     * 
     * @param path ubicación del archivo
     * @param archivoCalcular nombre y extensión del archivo en mensión.
     * @throws FileNotFoundException cuando no se encuentra el archivo que se está buscando
     * @throws IOException cuando no esposible leer el archivo
     */
    private void getContenidoArchivo(String path, Archivo archivoCalcular) 
            throws FileNotFoundException, IOException
    {
        int numeroComponentes = 0;
        int numeroLineas = 0;
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        String line = null;
        Pattern patronMetodos = Pattern.compile("(public|private|protected|static|final|native|synchronized|abstract|transient).*.*(\\))");
        Pattern patronConstructor = Pattern.compile("(public|private|protected|static|final|native|synchronized|abstract|transient).*?(class|interface).*");
        Pattern patronNoContar = Pattern.compile("^[(\\/)|(\\*)|\\{|\\}].*");
        String definicionClase = "";
        
        try
        {
            while((line = bufferedReader.readLine()) != null) 
            {
                if(line.length() > 0)
                {
                    line = line.trim();

                    if(patronMetodos.matcher(line).matches())
                        numeroComponentes++;


                    if(patronConstructor.matcher(line).matches())
                        definicionClase = line;

                    if(!patronNoContar.matcher(line).matches())
                        numeroLineas++;
                }     
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            
            archivoCalcular.setNumeroComponentes(numeroComponentes);
            archivoCalcular.setDefinicionClase(definicionClase);
            archivoCalcular.setNumeroLOC(numeroLineas);
        }
        catch(Exception exc)
        {
            bufferedReader.close();
            System.out.println("Ocurrió un error en la lectura del archivo");
        }
    }
}
