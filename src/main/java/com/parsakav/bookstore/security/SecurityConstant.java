package com.parsakav.bookstore.security;

import java.security.Key;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class SecurityConstant {
	public final static  String SIGN_UP_URL="/api/signup";
public static final long EXPIRATION_TIME=864000000;//10 days
public static final String TOKEN_PREFIX="Bearer ";
public static final String TOKEN_SECRET="snvmzmsckvnmxvmslamvlsmlmvlsmlvmcmzmvsnmsssssssss1211mxn";
public static final String HEADER_STRING="Authorization";

public static Key getSigningKey() {
	  byte[] keyBytes = Decoders.BASE64.decode(SecurityConstant.TOKEN_SECRET);
	  return Keys.hmacShaKeyFor(keyBytes);
	}

}
