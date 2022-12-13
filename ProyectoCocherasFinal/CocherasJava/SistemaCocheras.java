/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacocheras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author MATIAS
 */
public class SistemaCocheras {
    public static  int cocheras;
    public static int monto;
    public static String tipoVehiculo,patente,fecha,hora;
    
    // ----- INICIO -> Integrante del Grupo que escbrio el CODIGO : JESICA VIOLA
    // Metodo Main para ejecutar el programa
    public static void main(String[] args) {

        String[][] ArrayCocheras = new String[1000][4];

        menuPrincipal(ArrayCocheras);

    }

    // metodo menu principal
    public static void menuPrincipal(String[][] ArrayCocheras) {

        // mostrar menu de opciones
        int opcion = 0;
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Bienvenido al sistema de gestión de cocheras\n"
                    +"------------------------------------------\n"
                    +"1. Español\n"
                    +"2. English\n"
                    +"3. Salir / Exit\n"
                    +"------------------------------------------\n"
                    +"Ingrese una opción / Choose a menu option: "));

        // leer la opcion ingresada por el usuario

        boolean opcionValida = false;
        while (!opcionValida) {
            try {
               
                if (opcion >= 1 && opcion <= 3) {
                    opcionValida = true;
                    switch (opcion) {
                        case 1:
                            int cocheras = cantidadCocherasEsp();
                            menuEspañol(cocheras, ArrayCocheras);
                            break;
                        case 2:
                            int cocheras2 = cantidadCocherasEng();
                            menuEnglish(cocheras2, ArrayCocheras);
                            break;
                        case 3:
                            mensajeDespedidaEsp();
                            break;

                        default:
                            System.out.println("Opción inválida");
                            break;

                    }
                } else {
                    // Mensaje de error
                    opcionInvalida();
                    // Volver a mostrar el menu
                    menuPrincipal(ArrayCocheras);
                }
            } catch (Exception e) {
                // Mensaje de error
                opcionInvalida();
                // Volver a mostrar el menu
                menuPrincipal(ArrayCocheras);

            }
        }

    }

    // Metodo para mostrar el menu en español
    public static void menuEspañol(int cocheras, String[][] ArrayCocheras) {

       int opcion = 0;
       
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
              opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Bienvenido al sistema de gestión de cocheras\n"
                    +"1. Ingresar vehículo\n"
                    +"2. Retirar vehículo\n"
                    +"3. Listar Cocheras Dispobibles\n"
                    +"4. Salir\n"
                    +"------------------------------------------\n"
                    +"Ingrese una opción: "));
                if (opcion >= 1 && opcion <= 4) {
                    opcionValida = true;
                    switch (opcion) {
                        case 1:
                            ingresoVehiculoEsp(cocheras, ArrayCocheras);
                        case 2:
                            buscarVehiculoEsp(cocheras, ArrayCocheras);
                        case 3:
                            mostrarCocherasDisponiblesEsp(cocheras, ArrayCocheras);
                        case 4:
                            mensajeDespedidaEsp();
                            break;

                        default:
                            System.out.println("Opción inválida");
                            // volver a mostrar el menu
                            menuEspañol(cocheras, ArrayCocheras);

                    }
                } else {
                    // Mensaje de error
                    opcionInvalida();

                    // volver a mostrar el menu
                    menuEspañol(cocheras, ArrayCocheras);
                }
            } catch (Exception e) {
                // Mensaje de error
                opcionInvalida();
                // Volver a mostrar el menu
                menuEspañol(cocheras, ArrayCocheras);

            }
        }
    }

    // Metodo para mostrar el menu en ingles
    public static void menuEnglish(int cocheras, String[][] ArrayCocheras) {
        // limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // int cantidadCocheras = cocheras;

        // menu de opciones
        int opcion = 0;
        
            
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Welcome to the parking management system\n"
                    +"1. Enter vehicle\n"
                    +"2. Remove vehicle\n"
                    +"3. List Available Parking Spaces\n"
                    +"4. Exit\n"
                    +"------------------------------------------\n"
                    +"Enter an option: "));

                if (opcion >= 1 && opcion <= 4) {
                    opcionValida = true;
                    switch (opcion) {
                        case 1:
                            ingresoVehiculoEng(cocheras, ArrayCocheras);
                        case 2:
                            buscarVehiculoEng(cocheras, ArrayCocheras);
                        case 3:
                            mostrarCocherasDisponiblesEng(cocheras, ArrayCocheras);
                        case 4:
                            mensajeDespedidaEng();
                            break;

                        default:
                            System.out.println("Invalid option");

                            // volver a mostrar el menu
                            menuEspañol(cocheras, ArrayCocheras);

                    }
                } else {
                    // Mensaje de error
                    opcionInvalidaEng();

                    // volver a mostrar el menu
                    menuEnglish(cocheras, ArrayCocheras);
                }
            } catch (Exception e) {
                // Mensaje de error
                opcionInvalidaEng();
                // Volver a mostrar el menu
                menuEnglish(cocheras, ArrayCocheras);

            }
        }
    }
    // -- FIN -> Integrante del Grupo que escbrio el CODIGO : JESICA VIOLA
    //
    //

    // ----- INICIO -> Integrante del Grupo que escbrio el CODIGO : SEBASTIAN
    // VERGUECIO
    // Metodo para ingresar vehiculos en español
    public static void ingresoVehiculoEsp(int cocheras, String[][] ArrayCocheras) {
        // Iniciar variable booleana para controlar el ingreso de vehiculos
        boolean cocheraLibre = false;
        int cocheraCarga = 0;

        // recorrer ArrayCocheras[0], verificar si es null
        for (int i = 0; i < cocheras; i++) {
            if (ArrayCocheras[i][0] == null) {

                cocheraLibre = true;
                cocheraCarga = i;
            }
        }
        
        // si cocherasLibre es true, mostrar mensaje de cochera libre
        if (cocheraLibre == true) {

            // ingresar datos en el array de cocheras disponibles
            try (Scanner scanner = new Scanner(System.in)) {
                
                
                tipoVehiculo = JOptionPane.showInputDialog("Ingrese el tipo de Vehiculo: ");
                patente = JOptionPane.showInputDialog("Ingrese la patente: ");
                fecha = JOptionPane.showInputDialog("Ingrese la Fecha Entrada: ");
                hora = JOptionPane.showInputDialog("Ingrese la Hora Entrada: ");

                // cargar datos en el array
                ArrayCocheras[cocheraCarga][0] = tipoVehiculo;
                ArrayCocheras[cocheraCarga][1] = patente;
                ArrayCocheras[cocheraCarga][2] = fecha;
                ArrayCocheras[cocheraCarga][3] = hora;               

                // terminar el ingreso de vehiculos
                int mensaje = 0;
                JOptionPane.showMessageDialog(null,"Vehículo ingresado correctamente\n"
                                                   +"\n"
                                                   +"\n"
                                                   +"Presione una tecla para continuar");

                // volver al menu principal
                menuEspañol(cocheras, ArrayCocheras);
            }

        } else {
            // si no hay cocheras libres, mostrar mensaje de error
            JOptionPane.showMessageDialog(null,"No hay cocheras disponibles!!   \n"
                                               +"\n"
                                               +"\n"
                                               +"Presione una tecla para continuar");

            // volver al menu principal
            menuEspañol(cocheras, ArrayCocheras);
        }
        menuEspañol(cocheras, ArrayCocheras);

    }

    // Metodo para ingresar vehiculos en Ingles
    public static void ingresoVehiculoEng(int cocheras, String[][] ArrayCocheras) {

        // Iniciar variable booleana para controlar el ingreso de vehiculos
        boolean cocheraLibre = false;
        int cocheraCarga = 0;

        // recorrer ArrayCocheras[0], verificar si es null
        for (int i = 0; i < cocheras; i++) {
            if (ArrayCocheras[i][0] == null) {

                cocheraLibre = true;
                cocheraCarga = i;
            }
        }
        System.out.println("Vehicle Data Entry: ");
        System.out.println("------------------------------------------");

        // si cocherasLibre es true, mostrar mensaje de cochera libre
        if (cocheraLibre == true) {

            // ingresar datos en el array de cocheras disponibles
            try (Scanner scanner = new Scanner(System.in)) {

                tipoVehiculo = JOptionPane.showInputDialog("Enter the type of vehicle: ");
                patente = JOptionPane.showInputDialog("Enter the license plate: ");
                fecha = JOptionPane.showInputDialog("Enter the Entry Date: ");
                hora = JOptionPane.showInputDialog("Enter the Entry Time: ");
                // cargar datos en el array
                ArrayCocheras[cocheraCarga][0] = tipoVehiculo;
                ArrayCocheras[cocheraCarga][1] = patente;
                ArrayCocheras[cocheraCarga][2] = fecha;
                ArrayCocheras[cocheraCarga][3] = hora;
                

                // terminar el ingreso de vehiculos
                
                JOptionPane.showMessageDialog(null,"Vehicle entered correctly\n"
                                                   +"\n"
                                                   +"\n"
                                                   +"Press any key to continue");

                // volver al menu principal
                menuEnglish(cocheras, ArrayCocheras);
            }

        } else {
            // si no hay cocheras libres, mostrar mensaje de error
            JOptionPane.showMessageDialog(null,"There are no available garages!!  \n"
                                               +"\n"
                                               +"\n"
                                               +"Press any key to continue");
            // volver al menu principal
            menuEnglish(cocheras, ArrayCocheras);
        }
        menuEnglish(cocheras, ArrayCocheras);

    }
    // -- FIN -> Integrante del Grupo que escbrio el CODIGO : SEBASTIAN VERGUECIO
    //
    //

    // ----- INICIO -> Integrante del Grupo que escbrio el CODIGO : LEILA BRITEZ
    // NEIRA
    // metodo Solicita cantidad de cocheras disponibles en español
    public static int cantidadCocherasEsp() {

         cocheras = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cocheras disponibles:  "
                                                                 + "\n"
                                                                 +"\n"));

        return cocheras;
    }

    // metodo Solicita cantidad de cocheras disponibles en Ingles
    public static int cantidadCocherasEng() {

        cocheras = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of available parking spaces: "
                                                                + "\n"
                                                                +"\n"));

        return cocheras;
    }
    // -- FIN -> Integrante del Grupo que escbrio el CODIGO : LEILA BRITEZ NEIRA
    //
    //

    // ----- INICIO -> Integrante del Grupo que escbrio el CODIGO : LEONARDO SOLAN
    // metodo para mostrar la cantidad de cocheras disponibles en Español
    public static void mostrarCocherasDisponiblesEsp(int cocheras, String[][] ArrayCocheras) {
        // imprimir la matriz de cocheras
         String imprimirJO ="";
         String imprimelibre="";
         
         for (int i = 0; i < cocheras; i++) {
             imprimelibre= "COCHERA NUMERO° __" + (i + 1) + " :   DISPONIBLE"; 
             for (int j = 0; j < ArrayCocheras[i].length; j++) {
             if (ArrayCocheras[i][j] == null) {
              JOptionPane.showMessageDialog(null,imprimelibre);
              break;

               }
             } 
         }   
        for (int i = 0; i < cocheras; i++) {
            for (int j = 0; j < ArrayCocheras[i].length; j++) {
                imprimirJO+=ArrayCocheras[i][j];
                imprimirJO +="     |      ";
            }
            imprimirJO +="\n";
 
        }
        JOptionPane.showMessageDialog(null ,"------------------------------------------\n"
                                               +"     Tipo |  Patente |  Fecha |  Hora\n "
                                               +"------------------------------------------ \n"
                                               +imprimirJO
                                               +"\n"
                                               +"\n"
                                               +"     Presione una tecla para continuar"); 


        menuEspañol(cocheras, ArrayCocheras);
    }

    // metodo para mostrar la cantidad de cocheras disponibles en Ingles
    public static void mostrarCocherasDisponiblesEng(int cocheras, String[][] ArrayCocheras) {

        // imprimir la matriz de cocheras
        
        //VARIABLES PARA USAR JOPTIONPANE
         String imprimirJO ="";
         String imprimelibre="";
         
         for (int i = 0; i < cocheras; i++) {
             imprimelibre= "PARKING NUMBER° __" + (i + 1) + " :   AVAILABLE"; 
             for (int j = 0; j < ArrayCocheras[i].length; j++) {
             if (ArrayCocheras[i][j] == null) {
              JOptionPane.showMessageDialog(null,imprimelibre);
              break;

               }
             } 
         }   
        for (int i = 0; i < cocheras; i++) {
            for (int j = 0; j < ArrayCocheras[i].length; j++) {
                imprimirJO+=ArrayCocheras[i][j];
                imprimirJO +="    |     ";
            }
            imprimirJO +="\n";
 
        }
        JOptionPane.showMessageDialog(null ,"------------------------------------------\n"
                                           +"   Type |  License  |   Date  |  Time\n "
                                           +"------------------------------------------ \n"
                                           +imprimirJO
                                           +"\n"
                                           +"\n"
                                           +"        Press any key to continue"); 

        menuEnglish(cocheras, ArrayCocheras);
    }
    // -- FIN -> Integrante del Grupo que escbrio el CODIGO : LEONARDO SOLAN
    //
    //

    // INICIO -> Integrante del Grupo que escbrio el CODIGO : SAMUEL LUCAS LIMACHI
    // metodo para mostrar un mensaje de opcion invalida en español
    public static void opcionInvalida() {
        
        // mostar mensaje de opcion invalida
        JOptionPane.showMessageDialog(null,"------------------------------------------\n"
                                          +"          No es una opción válida\n "
                                          +"------------------------------------------\n");                                     
        // esperar 2 segundos
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // ----- metodo para mostrar un mensaje de opcion invalida en ingles
    public static void opcionInvalidaEng() {
      

        // mostar mensaje de opcion invalida
        JOptionPane.showMessageDialog(null,"------------------------------------------\n"
                                          +"It is not a valid option\n "
                                          +"------------------------------------------\n" );
                                             
        // esperar 2 segundos
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    // metodo para mostrar un mensaja de despedida en español
    public static void mensajeDespedidaEsp() {
         // mostrar mensaje de despedida
        JOptionPane.showMessageDialog(null,"------------------------------------------\n"
                                          +"  Gracias por utilizar el sistema \n "
                                          +"------------------------------------------\n");   
        // finalizar el programa
        System.exit(0);
    }

    // metodo para mostrar un mensaja de despedida en ingles
    public static void mensajeDespedidaEng() {
        // mostrar mensaje de despedida
        JOptionPane.showMessageDialog(null,"------------------------------------------\n"
                                          +" Thank you for using the system \n "
                                          +"------------------------------------------\n");  
        // finalizar el programa
        System.exit(0);
    }
    // -- FIN -> Integrante del Grupo que escbrio el CODIGO : SAMUEL LUCAS LIMACHI
    //
    //

    // ----- INICIO -> Integrante del Grupo que escbrio el CODIGO : FRANCO MESAS
    // metodo para buscar un vehiculo por patente en español
    public static void buscarVehiculoEsp(int cocheras, String[][] ArrayCocheras) {
        // mostrar mensaje de busqueda de vehiculo y  ingresar patente a buscar
        patente = JOptionPane.showInputDialog("Ingrese la patente del vehículo a buscar: ");
        
        // ingresar patente a buscar
        Scanner scanner = new Scanner(System.in);

        // recorrer el array de cocheras
        for (int i = 0; i < cocheras; i++) {
            if (ArrayCocheras[i][1] != null) {
                if (ArrayCocheras[i][1].equals(patente)) {
                    System.out.println("------------------------------------------");
                    System.out.println("Vehículo encontrado");
                    System.out.println("------------------------------------------");
                    System.out.println("Tipo: " + ArrayCocheras[i][0]);
                    System.out.println("Patente: " + ArrayCocheras[i][1]);
                    System.out.println("Fecha: " + ArrayCocheras[i][2]);
                    System.out.println("Hora: " + ArrayCocheras[i][3]);

                    // mensaje "Se procede a eliminar el vehiculo y liberar la cochera"
                    JOptionPane.showMessageDialog(null,"------------------------------------------------------\n"
                                                      +"Se procede a eliminar el vehiculo y liberar la cochera\n "
                                                      +"-------------------------------------------------------\n");
                    //ingresamos monto a cobrar
                    monto = Integer.parseInt(JOptionPane.showInputDialog("ingrese el monto a cobrar $: "
                                                                 + "\n"
                                                                 +"\n"));
                    
                    // mensaje "Se procedera a cobrar el estacionamiento"
                    JOptionPane.showMessageDialog(null,"------------------------------------------\n"
                                                      +" Se procedera a cobrar el monto de "+monto+" pesos.\n "
                                                      +"\n"
                                                      +"\n"
                                                      +"MUCHAS GRACIAS POR USAR NUESTRA COCHERAS\n"
                                                      +"------------------------------------------ \n"
                                                      +"\n"
                                                      +"\n"
                                                      +"\n"
                                                      +"Presione una tecla para continuar");
 
                    // eliminar el vehiculo y liberar la cochera
                    ArrayCocheras[i][0] = null;
                    ArrayCocheras[i][1] = null;
                    ArrayCocheras[i][2] = null;
                    ArrayCocheras[i][3] = null;
                    
                    patente = JOptionPane.showInputDialog("Ingrese la patente del vehículo a buscar: ");
                    
                    menuEspañol(cocheras, ArrayCocheras);
                }
            }
        }

        // si no encuentra el vehiculo, mostrar mensaje de error
        JOptionPane.showMessageDialog(null,"------------------------------------------\n"
                                          +"  No se encontró el vehículo\n "
                                          +"------------------------------------------ \n"
                                          +"\n"
                                          +"Presione una tecla para continuar");

        menuEspañol(cocheras, ArrayCocheras);
    }

    // metodo para buscar un vehiculo por patente en ingles
    public static void buscarVehiculoEng(int cocheras, String[][] ArrayCocheras) {

        // mostrar mensaje de busqueda de vehiculo y  ingresar patente a buscar
       
       

        // recorrer el array de cocheras
        for (int i = 0; i < cocheras; i++) {
            if (ArrayCocheras[i][1] != null) {
                if (ArrayCocheras[i][1].equals(patente)) {
                    System.out.println("------------------------------------------");
                    System.out.println("Vehicle found");
                    System.out.println("------------------------------------------");
                    System.out.println("Type: " + ArrayCocheras[i][0]);
                    System.out.println("License plate: " + ArrayCocheras[i][1]);
                    System.out.println("Date: " + ArrayCocheras[i][2]);
                    System.out.println("Time: " + ArrayCocheras[i][3]);
                    
                    // mensaje "Se procede a eliminar el vehiculo y liberar la cochera"
                    JOptionPane.showMessageDialog(null,"------------------------------------------------------------------\n"
                                                      +"The vehicle will be removed and the parking space will be released\n "
                                                      +"------------------------------------------------------------------ \n");
                    
                    // mensaje "Se procedera a cobrar el estacionamiento"
                    JOptionPane.showMessageDialog(null,"------------------------------------------\n"
                                                      +" \n "
                                                      +"THANK YOU SO MUCH FOR USING OUR GARAGES\n"
                                                       +"\n"
                                                      +"The amount of "+monto+" pesos will be collected.\n"
                                                      +"------------------------------------------ \n"
                                                      +"\n"
                                                      +"\n"
                                                      +"Press enter to continue");

                    // eliminar el vehiculo y liberar la cochera
                    ArrayCocheras[i][0] = null;
                    ArrayCocheras[i][1] = null;
                    ArrayCocheras[i][2] = null;
                    ArrayCocheras[i][3] = null;

                    menuEnglish(cocheras, ArrayCocheras);

                }
            }
        }

        // si no encuentra el vehiculo, mostrar mensaje de error
        JOptionPane.showMessageDialog(null,"------------------------------------------\n"
                                          +"  The vehicle was not found\n "
                                          +"------------------------------------------ \n"
                                          +"\n"
                                          +"Press enter to continue");

        menuEnglish(cocheras, ArrayCocheras);
    }
    // -- FIN -> Integrante del Grupo que escbrio el CODIGO : FRANCO MESAS
    //
    //

    // ----- INICIO -> Integrante del Grupo que escbrio el CODIGO : GIMENEZ ERNESTO
    // MATIAS
    // metodo para limpiar la pantalla independiente del sistema operativo
    public static void limpiarPantalla() {

        try {

            String SistemaOperativo = System.getProperty("os.name");
            // System.out.println(SistemaOperativo);

            ArrayList<String> comando = new ArrayList<String>();
            if (SistemaOperativo.contains("Windows")) {
                comando.add("cmd");
                comando.add("/c");
                comando.add("cls");
            } else {
                comando.add("clear");
            }

            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    // -- FIN -> Integrante del Grupo que escbrio el CODIGO : GIMENEZ ERNESTO MATIAS
    //
    //

    
}
