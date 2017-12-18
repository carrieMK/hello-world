package com.mkki.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.mkki.mybatis.service.*;

@Controller
public class HomeController { 
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
	
	@Autowired 
	private commonService commonService; 
	
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String home(Locale locale, Model model) { 
		Map map = new HashMap(); 
		map.put("sujuNo", "TC0001438700005"); 
		List list=commonService.selectList(map); 
		logger.info("°á°ú logger:::::::::::::::: "+list); 
		
		return "home"; 
	} 
}
