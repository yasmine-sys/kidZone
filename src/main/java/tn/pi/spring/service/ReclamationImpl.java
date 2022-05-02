package tn.pi.spring.service;


import java.io.UnsupportedEncodingException;
 
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.pi.spring.Iservice.ReclamationService;
import tn.pi.spring.entity.Reclamation;


@Service
public class ReclamationImpl implements ReclamationService {
	@Autowired
    JavaMailSender mailSender;

	@Override
	public void sendEmail(Reclamation reclamation)throws MessagingException {
		
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	 
	         
	         
	                     MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	         
	                    mimeMessageHelper.setSubject(reclamation.getObjet());
	                    mimeMessageHelper.setFrom("salim");
	                    mimeMessageHelper.setTo(reclamation.getMailTo());
	                    mimeMessageHelper.setText(reclamation.getDescription());
	         
	                    mailSender.send(mimeMessageHelper.getMimeMessage());
	         
	               
	                
	}
}