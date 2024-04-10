package com.parsakav.bookstore.security;

import com.parsakav.bookstore.SpringApplicationContext;
import com.parsakav.bookstore.service.RoleService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AuthorizationFilter extends BasicAuthenticationFilter {


	public AuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String header = request.getHeader(SecurityConstant.HEADER_STRING);
		if (header == null || !header.startsWith(SecurityConstant.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		UsernamePasswordAuthenticationToken uToken = getAuthetication(request);
		SecurityContextHolder.getContext().setAuthentication(uToken);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthetication(HttpServletRequest request) {
		RoleService roleService= (RoleService) SpringApplicationContext.getBean("roleServiceImpl");
		String header = request.getHeader(SecurityConstant.HEADER_STRING);
		try {
			if (header != null) {

				String username = Jwts.parserBuilder().setSigningKey(SecurityConstant.getSigningKey()).build()
						.parseClaimsJws(header.replace("Bearer", "").trim()).getBody().getSubject();
				if (username != null) {
					List<GrantedAuthority> roles = new ArrayList<>();
					roles.add(new SimpleGrantedAuthority(roleService.findRole(username)));
					return new UsernamePasswordAuthenticationToken(username, null, roles);
				}
			}
		} catch (Exception e) {
e.printStackTrace();

		}
		return null;
	}
}
