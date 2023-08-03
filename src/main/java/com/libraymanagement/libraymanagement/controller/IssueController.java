package com.libraymanagement.libraymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libraymanagement.libraymanagement.entity.Book;
import com.libraymanagement.libraymanagement.entity.Issue;
import com.libraymanagement.libraymanagement.entity.Member;
import com.libraymanagement.libraymanagement.repository.BookRepository;
import com.libraymanagement.libraymanagement.repository.MemberRepository;
import com.libraymanagement.libraymanagement.service.BookService;
import com.libraymanagement.libraymanagement.service.IssueService;
import com.libraymanagement.libraymanagement.service.MemberService;

@Controller
public class IssueController {

	@Autowired 
	private IssueService issueService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/issue-form")
	public String newIssuePage(ModelMap model) { 
		model.put("memberlist", memberService.getAllUsers());
        model.put("bookslist", bookService.getAllBook());
		return "issueform";
	}
	
	/*
	 * @PostMapping("/issue-list") public String forBookBarrow(ModelMap
	 * model, @RequestParam String memberName, @RequestParam String name) {
	 * model.put("memberlist", memberService.getAllUsers()); model.put("bookslist",
	 * bookService.getAllBook()); return "issue-list"; }
	 */

	
	@GetMapping("/issue-list")
	public ModelAndView getAllBooks() {
		List<Issue> list=issueService.getAll();
		return new ModelAndView("issue-list","issue",list);
	}
	
	@PostMapping("/saveissuebook")
	public String addBook() {
		Member member = memberRepository.findById(1L).orElse(null);
        Book book = bookRepository.findById(1L).orElse(null);
		issueService.save(member,book);
		return "redirect:/issue-list";
	}
	
	/*
	 * @PostMapping("/saveissuebook") public String addBook(@ModelAttribute Issue
	 * issue) { issueService.save(issue); return "redirect:/issue-list"; }
	 */
	
//	@GetMapping("/issue-list")
//	public String listIssuePage(Model model) {
//		model.addAttribute("issues", issueService.getAllUnreturned());
//		return "/issue-list";
//	}
	
	
}
