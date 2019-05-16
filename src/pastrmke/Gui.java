package pastrmke;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Gui extends JFrame {
	
	SQLite sql=new SQLite();

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 414, 136);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 437);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
			
		 String[] columNames ={
				"Based-id", "Scan-id", "TAG", "Unit", "Family", "Weight", "Length", "RedaData"
			};
	
		table = new JTable(null,columNames);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setCellSelectionEnabled(true);
		
		table.setColumnSelectionAllowed(true);
		table.setBounds(49, 178, 504, 171);
		contentPane.add(table);
		
		
		textField = new JTextField();
		textField.setBounds(49, 26, 196, 39);
		contentPane.add(textField);
		textField.setColumns(30);
		
		JButton ScanB = new JButton("Scan");
		ScanB.setBounds(78, 76, 137, 28);
		contentPane.add(ScanB);
		
		this.sql.Connection();
		this.sql.showDatas(table);
	}
}
