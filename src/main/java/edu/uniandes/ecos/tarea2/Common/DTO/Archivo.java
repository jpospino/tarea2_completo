/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea2.Common.DTO;

/**
* <h1>Archivo</h1>
* Clase contenedora de la informaci�n de los archivos 
* encontrados en cada uno de los directorios de la solu-
* ci�n que compone el proyecto o programa.
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
     * M�todo get del parametro path
     * @return el directorio donde est� ubicado el archivo
     */
    public String getPath() 
    {
        return path;
    }

    /**
     * M�todo set del directorio donde se ubica el archivo
     * @param path directorio del archivo
     */
    public void setPath(String path) 
    {
        this.path = path;
    }

    /**
     * M�todo get del nombre y extensi�n del archivo
     * @return nombre del archivo y su extensi�n
     */
    public String getNombreArchivo() 
    {
        return nombreArchivo;
    }

    /**
     * M�todo set del nombre y la extensi�n del archivo.
     * @param nombreArchivo nombre y extensi�n del archivo.
     */
    public void setNombreArchivo(String nombreArchivo) 
    {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * M�todo get del n�mero de componentes que conforman la clase
     * @return n�mero de componentes que contiene la clase
     */
    public int getNumeroComponentes() 
    {
        return numeroComponentes;
    }

    /**
     * M�todo set del n�mero de componentes de la clase.
     * @param numeroComponentes n�mero de componentes de la clase
     */
    public void setNumeroComponentes(int numeroComponentes) 
    {
        this.numeroComponentes = numeroComponentes;
    }

    /**
     * M�todo get del n�mero de lineas de c�digo de la clase
     * @return n�mero de l�neas de c�digo de la clase.
     */
    public int getNumeroLOC() 
    {
        return numeroLOC;
    }

    /**
     * M�todo set del n�mero de l�neas de c�digo que tiene la clase.
     * @param numeroLOC n�mero de l�neas de c�digo que tiene la clase
     */
    public void setNumeroLOC(int numeroLOC) 
    {
        this.numeroLOC = numeroLOC;
    }

    /**
     * M�todo get del sigiente archivo de la cadena de archivos
     * @return arhivo sigueinte en la cadena
     */
    public Archivo getArchivoSiguiente() 
    {
        return archivoSiguiente;
    }

    /**
     * M�todo set del archivo siguiente en la cadena
     * @param archivoSiguiente archivo siguiente de la cadena de archivos
     */
    public void setArchivoSiguiente(Archivo archivoSiguiente) 
    {
        this.archivoSiguiente = archivoSiguiente;
    }

    /**
     * M�todo get de la definici�n de la clase
     * @return definici�n de la clase
     */
    public String getDefinicionClase() 
    {
        return definicionClase;
    }

    /**
     * M�todo set de la definici�n de la clase
     * @param definicionClase definici�n de la clase
     */
    public void setDefinicionClase(String definicionClase) 
    {
        this.definicionClase = definicionClase;
    }
}
