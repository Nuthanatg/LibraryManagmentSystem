package com.libraymanagement.libraymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libraymanagement.libraymanagement.entity.Book;
import com.libraymanagement.libraymanagement.entity.Member;
import com.libraymanagement.libraymanagement.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/users_register")
	public String usersPresent() {
		return "users";
	}
	
	@GetMapping("/users_book")
	public ModelAndView getAllUsers() {
		List<Member> list=memberService.getAllUsers();
		return new ModelAndView("usersbook","user",list);
	}
	
	@PostMapping("/saveuser")
	public String addUser(@ModelAttribute Member userb) {
		memberService.save(userb);
		return "redirect:/users_book";
	}
	
	@RequestMapping("/editMember/{id}")
	public String editMember(@PathVariable("id") Long id, Model model) {
		Member u = memberService.getMemberById(id);
		model.addAttribute("user",u);
		return "userEdit";
	}
	
	@RequestMapping("/deleteMember/{id}")
	public String deleteMember(@PathVariable("id") Long id) {
		memberService.deleteById(id);
		return "redirect:/users_book";
	}

}
