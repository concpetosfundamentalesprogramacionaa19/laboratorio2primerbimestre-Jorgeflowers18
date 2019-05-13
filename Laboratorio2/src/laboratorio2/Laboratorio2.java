/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import java.util.Scanner;

/**
 *
 * @author Jorgeso
 */
public class Laboratorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaración de variables
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        int contn = 0;
        String contns;
        String mensaje = "";
        String reporte = "";
        String mensajeult = "";
        String cadenatotal = "";
        String falt = "";
        String present = "";
        String totales = "";
        int acum = 0;
        String acums;
        int sueldo = 0;
        String sueldos;
        int numhijos = 0;
        String numhijosS;
        double pasajes = 0;
        String pasajeS;
        double bar = 0;
        String barS;
        double salidas = 0;
        String salidasS;
        double total = 0;
        double totalp = 0;
        double totalb = 0;
        double totals = 0;
        int hijos = 0;
        int opt = 0;
        String infohijo = "";
        boolean opc = true;

        while (opc) {
            // Interfaz de estética para el usuario
            System.out.println("_______________________________________________"
                    + "___________________________________");
            System.out.println("|Bienvenido al programar para la comparación de"
                    + " presupuesto semanal de su sueldo. |");
            System.out.println("|______________________________________________"
                    + "__________________________________|");
            System.out.println("|1)Registro de datos y su presentación de      "
                    + "reporte                           |");
            System.out.println("|2)Salir del programa                          "
                    + "                                   |");
            System.out.println("|______________________________________________"
                    + "__________________________________|");
            System.out.println("Por favor ingrese su opción (1-3)");
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {

                case 1:
                    // Petición de información
                    System.out.println("Por favor ingrese los nombres y "
                            + "apellidos del padre de familia:");
                    nombre = sc.nextLine();
                    contn = contn + 1;
                    System.out.println("Por favor ingrese el presupuesto "
                            + "semanal del padre de familia:");
                    sueldo = sc.nextInt();
                    System.out.println("Ingrese el número de hijos del padre de"
                            + " familia:");
                    numhijos = sc.nextInt();

                    contns = Integer.toString(contn);
                    sueldos = Integer.toString(sueldo);
                    numhijosS = Integer.toString(numhijos);

                    for (int i = 0; i < numhijos; i++) {
                        // Aquí solicitamos la info por cada hijo y se va 
                        // calculando los 
                        // totales para la presentación final
                        hijos = hijos + 1;
                        System.out.println("Ingrese el gasto del hijo " + hijos
                                + " para pasaje"
                                + ":");
                        pasajes = sc.nextDouble();
                        System.out.println("Ingrese el gasto del hijo " + hijos
                                + " para Bar:");
                        bar = sc.nextDouble();
                        System.out.println("Ingrese el gasto del hijo " + hijos
                                + " para Salidas:");
                        salidas = sc.nextDouble();
                        totalp = totalp + pasajes;
                        totalb = totalb + bar;
                        totals = totals + salidas;
                        total = total + pasajes + bar + salidas;
                        // Transformación de double a string para la 
                        // presentación
                        pasajeS = String.valueOf(pasajes);
                        barS = String.valueOf(bar);
                        salidasS = String.valueOf(salidas);

                        acum = acum + 1;

                        infohijo = String.format("%sHijo " + acum + 
                                "\t%s\t%s\t%s\n",
                                 infohijo, pasajeS, barS, salidasS);

                    }
                    if (total > sueldo) {
                        falt = "falta";

                    }
                    if (total < sueldo) {
                        falt = "sobra";
                    }
                    if (total == sueldo) {
                        falt = "alcanza";
                    }

                    totales = String.format("%s%s\t%s\t%s\t%s", totales,
                            "Totales", totalp, totalb, totals);
                    mensajeult = String.format("%s%s", mensajeult,
                            "El padre de familia " + nombre + " le " + falt
                            + " el dinero semanal, para sus gastos.");
                    reporte = String.format("%s%s\n", reporte, "Reporte "
                            + contns);
                    mensaje = String.format("%s%s\n%s: %s\n%s: %s\n%s: %s\n\n%s"
                            + "\n%s\n%s\n%s\n%s\n\nFin reporte "
                            + contns + "", mensaje, reporte,
                            "Nombre de Padre de Familia",
                            nombre, "Sueldo Semanal", sueldos, "Número de hijos"
                            , numhijos, "Reporte de Gastos",
                            "Persona\tPasaje\tBar\tSalidas",
                            infohijo, totales, mensajeult);
                    System.out.println(mensaje);
                    // present = String.format("%s%s", present, mensaje);
                    mensaje = "";
                    
                    break;

                case 2:
                    // caso para salir del programa
                    opc = false;
                    break;

                default:
                    // Respuesta predeterminada en caso de que la opcion 
                    // ingresada no esté registrada
                    System.out.println("El número que ingresó no pertenece a"
                            + "ninguna opción. Se lo devuelve al menú.");
            }
        }

    }
}
