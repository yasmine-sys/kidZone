package tn.pi.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.entity.ListMenu;
import tn.pi.spring.Iservice.IListMenu;
import tn.pi.spring.repository.ListMenuRepository;

@Service
public class ListMenuService implements IListMenu {
	@Autowired
	ListMenuRepository ListMenuRepository;

	@Override
	public List<ListMenu>retrieveAllListMenu() {
		//List<ListMenu> listMenu = (List<ListMenu>) ListMenuRepository.findAll();
		return (List<ListMenu>) ListMenuRepository.findAll();
	}

	@Override
	public ListMenu addListMenu(ListMenu r) {
		return ListMenuRepository.save(r);
	}

	@Override
	public void deleteListMenu(Long id) {
		ListMenuRepository.deleteById(id);
		
	}

	@Override
	public ListMenu updateListMenu(ListMenu r) {
		return ListMenuRepository.save(r);
	}

	@Override
	public ListMenu retrieveListMenu(Long id) {
		ListMenu ListMenu = ListMenuRepository.findById(id).orElse(null);
		return ListMenu;
	}
}
