package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ALQUILERES")
public class AlquilerEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
	@Column(name="ID_ALQUILERES")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlquiler")
	@SequenceGenerator(sequenceName = "SEQ_ALQUILERES", allocationSize = 1, name = "seqAlquiler")
	private Long id;
	
	@Column(name="FECHASALIDA")
	private Date fechasalida;
	
	@Column(name="FECHAENTRADA")
	private Date fechaentrada;
	
	@ManyToOne
	@JoinColumn (name ="ID_LECTOR", nullable = false)
	private LectorEntity lector;
	
	@ManyToOne
	@JoinColumn (name ="ID_LIBRO", nullable = false)
	private LibroEntity libro; 
}
