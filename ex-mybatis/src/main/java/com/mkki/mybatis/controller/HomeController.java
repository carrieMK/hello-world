package com.mkki.mybatis.controller;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mkki.mybatis.model.commonVO;
import com.mkki.mybatis.service.commonService;

@RestController
public class HomeController { 
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
	
	@Autowired 
	private commonService commonService; 
	
	@RequestMapping(value = "/home", method = RequestMethod.POST) 
	public void home(HttpServletRequest request) { 
		
		Enumeration<String> e = request.getParameterNames();		
		while(e.hasMoreElements()) {
			String parameterName = e.nextElement();
			logger.info("parameter Name = [" + parameterName + "]" + " ==> " + request.getParameter(parameterName));
		}
	}
		
	@RequestMapping(value = "/home1", method = RequestMethod.POST) 
	public Map<String, Object> home1(Locale locale, Model model, @RequestBody @Valid commonVO commonVo, Errors errors, HttpServletRequest request) { 
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		if(errors.hasErrors()) {
			logger.info("bindingResult.getErrorCount() ==> [{}]", errors.getErrorCount());
			logger.info("bindingResult.getErrorCount() ==> [{}]", errors.toString());
			returnMap.put("error", errors.toString()); 
			
			return returnMap;
		}
		logger.info("Welcome home! The client locale is {}.{}", locale, commonVo.toString());
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()) {
			String headerName = e.nextElement();
			logger.info("header Name = [" + headerName + "]" + " ==> " + request.getHeader(headerName));
		}
		Enumeration<String> e1 = request.getAttributeNames();		
		while(e1.hasMoreElements()) {
			String attributeName = e1.nextElement();
			logger.info("attribute Name = [" + attributeName + "]" + " ==> " + request.getAttribute(attributeName));
		}
		
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);         
        String formattedDate = dateFormat.format(date);         
        model.addAttribute("serverTime", formattedDate );
		//Map map = new HashMap(); 
		//map.put("gogaekNo", "TC00014401"); 

		returnMap.put("map", commonService.selectList(commonVo.getGogaekNo())); 
		logger.info("결과 logger:::::::::::::::: " + returnMap); 
		
		return returnMap;
	}

	@RequestMapping(value = "/home2")
	public String home2() { 
		commonVO commonVo = new commonVO();
		commonVo.setGogaekNo("TC00014401");
		List list = commonService.selectList2(commonVo);
		logger.info("결과2 logger:::::::::::::::: " + list); 
		
		return "home"; 
	}

}
