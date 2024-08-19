package com.example.Pos.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Pos.data.User;
import com.example.Pos.data.UserRepository;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private final UserRepository userRepository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
		builder.password(user.getUserPassword());
		builder.roles(user.getUserRole());
		return builder.build();
	}
	
	public User createUser(String username, String password, String role) {
		User newUser = new User();
		User existUser = userRepository.findByUserName(username);
		if(!(existUser ==null)) {
			return null;
		}
		newUser.setUserName(username);
		newUser.setUserPassword(passwordEncoder.encode(password));
		newUser.setUserRole(role);
		return userRepository.save(newUser);
	}
	
	
}
