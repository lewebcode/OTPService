package fun.justdevelops.otpservice.service;

import fun.justdevelops.otpservice.model.entity.ChannelType;
import fun.justdevelops.otpservice.service.senders.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OtpDispatcherService {
    private final List<OtpSender> senders;

    @Autowired
    public OtpDispatcherService(
            EmailOtpSender emailOtpSender,
            FileOtpSender fileOtpSender,
            SmsOtpSender smsOtpSender,
            TelegramOtpSender telegramOtpSender) {
        senders = new ArrayList<>();
        senders.add(emailOtpSender);
        senders.add(fileOtpSender);
        senders.add(smsOtpSender);
        senders.add(telegramOtpSender);
    }

    public void sendOtp(ChannelType channel, String destination, int code) {
        senders.stream()
                .filter(s -> s.getChannelType() == channel)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported channel"))
                .sendOtp(destination, code);
    }
}
