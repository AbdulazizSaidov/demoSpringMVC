package com.vibenar.mail;

import com.vibenar.utils.SetsService;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailSubmitService {

    public static void sendDocflowEmail(String _email, String text) throws MessagingException {

        try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {
            context.load("classpath:applicationContext.xml");
            context.refresh();
            JavaMailSender mailSender = context.getBean("mailSender", JavaMailSender.class);
            SimpleMailMessage templateMessage = context.getBean("templateMessage", SimpleMailMessage.class);

            // Создаём потокобезопасную копию шаблона.
            SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);

            //TODO: Сюда напишите свой e-mail получателя.
            mailMessage.setTo(_email);

            mailMessage.setText(SetsService.getCachedValue(text));
            try {
                mailSender.send(mailMessage);
            } catch (MailException mailException) {
                mailException.printStackTrace();
            }
        }

    }
}
