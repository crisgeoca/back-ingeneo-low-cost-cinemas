package com.ingeneo.cinemas.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.ingeneo.cinemas.interfaces.EmailSenderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService{	
	
	private static final String EMAIL_SEND_FAILED = "No se puedo enviar el email de registro - Causa %s";
	
	private final static Logger LOGGER = LoggerFactory.getLogger(EmailSenderServiceImpl.class);

    @Override
    @Async
    public void send(String to, String email) {
    	
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("crisgeoca@gmail.com", "*****");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("crisgeoca@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Confirm your email");
            message.setContent(email, "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
        	String errorMessage = String.format(EMAIL_SEND_FAILED, e.getMessage());
        	LOGGER.error(errorMessage);
            throw new IllegalStateException(errorMessage);
        }
    }
    
}
