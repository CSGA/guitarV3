package Guitar.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import Guitar.dbutil.DbUtil;
import Guitar.dbutil.DbUtil2;
import Guitar.entity.Guitar;
import Guitar.entity.GuitarSpec;

public class dbtransTest {

	@Test
	public void test() {
		DbUtil2 dbUtil=new DbUtil2();
	       Guitar guitar1=null;
	        ResultSet rs=dbUtil.executeQuery("select * from guitar",new Object[]{});
	        try {
	            while(rs.next()){
	            	guitar1 =new Guitar(null, 0, null);
	                String serialNumber=rs.getString(1);
	                Double price=rs.getDouble(2);
	                GuitarSpec spec1=new GuitarSpec();	
	                spec1.setBuilder(rs.getString(3));
	                spec1.setModel(rs.getString(4));
	                spec1.setType( rs.getString(5));
	                spec1.setNumStrings(rs.getString(6));
	                spec1.setBackWood( rs.getString(7));
	                spec1.setTopWood( rs.getString(8));
	                guitar1.setSerialNumber(serialNumber);
	                guitar1.setPrice(price);
	                guitar1.setSpec(spec1);
	                System.out.println(guitar1.getSerialNumber()+ " " +guitar1.getPrice()+guitar1.getSpec().getBuilder()+ " " +guitar1.getSpec().getModel()+ " " +guitar1.getSpec().getType()+ " " +guitar1.getSpec().getNumStrings()+ " " +guitar1.getSpec().getBackWood()+ " " +guitar1.getSpec().getTopWood()+"\n");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();	        	
	        }
            System.out.println("These are data from mysqlDB.");
	}
}
