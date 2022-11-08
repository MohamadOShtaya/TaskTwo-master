package com.quizplus.tasktwo.Rerpositry;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
    private static SessionFactory sessionFactory ;
   static {
       Configuration config = new Configuration();
       config.configure();
       sessionFactory = config.buildSessionFactory();
   }
   public static SessionFactory getSessionFactory(){
       return sessionFactory;
   }
}