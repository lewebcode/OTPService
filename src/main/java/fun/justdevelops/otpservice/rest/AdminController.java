package fun.justdevelops.otpservice.rest;


import fun.justdevelops.otpservice.dto.DeleteUserRequest;
import fun.justdevelops.otpservice.dto.GetUserResponse;
import fun.justdevelops.otpservice.dto.ResponseWithMessage;
import fun.justdevelops.otpservice.dto.SetOtpConfigRequest;
import fun.justdevelops.otpservice.model.entity.OtpConfig;
import fun.justdevelops.otpservice.service.OtpConfigService;
import fun.justdevelops.otpservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final OtpConfigService otpConfigService;
    private final UserService userService;

    @Autowired
    public AdminController(OtpConfigService otpConfigService, UserService userService) {
        this.otpConfigService = otpConfigService;
        this.userService = userService;
    }

    @GetMapping("/get-otp-config")
    public OtpConfig getOtpConfig() {
        return otpConfigService.get();
    }

    @PostMapping("/set-otp-config")
    public OtpConfig setOtpConfig(@RequestBody SetOtpConfigRequest request) {
        return otpConfigService.set(request);
    }

    @GetMapping("/get-users")
    public List<GetUserResponse> getUsers() {
        return userService.getUsersInfo();
    }

    @PostMapping("/delete-user")
    public ResponseEntity<ResponseWithMessage> deleteUser(@RequestBody DeleteUserRequest deleteUserRequest) {
        return  userService.deleteUser(deleteUserRequest);
    }
}
