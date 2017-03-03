/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea2.Models;

import edu.uniandes.ecos.tarea2.Common.DTO.Folder;
import java.io.File;

/**
* <h1>FolderModel</h1>
* Clase encargada de hacer operaciones de interacci�n
* directa las carpetas que conforman la soluci�n.
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-02-20
 */
public class FolderModel 
{
    /**
     * obtiene una lista en lazada de las carpetas que est�n contenidas dentro 
     * de otra carpeta padre.
     * @param path ubicaci�n de la carpeta padre
     * @return lista enlazada de carpetas que lo conforman
     */
    public Folder getFolder(String path)
    {
        Folder folderPadre = new Folder();
        folderPadre.setPath(path);
        return this.getFolder(folderPadre);
    }
    
    /**
     * M�todo que sirve como recursividad para extraer carpetas y subcarpetas de
     * una ubicaci�n espec�fica
     * @param folderPadre ubicaci�n del folder padre
     * @return lista en lazadas que conforman la soluci�n
     */
    private Folder getFolder(Folder folderPadre)
    {
        if(folderPadre.getSiguiente() == null)
        {
            File directorio = new File(folderPadre.getPath());
            File[] listaFolder = directorio.listFiles();
            for (int i = 0; i < listaFolder.length; i++) 
            {
                if (listaFolder[i].isDirectory() && !listaFolder[i].isHidden()) 
                {
                    Folder folderSiguiente  = new Folder();
                    folderSiguiente.setPath(folderPadre.getPath() + "\\" + listaFolder[i].getName());
                    
                    if(folderPadre.getSiguiente() == null)
                    {
                        folderPadre.setSiguiente(folderSiguiente);
                    }
                    else
                    {
                        Folder iteracion = folderPadre.getSiguiente();
                        while(iteracion.getSiguiente() != null)
                        {
                            iteracion = iteracion.getSiguiente();
                        }
                        
                        iteracion.setSiguiente(folderSiguiente);
                    }
                    
                    getFolder(folderSiguiente); 
                }
            }
        }
        else
        {
            getFolder(folderPadre.getSiguiente());
        }
        
        return folderPadre;
    }
}
