package com.stansa.util;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailUtil {

	private JavaMailSender mailSender;


    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String from, String to, String subject, String msg) {
        try {

            MimeMessage message = mailSender.createMimeMessage();

            message.setSubject(subject);
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(msg, true);
            mailSender.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getBodyVelocity(String template){
		VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();


         ArrayList list = new ArrayList();
         Map map = new HashMap();

         map.put("name", "Cow");
         map.put("price", "$100.00");
         list.add( map );
  
         map = new HashMap();
         map.put("name", "Eagle");
         map.put("price", "$59.99");
         list.add( map );

         map = new HashMap();
         map.put("name", "Shark");
         map.put("price", "$3.99");
         list.add( map );

         /*
          *  add that list to a VelocityContext
          */

         VelocityContext context = new VelocityContext();
         context.put("petList", list);


         Template t = ve.getTemplate(template);


         StringWriter writer = new StringWriter();

         t.merge( context, writer );
		return writer.toString();
	}
}
