package Guitar.service;
import java.util.List;

import Guitar.dao.GuitarDao;
import Guitar.dao.dataAccess;
import Guitar.entity.Guitar;
import Guitar.entity.GuitarSpec;

public class GuitarService {

	private GuitarDao guitarDao=dataAccess.createGuitarDao();
	
	public List<Guitar> search(GuitarSpec spec) {
		// TODO Auto-generated method stub
		return guitarDao.search(spec);
	}

	public GuitarDao getGuitarDao() {
		return guitarDao;
	}

	public void setGuitarDao(GuitarDao guitarDao) {
		this.guitarDao = guitarDao;
	}

	public List<Guitar> show() {
		// TODO Auto-generated method stub
		return guitarDao.show();
	}
	public boolean add(Guitar guitar){
		return guitarDao.add(guitar);
	}
	public boolean delete(Guitar guitar){
		return guitarDao.delete(guitar);
	}
}
