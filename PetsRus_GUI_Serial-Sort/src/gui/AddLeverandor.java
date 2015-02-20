package gui;

import medlemmer.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLeverandor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6731840485718514604L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNavn;
	private JTextField textFieldEpost;
	private JTextField textFieldAdresse;
	private JTextField textFieldPostnr;
	private JTextField textFieldTelefonNr;
	private JTextField textFieldPoststed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddLeverandor dialog = new AddLeverandor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddLeverandor() {
		setTitle("Legg til leverand\u00F8r");
		setBounds(100, 100, 278, 288);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		JLabel lblNavn = new JLabel("Navn:");
		JLabel lblEpost = new JLabel("E-post:");
		JLabel lblAdresse = new JLabel("Adresse:");
		JLabel lblPostnr = new JLabel("Postnr:");
		JLabel lblPoststed = new JLabel("Poststed:");
		JLabel lblTelefonrNr = new JLabel("Telefonr nr:");
		
		textFieldNavn = new JTextField();
		textFieldNavn.setColumns(10);
		
		textFieldEpost = new JTextField();
		textFieldEpost.setColumns(10);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setColumns(10);
		
		textFieldPostnr = new JTextField();
		textFieldPostnr.setColumns(10);
		
		textFieldTelefonNr = new JTextField();
		textFieldTelefonNr.setColumns(10);
		
		textFieldPoststed = new JTextField();
		textFieldPoststed.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPoststed)
						.addComponent(lblNavn)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(22)
								.addComponent(lblEpost))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(22)
								.addComponent(lblPostnr))
							.addComponent(lblTelefonrNr))
						.addComponent(lblAdresse))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textFieldTelefonNr)
							.addComponent(textFieldEpost)
							.addComponent(textFieldNavn, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addComponent(textFieldPostnr)
							.addComponent(textFieldPoststed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textFieldAdresse))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNavn)
						.addComponent(textFieldNavn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEpost)
						.addComponent(textFieldEpost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefonrNr)
						.addComponent(textFieldTelefonNr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresse)
						.addComponent(textFieldAdresse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPostnr)
						.addComponent(textFieldPostnr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPoststed)
						.addComponent(textFieldPoststed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				/**
				 * Add Leverandor to ArrayList when OK is clicked.
				 */
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						String navn = textFieldNavn.getText();
						String epost = textFieldEpost.getText();
						String adr = textFieldAdresse.getText();
						String psted = textFieldPoststed.getText();
						String tlf = textFieldTelefonNr.getText();
						String pnrTF = textFieldPostnr.getText();
						int pnr = 0;
						
						try{
							pnr = Integer.parseInt(textFieldPostnr.getText());
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null, "Feil i post nr!", "Error!", 0);
						}
						
						if(navn.length() != 0 && epost.length() != 0 && adr.length() != 0 && psted.length() != 0 && tlf.length() != 0 && pnrTF.length() != 0){
							
							Leverandor lev = new Leverandor(navn, epost, adr, psted, tlf, pnr);
							MainFrame.getLeverandorList().add(lev);
							
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "En eller flere verdier mangler!", "Error!", 0);
						} 
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
