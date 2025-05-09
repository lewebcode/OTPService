package fun.justdevelops.otpservice.service.senders;

import fun.justdevelops.otpservice.model.entity.ChannelType;

public interface OtpSender {
    void sendOtp(String destination, int code);
    ChannelType getChannelType();
}
