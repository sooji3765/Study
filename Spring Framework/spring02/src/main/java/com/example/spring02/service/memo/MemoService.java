package com.example.spring02.service.memo;

import java.util.List;
import com.example.spring02.model.memo.dto.MemoDto;

public interface MemoService {

	public List<MemoDto> list();
	public void insert(MemoDto dto);
	public MemoDto memo_view(int idx);
	public void update(MemoDto dto);
	public void delete(int idx);
}
