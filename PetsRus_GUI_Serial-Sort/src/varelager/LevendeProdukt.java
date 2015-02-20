package varelager;

import medlemmer.Leverandor;

public class LevendeProdukt extends Produkt{
	/**
	 * 
	 */
	private static final long serialVersionUID = -777194045154265511L;
	private static int antLevendeProdukter;
	private String slektsnavn, artsnavn;
	
	public String getSlektsnavn() {
		return slektsnavn;
	}

	public void setSlektsnavn(String slektsnavn) {
		this.slektsnavn = slektsnavn;
	}

	public String getArtsnavn() {
		return artsnavn;
	}

	public void setArtsnavn(String artsnavn) {
		this.artsnavn = artsnavn;
	}

	public static int getAntLevendeProdukter() {
		return antLevendeProdukter;
	}

	public void solgt() {
		antLevendeProdukter--; 
		super.solgt();
	}

	public LevendeProdukt(String produktnavn, double inkjPris, double pris,
			Leverandor leverandør, String slektsnavn, String artsnavn) {
		super(produktnavn, inkjPris, pris, leverandør);
		this.slektsnavn = slektsnavn;
		this.artsnavn = artsnavn;
		antLevendeProdukter++;
	}

	
	
}
