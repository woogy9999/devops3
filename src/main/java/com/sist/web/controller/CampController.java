package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.web.vo.*;
@Controller
public class CampController {
	
	@GetMapping("/")
	public String main_page(){
		return "main";
	}
}
