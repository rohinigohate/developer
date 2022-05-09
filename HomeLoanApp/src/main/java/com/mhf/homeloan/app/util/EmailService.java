package com.mhf.homeloan.app.util;


import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import com.mhf.homeloan.app.exception.EmailNotSentException;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender mailSend;

	public boolean sendEmail(String subject, String body, String to) {
		MimeMessage mimeMessage = mailSend.createMimeMessage();
		boolean mailSent = false;
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setSubject(subject);
			helper.setText(body);
			helper.setTo(to);
			mailSend.send(helper.getMimeMessage());
			mailSent = true;
		} catch (Exception e) {
			throw new EmailNotSentException(e.getMessage());
		}
		return mailSent;
	}
}
