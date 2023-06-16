package com.example.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.Model.LoginModel;
import com.example.app.Service.LoginService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController
{
	@Autowired
	LoginService usrService;
	@PostMapping("user/checkLogin")
		public String validateUser(@RequestBody LoginModel u)
		{
		System.out.println(u.getUsername());
			return usrService.validateUser(u.getUsername(),u.getPassword());
		}
	@PostMapping("/addUser")
	public LoginModel saveUser(@RequestBody LoginModel u)
	{
	return usrService.saveUser(u);
	}
	@GetMapping("/userdetails")
    public List<LoginModel> getDetails()
    {
    	return usrService.getDetails();
    }
}
