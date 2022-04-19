package tn.pi.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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

import com.lowagie.text.DocumentException;

import tn.pi.entity.Menu;
import tn.pi.spring.Iservice.IMenu;
import tn.pi.spring.service.MenuPdf;

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
	@GetMapping("/Menu/pdf")
	public void PaymentPdf(HttpServletResponse response) throws DocumentException, IOException {
	    response.setContentType("application/pdf");
	   // DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	   // String currentDateTime = dateFormatter.format(new Date());
	     
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=Menu"+ ".pdf";
	    response.setHeader(headerKey, headerValue);
	     
	    List<Menu> listMenu = menuService.retrieveAllMenu();
	     
	    MenuPdf exporter = new MenuPdf(listMenu);
	    exporter.export(response);
	     
	    
	}
}
