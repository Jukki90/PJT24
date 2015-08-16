package com.example.fw;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static /*final*/ SessionFactory sessionFactory = buildSessionFactory();

    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
           // return new Configuration().configure().buildSessionFactory(); 
        	  Configuration configuration = new Configuration();
        	    configuration.configure();
        	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
        	            configuration.getProperties()). buildServiceRegistry();
        	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	    return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
