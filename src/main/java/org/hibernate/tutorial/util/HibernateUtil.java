package org.hibernate.tutorial.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory sessionFactory=buildsessionfactory();

private static SessionFactory buildsessionfactory() {
	try
	{
	return new Configuration().configure().buildSessionFactory();
	}
	finally
	{
		
	}
}

public static SessionFactory getSessionFactory()
{
	return sessionFactory;
}
}
