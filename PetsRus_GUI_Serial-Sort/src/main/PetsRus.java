package main;

import gui.MainFrame;

import javax.swing.SwingUtilities;

import varelager.*;
import medlemmer.Leverandor;


public class PetsRus {
	
	// Jobber kun fra 1 mappe så lager variable så det er enklere. 
	// Setter filLoc til public så det er enklere å få tilgang til den. 
	private static String temp = System.getProperty("user.home");
	public static String fileLoc = temp + "\\Dropbox\\School\\OOP2014\\div\\";

	public static void main(String[] args) {
		
		// Kun brukt til test
	//	leggTil();
		
		// Legg til produkter og leverandører
		new LastProdukter(fileLoc+"lev.ser");
		new LastProdukter(fileLoc+"prod.ser");
		
		// Start GUI
		SwingUtilities.invokeLater(new Runnable() {

			 @Override
			 public void run() {
				 MainFrame frame = new MainFrame();
				 frame.setVisible(true);
			}
		 });
		
		// brukt for testing og for å hente ut div. system info
	//	System.out.println(System.getProperties());
		
		
	}
	
	@SuppressWarnings("unused")
	private static void leggTil(){
		
		MainFrame.getLeverandorList().add(new Leverandor("Fish Tank", "fish@fish.no", "Gate 2", "Halden", "+4799988774", 1770));
		MainFrame.getLeverandorList().add(new Leverandor("Time", "melk@melk.no", "Gate 3", "Halden", "+4711223586", 1771));

		MainFrame.getFiskList().add(new Fisk("Gullfisk", 50, 100, MainFrame.getLeverandorList().get(0), "Gull", "Fisk"));
		MainFrame.getReptilList().add(new Reptil("Gekko", 25, 50, MainFrame.getLeverandorList().get(0), "Gekko", "Kryp"));
		MainFrame.getPattedyrList().add(new Pattedyr("The Fox", 100, 200, MainFrame.getLeverandorList().get(0), "Blub", "Moo"));
	}
}

