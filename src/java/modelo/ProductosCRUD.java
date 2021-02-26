/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.*;
import java.util.List;


/**
 *
 * @author Donus
 */
public class ProductosCRUD {
    
    public static List<Productos> getProductos() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM productos";
        Query q = manager.createNativeQuery(sql,Productos.class); //método para consultas en SQL
        List<Productos> productosBD =  q.getResultList();

        return productosBD;        
        }
    
     public static int actualizaProductoTest() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.categoria = 'zumos' WHERE p.id = 10";
        Query q = manager.createQuery(sql,Productos.class);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;      
    }
    
     public static int actualizaProducto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_ProductosCRUD_war_1PU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.nombre = :nombre, p.imagen = :imagen, p.categoria = :categoria, p.precio = :precio WHERE p.id = 10";
        Query q = manager.createQuery(sql,Productos.class);
        q.setParameter("categoria", "Digestivos");
        q.setParameter("nombre", "Pacharán");
        q.setParameter("imagen", "pacharan.jpg");
        q.setParameter("precio", 4.0);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;      
    }
    
}
