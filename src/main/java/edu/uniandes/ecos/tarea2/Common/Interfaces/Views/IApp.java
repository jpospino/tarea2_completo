/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea2.Common.Interfaces.Views;

import edu.uniandes.ecos.tarea2.Common.DTO.Folder;

/**
* <h1>IApp</h1>
* Interfaz de la vista del programa de conte de líneas
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-02-20
*/
public interface IApp 
{
    /**
     * Método set del folder principal
     * @param folder  principal
     */
    void setFolder(Folder folder);
    
    /**
     * Método get del folder principal
     * @return folder principal
     */
    Folder getFolder();
    
    /**
     * Método set de la ruta del folder del programa
     * @param ruta del programa
     */
    void setPathFolder(String pathFolader);
    
    /**
     * Método get de la ubicación del programa
     * @return ubicación del programa
     */
    String getPathFolder();
}
