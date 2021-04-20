package com.ingeneo.cinemas.impl;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class EmailValidatorServiceImpl implements Predicate<String>{

	@Override
	public boolean test(String t) {
		return true;
	}

}
