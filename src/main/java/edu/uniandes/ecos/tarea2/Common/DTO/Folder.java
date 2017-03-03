/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea2.Common.DTO;

/**
* <h1>Folder</h1>
* Clase contenedora de la informaci�n de los carpetas y 
* subcarpetas que conforman el proyecto o programa.
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-02-20
 */
public class Folder 
{
    private String path;
    private Folder Siguiente;
    private Archivo archivo;
    
    public Folder()
    {
        this.Siguiente = null;
    }
    
    /**
     * M�todo get de la ubicaci�n de la carpeta
     * @return ubicaci�n de la carpeta
     */
    public String getPath() 
    {
        return path;
    }

    /**
     * M�todo set de la ubicaci�n de la carpeta
     * @param path ubicaci�n de la carpeta
     */
    public void setPath(String path) 
    {
        this.path = path;
    }
    
    /**
     * M�todo get de la siguiente carpeta de la lista
     * @return siguiente carpeta
     */
    public Folder getSiguiente() 
    {
        return Siguiente;
    }

    /**
     * M�todo set de la siguiente carpeta de la lista
     * @param Siguiente carpeta siguiente
     */
    public void setSiguiente(Folder Siguiente) 
    {
        this.Siguiente = Siguiente;
    }

    /**
     * M�todo get de la lista enlazada de archivos que componen la carpeta
     * @return archivos que contiene la carpeta
     */
    public Archivo getArchivo() 
    {
        return archivo;
    }

    /**
     * M�todo set de la lista enlazada de archivos que componen la carpeta
     * 
     * @param archivo archivos que conforman la carpeta
     */
    public void setArchivo(Archivo archivo) 
    {
        this.archivo = archivo;
    }
}
