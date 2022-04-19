package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.entity.Menu;


public interface IMenu {
	List<Menu> retrieveAllMenu();

	Menu addMenu (Menu r);

	void deleteMenu (Long id);

	Menu updateMenu (Menu r);
	
	Menu retrieveMenu (Long id);
}
