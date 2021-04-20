package com.ingeneo.cinemas.security;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ingeneo.cinemas.entities.ConfirmationToken;
import com.ingeneo.cinemas.entities.Users;
import com.ingeneo.cinemas.interfaces.ConfirmationTokenService;
import com.ingeneo.cinemas.repositories.LoginRepositiry;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginSecurityServiceImpl implements UserDetailsService{
	
	private static final String USER_NOT_FOUND = "User with email %s not found";
	
	private final LoginRepositiry loginRepositiry;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return loginRepositiry.findByEmail(username)
				.orElseThrow(() 
						-> new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
	}
	
	public String signUpUser(Users users) {
		
		boolean emailRegistered = loginRepositiry.findByEmail(users.getEmail()).isPresent();
		
		if(emailRegistered) {
			throw new IllegalStateException("Email already registered");
		}
		
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		loginRepositiry.save(users);
		
		String token = UUID.randomUUID().toString();
		confirmationTokenService.saveConfirmationTokenService(ConfirmationToken.builder()
				.token(token)
				.createdAt(LocalDateTime.now())
				.expiresAt(LocalDateTime.now().plusMinutes(5))
				.users(users)
				.build());
		return token;
	}
	
	public int enableAppUser(String email) {
        return loginRepositiry.enableAppUser(email);
    }

}
