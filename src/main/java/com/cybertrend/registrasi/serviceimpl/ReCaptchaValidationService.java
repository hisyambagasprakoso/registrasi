package com.cybertrend.registrasi.serviceimpl;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.cybertrend.registrasi.model.ReCaptchResponseType;

@Service
public class ReCaptchaValidationService {
    private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
    
private final String RECAPTCHA_SECRET = "6Lds7eImAAAAAG8M-ZGy_N2IjjQulca_lg9OTNnv";

    public boolean validateCaptcha(final String captchaResponse){
        if (captchaResponse == null || "".equals(captchaResponse)) {
            return false;
        }

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add("secret", RECAPTCHA_SECRET);
        requestMap.add("response", captchaResponse);

        ReCaptchResponseType apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap, ReCaptchResponseType.class);
        // if(apiResponse == null){
        //     return false;
        // }
        if(Objects.nonNull(apiResponse) && apiResponse.isSuccess()){
            return true;
        }else{
            return false;
        }

        // return Boolean.TRUE.equals(apiResponse.isSuccess());
    }
}
