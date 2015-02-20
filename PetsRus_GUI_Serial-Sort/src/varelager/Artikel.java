package varelager;

import medlemmer.Leverandor;

public class Artikel extends Produkt {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7920356363915720149L;
	private static int antArtikler;
	private int antiartikel;
	
	public void solgt() {
		antArtikler--;
		super.solgt();		
	}

	public Artikel(String produktnavn, double inkjPris, double pris,
			Leverandor leverandør, int antiartikel) {
		super(produktnavn, inkjPris, pris, leverandør);
		this.antiartikel = antiartikel;
		antArtikler++;
	}

	public static int getAntArtikler() {
		return antArtikler;
	}

	public static void setAntArtikler(int antArtikler) {
		Artikel.antArtikler = antArtikler;
	}

	public int getAntiartikel() {
		return antiartikel;
	}

	public void setAntiartikel(int antiartikel) {
		this.antiartikel = antiartikel;
	}
}
