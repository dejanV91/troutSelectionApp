import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conection {
	
public static Connection conections() {

		try {
			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:C:\\Users\\Dejan\\Desktop\\Pastrmke PROJECT\\Pastrmke.db");
			return conn;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "problem sa konekcijom");
			return null;

		}

	}
}
