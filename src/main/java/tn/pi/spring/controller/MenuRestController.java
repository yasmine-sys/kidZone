package tn.pi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.pi.entity.Menu;
import tn.pi.spring.Iservice.IMenu;

@RestController
@RequestMapping("/Menu")
public class MenuRestController {
	@Autowired
	IMenu menuService;

	// http://localhost:8089/SpringMVC/Menu/retrieve-all-Menu
	@GetMapping("/retrieve-all-menus")
	@ResponseBody
	public List<Menu> geMenu() {
		System.out.println("ggggg");
		
		List<Menu> list = menuService.retrieveAllMenu();
		System.out.println(list);
		return list;
	}

	// http://localhost:8089/SpringMVC/Menu/retrieve-Menu/8
	@GetMapping("/retrieve-Menu/{menu-id}")
	@ResponseBody
	public Menu retrieveMenu(@PathVariable("menu-id") Long menuId) {
	
		return menuService.retrieveMenu(menuId);
	}

	// http://localhost:8089/SpringMVC/Menu/add-Menu
	@PostMapping("/add-menu")
	@ResponseBody
	public Menu addMenu(@RequestBody Menu e) {
		Menu Menu = menuService.addMenu(e);
		return Menu;
	}

	// http://localhost:8089/SpringMVC/Menu/remove-Menu/{Menu-id}
	@DeleteMapping("/remove-menu/{menu-id}")
	@ResponseBody
	public void removeMenu(@PathVariable("Menu-id") Long menuId) {
		menuService.deleteMenu(menuId);
	}

	// http://localhost:8089/SpringMVC/Menu/modify-Menu
	@PutMapping("/modify-menu")
	@ResponseBody
	public Menu modifyMenu(@RequestBody Menu menu) {
		return menuService.updateMenu(menu);
	}
}
