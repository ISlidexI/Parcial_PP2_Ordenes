package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenceApp {
public static void main (String[]args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
	EntityManager em = emf.createEntityManager();
	
	try {
		em.getTransaction().begin();
	
		Factura factura1 = new Factura();
		
		factura1.setNumero(12);
		factura1.setFecha("10/08/2020");
		
		Domicilio dom = new Domicilio("San Martin", 1222);
		Cliente cliente = new Cliente ("Pablo", "Nuñes", 15245778);
		cliente.setDomicilio(dom);
		dom.setCliente(cliente);
		
		factura1.setCliente(cliente);
		
		Categoria perecedero = new Categoria("Perecedero");
		Categoria lacteos = new Categoria("Lacteos");
		Categoria limpeza = new Categoria("Limpeza");
		
		Articulo art1 = new Articulo(200, "yogur", 20);
		Articulo art2 = new Articulo(300, "detergente magistral", 30);
		
		art1.getCategorias().add(lacteos);
		art1.getCategorias().add(perecedero);
		lacteos.getArticulos().add(art1);
		perecedero.getArticulos().add(art1);
		
		art2.getCategorias().add(limpeza);
		limpeza.getArticulos().add(art2);
		
		DetalleFactura detalle1 = new DetalleFactura();
		
		detalle1.setArticulo(art1);
		detalle1.setCantidad(2);
		detalle1.setSubtotal(40);
		
		art1.getDetalles().add(detalle1);
		factura1.getDetalles().add(detalle1);
		detalle1.setFactura(factura1);
		
		DetalleFactura detalle2 = new DetalleFactura();
		
		detalle2.setArticulo(art2);
		detalle2.setCantidad(1);
		detalle2.setSubtotal(80);
		
		art2.getDetalles().add(detalle2);
		factura1.getDetalles().add(detalle1);
		detalle1.setFactura(factura1);
		
		factura1.setTotal(120);
		
		em.persist(factura1);
		
		
		
		
		
		em.flush();
		
		em.getTransaction().commit();
		
	}catch (Exception e) {
		em.getTransaction().rollback();
	}
	
	em.close();
	emf.close();
}

}