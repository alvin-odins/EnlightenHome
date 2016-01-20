package com.enlightenhome.mailservice.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.enlightenhome.user.model.User;

public class MailServiceUtil {

	public static void sendMail(String toAddreess,String subject,String textMessage){
		
		User usr = new User();
		
		//final String userName="someemail@mail.com";
		//final String password="onedaypassword"; 
		
		final String userName= usr.getEmail_Id();
		final String password = usr.getPassword();
		
		try {
			//mail properties
			Properties pros=new Properties();
			pros.setProperty("mail.smtp.auth", "true");
			pros.setProperty("mail.smtp.starttls.enable", "true");
			pros.setProperty("mail.smtp.host", "smtp.gmail.com");
			pros.setProperty("mail.smtp.port", "587");
			
			//authentication-properties,authntication
			Session session=Session.getInstance(pros, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
				
					return new PasswordAuthentication(userName, password);
				}
			});
			
			
			//message-using session
			//MIME-Multipurpose internet mail extension
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress("javabyraghu@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddreess));
			message.setSubject(subject);
			message.setText(textMessage);
			
			
			//send
			Transport.send(message);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
