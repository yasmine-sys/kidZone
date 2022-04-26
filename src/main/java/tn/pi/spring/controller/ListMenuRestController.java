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

import tn.pi.entity.ListMenu;
import tn.pi.spring.Iservice.IListMenu;
import tn.pi.spring.service.ListMenuPdf;

@RestController
@RequestMapping("/ListMenu")
public class ListMenuRestController {
	
		@Autowired
		IListMenu ListMenuService;

		// http://localhost:8089/SpringMVC/Menu/retrieve-all-Menu
		@GetMapping("/retrieve-all-ListMenu")
		@ResponseBody
		public List<ListMenu> getListMenu() {
			//System.out.println("ggggg");
			
			//List<ListMenu> list = ListMenuService.retrieveAllListMenu();
			//System.out.println(list);
			return ListMenuService.retrieveAllListMenu();
		}

		// http://localhost:8089/SpringMVC/Menu/retrieve-Menu/8
		@GetMapping("/retrieve-ListMenu/{ListMenu-id}")
		@ResponseBody
		public ListMenu retrieveListMenu(@PathVariable("ListMenu-id") Long ListMenuId) {
		
			return ListMenuService.retrieveListMenu(ListMenuId);
		}

		// http://localhost:8089/SpringMVC/Menu/add-Menu
		@PostMapping("/add-ListMenu")
		@ResponseBody
		public ListMenu addListMenu(@RequestBody ListMenu e) {
			ListMenu ListMenu = ListMenuService.addListMenu(e);
			return ListMenu;
		}

		// http://localhost:8089/SpringMVC/Menu/remove-Menu/{Menu-id}
		@DeleteMapping("/remove-ListMenu/{ListMenu-id}")
		@ResponseBody
		public void removeListMenu(@PathVariable("ListMenu-id") Long ListMenuId) {
			ListMenuService.deleteListMenu(ListMenuId);
		}

		// http://localhost:8089/SpringMVC/Menu/modify-Menu
		@PutMapping("/modify-ListMenu")
		@ResponseBody
		public ListMenu modifyListMenu(@RequestBody ListMenu ListMenu) {
			return ListMenuService.updateListMenu(ListMenu);
		}
		@GetMapping("/ListMenu/pdf")
		public void PaymentPdf(HttpServletResponse response) throws DocumentException, IOException {
		    response.setContentType("application/pdf");
		   // DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		   // String currentDateTime = dateFormatter.format(new Date());
		     
		    String headerKey = "Content-Disposition";
		    String headerValue = "attachment; filename=ListMenu"+ ".pdf";
		    response.setHeader(headerKey, headerValue);
		     
		    List<ListMenu> listMenu = ListMenuService.retrieveAllListMenu();
		     
		    ListMenuPdf exporter = new ListMenuPdf(listMenu);
		    exporter.export(response);
		     		    
		}
}
