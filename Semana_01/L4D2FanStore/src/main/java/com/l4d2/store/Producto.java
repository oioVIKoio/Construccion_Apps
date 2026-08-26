package com.l4d2.store;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void reducirStock(int cantidad) {
        this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return nombre + " | Precio: S/. " + String.format("%.2f", precio) + " | Stock: " + stock;
    }
}
