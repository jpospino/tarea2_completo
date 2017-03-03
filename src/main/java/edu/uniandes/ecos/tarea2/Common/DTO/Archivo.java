/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea2.Common.DTO;

/**
* <h1>Archivo</h1>
* Clase contenedora de la información de los archivos 
* encontrados en cada uno de los directorios de la solu-
* ción que compone el proyecto o programa.
* 
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-02-20
*/
public class Archivo 
{
    private String path;
    private String nombreArchivo;
    private int numeroComponentes;
    private int numeroLOC;
    private Archivo archivoSiguiente;
    private String definicionClase;
    
    /**
     * Contructor de la clase
     */
    public Archivo()
    {
        this.archivoSiguiente = null;
    }

    /**
     * Método get del parametro path
     * @return el directorio donde está ubicado el archivo
     */
    public String getPath() 
    {
        return path;
    }

    /**
     * Método set del directorio donde se ubica el archivo
     * @param path directorio del archivo
     */
    public void setPath(String path) 
    {
        this.path = path;
    }

    /**
     * Método get del nombre y extensión del archivo
     * @return nombre del archivo y su extensión
     */
    public String getNombreArchivo() 
    {
        return nombreArchivo;
    }

    /**
     * Método set del nombre y la extensión del archivo.
     * @param nombreArchivo nombre y extensión del archivo.
     */
    public void setNombreArchivo(String nombreArchivo) 
    {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * Método get del número de componentes que conforman la clase
     * @return número de componentes que contiene la clase
     */
    public int getNumeroComponentes() 
    {
        return numeroComponentes;
    }

    /**
     * Método set del número de componentes de la clase.
     * @param numeroComponentes número de componentes de la clase
     */
    public void setNumeroComponentes(int numeroComponentes) 
    {
        this.numeroComponentes = numeroComponentes;
    }

    /**
     * Método get del número de lineas de código de la clase
     * @return número de líneas de código de la clase.
     */
    public int getNumeroLOC() 
    {
        return numeroLOC;
    }

    /**
     * Método set del número de líneas de código que tiene la clase.
     * @param numeroLOC número de líneas de código que tiene la clase
     */
    public void setNumeroLOC(int numeroLOC) 
    {
        this.numeroLOC = numeroLOC;
    }

    /**
     * Método get del sigiente archivo de la cadena de archivos
     * @return arhivo sigueinte en la cadena
     */
    public Archivo getArchivoSiguiente() 
    {
        return archivoSiguiente;
    }

    /**
     * Método set del archivo siguiente en la cadena
     * @param archivoSiguiente archivo siguiente de la cadena de archivos
     */
    public void setArchivoSiguiente(Archivo archivoSiguiente) 
    {
        this.archivoSiguiente = archivoSiguiente;
    }

    /**
     * Método get de la definición de la clase
     * @return definición de la clase
     */
    public String getDefinicionClase() 
    {
        return definicionClase;
    }

    /**
     * Método set de la definición de la clase
     * @param definicionClase definición de la clase
     */
    public void setDefinicionClase(String definicionClase) 
    {
        this.definicionClase = definicionClase;
    }
}
