package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.pi.entity.Menu;
import tn.pi.spring.Iservice.IMenu;
import tn.pi.spring.repository.MenuRepository;

@Service
public class MenuService implements IMenu {
	@Autowired
	MenuRepository menuRepository;

	@Override
	public List<Menu>retrieveAllMenu() {
		 //List<Menu> listMenu = (List<Menu>) menuRepository.findAll();
		 return (List<Menu>) menuRepository.findAll();
	}

	@Override
	public Menu addMenu(Menu r) {
		return menuRepository.save(r);
	}

	@Override
	public void deleteMenu(Long id) {
		menuRepository.deleteById(id);
		
	}

	@Override
	public Menu updateMenu(Menu r) {
		return menuRepository.save(r);
	}

	@Override
	public Menu retrieveMenu(Long id) {
		Menu Menu = menuRepository.findById(id).orElse(null);
		return Menu;
	}

	//@Override
	//public Menu findRandom() {
		//Menu Menu = menuRepository.findRandom();
		//return Menu;
	//}
	
}
