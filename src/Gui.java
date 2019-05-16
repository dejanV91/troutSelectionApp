import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Gui {

	private JFrame frame;
	protected static JLabel rangTagField;
	public static JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Created Objects
	protected static Connection conn = null;
	protected static JLabel tagField;
	protected static JLabel basedField;
	protected static JLabel scanField;
	protected static JLabel unitField;
	protected static JLabel familyField;
	protected static JLabel weightField;
	protected static JLabel lengthField;
	protected static JTable table;
	
	

	public Gui()  {
		initialize();
		conn = Conection.conections();
	}

	private void initialize()  {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 879, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(61, 55, 203, 42);
		frame.getContentPane().add(textField);
		textField.setColumns(30);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScanFish.scanFish();
				ScanFish.scanRangTag();
				TableSet.createPedigree();
				TableSet.setTable();
			}
		});
		btnNewButton.setBounds(38, 108, 119, 30);
		frame.getContentPane().add(btnNewButton);

		JLabel tagLabel = new JLabel("TAG:");
		tagLabel.setBounds(25, 169, 97, 30);
		frame.getContentPane().add(tagLabel);

		JLabel basedIdLabel = new JLabel("Based-id:");
		basedIdLabel.setBounds(25, 199, 97, 30);
		frame.getContentPane().add(basedIdLabel);

		JLabel ScanLabel = new JLabel("Scan-id:");
		ScanLabel.setBounds(25, 225, 97, 30);
		frame.getContentPane().add(ScanLabel);

		JLabel lblUnit = new JLabel("Unit:");
		lblUnit.setBounds(25, 251, 97, 30);
		frame.getContentPane().add(lblUnit);

		JLabel lblFamily = new JLabel("Family:");
		lblFamily.setBounds(25, 277, 97, 30);
		frame.getContentPane().add(lblFamily);

		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(25, 303, 97, 30);
		frame.getContentPane().add(lblWeight);

		JLabel lblHight = new JLabel("Length:");
		lblHight.setBounds(25, 328, 97, 30);
		frame.getContentPane().add(lblHight);

		tagField = new JLabel("");
		tagField.setFont(new Font("Tahoma", Font.BOLD, 13));
		tagField.setBounds(111, 173, 153, 22);
		frame.getContentPane().add(tagField);

		basedField = new JLabel("");
		basedField.setBounds(111, 203, 153, 22);
		frame.getContentPane().add(basedField);

		scanField = new JLabel("");
		scanField.setBounds(111, 229, 153, 22);
		frame.getContentPane().add(scanField);

		unitField = new JLabel("");
		unitField.setBounds(111, 254, 153, 22);
		frame.getContentPane().add(unitField);

		familyField = new JLabel("");
		familyField.setBounds(111, 280, 153, 22);
		frame.getContentPane().add(familyField);

		weightField = new JLabel("");
		weightField.setBounds(111, 306, 153, 22);
		frame.getContentPane().add(weightField);

		lengthField = new JLabel("");
		lengthField.setBounds(110, 332, 153, 22);
		frame.getContentPane().add(lengthField);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				
			}
		});
		btnReset.setBounds(166, 108, 119, 30);
		frame.getContentPane().add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(341, 55, 476, 345);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel RangTag = new JLabel("Ranking:");
		RangTag.setBounds(25, 369, 97, 30);
		frame.getContentPane().add(RangTag);
		
		rangTagField = new JLabel("");
		rangTagField.setFont(new Font("Tahoma", Font.BOLD, 13));
		rangTagField.setForeground(Color.RED);
		rangTagField.setBounds(111, 374, 153, 22);
		frame.getContentPane().add(rangTagField);
		
		
	}
}
