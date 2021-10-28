package banca;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		new GUI_client();
		new GUI_fisc();
		
		Banca b = new Banca();
		Fisc f = new Fisc();
		Client c1 = new Client("123443126");
		Client c2 = new Client("199035523");
		Client c3 = new Client("333336939");
		Client c4 = new Client("000010100");
		
		c1.creaza_cont();
		c2.creaza_cont();
		c3.creaza_cont();
		c4.creaza_cont();
		c1.depozit(1000, "EUR");
		c1.depozit(1000, "RON");
		c2.depozit(1500, "EUR");
		c2.depozit(1500, "RON");
		c3.depozit(2000, "EUR");
		c3.depozit(2000, "RON");
		c3.retragere(550.55, "EUR");
		c2.retragere(250, "RON");
		c3.retragere(500, "EUR");
		c3.sold();
		c3.lichidare();
		c4.lichidare();
		f.adauga_monitorizare(c1.getCnp());
		f.adauga_monitorizare(c2.getCnp());
		c1.depozit(1000, "EUR");
		c1.depozit(1000, "RON");
		c2.retragere(50, "EUR");
		c2.retragere(50, "EUR");
		f.elimina_monitorizare(c1.getCnp());
		List <String> mesaje = f.getMesaje_monitorizari();
		mesaje.forEach(System.out::print);
		
	}
}
