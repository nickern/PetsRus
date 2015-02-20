package main;

import gui.MainFrame;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Reptil;

public class LastProdukter {
	private String path;

	// konstruktør
	public LastProdukter(String path) {
		this.path = path;
		lesData();
	}

	private void lesData() {

		FileInputStream inStream = null;

		ObjectInputStream objInStream = null;

		try {
			// åpner strømmer
			inStream = new FileInputStream(path);

			objInStream = new ObjectInputStream(inStream);

			Object object = null;

			// går igjennom alle objekter i filen og legger dem i Arraylist'ene
			while ((object = objInStream.readObject()) != null) {
				
				if (object instanceof Leverandor) {
					MainFrame.getLeverandorList().add((Leverandor) object);
					
				} else if (object instanceof Fisk) {
					MainFrame.getFiskList().add((Fisk) object);

				} else if (object instanceof Pattedyr) {
					MainFrame.getPattedyrList().add((Pattedyr) object);
					
				} else if (object instanceof Reptil) {
					MainFrame.getReptilList().add((Reptil) object);
					
				} else {
					JOptionPane.showMessageDialog(null, "ERROR: Finner ikke leverandør eller varer i filen!", "Error!", 0);
				}
			}

			// lukker strømmer
			objInStream.close();
			inStream.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Finner ikke filen!!", "Error!", 0);

		} catch (EOFException e) {

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// get og set
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
