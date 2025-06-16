package com.sist.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.CampService;
import com.sist.web.vo.*;
import java.util.*;

@Controller
public class MainController {
	@Autowired
	private CampService cService;
	
	@GetMapping("/main")
	public String main_main(@RequestParam(name="page",required = false) String page,Model model)
	{
		
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end =(rowSize*curpage);
		
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<CampVO> list=cService.campListData(map); 
		int totalpage=cService.campTotalPage();
		 
		final int BLOCK=10; 
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("main_html","main/home");
		return "main";
	}
	
}
