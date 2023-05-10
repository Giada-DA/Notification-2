package co.develhope.email2.emails.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h1>Ce la faremo?</h1>" +
                "<h2>Forse si o forse no</h2>" +
                "<img src='https://i0.wp.com/www.dasscinemag.com/dass2021/wp-content/uploads/2020/04/Koda-fratello-orso-1.jpg?fit=1280%2C720&ssl=1' alt='Alternative text' height='200'>" +
                "<h3>" + text + "</h3>";
        helper.setText(htmlMsg, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setFrom("whanau.gda@gmail.com");
        javaMailSender.send(mimeMessage);
    }
}
