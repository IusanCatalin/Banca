package banca;

public class Client implements Actiuni_client {
	private String cnp; //daca mergeam cu un tip de date numeric nu recunostea '0' din fata
	private double sold_ron;
	private double sold_euro;
	private boolean monitorizare = false;
	
	Client(String cnp){
		this.cnp = cnp;
	}
	Client(){
		this.cnp = "";
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public double getSold_ron() {
		return sold_ron;
	}
	public void setSold_ron(double sold_ron) {
		this.sold_ron = sold_ron;
	}
	public double getSold_euro() {
		return sold_euro;
	}
	public void setSold_euro(double sold_euro) {
		this.sold_euro = sold_euro;
	}
	@Override
	public void creaza_cont() {
		this.sold_euro = 0.0;
		this.sold_ron = 0.0;	
		Banca.adauga_client(this);
	}
	@Override
	public void lichidare() {
		if( this.sold_euro == 0.0 && this.sold_ron == 0.0) {			
			System.out.println("The client "+ this.cnp +"'s account was deleted.");
			this.cnp = "";
			Banca.sterge_client(this);
		} 
		else
		{
			System.out.println("The client " + this.cnp + " needs to get "+ this.sold_euro+"EUR and "+ this.sold_ron+"RON.");
			this.sold_euro = 0;
			this.sold_ron = 0;
			this.cnp = "";
			Banca.sterge_client(this);
		}	
	}
	@Override
	public void depozit(double suma, String curency) {
		if(curency.equals("RON")) {
			this.sold_ron = this.sold_ron + suma;
			System.out.println("Client "+ this.cnp + " added " + suma +"RON in his account.");
			if(this.monitorizare==true) {
				System.out.println("monitorizare true");
				String msg = "Fisc:Client "+ this.cnp + " added " + suma +"RON in his account.";
				Fisc.adauga_mesaj(this.cnp, msg);
			}
		}
		else {
			this.sold_euro = this.sold_euro + suma;
			System.out.println("Client "+ this.cnp + " added " + suma +"EUR in his account.");
			if(this.monitorizare==true) {
				String msg = "Fisc:Client "+ this.cnp + " added " + suma +"EUR in his account.";
				Fisc.adauga_mesaj(this.cnp, msg);
			}
		}		
	}
	@Override
	public void retragere(double suma, String curency) {
		if(curency.equals("RON") & this.sold_ron - suma > 1000.0) {
			this.sold_ron = this.sold_ron - suma;
			System.out.println("Client "+ this.cnp + " withdrawed " + suma +"RON from his account.");
			if(this.monitorizare==true) {
				String msg = "Fisc:Client "+ this.cnp + " withdrawed " + suma +"RON from his account.";
				Fisc.adauga_mesaj(this.cnp, msg);
			}
		}
		else if(curency.equals("EUR") & this.sold_euro - suma > 1000.0) {
			this.sold_euro = this.sold_euro - suma;
			System.out.println("Client "+ this.cnp + " withdrawed " + suma +"EUR from his account.");
			if(this.monitorizare==true) {
				String msg = "Fisc:Client "+ this.cnp + " withdrawed " + suma +"EUR from his account.";
				Fisc.adauga_mesaj(this.cnp, msg);
			}
		}	
		else if(curency.equals("EUR") & this.sold_euro - suma < 1000.0) {
			System.out.println("The amount exceeds the curent EUR funds");
		}
		else if(curency.equals("RON") & this.sold_euro - suma < 1000.0) {
			System.out.println("The amount exceeds the curent RON funds");
		}
	}
	@Override
	public void sold() {
		System.out.println("The account has " + this.sold_ron+"RON and " + this.sold_euro +"EUR.");	
		
	}
	
	public String get_sold() {
		return("The account has " + this.sold_ron+"RON and " + this.sold_euro +"EUR.");
	}
	
	public void set_monitorizare(boolean b) {
		this.monitorizare = b;
		System.out.println("s-a monitorizat");
	}
}
