package com.parsakav.bookstore.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.parsakav.bookstore.request.UserLoginRequest;
import com.parsakav.bookstore.service.RoleService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;
	@Autowired
	private RoleService roleService;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {

			UserLoginRequest creds = new ObjectMapper().readValue(request.getInputStream(),
					UserLoginRequest.class);


			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(creds.getPhoneNumber(), creds.getPassword(), null));
		}catch (com.fasterxml.jackson.databind.exc.MismatchedInputException e){
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
		Authentication authResult) throws IOException, ServletException {

			String username=((User) authResult.getPrincipal()).getUsername();
		String token = Jwts.builder().setSubject(username)
				.setExpiration(dateAfterNow(SecurityConstant.EXPIRATION_TIME))
				.signWith(SecurityConstant.getSigningKey())
				.compact();



	/*	UserDetailsService userService=(UserDetailsService) SpringApplicationContext.getBean("UserDetailsImpl");
			UserDto user=userService.getUser(username);*/
		response.addHeader(SecurityConstant.HEADER_STRING, SecurityConstant.TOKEN_PREFIX + token);

		User user = (User) authResult.getPrincipal();
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		response.setContentType("application/json");
		String json = new Gson().toJson(authResult.getAuthorities());
		try (PrintWriter pw = response.getWriter()) {
			pw.println(json);
		}
			/*
			response.addHeader("UserId", user.getUserId());
*/



	}


	private Date dateAfterNow(long millis) {
		return new Date(System.currentTimeMillis()+millis);
	}
}
