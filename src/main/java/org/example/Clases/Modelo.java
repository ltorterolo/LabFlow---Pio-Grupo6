package org.example.Clases;

import org.example.TDAs.ListaEnlazada;

public class Modelo {
    private String identificador; 
    private String nombre; 
    private TipoModelo tipo;
    private ListaEnlazada<String> parametrosAsociados = new ListaEnlazada<>();

    public Modelo(String identificador, String nombre, TipoModelo tipo){
        this.identificador = identificador;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getId(){
        return identificador;
    }

    public String getNombre(){
        return nombre;
    }

    public TipoModelo getTipo(){
        return tipo;
    }

    public ListaEnlazada<String> getParametrosAsociados() {return parametrosAsociados;}

    public boolean agregarParametro(String parametro){
        parametrosAsociados.agregar(parametro);
        return true;
    }

    @Override
    public String toString(){
        return "ID: " + identificador + ", Nombre: " + nombre + ", Tipo: " + tipo + ", Parámetros: " + parametrosAsociados.toString();
    }
}
