package varelager;

import java.io.Serializable;
import java.util.Comparator;

import medlemmer.Leverandor;

public class Produkt implements Serializable, Comparable<Produkt> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2990459514038266727L;
	private String produktnavn;
	private double inkjPris, pris;
	private Leverandor leverand�r;
	private static int antProdukter;
	
	public void solgt(){
		antProdukter--;
	}
	
	@Override
	public String toString(){
		return produktnavn + " - " + pris + "kr";
	}

	public Produkt(String produktnavn, double inkjPris, double pris,
			Leverandor leverand�r) {
		super();
		this.produktnavn = produktnavn;
		this.inkjPris = inkjPris;
		this.pris = pris;
		this.leverand�r = leverand�r;
		antProdukter++; 
	}

	public String getProduktnavn() {
		return produktnavn;
	}

	public void setProduktnavn(String produktnavn) {
		this.produktnavn = produktnavn;
	}

	public double getInkjPris() {
		return inkjPris;
	}

	public void setInkjPris(double inkjPris) {
		this.inkjPris = inkjPris;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public Leverandor getLeverand�r() {
		return leverand�r;
	}

	public void setLeverand�r(Leverandor leverand�r) {
		this.leverand�r = leverand�r;
	}

	public static int getAntProdukter() {
		return antProdukter;
	}

	@Override
	public int compareTo(Produkt p) {
		return Double.compare(this.pris, p.pris);
	}
	
	public static Comparator<Produkt> ProduktComparator = new Comparator<Produkt>() {

	public int compare(Produkt prod1, Produkt prod2) {
	
	String produkt1 = prod1.getProduktnavn().toUpperCase();
	String produkt2 = prod2.getProduktnavn().toUpperCase();
	
	return produkt1.compareTo(produkt2);

	}
	
	};
	

}
