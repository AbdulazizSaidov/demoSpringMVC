package com.vibenar.mail;

import com.vibenar.utils.SetsService;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.simplejavamail.email.Email;

public class Mailer {
    private String host;
    private String port;
    private String submitter;
    private String username;
    private String password;
    private String from;

    org.simplejavamail.mailer.Mailer mailer;

    public Mailer() {
        this.host = SetsService.getCachedValue("MAIL_NOREPLY_HOST");
        this.port = SetsService.getCachedValue("MAIL_NOREPLY_PORT");
        this.submitter = SetsService.getCachedValue("MAIL_NOREPLY_USERNAME");
        this.username = SetsService.getCachedValue("MAIL_NOREPLY_USERNAME");
        this.password = SetsService.getCachedValue("MAIL_NOREPLY_PASSWORD");
        this.from = SetsService.getCachedValue("MAIL_NOREPLY_USERNAME");
        mailer = MailerBuilder
                .withSMTPServer(host, Integer.parseInt(port), username, password)
                .withTransportStrategy(TransportStrategy.SMTPS)
                .withSessionTimeout(10 * 1000)
                .clearEmailAddressCriteria() // turns off email validation
                //.withDebugLogging(true)

                .buildMailer();

    }

    public void send(String to, String content, String subject) {

        Email email = EmailBuilder.startingBlank()
                .to(to)
                .from(from)
                .withSubject(subject)
                .withHTMLText(content)
                .buildEmail();
        mailer.sendMail(email);


    }


}
