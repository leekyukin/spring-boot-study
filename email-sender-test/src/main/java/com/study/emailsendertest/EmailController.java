package com.study.emailsendertest;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmailController {

    private final JavaMailSender mailSender;

    @PostMapping("/mail")
    public void sendMail(
            @RequestBody MailRequestDto request
    ) {
        final MimeMessagePreparator preparator = (MimeMessage message) -> {
          final MimeMessageHelper helper = new MimeMessageHelper(message);
          helper.setTo(request.getReceiver());
          helper.setSubject(request.getTitle());
          helper.setText(request.getContent());
        };

        mailSender.send(preparator);
    }
}
