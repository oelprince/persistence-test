package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil {
  private final EntityManagerFactory entityManagerFactory;
  
  public EntityManagerUtil() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("test");
        } catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
        }
  }

  public EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();

  }
}