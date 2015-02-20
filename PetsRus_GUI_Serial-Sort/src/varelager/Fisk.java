package varelager;

import medlemmer.Leverandor;

public class Fisk extends LevendeProdukt {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4125383195208904164L;
	private static int antFisker;
	
	public void solgt(){
		antFisker--;
		super.solgt();
	}

	public Fisk(String produktnavn, double inkjPris, double pris,
			Leverandor leverandør, String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandør, slektsnavn, artsnavn);
		antFisker++;
 	}

	public static int getAntFisker() {
		return antFisker;
	}
	
}
