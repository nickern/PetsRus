package gui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LagreProdukter {
	private String path;
	private ArrayList<Object> objList;
	
	//konstruktør
	public LagreProdukter(String path, ArrayList<Object> objList) {
		this.path = path;
		this.objList = objList;
		
		
		//sletter innhold i filen ved bruk av metoden delFileContent()
		delFileContent();
		
		// kaller metoden lagreData
		lagreTilFil();
	}
	
	private void lagreTilFil() {
		
		
		try {
			// åpne strøm til fil
			FileOutputStream outStream = new FileOutputStream(path);
			
			// åpner objektstrøm til fil
			ObjectOutputStream objStream = new ObjectOutputStream(outStream);
			
			// gå igjennom liste og skriv til til
			for(Object obj : objList) {
				objStream.writeObject(obj);
			}
			
			// lukker strømmer
			objStream.close();
			outStream.close();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Finner ikke filen!!", "Error!", 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR: Kan ikke åpne objektstrøm til filen!", "Error!", 0);
		}
		
	}
	
	//slette innhold i fil
	private void delFileContent(){
		try {
			// åpner strøm til fil med append satt til sant
			FileWriter fWriter = new FileWriter(path, false);
			
			// overskriver all data i filen med en tom String
			fWriter.write("");
			
			// lukker strømmen
			fWriter.close();
			
		// fanger evt feil 
		} catch (IOException e) {
			System.out.println("Error: finner ikke filen");
		}
	}
	
	
	//get og set
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
}