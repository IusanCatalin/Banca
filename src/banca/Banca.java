package banca;

import java.util.ArrayList;
import java.util.List;

public class Banca {
	private static List<Client> clienti = new ArrayList<>();
	
	public static void adauga_client(Client c) {
		clienti.add(c);
		System.out.print("adaugat");
		System.out.print(c.getCnp());
	}
	
	public static void sterge_client(Client c) {
		clienti.remove(c);
	}
	
	public static void set_monitorizare(String cnp) {
		System.out.println(cnp);
		for(Client c : clienti ) {
			if(c.getCnp().equals(cnp)) {
				c.set_monitorizare(true);
			}
		} 
	}
	public static void remove_monitorizare(String cnp) {
		for(Client c : clienti ) {
			if(c.getCnp().equals(cnp)) {
				c.set_monitorizare(false);
			}
		}
	}
}
