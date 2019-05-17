import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableStringConverter;

import net.proteanit.sql.DbUtils;

public class TableSet {
	
	protected static DefaultTableModel dm;
	
	protected static String tagFish = ScanFish.tag;
	protected static String unit = null;
	protected static String mother = null;
	protected static String father = null;
	protected static String motherOfMother = null;
	protected static String fatherOfMother = null;
	protected static String motherOfFather = null;
	protected static String fatherOfFather = null;
	static Connection conn = Conection.conections();

	//create all family of tag fish
	public static void createPedigree() {
		try {

			unit = ScanFish.unit;

			String query = "SELECT * FROM Kombinacija WHERE field1='" + unit + "';";
			PreparedStatement prp = conn.prepareStatement(query);

			ResultSet res = prp.executeQuery();

			while (res.next()) {

				mother = res.getString(ColumnsConstant.getMather());
				father = res.getString(ColumnsConstant.getFather());
				motherOfMother = res.getString(ColumnsConstant.getMatherOfMather());
				fatherOfMother = res.getString(ColumnsConstant.getFatherOfMather());
				motherOfFather = res.getString(ColumnsConstant.getMatherOfFather());
				fatherOfFather = res.getString(ColumnsConstant.getFatherOfFather());

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	// query and set dates in table on GUI
	public static void setTable() {
		try {

			String query = "SELECT Cipovanje2015.TAG,Cipovanje2015.Weight,Cipovanje2015.Unit,Rangiranje.Rang as Ranking  FROM Cipovanje2015 INNER JOIN Kombinacija as k on Cipovanje2015.Unit=k.field1 INNER JOIN Rangiranje on k.field1=Rangiranje.Tank WHERE NOT k.field1='"
					+ unit + "' AND NOT (k.field3='" + mother + "' OR k.Majka='" + mother + "' OR k.Otac='" + mother
					+ "') AND NOT (k.field3='" + motherOfMother + "' OR k.Majka='" + motherOfMother + "' OR k.Otac='"
					+ motherOfMother + "') AND NOT (k.field3='" + motherOfFather + "' OR k.Majka='" + motherOfFather
					+ "' OR k.Otac='" + motherOfFather + "') AND NOT (k.field4='" + father + "' OR k.field9='" + father
					+ "' OR field14='" + father + "') AND NOT (k.field4='" + fatherOfMother + "' OR k.field9='"
					+ fatherOfMother + "' OR field14='" + fatherOfMother + "') AND NOT (k.field4='" + fatherOfFather
					+ "' OR k.field9='" + fatherOfFather + "' OR field14='" + fatherOfFather + "') ORDER BY Rang ;";
			PreparedStatement prp = conn.prepareStatement(query);

			ResultSet res = prp.executeQuery();
			Gui.table.setModel(DbUtils.resultSetToTableModel(res));
		

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}
	
	

}
