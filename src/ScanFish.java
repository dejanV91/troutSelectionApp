import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ScanFish {
	 //tank of Tag fish
	static String tag=null;
	static String unit=null;
	static Connection conn=Conection.conections();
	
	
	// this method scan one fish
	public static void scanFish() {
		
		
		try {
			tag=Gui.textField.getText();
		
			String query = "select * from Cipovanje2015 where TAG='"+tag+"'";
			PreparedStatement pst = conn.prepareStatement(query);
			
			ResultSet res = pst.executeQuery();
			
			while(res.next()) {
				unit=res.getString(ColumnsConstant.getUnit());
				Gui.tagField.setText(res.getString(ColumnsConstant.getTag()));
				Gui.basedField.setText(res.getString(1));
				Gui.scanField.setText(res.getString(2));
				Gui.unitField.setText(res.getString(ColumnsConstant.getUnit()));
				Gui.familyField.setText(res.getString(5));
				Gui.weightField.setText(res.getString(6));
				Gui.lengthField.setText(res.getString(7));
				
				
			}
		
			
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
	
	}
	//METHOD SCAN RANG of SCAN FISH
	public static void scanRangTag() {
		String fish=tag;
		String query="SELECT Rang from Rangiranje INNER JOIN Cipovanje2015 on Rangiranje.Tank=Cipovanje2015.Unit where Cipovanje2015.TAG='"+fish+"';";
		try {
			PreparedStatement prp=conn.prepareStatement(query);
			ResultSet res=prp.executeQuery();
			
			while(res.next()) {
				Gui.rangTagField.setText(res.getString(1));
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
