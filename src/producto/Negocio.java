package producto;

import java.util.ArrayList;
import java.util.Scanner;

public class Negocio {
    ArrayList<Producto> productos = new ArrayList<Producto>(7);
    Producto productoInicial = new Producto();
    Producto productoAgregado = new Producto();
    Scanner sc = new Scanner(System.in);
    int opcion = 0;

    public void menu() {
        productosPrevios();

        while (opcion != 4) {
            System.out.println("Elija una opcion");
            System.out.println("1.- Ver Productos");
            System.out.println("2.- Agregar Productos");
            System.out.println("3.- Modificar Productos");
            System.out.println("4.- Salir");
            opcion = sc.nextInt();
            eleccion();
        }
    }

    private void productosPrevios(){
        productoInicial.setNombre("Chocolate");
        productoInicial.setDescripcion("Chocolate amargo, 500 gr.");
        productoInicial.setValor(500);
        productos.add(productoInicial);

        productoInicial = new Producto("Leche", "Leche entera, 1 litro.",800);
        productos.add(productoInicial);

        productoInicial = new Producto("Arroz", "Arroz grado 2, 1 kilo.",900);
        productos.add(productoInicial);//
    }

    private void eleccion() {
        switch (opcion) {
            case 1:
                listar();
                break;
            case 2:
                agregar();
                break;
            case 3:
                modificar();
                break;
        }
    }

    private void listar() {
        System.out.println("========================LISTADO PRODUCTOS========================");
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
        System.out.println(" ");
    }

    private void agregar() {
        if (productos.size() > 6) {
            System.out.println("La lista se encuentra llena");
            System.out.println(" ");
        } else {
            System.out.println("========================AGREGAR PRODUCTOS========================");
            System.out.println("Ingrese el nombre del productoInicial");
            productoAgregado.setNombre(sc.next());

            System.out.println("Ingrese el valor del productoInicial");
            productoAgregado.setValor(sc.nextDouble());

            System.out.println("Ingrese la descripcion del productoInicial");
            productoAgregado.setDescripcion(sc.next());

            productos.add(productoAgregado);
            System.out.println("Producto agregado con exito");
            System.out.println(" ");
            productoAgregado = new Producto();
        }
    }

    private void modificar() {
        int i = 1;
        System.out.println("========================MODIFICAR PRODUCTOS========================");
        for (Producto producto : productos) {
            System.out.println(i +" -"+producto.toString());
            i++;
        }
        System.out.println(" ");
        System.out.println("Ingrese el numero del producto que quiere modificar: ");
        i = sc.nextInt();
        System.out.println("Ingrese el nuevo nombre del producto: ");
        productoAgregado.setNombre(sc.next());

        System.out.println("Ingrese el nuevo valor del producto: ");
        productoAgregado.setValor(sc.nextDouble());

        System.out.println("Ingrese la nueva descripcion del producto: ");
        productoAgregado.setDescripcion(sc.next());

        productos.set(i-1, productoAgregado);
        productoAgregado = new Producto();
        System.out.println(" ");
    }
}
