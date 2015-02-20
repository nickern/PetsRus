package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.LayoutStyle.ComponentPlacement;

import varelager.Produkt;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ListProdukter extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4612239640323941117L;
	private final JPanel contentPanel = new JPanel();
	
	JList<Object> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListProdukter dialog = new ListProdukter();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListProdukter() {
		setBounds(100, 100, 359, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
		
		// lage array
		int produktN = MainFrame.getFiskList().size() + MainFrame.getPattedyrList().size() + MainFrame.getReptilList().size();


		final Produkt[] prodArray = new Produkt[produktN];

	//	MainFrame.getFiskList().toArray(prodArray);
		
		int tempN = 0;
		
		for(Produkt p : MainFrame.getFiskList()){
			prodArray[tempN] = p;
			tempN++;
		}
		for(Produkt p : MainFrame.getReptilList()){
			prodArray[tempN] = p;
			tempN++;
		}
		for(Produkt p : MainFrame.getPattedyrList()){
			prodArray[tempN] = p;
			tempN++;
		}
		
		final DefaultListModel<Object> model = new DefaultListModel<>();
		for(Object o : prodArray) {
			model.addElement(o);
		}
		
		
		list = new JList<Object>(model);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		JButton sortAZ = new JButton("a -> \u00E5");
		sortAZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// soterer listen 
				Arrays.sort(prodArray, Produkt.ProduktComparator);
				
				// tømmer listen
				model.clear();
				
				// legger ny sortert liste tilbake i Jlist
				for(Object o : prodArray) {
					model.addElement(o);
				}
			}
		});
		
		JButton sortZA = new JButton("\u00E5 -> a");
		sortZA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// soterer listen 
				Arrays.sort(prodArray, Produkt.ProduktComparator);
				Collections.reverse(Arrays.asList(prodArray));
				
				// tømmer listen
				model.clear();
				
				// legger ny sortert liste tilbake i Jlist
				for(Object o : prodArray) {
					model.addElement(o);
				}
				
			}
		});
		
		JButton sortPriceHL = new JButton("H\u00F8y -> Lav");
		sortPriceHL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// soterer listen 
				Arrays.sort(prodArray);
				Collections.reverse(Arrays.asList(prodArray));
				
				// tømmer listen
				model.clear();
				
				// legger ny sortert liste tilbake i Jlist
				for(Object o : prodArray) {
					model.addElement(o);
				}
			}
		});
		
		JButton sortPriceLH = new JButton("Lav -> H\u00F8y");
		sortPriceLH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// soterer listen 
				Arrays.sort(prodArray);
				
				// tømmer listen
				model.clear();
				
				// legger ny sortert liste tilbake i Jlist
				for(Object o : prodArray) {
					model.addElement(o);
				}
			}
		});
		
		JLabel lblPris = new JLabel("Pris:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(sortPriceHL)
										.addComponent(sortPriceLH)))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(sortAZ)
										.addComponent(sortZA))))
							.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPris)
							.addGap(50))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(34)
									.addComponent(sortZA))
								.addComponent(sortAZ))
							.addGap(26)
							.addComponent(lblPris)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sortPriceHL)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sortPriceLH)
							.addGap(93))))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
