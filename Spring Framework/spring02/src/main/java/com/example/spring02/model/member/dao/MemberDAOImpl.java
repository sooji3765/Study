package com.example.spring02.model.member.dao;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.example.spring02.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(MemberDTO dto) {

		String name = sqlSession.selectOne("member.login_check", dto);	
		return (name==null) ? false : true;
	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember",userid);
	}

	
	

}
