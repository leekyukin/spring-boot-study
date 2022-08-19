package com.study.emailsendertest;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.*;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
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

    @GetMapping("/checkCode")
    public boolean checkCode(
            @RequestParam String code
    ) {
        return code.equals("1");
    }
}
