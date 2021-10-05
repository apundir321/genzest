package com.howtodoinjava.listener;


import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.howtodoinjava.OnRegistrationCompleteEvent;
import com.howtodoinjava.model.User;
import com.howtodoinjava.security.IUserService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;



@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private IUserService service;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;

    // API

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);
//        final SimpleMailMessage email = constructEmailMessage(event, user, token);
//        mailSender.send(email);
       constructEmailMessage(event, user, token);
//        mailSender.send(email);
    }

    
    private void constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token) {
      
    	System.out.println("sending email");
    	final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = event.getAppUrl() + "/registrationConfirm.html?token=" + token;
        final String message = messages.getMessage("message.regSuccLink", null, "You registered successfully. To confirm your registration, please click on the below link.", event.getLocale());
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
//        return email;
        List<String> sendList = Arrays.asList(recipientAddress);
////        sendMailViaGodaddy("support@genzest.com", "support@genzest", sendList, subject, message + " \r\n" + confirmationUrl);
        sendMailViaAws("support@genzest.com", "support@genzest", sendList, subject, message + " \r\n" + confirmationUrl);
    }
    
    public  void sendMailViaGodaddy(String from, String password,List<String> to,String subject,String text ) {
        try {
        	
        	System.out.println("sending email");
          Properties props = System.getProperties();
          props.setProperty("mail.transport.protocol", "smtp");
          props.setProperty("mail.host", "smtpout.secureserver.net");
                       
 
         props.put("mail.smtp.auth", "true");
         props.setProperty("mail.user", from);
         props.setProperty("mail.password", password);
         
        Session mailSession = Session.getDefaultInstance(props, null);
        // mailSession.setDebug(true);
        Transport transport = mailSession.getTransport("smtp");
        MimeMessage message = new MimeMessage(mailSession);
        message.setSentDate(new java.util.Date());
        message.setSubject(subject);
        message.setFrom(new InternetAddress(from));
        for (int i=0;i < to.size();i++)
        {
                                         
         message.addRecipient(Message.RecipientType.TO, new  
          InternetAddress(to.get(i)));
        }
               
        message.setText(text);
 
                        transport.connect("smtpout.secureserver.net",from,password);
        transport.sendMessage(message,
         message.getRecipients(Message.RecipientType.TO));
        
        System.out.println("email sent");
        transport.close();
                       
         
        } catch (Exception e) {
        	System.out.println("exception occured");
        }
   }
    
    public  void sendMailViaAws(String from, String password,List<String> to,String subject,String text ) {
        try {
        	String SMTP_USERNAME = "AKIAR6ST375ZJTBO7IEQ";
        	 String SMTP_PASSWORD = "BAyh53Fh4w6NQUF0o2ZRd6K8mKforvYGYZMUUAwdF4uF";
        	 String HOST = "email-smtp.us-east-2.amazonaws.com";
        	 int PORT = 587;
        	System.out.println("sending email");
          Properties props = System.getProperties();
          props.setProperty("mail.transport.protocol", "smtp");
          props.setProperty("mail.host", "smtpout.secureserver.net");
          props.put("mail.smtp.port", PORT);
 
         props.put("mail.smtp.auth", "true");
//         props.setProperty("mail.user", from);
//         props.setProperty("mail.password", password);
         
        Session mailSession = Session.getDefaultInstance(props, null);
        // mailSession.setDebug(true);
        Transport transport = mailSession.getTransport("smtp");
        MimeMessage message = new MimeMessage(mailSession);
        message.setSentDate(new java.util.Date());
        message.setSubject(subject);
        message.setFrom(new InternetAddress(from));
        for (int i=0;i < to.size();i++)
        {
                                         
         message.addRecipient(Message.RecipientType.TO, new  
          InternetAddress(to.get(i)));
        }
               
        message.setText(text);
 
                        transport.connect(HOST,SMTP_USERNAME,SMTP_PASSWORD);
        transport.sendMessage(message,
         message.getRecipients(Message.RecipientType.TO));
        
        System.out.println("email sent");
        transport.close();
                       
         
        } catch (Exception e) {
        	System.out.println("exception occured");
        }
   }
}

