package com.stansa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

import com.stansa.util.EmailUtil;

public class EnvioCorreoJobService {
	@Autowired
	@Qualifier("mailMail")
	private EmailUtil mailSender;
	
	private static final String templateEmail = "templateEmail/email_html.vm";

	// @Scheduled(cron="*/5 * * * * ?")//5 segundos
	@Scheduled(cron="0 0/13 11 * * *")// 11.13am
	public void demoServiceMethod() {
		String body = mailSender.getBodyVelocity(templateEmail);
		mailSender.sendMail("sleivac90@gmail.com", "sleivac90@gmail.com",
				"test html email", body);
	}
}
