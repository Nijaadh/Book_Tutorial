package com.electron.electron.controller;

import com.electron.electron.common.CommonResponse;
import com.electron.electron.dto.LoginRequestDto;
import com.electron.electron.dto.SignUpRequestDto;
import com.electron.electron.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="tutorial/v1/login/")
public class LoginController {

    @Autowired
    LoginService loginService;
    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        CommonResponse commonResponse = loginService.signUp(signUpRequestDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse> login(@RequestBody LoginRequestDto loginRequestDto){
        CommonResponse commonResponse = loginService.login(loginRequestDto);
        return ResponseEntity.status(commonResponse.getStatus()).body(commonResponse);
    }
}
