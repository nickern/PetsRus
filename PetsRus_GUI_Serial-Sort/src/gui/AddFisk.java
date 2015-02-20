package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import varelager.Fisk;
import medlemmer.Leverandor;

public class AddFisk extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6481983454247890270L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField textFieldNavn;
	private JTextField textFieldinkjPris;
	private JTextField textFieldPris;
	private JTextField textFieldSlektsnavn;
	private JTextField textFieldArtsnavn;
	JComboBox<Leverandor> comboBoxLeverandor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddFisk dialog = new AddFisk();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddFisk() {
		setTitle("Legg til... Fisk");
		setBounds(100, 100, 249, 305);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String produktnavn = textFieldNavn.getText();
						String inkjPrisTF = textFieldinkjPris.getText();
						String prisTF = textFieldPris.getText();
						String slektsnavn = textFieldSlektsnavn.getText();
						String artsnavn = textFieldArtsnavn.getText();
						double pris = 0;
						double inkjPris = 0;
						
						
						try{
							pris = Double.parseDouble(prisTF);
							inkjPris = Double.parseDouble(inkjPrisTF);
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null, "Feil i pris eller innkjøpspris!", "Error!", 0);
						}
						
						if(produktnavn.length() != 0 && slektsnavn.length() != 0 && artsnavn.length() != 0 && inkjPrisTF.length() != 0 && prisTF.length() != 0){
							
							Fisk fisk = new Fisk(produktnavn, inkjPris, pris, (Leverandor)comboBoxLeverandor.getSelectedItem(), slektsnavn, artsnavn);
							
							MainFrame.getFiskList().add(fisk);
							
							dispose();
							
						}
						else{
							
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(contentPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		JLabel lblNewLabel = new JLabel("Navn:");
		textFieldNavn = new JTextField();
		textFieldNavn.setColumns(10);
		JLabel lblinkjPris = new JLabel("Innkj\u00F8pspris:");
		textFieldinkjPris = new JTextField();
		textFieldinkjPris.setColumns(10);
		JLabel lblPris = new JLabel("Pris:");
		textFieldPris = new JTextField();
		textFieldPris.setColumns(10);
		JLabel lblLeverandr = new JLabel("Leverand\u00F8r:");
		
		// legg til innhold i combobox
		
		// lage array for leverandor
		
		int leverandorN = MainFrame.getLeverandorList().size();
		Leverandor[] levArray = new Leverandor[leverandorN];
		
		// lopierer objectreferanser fra lister til arrays
		MainFrame.getLeverandorList().toArray(levArray);
		
		// populer combobox
				// Remove comment to use the designer.
	//			JComboBox<Leverandor> comboBoxLeverandor = new JComboBox();
				// Comment this out to use the designer.
		comboBoxLeverandor = new JComboBox<Leverandor>(levArray);
		
		JLabel lblSlektsnavn = new JLabel("Slektsnavn:");
		
		textFieldSlektsnavn = new JTextField();
		textFieldSlektsnavn.setColumns(10);
		
		JLabel lblArtsnavn = new JLabel("Artnavn:");
		
		textFieldArtsnavn = new JTextField();
		textFieldArtsnavn.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblinkjPris)
						.addComponent(lblPris)
						.addComponent(lblLeverandr)
						.addComponent(lblArtsnavn)
						.addComponent(lblSlektsnavn))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBoxLeverandor, 0, 119, Short.MAX_VALUE)
						.addComponent(textFieldNavn)
						.addComponent(textFieldinkjPris)
						.addComponent(textFieldPris)
						.addComponent(textFieldSlektsnavn)
						.addComponent(textFieldArtsnavn))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textFieldNavn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblinkjPris)
						.addComponent(textFieldinkjPris, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPris)
						.addComponent(textFieldPris, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLeverandr)
						.addComponent(comboBoxLeverandor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSlektsnavn)
						.addComponent(textFieldSlektsnavn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArtsnavn)
						.addComponent(textFieldArtsnavn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}
}
