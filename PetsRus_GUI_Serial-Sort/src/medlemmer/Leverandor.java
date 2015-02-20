package medlemmer;

import java.io.Serializable;

public class Leverandor implements Serializable, Comparable<Leverandor> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8632224297507051968L;
	private String  navn, epost, adr, psted, tlf;	
	private int pnr; 

	public Leverandor(String navn, String epost, String adr, String psted,
			String tlf, int pnr) {
		
		super();
		this.navn = navn;
		this.epost = epost;
		this.adr = adr;
		this.psted = psted;
		this.tlf = tlf;
		this.pnr = pnr;
	}
	
	@Override
	public String toString(){
		return navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getPsted() {
		return psted;
	}

	public void setPsted(String psted) {
		this.psted = psted;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}


	@Override
	public int compareTo(Leverandor l) {
		
		String lev1 = this.getNavn().toUpperCase();
	    String lev2 = l.getNavn().toUpperCase();
		
		return lev1.compareTo(lev2);
	}
	
}
