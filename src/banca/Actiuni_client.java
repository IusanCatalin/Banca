package banca;

public interface Actiuni_client {
	public void creaza_cont();
	public void lichidare();
	public void depozit(double suma, String curency);
	public void retragere(double suma, String curency);
	public void sold();

}
