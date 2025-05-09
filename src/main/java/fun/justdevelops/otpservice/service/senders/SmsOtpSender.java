package fun.justdevelops.otpservice.service.senders;

import fun.justdevelops.otpservice.model.entity.ChannelType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsOtpSender implements OtpSender {

    @Override
    public void sendOtp(String phoneNumber, int code) {
        log.info("Sending SMS to {}: Your OTP code is {}", phoneNumber, code);
    }

    @Override
    public ChannelType getChannelType() {
        return ChannelType.SMS;
    }
}
