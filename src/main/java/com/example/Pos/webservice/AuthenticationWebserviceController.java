package com.example.Pos.webservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pos.business.UserService;
import com.example.Pos.data.AuthenticationRequest;
import com.example.Pos.data.User;
import com.example.Pos.util.JwtUtil;

@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationWebserviceController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	@Autowired
	JwtUtil jwtUtil;

	@CrossOrigin
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Map<String, String>> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
		Map<String, String> response = new HashMap<>();
		try {
			// Load user from the database
			UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUserName());

			// Verify the password
			if (passwordEncoder.matches(authenticationRequest.getUserPassword(), userDetails.getPassword())) {
				// Password is correct
				Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				String jwt = jwtUtil.generateToken(userDetails);
				response.put("jwt", jwt);
				return ResponseEntity.ok(response);
			} else {
				// Password is incorrect
				response.put("error", "Authentication failed: Incorrect password");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
			}
		} catch (UsernameNotFoundException e) {
			response.put("error", "Authentication failed: User not found");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		} catch (Exception e) {
			response.put("error", "Authentication failed: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

		}
	}

	@CrossOrigin
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
		Map<String, String> response = new HashMap<>();
		User createUser =  userService.createUser(user.getUserName(), user.getUserPassword(), user.getUserRole());
		if(createUser==null) {
			response.put("message", "Sign in to this account or enter an email address that isn't already in use.");
			response.put("type", "Error");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
		response.put("message", "User registered succesfully");
		response.put("type", "Error");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

}
