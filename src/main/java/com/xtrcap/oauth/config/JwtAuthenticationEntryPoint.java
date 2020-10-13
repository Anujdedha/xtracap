package com.xtrcap.oauth.config;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
/**@author ANUJ**/
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException {
	    final String expiredMsg = (String) request.getAttribute("expired");
	    final String msg = (expiredMsg != null) ? expiredMsg : "Unauthorized";
	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, msg);
	
	}
}
