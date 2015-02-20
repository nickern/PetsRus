package varelager;

import medlemmer.Leverandor;

public class Reptil extends LevendeProdukt {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4050270531914712282L;
	private static int antReptiler;
	public void solgt() {
		antReptiler--;
		super.solgt();
	}
	public Reptil(String produktnavn, double inkjPris, double pris,
			Leverandor leverandÝr, String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandÝr, slektsnavn, artsnavn);
		antReptiler++;
	}
	public static int getAntReptiler() {
		return antReptiler;
	}
	
}
