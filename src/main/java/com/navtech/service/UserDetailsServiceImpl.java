package com.navtech.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.navtech.models.Student;
import com.navtech.repositories.StudentRepositories;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private StudentRepositories studentRepositories;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepositories.findByUsername(username);
		if(student == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(student.getUsername(), student.getPassword(), new ArrayList<>());
	}
}
