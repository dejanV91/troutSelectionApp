package pastrmke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class SQLite {

	Connection conn = null;
	PreparedStatement pst = null;
	Statement stm = null;
	ResultSet result = null;

	public void Connection() {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Dejan\\Desktop\\Pastrmke PROJECT\\Pastrmke.db");
			if (!conn.isClosed())
				JOptionPane.showMessageDialog(null, "Konekcia uspela");
			else
				JOptionPane.showMessageDialog(null, "Neuspela konekcija!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Neuspela konekcija!");
		}
	}
	public void showDatas(JTable jtb) {	
		
		try {
			String query="SELECT * FROM Cipovanje2015";
			pst=conn.prepareStatement(query);
			result=pst.executeQuery();
			jtb.setModel(DbUtils.resultSetToTableModel(result));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

}
