package org.example;
import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<usuario> usuarios = new ArrayList<>();
        ArrayList<libros> librosDisponibles = new ArrayList<>();

        // Crear algunos usuarios y libros de muestra
        usuario usuario1 = new usuario("Juan", "Perez", "123456789", "juan@example.com",2);
        usuario usuario2 = new usuario("Maria", "Gomez", "987654321", "maria@example.com",4);
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        libros libro1 = new libros("El nombre del viento", "Patrick Rothfuss", "978-8499082479");
        libros libro2 = new libros("Cien años de soledad", "Gabriel García Márquez", "978-0307474728");
        librosDisponibles.add(libro1);
        librosDisponibles.add(libro2);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Acceder a un usuario");
            System.out.println("2. Ver libros disponibles");
            System.out.println("3. Ver libros pendientes de devolver (por el usuario)");
            System.out.println("4. Pedir un libro");
            System.out.println("5. Devolver un libro");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Acceder a un usuario
                    System.out.print("Ingrese el número de usuario (empezando desde 1): ");
                    int numUsuario = scanner.nextInt();
                    if (numUsuario > 0 && numUsuario <= usuarios.size()) {
                        usuario usuarioSeleccionado = usuarios.get(numUsuario - 1);
                        System.out.println("Usuario seleccionado: " + usuarioSeleccionado.getNombre() + " " + usuarioSeleccionado.getApellido());
                    } else {
                        System.out.println("Número de usuario no válido.");
                    }
                    break;
                case 2:
                    // Ver libros disponibles
                    System.out.println("Libros disponibles:");
                    for (libros libro : librosDisponibles) {
                        System.out.println(libro.getTitulo());
                    }
                    break;
                case 3:
                    // Ver libros pendientes de devolver (por el usuario)
                    System.out.print("Ingrese el número de usuario (empezando desde 1): ");
                    int numUsuarioPendientes = scanner.nextInt();
                    if (numUsuarioPendientes > 0 && numUsuarioPendientes <= usuarios.size()) {
                        usuario usuarioPendientes = usuarios.get(numUsuarioPendientes - 1);
                        System.out.println("Libros pendientes de devolución para " + usuarioPendientes.getNombre() + " " + usuarioPendientes.getApellido() + ":");
                        ArrayList<libros> librosPendientes = usuarioPendientes.getLibrosPendientes();
                        if (librosPendientes.isEmpty()) {
                            System.out.println("No hay libros pendientes de devolución.");
                        } else {
                            for (libros libro : librosPendientes) {
                                System.out.println(libro.getTitulo());
                            }
                        }
                    } else {
                        System.out.println("Número de usuario no válido.");
                    }
                    break;

                case 4:
                    // Pedir un libro
                    System.out.print("Ingrese el número de usuario (empezando desde 1): ");
                    int numUsuarioPedido = scanner.nextInt();
                    if (numUsuarioPedido > 0 && numUsuarioPedido <= usuarios.size()) {
                        usuario usuarioPedido = usuarios.get(numUsuarioPedido - 1);
                        System.out.println("Usuario seleccionado: " + usuarioPedido.getNombre() + " " + usuarioPedido.getApellido());
                        System.out.println("Libros disponibles:");
                        for (int i = 0; i < librosDisponibles.size(); i++) {
                            System.out.println((i + 1) + ". " + librosDisponibles.get(i).getTitulo());
                        }
                        System.out.print("Seleccione el número del libro que desea pedir: ");
                        int numLibroPedido = scanner.nextInt();
                        if (numLibroPedido > 0 && numLibroPedido <= librosDisponibles.size()) {
                            libros libroPedido = librosDisponibles.get(numLibroPedido - 1);
                            usuarioPedido.getLibrosPendientes().add(libroPedido);
                            System.out.println("Libro '" + libroPedido.getTitulo() + "' pedido por " + usuarioPedido.getNombre() + " " + usuarioPedido.getApellido());
                            librosDisponibles.remove(libroPedido); // Eliminamos el libro de la lista de libros disponibles
                        } else {
                            System.out.println("Número de libro no válido.");
                        }
                    } else {
                        System.out.println("Número de usuario no válido.");
                    }
                    break;
                case 5:
                    // Devolver un libro
                    System.out.print("Ingrese el número de usuario (empezando desde 1): ");
                    int numUsuarioDevolucion = scanner.nextInt();
                    if (numUsuarioDevolucion > 0 && numUsuarioDevolucion <= usuarios.size()) {
                        usuario usuarioDevolucion = usuarios.get(numUsuarioDevolucion - 1);
                        System.out.println("Libros pendientes de devolución para " + usuarioDevolucion.getNombre() + " " + usuarioDevolucion.getApellido() + ":");
                        ArrayList<libros> librosPendientes = usuarioDevolucion.getLibrosPendientes();
                        if (librosPendientes.isEmpty()) {
                            System.out.println("No hay libros pendientes de devolución para este usuario.");
                        } else {
                            for (int i = 0; i < librosPendientes.size(); i++) {
                                System.out.println((i + 1) + ". " + librosPendientes.get(i).getTitulo());
                            }
                            System.out.print("Seleccione el número del libro que desea devolver: ");
                            int numLibroDevolucion = scanner.nextInt();
                            if (numLibroDevolucion > 0 && numLibroDevolucion <= librosPendientes.size()) {
                                libros libroDevolucion = librosPendientes.remove(numLibroDevolucion - 1);
                                System.out.println("Libro '" + libroDevolucion.getTitulo() + "' devuelto por " + usuarioDevolucion.getNombre() + " " + usuarioDevolucion.getApellido());
                            } else {
                                System.out.println("Número de libro no válido.");
                            }
                        }
                    } else {
                        System.out.println("Número de usuario no válido.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
