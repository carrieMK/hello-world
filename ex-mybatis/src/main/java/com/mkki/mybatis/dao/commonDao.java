package com.mkki.mybatis.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Repository 
public class commonDao { 
	
	@Autowired 
	@Resource(name="sqlSession") 
	private SqlSessionTemplate sqlsession; 
	
	@SuppressWarnings("unchecked") 
	public List selectList(Map param) { 
		List result = sqlsession.selectList("testSql.selectList",param); 
		
		return result ; 
	} 
}
