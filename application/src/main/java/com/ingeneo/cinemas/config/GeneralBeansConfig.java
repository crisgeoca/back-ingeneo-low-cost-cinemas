package com.ingeneo.cinemas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ingeneo.cinemas.impl.CinemaBranchServiceImpl;
import com.ingeneo.cinemas.impl.CityServiceImpl;
import com.ingeneo.cinemas.impl.ConfirmationTokenServiceImpl;
import com.ingeneo.cinemas.impl.EmailSenderServiceImpl;
import com.ingeneo.cinemas.impl.EmailValidatorServiceImpl;
import com.ingeneo.cinemas.impl.MovieGenreServiceImpl;
import com.ingeneo.cinemas.impl.MovieServiceImpl;
import com.ingeneo.cinemas.impl.RegistrationServiceImpl;
import com.ingeneo.cinemas.impl.RoomServiceImpl;
import com.ingeneo.cinemas.impl.TypeServiceImpl;
import com.ingeneo.cinemas.interfaces.ConfirmationTokenService;
import com.ingeneo.cinemas.interfaces.EmailSenderService;
import com.ingeneo.cinemas.repositories.CinemaBranchRepository;
import com.ingeneo.cinemas.repositories.CityRepository;
import com.ingeneo.cinemas.repositories.ConfirmationTokenRepository;
import com.ingeneo.cinemas.repositories.LoginRepositiry;
import com.ingeneo.cinemas.repositories.MovieGenreRepository;
import com.ingeneo.cinemas.repositories.MovieRepository;
import com.ingeneo.cinemas.repositories.RoomRepository;
import com.ingeneo.cinemas.repositories.TypeRepository;
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
	
	@Bean("typeServiceImpl")
	public TypeServiceImpl createTypeServiceImpl(TypeRepository typeRepository){
		return new TypeServiceImpl(typeRepository);
	}
	
	@Bean("roomServiceImpl")
	public RoomServiceImpl createRoomServiceImpl(RoomRepository roomRepository, CinemaBranchRepository cinemaBranchRepository, 
			TypeRepository typeRepository){
		return new RoomServiceImpl(roomRepository, cinemaBranchRepository, typeRepository);
	}
	
	@Bean("movieServiceImpl")
	public MovieServiceImpl createMovieServiceImpl(MovieRepository movieRepository, CinemaBranchRepository cinemaBranchRepository, 
			TypeRepository typeRepository, MovieGenreRepository movieGenreRepository){
		return new MovieServiceImpl(movieRepository, cinemaBranchRepository, typeRepository, movieGenreRepository);
	}
	
	@Bean("movieGenreServiceImpl")
	public MovieGenreServiceImpl createMovieGenreServiceImpl(MovieGenreRepository movieGenreRepository){
		return new MovieGenreServiceImpl(movieGenreRepository);
	}

}
