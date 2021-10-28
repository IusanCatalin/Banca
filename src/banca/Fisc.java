package banca;

import java.util.ArrayList;
import java.util.List;

public class Fisc implements Actiuni_fisc {
	private static List<String> lista_monitorizari = new ArrayList<>();
	private static List<String> mesaje_monitorizari = new ArrayList<>();
	
	public List<String> getLista_monitorizari() {
		return lista_monitorizari;
	}
	public void setLista_monitorizari(List<String> lista_monitorizari) {
		Fisc.lista_monitorizari = lista_monitorizari;
	}
	public List<String> getMesaje_monitorizari() {
		return mesaje_monitorizari;
	}
	public void setMesaje_monitorizari(List<String> mesaje_monitorizari) {
		Fisc.mesaje_monitorizari = mesaje_monitorizari;
	}
	@Override
	public void adauga_monitorizare(String cnp) {
		Fisc.lista_monitorizari.add(cnp);
		Fisc.mesaje_monitorizari.add("");
		Banca.set_monitorizare(cnp);
		System.out.println("Fisc now monitorizing "+cnp + "'s account");
	}
	@Override
	public void elimina_monitorizare(String cnp) {
		int index = Fisc.lista_monitorizari.indexOf(cnp);
		Fisc.mesaje_monitorizari.remove(index);		
		Fisc.lista_monitorizari.remove(cnp);
		Banca.remove_monitorizare(cnp);
		System.out.println("Fisc stopped monitorizing "+cnp  + "'s account");
	} 
	
	public static void adauga_mesaj(String cnp, String message) {
		int index = Fisc.lista_monitorizari.indexOf(cnp);
		Fisc.mesaje_monitorizari.set(index, Fisc.mesaje_monitorizari.get(index) + message + "\n" );
		GUI_fisc.add_toLabel(message);
	}
	

}
