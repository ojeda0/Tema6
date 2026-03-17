package tarea;

import java.time.LocalDate;

import exceptions.FechaFinException;
import exceptions.FechaInicioException;
import exceptions.InvalidTareaDataException;
import exceptions.PrioridadInvalidaException;
import exceptions.TareaStateException;

public class Tarea {

	//ATRIBUTOS
	private String nombre;
	private TipoEstado estado;
	private int prioridad;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	//CONSTRUCTOR
	public Tarea() {
		
	}

	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		
		if(nombre == null) {
			
			throw new InvalidTareaDataException("ERROR. El nombre introducido no puede ser nulo.");
			
		}
		
		if(nombre.isBlank()) {
			
			throw new InvalidTareaDataException("ERROR. El nombre introducido no puede estar vacío.");
			
		}
		
		if(nombre.length() < 3) {
			
			throw new InvalidTareaDataException("ERROR. El nombre introducido debe tener 3 caracteres o más.");
			
		}
		
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado.toString();
	}

	public void setEstado(String estado) {
		
		if(estado == null) {
			
			throw new TareaStateException("ERROR. El estado introducido no puede ser nulo.");
			
		}
		
		if(!(estado.equalsIgnoreCase(TipoEstado.PENDIENTE.toString())) && !(estado.equalsIgnoreCase(TipoEstado.EN_PROGRESO.toString())) && !(estado.equalsIgnoreCase(TipoEstado.COMPLETADA.toString()))) {
			
			throw new TareaStateException("ERROR. El estado introducido debe ser un tipo de estado válido.");
			
		}
		
		this.estado = TipoEstado.valueOf(estado.toUpperCase());
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		
		if(prioridad < 1 || prioridad > 5) {
			
			throw new PrioridadInvalidaException("ERROR. La prioridad debe estar entre 1 y 5.");
			
		}
		
		this.prioridad = prioridad;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		
		if(fechaInicio == null) {
			
			throw new FechaInicioException("ERROR. La fecha de inicio introducida no puede ser nula.");
			
		}
		
		if(fechaInicio.isBefore(LocalDate.now())) {
			
			throw new FechaInicioException("ERROR. La fecha de inicio no puede ser anterior a la de hoy.");
			
		}
		
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		
		if(fechaFin == null) {
			
			throw new FechaFinException("ERROR. La fecha de fin introducida no puede ser nula.");
			
		}
		
		if(this.fechaInicio == null) {
			
			throw new FechaFinException("ERROR. Debe existir una fecha de inicio.");
			
		}
		
		if(fechaFin.isBefore(this.fechaInicio)) {
			
			throw new FechaFinException("ERROR. La fecha de fin no puede ser anterior a la de inicio");
			
		}
		
		this.fechaFin = fechaFin;
	}
	
	
}
