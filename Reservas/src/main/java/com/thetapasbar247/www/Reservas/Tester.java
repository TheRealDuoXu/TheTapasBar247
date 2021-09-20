package com.thetapasbar247.www.Reservas;

import java.util.Date;

public class Tester {
	
	public static void main(String args[]) {
		PersistenceManager pm = new PersistenceManager();
		pm.doPersist("Pepe", "pepe@yi.com", 645699420, new Date(), "12:12", 2, "yi es gay");
		
		final int PRINT_PERSISTED_OBJ = 0;
		pm.getAll(PRINT_PERSISTED_OBJ);
	}
}
