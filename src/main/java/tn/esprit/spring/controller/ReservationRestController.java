package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.EventEntity;
import tn.esprit.spring.entity.Pdf;
import tn.esprit.spring.entity.Pdf_Qrcode;
import tn.esprit.spring.entity.QRcode;
import tn.esprit.spring.entity.Rating;
import tn.esprit.spring.entity.ReservationEntity;
import tn.esprit.spring.entity.ReservationPK;
import tn.esprit.spring.interfaces.IEnfantService;
import tn.esprit.spring.interfaces.IEventService;
import tn.esprit.spring.interfaces.IReservationService;
import tn.esprit.spring.repository.EnfantRepository;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.ReservationRepository;
import tn.esprit.spring.service.ReservationService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Base64;

@RestController
@CrossOrigin("*")
@RequestMapping("/reservation")
public class ReservationRestController {
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";
	@Autowired
	IEventService eventService;
	@Autowired
	IEnfantService enfantService;
	@Autowired
	EnfantRepository enfantRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	IReservationService reservationService;

	/*
	 * @RequestMapping(method = RequestMethod.GET) public String index(ModelMap
	 * modelMap) { modelMap.put("reservations",
	 * reservationService.retrieveAllReservationEntities()); return
	 * "reservation/index"; }
	 */

	@RequestMapping(value = "qrcode/{id}", method = RequestMethod.GET)
	public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(QRcode.getQRCodeImage(id, 200, 200));
		outputStream.flush();
		outputStream.close();
	}

	@GetMapping("/QRcode")
	public String getQRCode(Model model) {
		String medium = "https://rahul26021999.medium.com/";
		String github = "https://github.com/rahul26021999";

		byte[] image = new byte[0];
		try {

			// Generate and Return Qr Code in Byte Array
			image = QRcode.getQRCodeImage(medium, 250, 250);

			// Generate and Save Qr Code Image in static/image folder
			QRcode.generateQRCodeImage(github, 250, 250, QR_CODE_IMAGE_PATH);

		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
		// Convert Byte Array into Base64 Encode String
		String qrcode = Base64.getEncoder().encodeToString(image);

		model.addAttribute("medium", medium);
		model.addAttribute("github", github);
		model.addAttribute("qrcode", qrcode);

		return "qrcode";
	}

	
	// http://localhost:8089/SpringMVC/stock/addReservation
	@PostMapping("/addReservation/{idenf}/{idevent}")
	@ResponseBody
	public ReservationEntity addReservationEntity(@PathVariable("idenf") Long idenf,@PathVariable("idevent") Long idevent,@RequestBody ReservationEntity s) {
		s.setEnfant(enfantRepository.findById(idenf).get());
		s.setEvent(eventRepository.findById(idevent).get());
		System.out.println("-----------------------------------------------"+s.toString()); 
		s.setValide(true);
		ReservationEntity rev = reservationService.addReservation(s);
		return rev;
	}

	// http://localhost:8089/SpringMVC/stock/remove-stock/{stock-id}
	@DeleteMapping("/removeRes/{resId}")
	@ResponseBody
	public void removeReservation(@PathVariable("resId") Long ss) {
		reservationService.deleteReservation(ss);
	}

	// http://localhost:8089/SpringMVC/stock/retrieveall
	@GetMapping("/retrieveallRes")
	@ResponseBody
	public List<ReservationEntity> getRes() {
		List<ReservationEntity> list = reservationService.retrieveAllReservationEntities();
		System.out.println(list);
		return list;
	}

	@GetMapping("/pdf")
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=event_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<ReservationEntity> listUsers = reservationService.retrieveAllReservationEntities();

		Pdf_Qrcode exporter = new Pdf_Qrcode(listUsers);
		exporter.export(response);

	}
	@GetMapping("/retrieveRes/{resId}")
	@ResponseBody
	public ReservationEntity retrieveReservation(@PathVariable("resId") Long resId) {
		return reservationService.retrieveReservation(resId);
	}
}


/*
 * @GetMapping public String main(Model model) { model.addAttribute("rating",
 * new Rating()); return "index"; }
 * 
 * @PostMapping public String save(Rating rating, Model model) {
 * model.addAttribute("rating", rating); return "saved"; }
 */
