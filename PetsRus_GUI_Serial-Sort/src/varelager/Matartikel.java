package varelager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import medlemmer.Leverandor;

public class Matartikel extends Artikel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6621523267973679743L;
	private static int antMatartikler;
	private Calendar bestFoer;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
	
	public void solgt(){
		antMatartikler--;
		super.solgt();
	}

	public Matartikel(String produktnavn, double inkjPris, double pris,
			Leverandor leverandør, int antiartikel, Calendar bestFoer) {
		super(produktnavn, inkjPris, pris, leverandør, antiartikel);
		this.bestFoer = bestFoer;
		antMatartikler++;
	}


	public String getBestFoer() {
		return dateFormat.format(bestFoer.getTime());
	}

	public void setBestFoer(Calendar bestFoer) {
		this.bestFoer = bestFoer;
	}

	public static int getAntMatartikler() {
		return antMatartikler;
	}
	
}
