package main;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.InvalidTareaDataException;
import exceptions.PrioridadInvalidaException;
import exceptions.TareaStateException;
import tarea.Tarea;

public class Main {

	public static void main(String[] args) {
		
		//ESCÁNER
		Scanner sc = new Scanner(System.in);

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
				
				sc.reset();
				
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
				
				sc.reset();
				
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



		
		
	}

}
