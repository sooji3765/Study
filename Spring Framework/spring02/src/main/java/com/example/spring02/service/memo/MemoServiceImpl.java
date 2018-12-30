package com.example.spring02.service.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.memo.dao.MemoDao;
import com.example.spring02.model.memo.dto.MemoDto;

@Service
public class MemoServiceImpl implements MemoService {

	@Inject // 의존관계 주입 (스프링에서 인스턴스 생성)
	MemoDao memoDao;
	
	@Override
	public List<MemoDto> list() {
		return memoDao.list();
	}

	@Override
	public void insert(MemoDto dto) {
		memoDao.insert(dto.getWriter(), dto.getMemo());
	}

	@Override
	public MemoDto memo_view(int idx) {
	
		return memoDao.memo_view(idx);
	}

	@Override
	public void update(MemoDto dto) {
		memoDao.update(dto);
	}

	@Override
	public void delete(int idx) {
		memoDao.delete(idx);

	}

}
