package com.mkki.mybatis.service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.mkki.mybatis.dao.*;

@Service 
public class commonService { 
	
	@Autowired 
	private commonDao commonDao; 
	public List selectList(Map param){ 
		List list=commonDao.selectList(param); 
		
		return list; 
	} 
}
