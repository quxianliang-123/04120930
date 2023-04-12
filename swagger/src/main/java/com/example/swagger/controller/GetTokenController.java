package com.example.swagger.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class GetTokenController {

	//　パラメタが使用してない
	@GetMapping(path = "/customers")
	public String customers(Model model) {

		// TOKENをKEYCLOAKから取得する
		Authentication authToken = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> attributes = new HashMap<>();

		try {
			attributes = ((OAuth2AuthenticationToken) authToken).getPrincipal().getAttributes();
		} catch (Exception e) {

			//エラーを投げる
			e.getMessage();
		}

		// TOKENのpreferred_usernameをSTRINGで見る
		String a = attributes.get("preferred_username").toString();

		System.out.println(a);
		return "customers";
	}

}
