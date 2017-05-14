package com.tssa.km.core.mail;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleMailManager {
	 	private MailSender mailSender;
	    private SimpleMailMessage templateMessage;

	    public void setMailSender(MailSender mailSender) {
	        this.mailSender = mailSender;
	    }

	    public void setTemplateMessage(SimpleMailMessage templateMessage) {
	        this.templateMessage = templateMessage;
	    }

	    public void sendMail(String Message) {

	    	templateMessage.setText(Message);
	            
	        try{
	            this.mailSender.send(templateMessage);
	        }
	        catch(MailException ex) {
	            // simply log it and go on...
	            System.err.println(ex.getMessage());            
	        }
	    }

}
