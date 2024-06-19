package entidades;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detalle_factura")
public class DetalleFactura implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column (name= "cantidad")
	private int cantidad;
	
	@Column (name= "subtotal")
	private int subtotal;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn (name = "fk_factura")
	private Factura factura;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn (name = "fk_articulo")
	private Articulo articulo;
	
	public DetalleFactura() {
	}
	
	public DetalleFactura(int cantidad, int subtotal) {
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int setCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void getSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public DetalleFactura(int cantidad, int subtotal, Factura factura) {
		super();
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.factura = factura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public void setArticulo(Articulo art1) {
		// TODO Auto-generated method stub
		
	}
	
}


	
