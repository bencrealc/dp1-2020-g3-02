package org.springframework.samples.petclinic.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.samples.petclinic.enumerate.TipoEjercicio;

import lombok.Data;

@Data
@Entity
@Table(name = "ejercicios_individuales", uniqueConstraints = @UniqueConstraint(columnNames = { "nombre" }))
public class EjercicioIndividual extends BaseEntity {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ejercicio_individual")
	private Set<RealizaEjercicio> realiza_ejercicios;
	
	@ManyToMany
	@JoinTable(name = "seleRecomiendan", joinColumns = @JoinColumn(name = "ejercicio_individual_id"), 
	  inverseJoinColumns = @JoinColumn(name = "jugador_id"))
	Set<Jugador> jugadores;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "tipo_ejercicio", nullable = false)
	private TipoEjercicio tipoEjercicio;
	
	public EjercicioIndividual() {
	}

	public EjercicioIndividual(Set<RealizaEjercicio> realiza_ejercicios, Set<Jugador> jugadores, String nombre,
			String descripcion, TipoEjercicio tipoEjercicio) {
		super();
		this.realiza_ejercicios = realiza_ejercicios;
		this.jugadores = jugadores;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoEjercicio = tipoEjercicio;
	}

	@Override
	public String toString() {
		return "EjercicioIndividual [realiza_ejercicios=" + realiza_ejercicios + ", jugadores=" + jugadores
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipoEjercicio=" + tipoEjercicio + "]";
	}


	
}