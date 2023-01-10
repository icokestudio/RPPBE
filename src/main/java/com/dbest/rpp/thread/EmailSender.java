/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbest.rpp.thread;

import com.dbest.rpp.entity.CourseOperator;
import com.dbest.rpp.entity.Student;
import com.dbest.rpp.util.Constants;
import com.dbest.rpp.util.HelperFunc;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author felix
 */
public class EmailSender implements Runnable,Constants {
    private  String HOST = "smtp.gmail.com";
    private  String USER = "courseallocation@gmail.com";
    private  String PASSWORD = "Timmycoke";
    private  String PORT = "465";
    private  String FROM = "courseallocation@gmail.com";
    private  String TO;
 
    private  String STARTTLS = "true";
    private  String AUTH = "true";
    private  String DEBUG = "true";
    private  String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private  String SUBJECT;
    private  String TEXT;

    public EmailSender(Object user,String type,String link,String value,String subject) throws MalformedURLException, IOException {
        if(user instanceof Student){
            this.TO=((Student) user).getEmailAddress(); 
             TEXT=HelperFunc.emailGenerator(((Student) user).getFirstname(), link,value,type);
        } else{
            this.TO=((CourseOperator) user).getEmailAddress(); 
            TEXT=HelperFunc.emailGenerator(((CourseOperator) user).getFirstname(), link,value,type);
        }
        this.SUBJECT=subject;
    }
    
    

    @Override
    public void run() {
        try {
            sendEmail();
        } catch (MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void sendEmail() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.user", FROM);
 
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.debug", DEBUG);
 
        props.put("mail.smtp.socketFactory.port", PORT);
        props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "true");

       Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PASSWORD);
            }
        });
 
            //Construct the mail message
            MimeMessage message = new MimeMessage(session);
            message.setContent(TEXT,"text/html");
            message.setSubject(SUBJECT);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(RecipientType.TO, new InternetAddress(TO));
            message.saveChanges();
 
            //Use Transport to deliver the message
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
    }
   
}
