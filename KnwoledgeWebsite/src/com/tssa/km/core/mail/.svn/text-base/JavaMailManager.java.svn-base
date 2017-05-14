package com.tssa.km.core.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailManager {
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSenderMail() {
		return senderMail;
	}
	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}
	public String getReceiverMail() {
		return receiverMail;
	}
	public void setReceiverMail(String receiverMail) {
		this.receiverMail = receiverMail;
	}
	private String senderMail;
	private String receiverMail;
	private String username;
	private String password;
	private Properties javaMailProperties;
	public Properties getJavaMailProperties() {
		return javaMailProperties;
	}
	public void setJavaMailProperties(Properties javaMailProperties) {
		this.javaMailProperties = javaMailProperties;
	}
	public void sendMail3(String message){
		Session session = Session.getInstance(javaMailProperties, new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(username, password);
							}
				  });
		 session.setDebug(true);
				try {
		 
					Message mimeMessage = new MimeMessage(session);
					mimeMessage.setFrom(new InternetAddress(senderMail));
					mimeMessage.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(receiverMail));
					mimeMessage.setSubject("Online Test Registration");
					mimeMessage.setText(message);
		 
					Transport.send(mimeMessage);
		 
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
	}
	public void sendMail2(String msg){
		final String username = "onlineobjectivetest@gmail.com";
		final String password = "onlineobjectivetest";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("onlineobjectivetest@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("tbsingh@ymail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			//System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public void sendMail(String message){
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(true);
		try {
			
			Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(senderMail,"Tejbir Singh"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(receiverMail,"Tejbir Singh"));
            msg.setSubject("Online Test Registration");
            msg.setText(message);
            Transport.send(msg);
    		
		} catch (AddressException addressException) {
			addressException.printStackTrace();
		} catch (MessagingException messageException) {
			messageException.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

