package springboot.filter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getServletPath().equals("/login")) {
			filterChain.doFilter(request, response);
		} else {
			String access_token = request.getHeader("access_token");
			if(access_token != null) {
				System.out.println("hehe");
				try{Algorithm algorithm = Algorithm.HMAC256("hehe");
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(access_token);
				String username = decodedJWT.getSubject();
				String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
				List<SimpleGrantedAuthority> authorities = new ArrayList<>();
				Arrays.stream(roles).forEach(x -> {
					authorities.add(new SimpleGrantedAuthority(x));
				});
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, authorities);
				SecurityContextHolder.getContext().setAuthentication(authToken);
				filterChain.doFilter(request, response);
				}catch(Exception e) {
					System.out.println("Lỗi Auth!");
				}
			} else {
				filterChain.doFilter(request, response);
			}
			
		}
	}

}
