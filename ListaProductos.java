package com.mycompany.aplicacionsupermercado;

public class ListaProductos {
    private Nodo cabeza;

    public ListaProductos() {
        cabeza = null;
    }

    public void agregarProducto(Producto producto) {
        Nodo nuevoNodo = new Nodo(producto);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    public void modificarProducto(String codigo, double incrementoPorcentaje) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.producto.getCodigo().equals(codigo)) {
                double nuevoPrecio = temp.producto.getPrecio() * (1 + incrementoPorcentaje / 100);
                temp.producto.setPrecio(nuevoPrecio);
                return;
            }
            temp = temp.siguiente;
        }
    }

    public void eliminarProducto(String codigo) {
        if (cabeza == null) return;
        if (cabeza.producto.getCodigo().equals(codigo)) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo temp = cabeza;
        while (temp.siguiente != null && !temp.siguiente.producto.getCodigo().equals(codigo)) {
            temp = temp.siguiente;
        }
        if (temp.siguiente != null) {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }

    public Producto buscarProducto(String codigo) {
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.producto.getCodigo().equals(codigo)) {
                return temp.producto;
            }
            temp = temp.siguiente;
        }
        return null;
    }

    public void mostrarProductos() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.printf("%s\t%d\t%.2f\t%.2f\n", temp.producto.getCodigo(), temp.producto.getCantidad(),
                    temp.producto.getPrecio(), temp.producto.getTotal());
            temp = temp.siguiente;
        }
    }

    public void generarFactura() {
        double total = 0;
        int productosVendidos = 0;
        Nodo temp = cabeza;
        while (temp != null) {
            total += temp.producto.getTotal();
            productosVendidos++;
            temp = temp.siguiente;
        }
        double iva = total * 0.19;
        double precioFinal = total + iva;

        System.out.printf("Código\tCantidad\tPrecio\tTotal\n");
        mostrarProductos();
        System.out.printf("Precio final: %.2f\n", precioFinal);
        System.out.printf("IVA: %.2f\n", iva);
        System.out.printf("Total: %.2f\n", total);
    }
}
