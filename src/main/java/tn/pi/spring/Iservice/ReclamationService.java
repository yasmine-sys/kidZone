package tn.pi.spring.Iservice;

import javax.mail.MessagingException;

import tn.pi.spring.entity.Reclamation;

public interface ReclamationService {
	
	    public void sendEmail(Reclamation reclamation) throws MessagingException;
	

}
