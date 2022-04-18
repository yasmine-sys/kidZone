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

import tn.pi.spring.entity.Bus;
import tn.pi.spring.iservice.Ibus;

@RestController
@RequestMapping("/bus")
public class BusRestController {


		@Autowired
		Ibus busService;

		// http://localhost:8089/SpringMVC/bus/retrieve-all-bus
		@GetMapping("/retrieve-all-bus")
		@ResponseBody
		public List<Bus> getBuss() {
			System.out.println("ggggg");
			
			List<Bus> list = busService.retrieveAllBus();
			System.out.println(list);
			return list;
		}

		// http://localhost:8089/SpringMVC/bus/retrieve-bus/8
		@GetMapping("/retrieve-bus/{bus-id}")
		@ResponseBody
		public Bus retrieveBus(@PathVariable("bus-id") Long busId) {
		
			return busService.retrieveBus(busId);
		}

		// http://localhost:8089/SpringMVC/bus/add-bus
		@PostMapping("/add-bus")
		@ResponseBody
		public Bus addBus(@RequestBody Bus b) {
			Bus bus = busService.addBus(b);
			return bus;
		}

		// http://localhost:8089/SpringMVC/bus/remove-bus/{bus-id}
		@DeleteMapping("/remove-bus/{bus-id}")
		@ResponseBody
		public void removeBus(@PathVariable("bus-id") Long busId) {
			busService.deleteBus(busId);
		}

		// http://localhost:8089/SpringMVC/bus/modify-bus
		@PutMapping("/modify-bus")
		@ResponseBody
		public Bus modifyBus(@RequestBody Bus bus) {
			return busService.updateBus(bus);
		}

}
