package com.navtech.constants;

public class SecurityConstants {
	
	public final static String SECRET = "SecretKeyToGenJWTs";
	public final static long EXPIRATION_TIME = 864_000_000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/rest/v1/student/addStudent";

}
