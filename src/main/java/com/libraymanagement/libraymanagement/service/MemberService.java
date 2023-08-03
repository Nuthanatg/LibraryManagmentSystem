package com.libraymanagement.libraymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraymanagement.libraymanagement.entity.Book;
import com.libraymanagement.libraymanagement.entity.Member;
import com.libraymanagement.libraymanagement.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public void save(Member userb) {
		memberRepository.save(userb);
	}
	
	public List<Member> getAllUsers(){
		return memberRepository.findAll();
	}
	
	public Member get(Long id) {
		return memberRepository.findById(id).get();
	}
	
	public List<Member> getAll() {
		return memberRepository.findAll();
	}
	
	public Member getMemberById(Long id) {
		return memberRepository.findById(id).get();
	}
	
	public void deleteById(Long id) {
		memberRepository.deleteById(id);
	}

}
