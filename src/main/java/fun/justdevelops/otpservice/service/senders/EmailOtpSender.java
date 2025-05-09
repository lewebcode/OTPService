package fun.justdevelops.otpservice.service.senders;

import fun.justdevelops.otpservice.model.entity.ChannelType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailOtpSender implements OtpSender {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    public void sendOtp(String email, int code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your code: " + code);
        mailSender.send(message);
        log.info("OTP sent to email: {}", email);
    }

    @Override
    public ChannelType getChannelType() {
        return ChannelType.EMAIL;
    }
}
