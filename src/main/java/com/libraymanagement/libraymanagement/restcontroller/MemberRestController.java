package com.libraymanagement.libraymanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraymanagement.libraymanagement.entity.Book;
import com.libraymanagement.libraymanagement.entity.Member;
import com.libraymanagement.libraymanagement.service.MemberService;

@RestController
@RequestMapping(value = "/rest/member")
public class MemberRestController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = {"/", "/list"})
	public List<Member> all() {
		return memberService.getAll();
	}
	
	@GetMapping("/particularUser")
	public Member getuser(@PathVariable("id") Long id) {
		return memberService.getMemberById(id);
		}
}
