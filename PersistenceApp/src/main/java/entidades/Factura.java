package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Factura")
public class Factura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column (name= "fecha")
	private String fecha;
	@Column (name= "numero")
	private int numero;
	@Column (name= "total")
	private int total;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name= "fk_cliente")
	private Cliente cliente;
	
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

	public Factura() {
		
	}

	public Factura(String fecha, int numero, int total, Cliente cliente, List<DetalleFactura> detalles) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.total = total;
		this.cliente = cliente;
		this.detalles = detalles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
	
	
}
