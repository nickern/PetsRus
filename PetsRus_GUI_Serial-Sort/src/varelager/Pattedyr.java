package varelager;

import medlemmer.Leverandor;

public class Pattedyr extends LevendeProdukt {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7151367090628086815L;
	private static int antPatteDyr;
	
	public void solgt() {
		antPatteDyr--; 
		super.solgt();
	}
	public Pattedyr(String produktnavn, double inkjPris, double pris,
			Leverandor leverand�r, String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverand�r, slektsnavn, artsnavn);
		antPatteDyr++;
	}
	public static int getAntPatteDyr() {
		return antPatteDyr;
	}
	
}
