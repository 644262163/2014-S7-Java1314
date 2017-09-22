package com.demo.org.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.org.bean.Account;
import com.demo.org.service.IAccountService;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Resource
	private IAccountService accountService;
	
	
	@RequestMapping()
	public String index(ModelMap resultMap) {
		Account acc = accountService.getAccount(1);
		resultMap.addAttribute("acc",acc);
		
		return "index";
	}
}