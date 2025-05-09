package fun.justdevelops.otpservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fun.justdevelops.otpservice.model.entity.ChannelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class SignUpRequest {
    private String login;
    private String password;
    @JsonProperty("otp_destination")
    private String otpDestination;
    @JsonProperty("channel_type")
    private ChannelType channelType;
}
