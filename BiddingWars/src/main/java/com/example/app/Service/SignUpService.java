package com.example.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Model.SignUpModel;
import com.example.app.Repository.SignUpRepository;

@Service
public class SignUpService
{
	@Autowired
	SignUpRepository sr;
	public SignUpModel saveUser1(SignUpModel u)
    {
        return sr.save(u);
    }
}
