package org.example;

import org.example.dao.*;
import org.example.model.Cliente;
import org.example.model.RegistrosLavado;
import org.example.model.Servicios;
import org.example.model.Vehiculos;
import org.example.util.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcion;
                do {
                    System.out.println("\nMenu:");
                    System.out.println("\nSeleccione la tabla que desea gestionar:");
                    System.out.println("1. Tabla Clientes");
                    System.out.println("2. Tabla Servicios");
                    System.out.println("3. Tabla Vehiculos");
                    System.out.println("4. Tabla Registros de lavado");
                    System.out.println("0. Salir");
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    switch (opcion) {
                        case 1:
                            try (Connection connection = ConexionBD.obtenerConexion()) {
                                ClienteDAO clienteDAO = new ClienteDAOImpl(connection);
                                int opc;

                                do {
                                    System.out.println("\nMenu:");
                                    System.out.println("1. Registrar Cliente");
                                    System.out.println("2. Leer Cliente");
                                    System.out.println("3. Actualizar Cliente");
                                    System.out.println("4. Eliminar Cliente");
                                    System.out.println("5. Listar Clientes");
                                    System.out.println("0. Salir");
                                    System.out.print("Elige una opción: ");
                                    opc = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar el buffer

                                    switch (opc) {
                                        case 1: // Registrar
                                            System.out.print("ClienteID: ");
                                            int clienteID = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Nombre: ");
                                            String nombre = scanner.nextLine();
                                            System.out.print("Apellido: ");
                                            String apellido = scanner.nextLine();
                                            System.out.println("Teléfono: ");
                                            String telefono = scanner.nextLine();
                                            System.out.println("Email: ");
                                            String email = scanner.nextLine();
                                            System.out.println("Dirección: ");
                                            String direccion = scanner.nextLine();

                                            Cliente cliente = new Cliente(clienteID, nombre, apellido, telefono, email, direccion);
                                            clienteDAO.crear(cliente);
                                            System.out.println("Cliente registrado.");

                                            break;

                                        case 2: // Leer
                                            System.out.print("Ingrese el ID del cliente: ");
                                            int clienteIDLeer = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                            Cliente cli = clienteDAO.leer(clienteIDLeer);
                                            if (cli != null) {
                                                System.out.println(cli);
                                            } else {
                                                System.out.println("Cliente no encontrado.");
                                            }
                                            break;

                                        case 3: // Actualizar
                                            System.out.print("ID del Cliente a actualizar: ");
                                            int clienteIDActualizar = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                            Cliente clieActualizar = clienteDAO.leer(clienteIDActualizar);
                                            if (clieActualizar != null) {
                                                System.out.print("Nuevo nombre: ");
                                                clieActualizar.setNombre(scanner.nextLine());
                                                System.out.print("Nuevo apellido: ");
                                                clieActualizar.setApellido(scanner.nextLine());
                                                System.out.print("Nuevo telefono: ");
                                                clieActualizar.setTelefono(scanner.nextLine());
                                                System.out.print("Nuevo email: ");
                                                clieActualizar.setEmail(scanner.nextLine());
                                                System.out.println("Nueva dirección: ");
                                                clieActualizar.setDireccion(scanner.nextLine());
                                                clienteDAO.actualizar(clieActualizar);
                                                System.out.println("Cliente actualizado.");
                                            } else {
                                                System.out.println("Cliente no encontrado.");
                                            }
                                            break;

                                        case 4: // Eliminar
                                            System.out.print("Id del cliente a eliminar: ");
                                            int clienteIDEliminar = scanner.nextInt();
                                            scanner.nextLine();
                                            clienteDAO.eliminar(clienteIDEliminar);
                                            System.out.println("Cliente eliminado.");
                                            break;

                                        case 5: // Listar
                                            List<Cliente> listaClientes = clienteDAO.listar();
                                            if (listaClientes.isEmpty()) {
                                                System.out.println("No hay clientes registrados.");
                                            } else {
                                                System.out.println("--- Lista de Clientes ---");
                                                for (Cliente p : listaClientes) {
                                                    System.out.println(p); // Asume que Cliente tiene un .toString()
                                                }
                                            }
                                            break;

                                        case 0:
                                            System.out.println("Saliendo...");
                                            break;

                                        default:
                                            System.out.println("Opción no válida.");
                                    }
                                } while (opc != 0);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            try (Connection connection = ConexionBD.obtenerConexion()) {
                                ServiciosDAO serviciosDAO = new ServiciosDAOImpl(connection);
                                int opc1;

                                do {
                                    System.out.println("\nMenu:");
                                    System.out.println("1. Registrar Servicio");
                                    System.out.println("2. Leer Servicio");
                                    System.out.println("3. Actualizar Servicio");
                                    System.out.println("4. Eliminar Servicio");
                                    System.out.println("5. Listar Servicios");
                                    System.out.println("0. Salir");
                                    System.out.print("Elige una opción: ");
                                    opc1 = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar el buffer

                                    switch (opc1) {
                                        case 1: // Registrar
                                            System.out.print("ServicioID: ");
                                            int ServicioID = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Nombre: ");
                                            String nombre = scanner.nextLine();
                                            System.out.println("Precio: ");
                                            double precio = scanner.nextDouble();

                                            Servicios servicios = new Servicios(ServicioID, nombre, precio);
                                            serviciosDAO.crear(servicios);
                                            System.out.println("Servicio registrado.");

                                            break;

                                        case 2: // Leer
                                            System.out.print("Ingrese el ID del servicio: ");
                                            int ServicioIDLeer = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                            Servicios serv = serviciosDAO.leer(ServicioIDLeer);
                                            if (serv != null) {
                                                System.out.println(serv);
                                            } else {
                                                System.out.println("Servicio no encontrado.");
                                            }
                                            break;

                                        case 3: // Actualizar
                                            System.out.print("ID del Servicio a actualizar: ");
                                            int ServicioIDActualizar = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                            Servicios servActualizar = serviciosDAO.leer(ServicioIDActualizar);
                                            if (servActualizar != null) {
                                                System.out.print("Nuevo nombre: ");
                                                servActualizar.setNombre(scanner.nextLine());
                                                System.out.println("Nuevo precio: ");
                                                servActualizar.setPrecio(scanner.nextDouble());
                                                serviciosDAO.actualizar(servActualizar);
                                                System.out.println("Servicio actualizado.");
                                            } else {
                                                System.out.println("Servicio no encontrado.");
                                            }
                                            break;

                                        case 4: // Eliminar
                                            System.out.print("Id del servicio a eliminar: ");
                                            int servicioIDEliminar = scanner.nextInt();
                                            scanner.nextLine();
                                            serviciosDAO.eliminar(servicioIDEliminar);
                                            System.out.println("Servicio eliminado.");
                                            break;

                                        case 5: // Listar
                                            List<Servicios> listaServicios = serviciosDAO.listar();
                                            if (listaServicios.isEmpty()) {
                                                System.out.println("No hay servicios registrados.");
                                            } else {
                                                System.out.println("--- Lista de Servicios ---");
                                                for (Servicios p : listaServicios) {
                                                    System.out.println(p); // Asume que Cliente tiene un .toString()
                                                }
                                            }
                                            break;

                                        case 0:
                                            System.out.println("Saliendo...");
                                            break;

                                        default:
                                            System.out.println("Opción no válida.");
                                    }
                                } while (opc1 != 0);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;

                        case 3:
                            try (Connection connection = ConexionBD.obtenerConexion()) {
                                VehiculosDAO vehiculosDAO = new VehiculosDAOImpl(connection);
                                int opc2;

                                do {
                                    System.out.println("\nMenu:");
                                    System.out.println("1. Registrar Vehiculo");
                                    System.out.println("2. Leer Vehiculos");
                                    System.out.println("3. Actualizar Vehiculos");
                                    System.out.println("4. Eliminar Vehiculo");
                                    System.out.println("5. Listar Vehiculos");
                                    System.out.println("0. Salir");
                                    System.out.print("Elige una opción: ");
                                    opc2 = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar el buffer

                                    switch (opc2) {
                                        case 1: // Registrar
                                            System.out.println("VehiculoID: ");
                                            int VehiculoID = scanner.nextInt();
                                            System.out.print("ClienteID: ");
                                            int clienteID = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Marca: ");
                                            String marca = scanner.nextLine();
                                            System.out.print("Modelo: ");
                                            String modelo = scanner.nextLine();
                                            System.out.println("Placa: ");
                                            String placa = scanner.nextLine();
                                            System.out.println("Color: ");
                                            String color = scanner.nextLine();
                                            System.out.println("Tipo: ");
                                            String tipo = scanner.nextLine();

                                            Vehiculos vehiculos = new Vehiculos(VehiculoID, clienteID, marca, modelo, placa, color, tipo);
                                            vehiculosDAO.crear(vehiculos);
                                            System.out.println("Vehiculo registrado.");
                                            break;

                                        case 2: // Leer
                                            System.out.print("Ingrese el ID del vehiculo: ");
                                            int VehiculoIDLeer = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                            Vehiculos vehi = vehiculosDAO.leer(VehiculoIDLeer);
                                            if (vehi != null) {
                                                System.out.println(vehi);
                                            } else {
                                                System.out.println("Vehiculo no encontrado.");
                                            }
                                            break;

                                        case 3: // Actualizar
                                            System.out.print("ID del vehiculo a actualizar: ");
                                            int VehiculoIDActualizar = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                            Vehiculos vehiActualizar = vehiculosDAO.leer(VehiculoIDActualizar);
                                            if (vehiActualizar != null) {
                                                System.out.print("Nuevo clienteID: ");
                                                vehiActualizar.setClienteID(scanner.nextInt());
                                                scanner.nextLine();
                                                System.out.println("Nueva marca: ");
                                                vehiActualizar.setMarca(scanner.nextLine());
                                                System.out.println("Nuevo modelo: ");
                                                vehiActualizar.setModelo(scanner.nextLine());
                                                System.out.println("Nueva placa: ");
                                                vehiActualizar.setPlaca(scanner.nextLine());
                                                System.out.println("Nuevo color: ");
                                                vehiActualizar.setColor(scanner.nextLine());
                                                System.out.println("Nuevo tipo: ");
                                                vehiActualizar.setTipo(scanner.nextLine());
                                                vehiculosDAO.actualizar(vehiActualizar);
                                                System.out.println("Vehiculo actualizado.");
                                            } else {
                                                System.out.println("Vehiculo no encontrado.");
                                            }
                                            break;

                                        case 4: // Eliminar
                                            System.out.print("Id del vehiculo a eliminar: ");
                                            int VehiculoIDEliminar = scanner.nextInt();
                                            scanner.nextLine();
                                            vehiculosDAO.eliminar(VehiculoIDEliminar);
                                            System.out.println("Vehiculo eliminado.");
                                            break;

                                        case 5: // Listar
                                            List<Vehiculos> listaVehiculos = vehiculosDAO.listar();
                                            if (listaVehiculos.isEmpty()) {
                                                System.out.println("No hay vehiculos registrados.");
                                            } else {
                                                System.out.println("--- Lista de Vehiculos ---");
                                                for (Vehiculos p : listaVehiculos) {
                                                    System.out.println(p); // Asume que Cliente tiene un .toString()
                                                }
                                            }
                                            break;

                                        case 0:
                                            System.out.println("Saliendo...");
                                            break;

                                        default:
                                            System.out.println("Opción no válida.");
                                    }
                                } while (opc2 != 0);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            break;

                        case 4:
                            try (Connection connection = ConexionBD.obtenerConexion()) {
                                RegistrosLavadoDAO registrosLavadoDAO = new RegistrosLavadoDAOImpl(connection);
                                int opc3;

                                do {
                                    System.out.println("\nMenu:");
                                    System.out.println("1. Registrar un registro de lavado");
                                    System.out.println("2. Leer Registros de lavado");
                                    System.out.println("3. Actualizar registros de lavado");
                                    System.out.println("4. Eliminar registros de lavado");
                                    System.out.println("5. Listar registros de lavado");
                                    System.out.println("0. Salir");
                                    System.out.print("Elige una opción: ");
                                    opc3 = scanner.nextInt();
                                    scanner.nextLine(); // Limpiar el buffer

                                    switch (opc3) {
                                        case 1: // Registrar
                                            System.out.println("Registro de lavado ID: ");
                                            int registroID = scanner.nextInt();
                                            System.out.print("VehiculoID: ");
                                            int VehiculoID = scanner.nextInt();
                                            System.out.print("ServicioID: ");
                                            int ServicioID = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Fecha de lavado (YYYY-MM-DD): ");
                                            String fechaLavado = scanner.nextLine();
                                            System.out.print("Hora de inicio (HH:MM:SS): ");
                                            String horaInicio = scanner.nextLine();
                                            System.out.print("Hora de fin (HH:MM:SS): ");
                                            String horaFin = scanner.nextLine();
                                            System.out.print("Precio total: ");
                                            double precioTotal = scanner.nextDouble();

                                            RegistrosLavado registrosLavado = new RegistrosLavado(registroID, VehiculoID, ServicioID, fechaLavado, horaInicio, horaFin, precioTotal);
                                            registrosLavadoDAO.crear(registrosLavado);
                                            System.out.println("Registro de lavado completado.");
                                            break;

                                        case 2: // Leer
                                            System.out.print("Ingrese el ID del vehiculo: ");
                                            int registroIDLeer = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                            RegistrosLavado RegL = registrosLavadoDAO.leer(registroIDLeer);
                                            if (RegL != null) {
                                                System.out.println(RegL);
                                            } else {
                                                System.out.println("Registro de lavado no encontrado.");
                                            }
                                            break;

                                        case 3: // Actualizar
                                            System.out.print("ID del Registro de lavado a actualizar: ");
                                            int RegistroLavadoActualizar = scanner.nextInt();
                                            scanner.nextLine(); // Limpiar el buffer
                                            RegistrosLavado RegLActualizar = registrosLavadoDAO.leer(RegistroLavadoActualizar);
                                            if (RegLActualizar != null) {
                                                System.out.print("Nuevo VehiculoID: ");
                                                RegLActualizar.setVehiculoID(scanner.nextInt());
                                                scanner.nextLine();
                                                System.out.print("Nuevo ServicioID: ");
                                                RegLActualizar.setServicioID(scanner.nextInt());
                                                scanner.nextLine();
                                                System.out.print("Nueva Fecha de lavado (YYYY-MM-DD): ");
                                                RegLActualizar.setFechaLavado(scanner.nextLine());
                                                System.out.print("Nueva Hora de inicio (HH:MM:SS): ");
                                                RegLActualizar.setHoradeInicio(scanner.nextLine());
                                                System.out.print("Nueva Hora de fin (HH:MM:SS): ");
                                                RegLActualizar.setHoradeFin(scanner.nextLine());
                                                System.out.print("Nuevo Precio total: ");
                                                RegLActualizar.setPrecioTotal(scanner.nextDouble());
                                                registrosLavadoDAO.actualizar(RegLActualizar);
                                                System.out.println("Registro de lavado actualizado.");
                                            } else {
                                                System.out.println("Registro de lavado no encontrado.");
                                            }
                                            break;

                                        case 4: // Eliminar
                                            System.out.print("Id del registro de lavado a eliminar: ");
                                            int RegistroLavadoIDEliminar = scanner.nextInt();
                                            scanner.nextLine();
                                            registrosLavadoDAO.eliminar(RegistroLavadoIDEliminar);
                                            System.out.println("Registro de lavado eliminado.");
                                            break;

                                        case 5: // Listar
                                            List<RegistrosLavado> listaRegistrosLavados = registrosLavadoDAO.listar();
                                            if (listaRegistrosLavados.isEmpty()) {
                                                System.out.println("No hay registros de lavado registrados.");
                                            } else {
                                                System.out.println("--- Lista de Registros de Lavado ---");
                                                for (RegistrosLavado p : listaRegistrosLavados) {
                                                    System.out.println(p);
                                                }
                                            }
                                            break;

                                        case 0:
                                            System.out.println("Saliendo...");
                                            break;

                                        default:
                                            System.out.println("Opción no válida.");
                                    }
                                } while (opc3 != 0);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }


                            break;

                        case 0:
                            System.out.println("Saliendo...");
                            break;

                        default:
                            System.out.println("Opción no válida.");
                    }
                } while (opcion != 0);
            }
        }

