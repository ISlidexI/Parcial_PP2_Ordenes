package entidades;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="domicilio")
public class Domicilio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column (name= "nombre_calle")
	private String nombre_calle;
	
	@Column (name= "numero")
	private int numero;
	
	@OneToOne(mappedBy="domicilio")
	private Cliente cliente;
	
	public Domicilio() {
	}
	
	public Domicilio(String nombre_calle,  int numero) {
		this.nombre_calle = nombre_calle;
		this.numero = numero;
	}
	
	
	
	public Domicilio(String nombre_calle, int numero, Cliente cliente) {
		super();
		this.nombre_calle = nombre_calle;
		this.numero = numero;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_calle() {
		return nombre_calle;
	}
	public void setNombre_calle(String nombre_calle) {
		this.nombre_calle = nombre_calle;
	}
	public int getNumero() {
		return numero;
	}
	public void getNumero(int numero) {
		this.numero = numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
