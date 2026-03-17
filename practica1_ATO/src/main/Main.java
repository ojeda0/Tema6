package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.FechaFinException;
import exceptions.FechaInicioException;
import exceptions.InvalidTareaDataException;
import exceptions.PrioridadInvalidaException;
import exceptions.TareaStateException;
import tarea.Tarea;

public class Main {

	public static void main(String[] args) {
		
		//ESCÁNER
		Scanner sc = new Scanner(System.in);

		//FORMATO FECHA
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		//ATRIBUTOS
		String nombre;
		String estado;
		int prioridad;
		LocalDate fechaInicio;
		LocalDate fechaFin;
		
		//BOOLEANS
		boolean nombreValido = false;
		boolean estadoValido = false;
		boolean prioridadValida = false;
		boolean fechaInicioValida = false;
		boolean fechaFinValida = false;
		
		//CREAR TAREA VACIA
		Tarea t = new Tarea();
		
		
		//DO NOMBRE
		do {
			
			try {
				
				System.out.println("Introduce el nombre de la tarea: ");
				nombre = sc.nextLine();
				
				t.setNombre(nombre);
				nombreValido = true;
				
			}
			catch(InvalidTareaDataException ex) {
				
				System.out.println(ex.getMessage());
				
			}
			
		}while(!nombreValido);
		
		
		//DO ESTADO
		do {
			
			try {
				
				System.out.println("Introduce el estado de la tarea: ");
				estado = sc.nextLine();
				
				t.setEstado(estado);
				estadoValido = true;
				
			}
			catch(TareaStateException ex) {
				
				System.out.println(ex.getMessage());
				
			}
			
		}while(!estadoValido);
		
		
		//DO PRIORIDAD
		do {
			
			try {
				
				System.out.println("Introduce la prioridad de la tarea: ");
				prioridad = sc.nextInt();
				
				sc.nextLine();
				
				t.setPrioridad(prioridad);
				prioridadValida = true;
				
			}
			catch(PrioridadInvalidaException ex) {
				
				System.out.println(ex.getMessage());
				
			}
			catch(InputMismatchException ime) {
				
				System.out.println("ERROR. No se puede introducir una letra como prioridad.");
				sc.nextLine();
				
			}
			
		}while(!prioridadValida);


		//DO FECHA INICIO
		do {
			
			try {
				
				System.out.println("Introduce la fecha de inicio de la tarea: ");
				fechaInicio = LocalDate.parse(sc.nextLine(), formatoFecha);
				
				t.setFechaInicio(fechaInicio);
				fechaInicioValida = true;
				
			}
			catch(DateTimeParseException ex) {
				
				System.out.println("ERROR. La fecha ha sido introducida en un formato erróneo.");
				
			}
			catch(FechaInicioException fex) {
				
				System.out.println(fex.getMessage());
				
			}
			
		}while(!fechaInicioValida);

		
		//DO FECHA FIN
		do {
			
			try {
				
				System.out.println("Introduce la fecha de fin de la tarea: ");
				fechaFin = LocalDate.parse(sc.nextLine(), formatoFecha);
				
				t.setFechaFin(fechaFin);
				fechaFinValida = true;
				
			}
			catch(DateTimeParseException ex) {
				
				System.out.println("ERROR. La fecha ha sido introducida en un formato erróneo.");
				
			}
			catch(FechaFinException fex) {
				
				System.out.println(fex.getMessage());
				
			}
			
		}while(!fechaFinValida);
		
		System.out.printf("La tarea \"%s\" ha sido registrada con éxito.", t.getNombre());
		
		sc.close();
		
	}

}
