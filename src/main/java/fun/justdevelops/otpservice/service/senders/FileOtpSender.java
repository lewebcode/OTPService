package fun.justdevelops.otpservice.service.senders;

import fun.justdevelops.otpservice.model.entity.ChannelType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class FileOtpSender implements OtpSender {

    @Value("${otp.file.path:otp_codes.txt}")
    private String filePath;

    @Override
    public void sendOtp(String filename, int code) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(String.format("[%s] OTP: %d%n", LocalDateTime.now(), code));
        } catch (IOException e) {
            log.error("Error writing OTP to file", e);
            throw new RuntimeException("File write error", e);
        }
    }

    @Override
    public ChannelType getChannelType() {
        return ChannelType.FILE;
    }
}
