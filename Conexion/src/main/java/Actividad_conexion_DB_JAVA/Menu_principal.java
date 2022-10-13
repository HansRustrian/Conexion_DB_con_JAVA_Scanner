package Actividad_conexion_DB_JAVA;

import com.mysql.cj.exceptions.UnsupportedConnectionStringException;
import java.util.Scanner;

public class Menu_principal {
    
    public void menu_inicial() {

        System.out.println("**********************************");
        System.out.println("*      PASTELERIA NACIONAL       *");
        System.out.println("*                                *");
        System.out.println("* Bienvenido, eliga la opcion de *");
        System.out.println("* la accion que desea realizar : *");
        System.out.println("*                                *");
        System.out.println("* 1. Consultar menu              *");
        System.out.println("* 2. Adicionar registro          *");
        System.out.println("* 3. Modificar registro          *");
        System.out.println("* 4. Eliminar registro           *");
        System.out.println("* 5. Salir del sistema           *");
        System.out.println("**********************************");

    }

    public void menu_constante() {

        System.out.println("**********************************");
        System.out.println("*      ¿Que desea realizar?      *");
        System.out.println("*                                *");
        System.out.println("* 1. Consultar menu              *");
        System.out.println("* 2. Adicionar registro          *");
        System.out.println("* 3. Modificar registro          *");
        System.out.println("* 4. Eliminar registro           *");
        System.out.println("* 5. Salir del sistema           *");
        System.out.println("**********************************");

    }

    public void elegir_opcion() {
        Menu_principal mp = new Menu_principal();
        funciones_de_menu fm = new funciones_de_menu();
        while (true) {
            Scanner sp = new Scanner(System.in);
            int opcion = sp.nextInt();

            switch (opcion) {
                case 1:
                    fm.listar();
                    mp.menu_constante();
                    break;
                case 2:
                    System.out.println("Ingrese codigo de producto : ");
                    int codigo_a = sp.nextInt();
                    Scanner sp1 = new Scanner(System.in);
                    System.out.println("Ingrese nombre de producto : ");
                    String nombre_a = sp1.nextLine();
                    System.out.println("Ingrese unidades disponibles : ");
                    int unidades_a = sp.nextInt();
                    System.out.println("Ingrese sucursal : ");
                    String sucursal_a = sp1.nextLine();
                    Scanner sp2 = new Scanner(System.in);
                    System.out.println("Ingrese fecha de ingreso de producto : ");
                    String fecha_a = sp2.nextLine();
                    System.out.println("Ingrese Precio de producto : ");
                    int precio_a = sp2.nextInt();
                    fm.crear(codigo_a, nombre_a, unidades_a, sucursal_a, fecha_a, precio_a);
                    fm.desplegar();
                    mp.menu_constante();
                    break;
                case 3:
                    fm.desplegar();
                    System.out.println("Ingrese codigo de registro a modificar : ");
                    int codigo_m = sp.nextInt();
                    Scanner sp3 = new Scanner(System.in);
                    System.out.println("Ingrese nombre de registro : ");
                    String nombre_m = sp3.nextLine();
                    System.out.println("Ingrese unidades disponibles : ");
                    int unidades_m = sp.nextInt();
                    System.out.println("Ingrese sucursal : ");
                    String sucursal_m = sp3.nextLine();
                    Scanner sp4 = new Scanner(System.in);
                    System.out.println("Ingrese fecha de inventario de producto : ");
                    String fecha_m = sp4.nextLine();
                    System.out.println("Ingrese Precio de producto : ");
                    int precio_m = sp4.nextInt();
                    fm.modificar(nombre_m, unidades_m, sucursal_m, fecha_m, precio_m, codigo_m);
                    fm.desplegar();
                    mp.menu_constante();
                    break;
                case 4:
                    fm.desplegar();
                    Scanner sp5 = new Scanner(System.in);
                    System.out.println("Ingrese el Codigo de Registro a eliminar : ");
                    int codigo_e = sp5.nextInt();
                    String decision = "";
                    Scanner sp6 = new Scanner(System.in);
                    if (codigo_e != 0){
                        System.out.println(" ** ¿QUIERE PROCEDER A ELIMINAR EL REGISTRO "+codigo_e+"? S/N ** ");
                        decision = sp6.nextLine();
                    }
                    String decide = decision;
                    if (decide.equals("S") || decide.equals("s")){
                        fm.eliminar(codigo_e);
                    } else {
                        System.out.println(" ** REGISTRO NO ELIMINADO **");
                    }
                    fm.desplegar();
                    mp.menu_constante();
                    break;
                  case 5:
                      System.out.println("");
                      System.out.println("¡Vuelva Pronto!");
                      System.exit(0);
                default:
                    throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) {

        Menu_principal mpr = new Menu_principal();

        mpr.menu_inicial();
        mpr.elegir_opcion();
    }
    
}
