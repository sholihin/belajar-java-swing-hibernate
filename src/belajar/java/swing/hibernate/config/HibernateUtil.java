package belajar.java.swing.hibernate.config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import belajar.java.swing.hibernate.model.Product;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author mohamad
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void createTable(){
        AnnotationConfiguration aConfig = new AnnotationConfiguration();
        aConfig.addAnnotatedClass(Product.class);
        aConfig.configure();
        
        Configuration config = aConfig;
        new SchemaExport(config).create(true, true);
    }
}
