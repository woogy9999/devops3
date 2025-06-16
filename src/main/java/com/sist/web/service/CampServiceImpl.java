package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.CampMapper;
import com.sist.web.vo.CampVO;

@Service
public class CampServiceImpl implements CampService {

	@Autowired
	private CampMapper mapper;
	
	public List<CampVO> campListData(Map map){
		return mapper.campListData(map);
	}
	public int campTotalPage() {
		return mapper.campTotalPage();
	}
	
}
