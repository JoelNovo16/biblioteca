package org.example;
import java.util.ArrayList;

public class usuario {

    private String nombre;
    private  String apellido;
    private  String telefono;
    private  String email;
    private  int libros;
    private ArrayList<libros> librosPendientes;


    public usuario(String nombre,String apellido,String telefono,String email,int libros){
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.telefono=telefono;
        this.libros=libros;
        this.librosPendientes = new ArrayList<>();

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setLibros(int libros) {
        this.libros = libros;
    }

    public int getLibros() {
        return libros;
    }

    public ArrayList<libros> getLibrosPendientes() {
        return librosPendientes;
    }

    public void setLibrosPendientes(ArrayList<libros> librosPendientes) {
        this.librosPendientes = librosPendientes;
    }
}
