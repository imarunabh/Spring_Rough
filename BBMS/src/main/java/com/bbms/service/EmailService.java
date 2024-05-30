package com.bbms.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject,String message,String to ) {
		boolean f = false;
		String from = "arunabhsharma012345@gmail.com";
		String host = "smtp.gmail.com";
		Properties properties= System.getProperties();
		System.out.println("PROPERTIES"+properties);
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session= Session.getInstance(properties ,new Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("arunabhsharma012345@gmail.com", "aaannn@012345");
			}
		});
		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		try {
		m.setFrom(from);
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		m.setSubject(subject);
		m.setContent(message,"text/html");
		Transport.send(m);
		System.out.println("Sent Success");
		f=true;}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
		
		
		
	}

}
