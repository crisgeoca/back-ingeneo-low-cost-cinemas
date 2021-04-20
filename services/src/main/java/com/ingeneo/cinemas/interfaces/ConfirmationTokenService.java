package com.ingeneo.cinemas.interfaces;

import java.util.Optional;

import com.ingeneo.cinemas.entities.ConfirmationToken;

public interface ConfirmationTokenService {
	
	void saveConfirmationTokenService(ConfirmationToken ConfirmationToken);
	
	public Optional<ConfirmationToken> getToken(String token);
	
	public int setConfirmedAt(String token);

}
