import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class SearchFilter {

	static Connection conn = Conection.conections();

	public static void filter() {
		String query = "SELECT Cipovanje2015.TAG,Cipovanje2015.Weight,Cipovanje2015.Unit,Rangiranje.Rang as Ranking  FROM Cipovanje2015 INNER JOIN Kombinacija as k on Cipovanje2015.Unit=k.field1 INNER JOIN Rangiranje on k.field1=Rangiranje.Tank WHERE Cipovanje2015.TAG=? AND NOT k.field1='"
				+ TableSet.unit + "' AND NOT (k.field3='" + TableSet.mother + "' OR k.Majka='" + TableSet.mother
				+ "' OR k.Otac='" + TableSet.mother + "') AND NOT (k.field3='" + TableSet.motherOfMother
				+ "' OR k.Majka='" + TableSet.motherOfMother + "' OR k.Otac='" + TableSet.motherOfMother
				+ "') AND NOT (k.field3='" + TableSet.motherOfFather + "' OR k.Majka='" + TableSet.motherOfFather
				+ "' OR k.Otac='" + TableSet.motherOfFather + "') AND NOT (k.field4='" + TableSet.father
				+ "' OR k.field9='" + TableSet.father + "' OR field14='" + TableSet.father + "') AND NOT (k.field4='"
				+ TableSet.fatherOfMother + "' OR k.field9='" + TableSet.fatherOfMother + "' OR field14='"
				+ TableSet.fatherOfMother + "') AND NOT (k.field4='" + TableSet.fatherOfFather + "' OR k.field9='"
				+ TableSet.fatherOfFather + "' OR field14='" + TableSet.fatherOfFather + "') ORDER BY Rang ;";

		try {
			
				PreparedStatement prp = conn.prepareStatement(query);
				prp.setString(1, Gui.searchTable.getText());
				ResultSet res = prp.executeQuery();

				Gui.table.setModel(DbUtils.resultSetToTableModel(res));
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}
}
