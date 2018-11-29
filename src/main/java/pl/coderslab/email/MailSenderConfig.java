package pl.coderslab.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

@Configuration
@EnableScheduling
public class MailSenderConfig {

    @Bean
    public JavaMailSender JavaSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setProtocol("smtp");
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername("9999Rena@gmail.com");
        sender.setPassword("IrenaStasko");

        Properties mailProps = new Properties();
        mailProps.put("mail.smtps.auth", "true");
        mailProps.put("mail.smtp.starttls.enable", "true");
        mailProps.put("mail.smtp.debug", "true");
//        sender.setUsername("arolicka@poczta.onet.pl");
//        sender.setPassword("Bren-paidhi1");
        sender.setJavaMailProperties(mailProps);

        return sender;
//        sender.setHost("mail.smtp.ssl.trust");
//        sender.setHost("smtp.gmail.com");
//
//        sender.getJavaMailProperties().setProperty("mail.smtp.auch", "true");
//        sender.getJavaMailProperties().setProperty("mail.smpt.socketFactory.port", "465");
//        sender.getJavaMailProperties().setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        sender.getJavaMailProperties().setProperty("mail.smtp.port", "587");
//        sender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");
//        sender.getJavaMailProperties().setProperty("mail.smtp.starttls.required", "true");
//        return sender;
    }

}
