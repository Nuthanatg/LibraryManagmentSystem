package com.libraymanagement.libraymanagement.restcontroller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libraymanagement.libraymanagement.common.Constants;
import com.libraymanagement.libraymanagement.entity.Book;
import com.libraymanagement.libraymanagement.entity.Issue;
import com.libraymanagement.libraymanagement.entity.Member;
import com.libraymanagement.libraymanagement.service.BookService;
import com.libraymanagement.libraymanagement.service.IssueService;
import com.libraymanagement.libraymanagement.service.MemberService;

@RestController
@RequestMapping(value = "/rest/issue")
public class IssueRestController {
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private IssueService issueService;
	
	@GetMapping(value = {"/", "/list"})
	public List<Issue> all() {
		return issueService.getAll();
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@RequestParam Map<String, String> payload) {
		
		String memberIdStr = (String)payload.get("member");
		String[] bookIdsStr = payload.get("books").toString().split(",");
		
		Long memberId = null;
		List<Long> bookIds = new ArrayList<Long>();
		try {
			memberId = Long.parseLong( memberIdStr );
			for(int k=0 ; k<bookIdsStr.length ; k++) {
				bookIds.add( Long.parseLong(bookIdsStr[k]) );
			}
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			return "invalid number format";
		}	
		
		return "success";
	}
}
