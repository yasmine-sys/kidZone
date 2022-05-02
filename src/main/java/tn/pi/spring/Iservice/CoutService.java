package tn.pi.spring.Iservice;
import java.util.List;

import tn.pi.spring.entity.Cout;
public interface CoutService {
	
	
	public void affectercoutjardin(List<Cout> lc,Long JardinId);
}
