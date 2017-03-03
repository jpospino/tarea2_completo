/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea2.Controllers;

import edu.uniandes.ecos.tarea2.Common.DTO.Folder;
import edu.uniandes.ecos.tarea2.Common.Interfaces.Views.IApp;
import edu.uniandes.ecos.tarea2.Models.ArchivoModel;
import edu.uniandes.ecos.tarea2.Models.FolderModel;
import java.io.IOException;

/**
* <h1>ContadorLineaController</h1>
* Controllador de la vista ContadorLinea
* Encargado de conectar la vista con el modelo
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-02-20
 */
public class ContadorLineaController 
{
    private IApp iApp = null;
    private FolderModel folderModel = null;
    private ArchivoModel archivoModel = null;
    
    /**
     * Contructor por defecto. Tiene ocultamiento privado con 
     * el fin de ocultarlo y no permitir utilizarlo en instaciaciones
     * futuras.
     */
    private ContadorLineaController() 
    {  
    }
    
    /**
     * Constructor. Permite hacer instancia de la clases solo si se le inyecta
     * un objeto de la interfaz IApp
     * @param vista del controlador
     */
    public ContadorLineaController(IApp iApp)
    {
        this.iApp = iApp;
        folderModel = new FolderModel();
        archivoModel = new ArchivoModel();
    }
    
    /**
     * Método para el calculo de las líneas. Inicialmente se extraen
     * las carpetas y subcarpetas en donde está repartido el código
     * por último se buscan en cada una de ellas los archivos que 
     * la conforman para buscar los arhcivos de extensión JAVA.
     * @throws IOException 
     */
    public void ContarLineas() 
            throws IOException
    {
        /**
         * se consultan todos las carpetas y subcarpetas de la solución
        */
        Folder folder = folderModel.getFolder(iApp.getPathFolder());
        Folder folderConsulta = folder;
        
        /**
         * Se recorren carpetas y subcarpetas en búsqueda de archvios cuya
         * extensión sea JAVA.
         */
        while(folderConsulta != null)
        {
            folderConsulta.setArchivo(archivoModel.getArchivo(folderConsulta.getPath()));
            folderConsulta = folderConsulta.getSiguiente();
        }
        
        /**
         * se llena la información de la vista.
         */
        this.iApp.setFolder(folder);
    }
}
