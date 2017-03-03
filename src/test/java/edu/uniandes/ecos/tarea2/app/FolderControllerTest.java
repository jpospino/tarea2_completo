/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea2.app;


import edu.uniandes.ecos.tarea2.Common.DTO.Folder;
import edu.uniandes.ecos.tarea2.Models.FolderModel;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author JuanPablo
 */
public class FolderControllerTest 
        extends TestCase {
    
    public FolderControllerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    /**
     * Validación del método para obetener los folderes
     */
    public void testFolderModel() {
        try
        {
            FolderModel folderModel = new FolderModel();
            Folder resultado = folderModel.getFolder("E:\\pspdata");
            
            /**
             * while(resultado !=null)
             * {
             * System.out.println("Folder: " + resultado.getPath());
             * resultado = resultado.getSiguiente();
             * }
            */
        
            assertNotNull(resultado);
        }
        catch(Exception exc)
        {
            assertTrue(false);
        }
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}
