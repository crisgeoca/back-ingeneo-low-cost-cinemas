package com.ingeneo.cinemas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ingeneo.cinemas.impl.CinemaBranchServiceImpl;
import com.ingeneo.cinemas.impl.CityServiceImpl;
import com.ingeneo.cinemas.impl.ConfirmationTokenServiceImpl;
import com.ingeneo.cinemas.impl.EmailSenderServiceImpl;
import com.ingeneo.cinemas.impl.EmailValidatorServiceImpl;
import com.ingeneo.cinemas.impl.RegistrationServiceImpl;
import com.ingeneo.cinemas.interfaces.ConfirmationTokenService;
import com.ingeneo.cinemas.interfaces.EmailSenderService;
import com.ingeneo.cinemas.repositories.CinemaBranchRepository;
import com.ingeneo.cinemas.repositories.CityRepository;
import com.ingeneo.cinemas.repositories.ConfirmationTokenRepository;
import com.ingeneo.cinemas.repositories.LoginRepositiry;
import com.ingeneo.cinemas.security.LoginSecurityServiceImpl;

@Configuration
public class GeneralBeansConfig {
	
	@Bean("cityServiceImpl")
	public CityServiceImpl createCityServiceImpl(CityRepository cityRepository){
		return new CityServiceImpl(cityRepository);
	}
	
	@Bean("cinemaBranchServiceImpl")
	public CinemaBranchServiceImpl createCinemaBranchServiceImpl(CinemaBranchRepository cinemaBranchRepository, 
			CityRepository cityRepository, LoginRepositiry loginRepositiry){
		return new CinemaBranchServiceImpl(cinemaBranchRepository, cityRepository, loginRepositiry);
	}
	
	@Bean("loginSecurityServiceImpl")
	public LoginSecurityServiceImpl createLoginSecurityServiceImpl(LoginRepositiry loginRepositiry, 
			BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService){
		return new LoginSecurityServiceImpl(loginRepositiry, bCryptPasswordEncoder, confirmationTokenService);
	}
	
	@Bean("resgistrationServiceImpl")
	public RegistrationServiceImpl createResgistrationServiceImpl(EmailValidatorServiceImpl emailValidatorServiceImpl, 
			LoginSecurityServiceImpl loginSecurityServiceImpl, ConfirmationTokenServiceImpl confirmationTokenServiceImpl, 
			EmailSenderService emailSenderService){
		return new RegistrationServiceImpl(emailValidatorServiceImpl, loginSecurityServiceImpl, 
				confirmationTokenServiceImpl, emailSenderService);
	}
	
	@Bean("confirmationTokenServiceImpl")
	public ConfirmationTokenServiceImpl createConfirmationTokenServiceImpl(ConfirmationTokenRepository confirmationTokenRepository){
		return new ConfirmationTokenServiceImpl(confirmationTokenRepository);
	}
	
	@Bean("emailSenderServiceImpl")
	public EmailSenderServiceImpl createEmailSenderServiceImpl(){
		return new EmailSenderServiceImpl();
	}

}
