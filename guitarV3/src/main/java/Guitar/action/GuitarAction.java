package Guitar.action;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Guitar.dao.GuitarDao;
import Guitar.entity.Guitar;
import Guitar.entity.GuitarSpec;
import Guitar.service.GuitarService;

public class GuitarAction extends ActionSupport {
	  
	private String serialNumber,builder, model, type, backWood, topWood,numStrings;
	private double price;
	  
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	public String getNumStrings() {
		return numStrings;
	}
	public void setNumStrings(String numStrings) {
		this.numStrings = numStrings;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	List<Guitar> list=new LinkedList();
	 GuitarService guitarService=new GuitarService();	
	 
	public String search() throws Exception{
		 GuitarSpec spec =new GuitarSpec();
		 spec.setBuilder(builder);
		 spec.setTopWood(topWood);
		 spec.setBackWood(backWood);
		 spec.setModel(model);
		 spec.setType(type);
		 spec.setNumStrings(numStrings);
		 list=guitarService.search(spec);
		 ActionContext.getContext().getSession().put("GuitarList", list);
		 return SUCCESS;
      }
	
	public String show() throws Exception{		
		List<Guitar> list1=new ArrayList<Guitar>();
		 list1 =guitarService.show();
		 ActionContext.getContext().getSession().put("AllGuitarList", list1);
		 return SUCCESS;
     }
	
	public String add() throws Exception{		
    	Guitar guitar =new Guitar(null, 0, null);
    	GuitarSpec spec=new GuitarSpec();
        spec.setBuilder(builder);
        spec.setModel(model);
        spec.setType(type);
        spec.setNumStrings(numStrings);
        spec.setBackWood(backWood);
        spec.setTopWood(topWood);
        guitar.setSerialNumber(serialNumber);
        guitar.setPrice(price);
        guitar.setSpec(spec);
        guitarService.add(guitar);
		 return SUCCESS;
     }
	public String delete() throws Exception{		
    	Guitar guitar =new Guitar(null, 0, null);
    	guitar.setSerialNumber(serialNumber);
        guitarService.delete(guitar);
		 return SUCCESS;	
	}
	}
