package entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "articulo")
public class Articulo implements Serializable{
	
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name= "cantidad")
	private int cantidad;
	
	@Column (name= "denominacion")
	private String denominacion;
	
	@Column (name= "precio")
	private int precio;
	
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "articulo_categorias",
			joinColumns= @JoinColumn(name= "articulo_id"),
			inverseJoinColumns= @JoinColumn(name = "categorias_id")
			)
	
	private List<Categoria> categorias = new ArrayList<Categoria>();
	public Articulo() {
    }

    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    public Articulo(String denominacion, int cantidad, int precio, List<DetalleFactura> detalles) {
        this.denominacion = denominacion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.detalles = detalles;
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	
	
	}