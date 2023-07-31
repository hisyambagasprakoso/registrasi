package com.cybertrend.registrasi.model;

import lombok.Data;

@Data
public class ReCaptchResponseType {  
	 
	private boolean success;
	private String challenge_ts;
	private String hostname;
	
	
}   
