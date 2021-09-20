package com.thetapasbar247.www.Reservas;
import java.util.*;
import javax.persistence.*;

public class PersistenceManager {
	private static final String PERSISTENCE_UNIT_NAME = "Reservas";
	
	public int doPersist(String fullname, String email,
	int phone, Date date, String time, int people, String aditional) {
		//inicializar una factoria para la persistencia, Reservas
		EntityManagerFactory f = 
				Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		//toda las transacciones las lleva a cabo un entity manager
		EntityManager em = f.createEntityManager();
		
		//utilizaremos la forma lipia de realizar las transacciones
		EntityTransaction et = em.getTransaction();
		et.begin();
		Reserva r = new Reserva();
		
		r.setFullname(fullname);
		r.setEmail(email);
		r.setPhone(phone);
		r.setDate(date);
		r.setTime(time);
		r.setPeople(people);
		r.setAditional(aditional);
		try {
		em.persist(r);
		et.commit();
		}catch(PersistenceException e) {
			return -1;
		}finally {
			em.close();
		}
		return 0;
	}
	public List<Reserva> getAll(int action) {
		//inicializar una factoria para la persistencia, Reservas
		EntityManagerFactory f = 
			Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		//toda las transacciones las lleva a cabo un entity manager
		EntityManager em = f.createEntityManager();
		
		//SQL query sentenciaaa
		String SQL_TODOS = "select t from Reserva";
		Query q = em.createQuery(SQL_TODOS);
		
		//recuperar
		List<Reserva> agenda = q.getResultList();
		
		switch(action) {
		case 1:
			for(Reserva entrada:agenda) {
				entrada.print();
			}
		case 0:
			return agenda;
		}
		
		return null;
	}
	
	public Reserva find(long id) {
		//inicializar una factoria para la persistencia, Reservas
			EntityManagerFactory f = 
				Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		//toda las transacciones las lleva a cabo un entity manager
		EntityManager em = f.createEntityManager();
		return em.find(Reserva.class, id);
	}
}
