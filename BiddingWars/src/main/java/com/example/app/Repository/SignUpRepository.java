package com.example.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.Model.SignUpModel;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpModel,String>
{
	SignUpModel findByUsername(String username);
}
