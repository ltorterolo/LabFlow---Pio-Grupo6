package org.example.Clases;
import org.example.TDAs.ListaEnlazada;


public class Modelo {
    private int id;
    private String nombre;
    private TipoModelo tipoModelo;
    private ListaEnlazada<String> parametrosAsociados;

    public Modelo(int id, String nombre, TipoModelo tipoModelo ){
        this.id = id;
        this.nombre = nombre;
        this.tipoModelo = tipoModelo;
        this.parametrosAsociados = new ListaEnlazada<String>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoModelo getTipoModelo() {
        return tipoModelo;
    }
    public void setTipoModelo(TipoModelo tipoModelo) {
        this.tipoModelo = tipoModelo;
    }

    public ListaEnlazada<String> getParametrosAsociados() {
        return parametrosAsociados;
    }
    public void addParametrosAsociados(String parametrosAsociados) {
        this.parametrosAsociados.agregar(parametrosAsociados);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modelo modelo = (Modelo) o;
        return id == modelo.id;
    }    

    @Override
    public String toString() {
        return "ID: " + id +" | Nombre: " + nombre +" | Tipo: " + tipoModelo +" | Parametros: " + parametrosAsociados;
    }

}
