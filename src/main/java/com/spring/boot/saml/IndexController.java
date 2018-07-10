package com.spring.boot.saml;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableOAuth2Sso
@RestController
public class IndexController {

	@Autowired
	private RestTemplate restTemplate;
	
    @RequestMapping("/")
    public String index(Principal principal) {
    	String user =principal.getName();
    	
    	String url ="http://localhost:8080/oauth/token";
		System.out.println("after url");
	//	String result = restTemplate.getForObject(url, String.class);
	//	System.out.println("uuuuuuuuuuuuuuuuuuuuurk=l"+result);
        return "email id from principal " + user ;
    }
}
