package com.mycompany.aplicacionsupermercado;

public class Producto {
    private final String codigo;
    private final String nombre;
    private int cantidad;
    private double precio;
    private double total;

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = cantidad * precio;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }
    public double getTotal() { return total; }

    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad; 
        this.total = cantidad * precio; 
    }
    
    public void setPrecio(double precio) { 
        this.precio = precio; 
        this.total = cantidad * precio; 
    }
}
