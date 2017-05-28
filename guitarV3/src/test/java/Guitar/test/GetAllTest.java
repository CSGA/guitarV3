package Guitar.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import Guitar.dbutil.DbUtil;
import Guitar.entity.*;

public class GetAllTest {

	@Test
	public void test() {
	       DbUtil dbUtil=new DbUtil();
	        Inventory inventory=new Inventory();
	        ResultSet rs=dbUtil.executeQuery("select * from guitar",new Object[]{});
	        try {
	            while(rs.next()){
	                String serialNumber=rs.getString(1);
	                Double price=rs.getDouble(2);
	                GuitarSpec spec1=new GuitarSpec();	
	                spec1.setBuilder(rs.getString(3));
	                spec1.setModel(rs.getString(4));
	                spec1.setType( rs.getString(5));
	                spec1.setNumStrings(rs.getString(6));
	                spec1.setBackWood( rs.getString(7));
	                spec1.setTopWood( rs.getString(8));
	                inventory.addGuitar(serialNumber, price, spec1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        @SuppressWarnings({ "rawtypes", "unchecked" })
	        GuitarSpec spec=new GuitarSpec("","","acoustic","","","6");
			List<Guitar> list=new LinkedList();
	        list=inventory.search(spec);
	        if (!list.isEmpty()) {
	            System.out.println("Erin, you might like these guitars:");
	            for (Iterator i = list.iterator(); i.hasNext(); ) {
	              Guitar guitar = (Guitar)i.next();
	              GuitarSpec aspec = guitar.getSpec();
	              System.out.println("  We have a " +
	                aspec.getBuilder() + " " + aspec.getModel() + " " +
	                aspec.getType() + " guitar:" +
	                aspec.getBackWood() + " back and sides," +
	                aspec.getTopWood() + " top.\n  You can have it for only $" +
	                guitar.getPrice() + "!\n  ----");
	            }
	          } else {
	            System.out.println("Sorry, Erin, we have nothing for you.");
	          }		
	}
}
