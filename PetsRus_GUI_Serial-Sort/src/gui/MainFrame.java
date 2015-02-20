package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.LastProdukter;
import main.PetsRus;
import medlemmer.*;
import varelager.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;

import javax.swing.ListSelectionModel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9066261409068480574L;

	private JPanel contentPane;
	
	DefaultListModel<Object> modelLev;
	DefaultListModel<Object> modelReptil;
	DefaultListModel<Object> modelFisk;
	DefaultListModel<Object> modelPattedyr;
	
	// Array over ting i systemet
	private static ArrayList<Leverandor> leverandorList = new ArrayList<>();
	private static ArrayList<Fisk> fiskList = new ArrayList<>();
	private static ArrayList<Reptil> reptilList = new ArrayList<>();
	private static ArrayList<Pattedyr> pattedyrList = new ArrayList<>();
	
	public static ArrayList<Leverandor> getLeverandorList() {
		return leverandorList;
	}


	public static ArrayList<Fisk> getFiskList() {
		return fiskList;
	}


	public static ArrayList<Reptil> getReptilList() {
		return reptilList;
	}


	public static ArrayList<Pattedyr> getPattedyrList() {
		return pattedyrList;
	}
	
	// list over ting i systemet 
	private JList<Object> LeverandorLists;
	private JList<Object> ListFisk;
	private JList<Object> ListReptil;
	private JList<Object> ListPattedyr;
	
	
	private JLabel lblAntallPrduktN;
	private JLabel lblAntallFiskN;
	private JLabel lblAntallPattedyrN;
	private JLabel lblAntallReptilN;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				
				updateValues();
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setTitle("Pets R' Us");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 406);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFil = new JMenu("Fil");
		menuBar.add(mnFil);
		
		JMenuItem mntmpne = new JMenuItem("\u00C5pne");
		mntmpne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				   System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
				   System.out.println("Location: " + chooser.getSelectedFile().getPath());
				   
				   new LastProdukter(chooser.getSelectedFile().getPath());
				   
				}
			}
		});
		mnFil.add(mntmpne);
		
		JMenuItem mntmLagre = new JMenuItem("Lagre");
		mntmLagre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					// legger leverandører i objekt list
					ArrayList<Object> objLeverandor = new ArrayList<>();
					
					for(Leverandor l : leverandorList) {
						objLeverandor.add(l);
					}
					
					
					// legger varer i objekt list
					ArrayList<Object> objVareList = new ArrayList<>();
					
					for(Fisk f : fiskList) {
						objVareList.add(f);
					}
					for(Pattedyr p : pattedyrList) {
						objVareList.add(p);
					}
					for(Reptil r : reptilList) {
						objVareList.add(r);
					}
					
					// lagrer varelager og leverandører
					new LagreProdukter(PetsRus.fileLoc+"lev.ser", objLeverandor);
					new LagreProdukter(PetsRus.fileLoc+"prod.ser", objVareList);
					
					JOptionPane.showMessageDialog(null, "Info lagret!", "OK!", 1);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "ERROR: Fikk ikke lagret!", "Error!", 0);
				}
			}
		});
		mnFil.add(mntmLagre);
		
		JMenu mnLeggTil = new JMenu("Legg til..");
		menuBar.add(mnLeggTil);
		
		JMenuItem mntmLeverandr = new JMenuItem("Leverand\u00F8r");
		mntmLeverandr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddLeverandor addLev = new AddLeverandor();
				addLev.setVisible(true);
			}
		});
		
		JMenu mnDyr = new JMenu("Dyr");
		mnLeggTil.add(mnDyr);
		
		JMenuItem mntmFisk = new JMenuItem("Fisk");
		mntmFisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFisk addFisk = new AddFisk();
				addFisk.setVisible(true);
			}
		});
		mnDyr.add(mntmFisk);
		
		JMenuItem mntmPattedyr = new JMenuItem("Pattedyr");
		mntmPattedyr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPattedyr addPatt = new AddPattedyr();
				addPatt.setVisible(true);
			}
		});
		mnDyr.add(mntmPattedyr);
		
		JMenuItem mntmReptil = new JMenuItem("Reptil");
		mntmReptil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddReptil addReptil = new AddReptil();
				addReptil.setVisible(true);
			}
		});
		mnDyr.add(mntmReptil);
		mnLeggTil.add(mntmLeverandr);
		
		JMenu mnSelg = new JMenu("Selg/Fjern...");
		menuBar.add(mnSelg);
		
		JMenu mnDyr_1 = new JMenu("Dyr");
		mnSelg.add(mnDyr_1);
		
		JMenuItem mntmFisk_1 = new JMenuItem("Fisk");
		mntmFisk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveFisk removeFisk = new RemoveFisk();
				removeFisk.setVisible(true);
			}
		});
		mnDyr_1.add(mntmFisk_1);
		
		JMenuItem mntmPattedyr_1 = new JMenuItem("Pattedyr");
		mntmPattedyr_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemovePattedyr removePattedyr = new RemovePattedyr();
				removePattedyr.setVisible(true);
			}
		});
		mnDyr_1.add(mntmPattedyr_1);
		
		JMenuItem mntmReptil_1 = new JMenuItem("Reptil");
		mntmReptil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveReptil removeReptil = new RemoveReptil();
				removeReptil.setVisible(true);
			}
		});
		mnDyr_1.add(mntmReptil_1);
		
		JMenuItem mntmLeverandr_1 = new JMenuItem("Leverand\u00F8r");
		mntmLeverandr_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveLeverandor removeLev = new RemoveLeverandor();
				removeLev.setVisible(true);
			}
		});
		mnSelg.add(mntmLeverandr_1);
		
		JMenu mnVis = new JMenu("Vis");
		menuBar.add(mnVis);
		
		JMenuItem mntmLeverandrer = new JMenuItem("Leverand\u00F8rer");
		mntmLeverandrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ListLeverandor listLev = new ListLeverandor();
			listLev.setVisible(true);
			}
		});
		mnVis.add(mntmLeverandrer);
		
		JMenuItem mntmProdukter = new JMenuItem("Produkter");
		mntmProdukter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ListProdukter listProd = new ListProdukter();
			listProd.setVisible(true);
			}
		});
		mnVis.add(mntmProdukter);
		
		JMenu mnDebug = new JMenu("DEBUG");
		menuBar.add(mnDebug);
		
		JMenuItem mntmAddTestData = new JMenuItem("Add test data");
		mntmAddTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!(getLeverandorList().size() >= 3)) {
					getLeverandorList().add(new Leverandor("Fish Tank", "fish@fish.no", "Gate 2", "Halden", "+4799988774", 1770));
					getLeverandorList().add(new Leverandor("Reptil AS", "melk@melk.no", "Gate 3", "Halden", "+4711223586", 1771));
					getLeverandorList().add(new Leverandor("Pattedyr RUs", "pattedyr@patt.no", "Gate 4", "Halden", "+4711223586", 1771));
				}

				getFiskList().add(new Fisk("Gullfisk", 50, 100, MainFrame.getLeverandorList().get(0), "Gull", "Fisk"));
				getFiskList().add(new Fisk("Torsk", 50, 100, MainFrame.getLeverandorList().get(0), "Torsk", "Vann"));
				getFiskList().add(new Fisk("Fiskebolle", 50, 100, MainFrame.getLeverandorList().get(0), "i saus", "Meny"));
				
				getReptilList().add(new Reptil("Gekko", 25, 50, MainFrame.getLeverandorList().get(1), "Gekko", "Kryp"));
				getReptilList().add(new Reptil("SLange", 25, 50, MainFrame.getLeverandorList().get(1), "Gekko", "Kryp"));
				getReptilList().add(new Reptil("FLue", 25, 50, MainFrame.getLeverandorList().get(1), "Gekko", "Kryp"));
				
				getPattedyrList().add(new Pattedyr("The Fox", 100, 200, MainFrame.getLeverandorList().get(2), "Blub", "Moo"));
				getPattedyrList().add(new Pattedyr("Mus", 100, 200, MainFrame.getLeverandorList().get(2), "Mikke", "Mus"));
				getPattedyrList().add(new Pattedyr("The Fox", 100, 200, MainFrame.getLeverandorList().get(2), "Blub", "Moo"));
				
				updateValues();
			}
		});
		mnDebug.add(mntmAddTestData);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAntallProdukt = new JLabel("Antall produkt i systemet:");
		
		lblAntallPrduktN = new JLabel("0");
		
		JLabel lblAntallFisk = new JLabel("Antall fisk i systemet:");
		
		lblAntallFiskN = new JLabel("0");
		
		JLabel lblAntallPattedyr = new JLabel("Antall pattedyr i systemet:");
		
		lblAntallPattedyrN = new JLabel("0");
		
		JLabel lblAntallReptil = new JLabel("Antall reptil i systemet:");
		
		lblAntallReptilN = new JLabel("0");
		
		modelLev = new DefaultListModel<>();
		modelReptil = new DefaultListModel<>();
		modelFisk = new DefaultListModel<>();
		modelPattedyr = new DefaultListModel<>();
		
		for(Object o : leverandorList) {
			modelLev.addElement(o);
		}
		for(Object o : reptilList) {
			modelReptil.addElement(o);
		}
		for(Object o : fiskList) {
			modelFisk.addElement(o);
		}
		for(Object o : pattedyrList) {
			modelPattedyr.addElement(o);
		}
		
		
		LeverandorLists = new JList<Object>(modelLev);
		ListFisk = new JList<Object>(modelFisk);
		ListReptil = new JList<Object>(modelReptil);
		ListPattedyr = new JList<Object>(modelPattedyr);	
		
				
		LeverandorLists.setBorder(new LineBorder(new Color(0, 0, 0)));
		LeverandorLists.setEnabled(false);
		ListFisk.setBorder(new LineBorder(new Color(0, 0, 0)));
		ListFisk.setEnabled(false);
		ListPattedyr.setBorder(new LineBorder(new Color(0, 0, 0)));
		ListPattedyr.setEnabled(false);
		ListReptil.setBorder(new LineBorder(new Color(0, 0, 0)));
		ListReptil.setEnabled(false);
		
		
		LeverandorLists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListFisk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListReptil.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListPattedyr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel TitleLeverandorer = new JLabel("Leverand\u00F8rer:");
		JLabel TitleFisk = new JLabel("Fisk:");
		JLabel TitlePattedyr = new JLabel("Pattedyr:");
		JLabel TitleReptil = new JLabel("Reptil:");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(lblAntallProdukt)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAntallPrduktN)
							.addGap(87)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAntallReptil)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblAntallPattedyr)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(26)
										.addComponent(lblAntallFisk))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAntallFiskN)
								.addComponent(lblAntallPattedyrN)
								.addComponent(lblAntallReptilN)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(LeverandorLists, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(TitleLeverandorer))
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(TitleFisk)
								.addComponent(TitlePattedyr, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(TitleReptil)
								.addComponent(ListFisk, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
								.addComponent(ListReptil, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
								.addComponent(ListPattedyr, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAntallFisk)
								.addComponent(lblAntallFiskN))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAntallPattedyr)
								.addComponent(lblAntallPattedyrN))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAntallReptil)
								.addComponent(lblAntallReptilN)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAntallPrduktN)
							.addComponent(lblAntallProdukt)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(TitleLeverandorer)
						.addComponent(TitleFisk))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LeverandorLists, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(ListFisk, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TitleReptil)
							.addGap(2)
							.addComponent(ListReptil, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(TitlePattedyr)
							.addGap(8)
							.addComponent(ListPattedyr, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void updateValues() {
		
		lblAntallPrduktN.setText(fiskList.size() + reptilList.size() + pattedyrList.size() + "");
		lblAntallFiskN.setText(fiskList.size() + "");
		lblAntallPattedyrN.setText(pattedyrList.size() +"");
		lblAntallReptilN.setText(reptilList.size() + "");
		
		modelLev.clear();
		modelReptil.clear();
		modelFisk.clear();
		modelPattedyr.clear();
		
		for(Object o : leverandorList) {
			modelLev.addElement(o);
		}
		for(Object o : reptilList) {
			modelReptil.addElement(o);
		}
		for(Object o : fiskList) {
			modelFisk.addElement(o);
		}
		for(Object o : pattedyrList) {
			modelPattedyr.addElement(o);
		}
	}
}
