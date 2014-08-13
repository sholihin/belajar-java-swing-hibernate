package belajar.java.swing.hibernate;

import belajar.java.swing.hibernate.config.HibernateUtil;
import belajar.java.swing.hibernate.model.Product;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mohamad
 */
public class MainClass {

    public static void main(String[] args) {
        int proses = 1;
        switch(proses){
            case 0 : HibernateUtil.createTable();
                return;
            case 1 : insertData();
                return;
        }
        
    }
    
    private static void insertData(){
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();

            Product product = new Product();
            product.setBarcode("br002");
            product.setName("Ujang");
            product.setPrice(BigDecimal.valueOf(9000));
            session.save(product);
            tr.commit();
            System.out.println("berhasil menyimpan");
        } catch (Exception e) {
            System.out.println("gagal menyimpan "+e);
        }
        
    }
    
}
