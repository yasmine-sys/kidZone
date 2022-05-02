package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.entity.ListMenu;

public interface IListMenu {
	List<ListMenu> retrieveAllListMenu();

	ListMenu addListMenu (ListMenu r);

	void deleteListMenu (Long id);

	ListMenu updateListMenu (ListMenu r);
	
	ListMenu retrieveListMenu (Long id);

}
