package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import medlemmer.Leverandor;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;

public class ListLeverandor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4612239640323941117L;
	private final JPanel contentPanel = new JPanel();
	private JList<Object> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListLeverandor dialog = new ListLeverandor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListLeverandor() {
		setBounds(100, 100, 359, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		int levN = MainFrame.getLeverandorList().size();


		final Leverandor[] levArray = new Leverandor[levN];

	//	MainFrame.getFiskList().toArray(prodArray);
		
		int tempN = 0;
		
		for(Leverandor l : MainFrame.getLeverandorList()){
			levArray[tempN] = l;
			tempN++;
		}
		
		final DefaultListModel<Object> model = new DefaultListModel<>();
		
		for(Object o : levArray) {
			model.addElement(o);
		}
		
		
		list = new JList<Object>(model);
		
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnNewButton = new JButton("a -> \u00E5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// soterer listen 
				// default er lav -> høy, derfor bruker vi reverse order
				Arrays.sort(levArray);
				
				// tømmer listen
				model.clear();
				
				// legger ny sortert liste tilbake i Jlist
				for(Object o : levArray) {
					model.addElement(o);
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u00E5 -> a");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// soterer listen 
				// default er lav -> høy, derfor bruker vi reverse order
				Arrays.sort(levArray, Collections.reverseOrder());
				
				// tømmer listen
				model.clear();
				
				// legger ny sortert liste tilbake i Jlist
				for(Object o : levArray) {
					model.addElement(o);
				}
			}
		});
		
		JLabel lblSoteer = new JLabel("Sorter");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_1)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(47)
							.addComponent(lblSoteer)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(94)
							.addComponent(lblSoteer)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(34)
									.addComponent(btnNewButton_1))
								.addComponent(btnNewButton))))
					.addContainerGap())
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
