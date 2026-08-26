package com.l4d2.store;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarProductosIniciales();

        int opcion = 0;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    verProductos();
                    break;
                case 3:
                    comprarProducto();
                    break;
                case 4:
                    System.out.println("\n¡Gracias por visitar Left 4 Dead 2 Fan Store! ¡Sobrevive al apocalipsis!");
                    break;
                default:
                    System.out.println("\n[!] Opción no válida. Por favor, intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private static void cargarProductosIniciales() {
        productos.add(new Producto("Polo Zombie Hand L4D2", 45.00, 10));
        productos.add(new Producto("Gorra de Ellis Bullshifters", 35.00, 8));
        productos.add(new Producto("Hoodie Hunter con capucha", 120.00, 5));
        productos.add(new Producto("Taza Termo Botiquín First Aid", 30.00, 12));
        productos.add(new Producto("Peluche de Tank", 65.00, 4));
    }

    private static void mostrarMenu() {
        System.out.println("\n=================================");
        System.out.println("   LEFT 4 DEAD 2 - FAN STORE");
        System.out.println("=================================");
        System.out.println("1. agregar productos");
        System.out.println("2. Ver productos");
        System.out.println("3. Comprar producto");
        System.out.println("4. Salir");
        System.out.println("=================================");
    }

    private static void agregarProducto() {
        System.out.println("\n--- AGREGAR NUEVO PRODUCTO ---");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("[!] El nombre no puede estar vacío.");
            return;
        }

        try {
            System.out.print("Ingrese el precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese el stock inicial: ");
            int stock = Integer.parseInt(scanner.nextLine());

            if (precio <= 0 || stock < 0) {
                System.out.println("[!] El precio debe ser mayor a 0 y el stock no puede ser negativo.");
                return;
            }

            productos.add(new Producto(nombre, precio, stock));
            System.out.println("[✓] Producto agregado con éxito a la tienda.");
        } catch (NumberFormatException e) {
            System.out.println("[!] Error: Ingrese valores numéricos válidos para precio y stock.");
        }
    }

    private static void verProductos() {
        System.out.println("\n--- CATÁLOGO DE PRODUCTOS ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles en la tienda.");
            return;
        }

        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }
    }

    private static void comprarProducto() {
        System.out.println("\n--- COMPRAR PRODUCTO ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles para comprar.");
            return;
        }

        verProductos();

        try {
            System.out.print("\nSeleccione el número del producto que desea comprar: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            // Validación de existencia del producto
            if (index < 0 || index >= productos.size()) {
                System.out.println("[!] El producto seleccionado no existe.");
                return;
            }

            Producto productoSeleccionado = productos.get(index);

            System.out.print("Ingrese la cantidad a comprar: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            // Validación de cantidad mayor a 0
            if (cantidad <= 0) {
                System.out.println("[!] La cantidad debe ser mayor a cero.");
                return;
            }

            // Validación de stock suficiente
            if (cantidad > productoSeleccionado.getStock()) {
                System.out.println("[!] Stock insuficiente. Stock disponible: " + productoSeleccionado.getStock());
                return;
            }

            // Descontar stock y calcular total
            productoSeleccionado.reducirStock(cantidad);
            double total = cantidad * productoSeleccionado.getPrecio();

            System.out.println("\n---------------------------------");
            System.out.println("Producto: " + productoSeleccionado.getNombre());
            System.out.println("Cantidad: " + cantidad);
            System.out.printf("Total de la compra: S/. %.2f\n", total);
            System.out.println("---------------------------------");
            System.out.println("[✓] ¡Compra realizada con éxito!");
        } catch (NumberFormatException e) {
            System.out.println("[!] Error: Ingrese un número válido.");
        }
    }
}
