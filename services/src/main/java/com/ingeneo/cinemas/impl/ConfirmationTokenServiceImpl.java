package com.ingeneo.cinemas.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import com.ingeneo.cinemas.entities.ConfirmationToken;
import com.ingeneo.cinemas.interfaces.ConfirmationTokenService;
import com.ingeneo.cinemas.repositories.ConfirmationTokenRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService{
	
	private final ConfirmationTokenRepository confirmationTokenRepository;
	
	@Override
	public void saveConfirmationTokenService(ConfirmationToken ConfirmationToken) {
		
		confirmationTokenRepository.save(ConfirmationToken);		
	}

	@Override
	public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

	@Override
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

}
