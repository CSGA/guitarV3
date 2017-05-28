package Guitar.dao;
import java.util.List;

import Guitar.entity.Guitar;
import Guitar.entity.GuitarSpec;


public interface GuitarDao {

	List<Guitar> search(GuitarSpec spec);
	List<Guitar> show();
	public boolean add(Guitar guitar);
	public boolean delete(Guitar guitar);
}
