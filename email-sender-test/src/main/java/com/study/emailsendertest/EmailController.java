package com.study.emailsendertest;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmailController {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @PostMapping("/mail")
    public @ResponseBody void sendMail(
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

    @GetMapping("/issueCode")
    public void issueCode() {
        final MimeMessagePreparator preparator = (MimeMessage message) -> {
            final MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo("leekujin14@gmail.com");
            helper.setSubject("시크릿 코드");
            helper.setText(
                templateEngine.process("email-template",
                        new Context(Locale.KOREAN, Map.of("code", RandomCodeUtil.issue()))), true
            );
        };
        mailSender.send(preparator);
    }
}
