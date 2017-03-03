package edu.uniandes.ecos.tarea2.app;

import edu.uniandes.ecos.tarea2.Common.DTO.Archivo;
import edu.uniandes.ecos.tarea2.Common.DTO.Folder;
import edu.uniandes.ecos.tarea2.Common.Interfaces.Views.IApp;
import edu.uniandes.ecos.tarea2.Controllers.ContadorLineaController;
import java.io.IOException;
import java.util.Scanner;

/**
* <h1>App</h1>
* vista de usuario y contenedora del m�todo main 
* de la soluci�n.
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-02-20
 */
public class App 
        implements IApp
{
    private String pathFolder;
    private Folder folder;
    
    /**
     * M�todo set del folder principal
     * @param folder  principal
     */
    public void setFolder(Folder folder)
    {
        this.folder = folder;
    }
    
    /**
     * M�todo get del folder principal
     * @return folder principal
     */
    public Folder getFolder()
    {
        return this.folder;
    }
    
    /**
     * M�todo set de la ruta del folder del programa
     * @param ruta del programa
     */
    public void setPathFolder(String pathFolader)
    {
        this.pathFolder = pathFolader;
    }
    
    /**
     * M�todo get de la ubicaci�n del programa
     * @return ubicaci�n del programa
     */
    public String getPathFolder()
    {
        return this.pathFolder;
    }
    
    /**
     * Consstructor por defecto de la vista
     */
    private App() 
    {
    }
    
    /**
     * Sobrecarga del constructor de la case inicializando l ubicaci�n de la 
     * carpeta principal del proyecto
     * @param pathFolder ubicaci�n de la carpeta principal del proyecto
     */
    public App(String pathFolder)
    {
        this.pathFolder = pathFolder;
    }
    
    /**
     * M�todo para el conteo de las l�neas de c�digo de una carpeta.
     * @throws IOException error en la lectura del archivo.
     */
    public void ContarLineas() 
            throws IOException
    {
        ContadorLineaController contadorLineaController = new ContadorLineaController(this);
        contadorLineaController.ContarLineas();
    }
   
    /**
     * procedimiento proincipal del programa
     * @param args argumentos de ejecuci�n.
     * @throws IOException 
     */
    public static void main( String[] args ) 
            throws IOException
    {
        System.out.println("Ingrese la ruta del proyecto:");
        Scanner scanInput = new Scanner(System.in);
        String input = scanInput.nextLine();
        scanInput.close();
        
        String pathFolder = (input.length()== 0)? System.getProperty("user.dir") : input;
        
        App app = new App(pathFolder);
        app.ContarLineas();
        
        Folder folderImprimir = app.getFolder();
        
        String stringImprimir = padRight("Clase", 70);
        stringImprimir += padRight("CantidadComponenter", 23);
        stringImprimir += padRight("CantidadLOC", 23);
        System.out.println(stringImprimir);
        while(folderImprimir != null)
        {
            if(folderImprimir.getArchivo() != null)
            {
                Archivo archivoImprimir = folderImprimir.getArchivo();
                while(archivoImprimir != null)
                {
                    stringImprimir = padRight(archivoImprimir.getDefinicionClase(), 70);
                    stringImprimir += padRight(Integer.toString(archivoImprimir.getNumeroComponentes()), 23);
                    stringImprimir += padRight(Integer.toString(archivoImprimir.getNumeroLOC()), 23);
                    System.out.println(stringImprimir);    
                    archivoImprimir = archivoImprimir.getArchivoSiguiente();
                }
            }
            
            folderImprimir = folderImprimir.getSiguiente();
        }
    }
    
    /**
     * Retorna cadena de caracteres tabulado
     * @param s cadena de caracteres a tabular
     * @param n espacios a tabular
     * @return cadena de caracteres tabulado
     */
    public static String padRight(String s, int n) 
    {
        return String.format("%1$-" + n + "s", s);  
    }

}
