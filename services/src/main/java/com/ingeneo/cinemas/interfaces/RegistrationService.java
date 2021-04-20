package com.ingeneo.cinemas.interfaces;

import com.ingeneo.cinemas.bodies.RegistrationRequestBody;

public interface RegistrationService {
	
	String registerUser(RegistrationRequestBody registrationRequestBody);
	
	String confirmToken (String token);

}
