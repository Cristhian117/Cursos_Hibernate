package com.cursos_online;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cursos_online.entidades.Curso;

public class Main {

	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Curso curso = new Curso("Nuevo Curso");
		session.save(curso);
		
		session.getTransaction().commit();
		session.close();

	}

}
