package fun.justdevelops.otpservice.rest;


import fun.justdevelops.otpservice.dto.GenerateOtpRequest;
import fun.justdevelops.otpservice.dto.ResponseWithMessage;
import fun.justdevelops.otpservice.dto.ValidateOtpRequest;
import fun.justdevelops.otpservice.dto.ValidateOtpResponse;
import fun.justdevelops.otpservice.service.OtpService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OtpController {
    private final OtpService otpService;

    public OtpController(OtpService otpService) {
        this.otpService = otpService;
    }

    @PostMapping("/otp/generate")
    public ResponseWithMessage generateOtp(@RequestBody GenerateOtpRequest generateOtpRequest) {
        return otpService.generateOtp(generateOtpRequest);
    }

    @PostMapping("/otp/validate")
    public ValidateOtpResponse validateOtp(@RequestBody ValidateOtpRequest request) {
        return otpService.validateOtp(request);
    }
}
