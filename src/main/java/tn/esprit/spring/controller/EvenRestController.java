package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;


import com.itextpdf.text.DocumentException;
import com.lowagie.text.Image;

import tn.esprit.spring.entity.EventEntity;
import java.nio.file.Paths;
import tn.esprit.spring.entity.Pdf;
import tn.esprit.spring.entity.UserEntity;
import tn.esprit.spring.interfaces.IEventService;
import tn.esprit.spring.repository.EventRepository;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
@RestController
@CrossOrigin("*")
@RequestMapping("/event")
public class EvenRestController {
	
	@Autowired
	IEventService eventService;

	@Autowired
	tn.esprit.spring.repository.UserRepository userRepository ;

	/*private byte [] bytes;
	@PostMapping("/upload")
	public void uploadImage (@RequestParam("imageFile")MultipartFile file) throws IOException {
		this.bytes=file.getBytes();
	}*/
/*	@PostMapping("/addImage")
	 public RedirectView saveUser(EventEntity user,
	            @RequestParam("image") MultipartFile multipartFile) throws IOException {
	         
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        user.setImage(fileName);
	         
	        EventEntity savedUser = eventRepository.save(user);
	 
	 
	        String uploadDir = "user-photos/" + savedUser.getIdEvent();
	 
	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	         
	        return new RedirectView("/users", true);
	    }
*/
	/* @GetMapping("/users/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=event_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<EventEntity> listUsers = eventService.getAllEvents();
	         
	        Pdf exporter = new Pdf(listUsers);
	        exporter.export(response);
	         
	    }*/
	// URL : http://localhost:8090/SpringMVC/servlet/retrieveallevents
	@GetMapping("/retrieveallevents")
	@ResponseBody
	public List<EventEntity> getAllEvents() {
		return eventService.getAllEvents();
	}

	// http://localhost:8081/SpringMVC/servlet/eventname
	@GetMapping("/eventname")
	@ResponseBody
	public List<String> getAllEventNamesJPQL() {
		return eventService.getAllEventNamesJPQL();
	}

	// http://localhost:8081/SpringMVC/servlet/eventname
	@GetMapping("/searchEvent/{word}")
	@ResponseBody
	public List<EventEntity> Search(@PathVariable("word") String mot) {
		return eventService.Search(mot);
	}

	@GetMapping("/getAllEventByEnfant/{idEnf}")
	@ResponseBody
	public List<EventEntity> getAllEventByEnfant(@PathVariable("idEnf") Long idEnfant) {

		return eventService.getAllEventByEnfant(idEnfant);
	}

	// http://localhost:8081/SpringMVC/servlet/deleteEventById/1
	@DeleteMapping("/deleteEventById/{idevent}")
	@ResponseBody
	public void deleteEventById(@PathVariable("idevent") Long idEvent) {
		eventService.deleteEventById(idEvent);

	}

	// http://localhost:8081/SpringMVC/servlet/NbreEvent
	@GetMapping("/NbreEvent")
	@ResponseBody
	public int getNombreEventJPQL() {
		return eventService.getNombreEventJPQL();
	}

	/*
	 * @PutMapping("/updateEvent/{idEvent}")
	 * 
	 * @ResponseBody public ResponseEntity<String> updateEvent(@ModelAttribute
	 * EventEntity e, @PathVariable("idEvent") int idEvent,
	 * 
	 * @RequestParam("file") MultipartFile file) { ieventservice.updateEvent(e,
	 * idEvent, file); return new
	 * ResponseEntity<String>("Event updated successfully", HttpStatus.OK);
	 * 
	 * }
	 */

	// http://localhost:8081/SpringMVC/servlet/retrievealleventsoftoday
	@GetMapping("/eventToday")
	@ResponseBody
	public List<EventEntity> getAllEventPourToday() {
		return eventService.getAllEventPourToday();
	}

	// http://localhost:8081/SpringMVC/servlet/retrieve-all-eventsordonnebydate
	@GetMapping("/alleventsordonnebydate")
	@ResponseBody
	public List<EventEntity> getAllEventOrdonneParDate() {
		return eventService.getAllEventOrdonneParDate();
	}

	// http://localhost:8089/SpringMVC/stock/addReservation
	@PostMapping("/addEvent")
	@ResponseBody
	public EventEntity addEventEntity(@RequestBody EventEntity s) {
		 s.setUser(userRepository.findById((long) 1).get());
		return eventService.addEvent(s);
	}

	// http://localhost:8089/SpringMVC/stock/modify-stock
	@PutMapping("/modifyRes")
	@ResponseBody
	public EventEntity updateEvent(@RequestBody EventEntity s) {
		return eventService.updateEvent(s);
	}
	// http://localhost:8087/SpringMVC/servlet/addEvent/Reclamation_id
		@PostMapping("/addEventbyUser/{User_id}")
		@ResponseBody
		public EventEntity addEventbyUser (@RequestBody EventEntity m,  @PathVariable("User_id") Long User_id) {

			UserEntity UserEntity = new UserEntity();
			UserEntity=userRepository.findById(User_id).get();
			m.setUser(UserEntity);
			EventEntity meet = eventService.addEvent(m);
			return meet;

		}
/*	@PostMapping(value = "/ajout/{idEvent}/{iduser}")

	public ResponseEntity<String> ajout(@ModelAttribute EventEntity event, @PathVariable("iduser") Long userId) {

		return eventService.ajoutByDirecteurJardin(event, userId);
	}*/
	
	// attributes ,values,file
	/*	@PostMapping(value = "/ajout/{evenId}/{iduser}")

		public ResponseEntity<String> ajout(@PathVariable("evenId") Long evenId,@PathVariable("iduser") Long userId,
				@RequestParam("file") MultipartFile file) {

			return eventService.ajoutByDirecteurJardin(evenId,userId, file);
		}
		
		@PutMapping("/updateEvent/{idEvent}")
		@ResponseBody
		public ResponseEntity<String> updateEvent(EventEntity event, @PathVariable("idEvent") Long idEvent,
				@RequestParam("file") MultipartFile file) {
			eventService.updateEvente(event, idEvent, file);
			return new ResponseEntity<String>("Event updated successfully", HttpStatus.OK);

		}
		*/

}
