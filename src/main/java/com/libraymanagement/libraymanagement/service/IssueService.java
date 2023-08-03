package com.libraymanagement.libraymanagement.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraymanagement.libraymanagement.common.Constants;
import com.libraymanagement.libraymanagement.entity.Book;
import com.libraymanagement.libraymanagement.entity.Issue;
import com.libraymanagement.libraymanagement.entity.Member;
import com.libraymanagement.libraymanagement.repository.IssueRepository;

@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;
	
	public List<Issue> getAll() {
		return issueRepository.findAll();
	}
	
	public Issue get(Long id) {
		return issueRepository.findById(id).get();
	}
	
	/*
	 * public void save(Issue issue) { Book bookId =issue.getBook();
	 * if(ObjectUtils.isNotEmpty(bookId)) { issueRepository.save(issue); }else {
	 * 
	 * }
	 * 
	 * }
	 */
	public void save(Member member, Book book) {
        Issue issue = new Issue();
        issue.setMember(member);
        issue.setBook(book);
        
        issueRepository.save(issue);
    }

	/*
	 * public void save(Issue issue) { issueRepository.save(issue); }
	 */
	
	
//	public List<Issue> getAllUnreturned() {
//		return issueRepository.findByReturned( Constants.BOOK_NOT_RETURNED );
//	}
//	
//	public Issue addNew(Issue issue) {
//		issue.setIssueDate( new Date() );
//		issue.setReturned( Constants.BOOK_NOT_RETURNED );
//		return issueRepository.save(issue);
//	}
	
	
//	public Long getCountByMember(Member member) {
//		return issueRepository.countByMemberAndReturned(member, Constants.BOOK_NOT_RETURNED);
//	}
}
