package com.electron.electron.service;

import com.electron.electron.Util.JwtUtils;
import com.electron.electron.common.CommonResponse;
import com.electron.electron.dto.LoginRequestDto;
import com.electron.electron.dto.SignUpRequestDto;
import com.electron.electron.entity.User;
import com.electron.electron.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;
    public CommonResponse signUp(SignUpRequestDto signUpRequestDto) {
        CommonResponse commonResponse = new CommonResponse();;

        //validation

        //Dto to Entity conversion n
        User user = new User();

        user.setName(signUpRequestDto.getName());
        user.setGender(signUpRequestDto.getGender());
        user.setEmailid(signUpRequestDto.getEmailid());
        user.setPhoneNumber(signUpRequestDto.getPhoneNumber());
        user.setPassword(signUpRequestDto.getPassword());

        //store Entity
        User savedUser = userRepository.save(user);

//        commonResponse.setData(savedUser);


        String token = jwtUtils.generateJwtToken(savedUser);

        Map<String,Object>tokenData=new HashMap<>();
        tokenData.put("token",token);

        commonResponse.setData(tokenData);


        return commonResponse;
    }

    public CommonResponse login(LoginRequestDto loginRequestDto) {
        CommonResponse commonResponse = new CommonResponse();
        //validation

        //verify user exsist with given email and password

       User user = userRepository.findOneByEmailIdIgnoreCaseAndPassword(loginRequestDto.getEmailId(), loginRequestDto.getPassword());
        if(user==null){
            commonResponse.setData("user login faild!");
        }

        String token = jwtUtils.generateJwtToken(user);

        Map<String,Object>tokenData=new HashMap<>();
        tokenData.put("token",token);

        commonResponse.setData(tokenData);
        //return
        return commonResponse;
    }
}
