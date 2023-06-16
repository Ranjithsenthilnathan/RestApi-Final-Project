package com.example.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Model.SignUpModel;
import com.example.app.Service.SignUpService;

@RestController
@CrossOrigin("http://localhost:3000")
public class SignUpController
{
	@Autowired
	SignUpService ss;
	@PostMapping("user/adduser")
	public SignUpModel saveUser1(@RequestBody SignUpModel u)
	{
	return ss.saveUser1(u);
	}
}
