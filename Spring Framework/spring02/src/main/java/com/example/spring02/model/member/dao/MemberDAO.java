package com.example.spring02.model.member.dao;

import javax.servlet.http.HttpSession;

import com.example.spring02.model.member.dto.MemberDTO;

public interface MemberDAO {
	
	public boolean loginCheck(MemberDTO dto);
	public MemberDTO viewMember(String userid);
	

}
