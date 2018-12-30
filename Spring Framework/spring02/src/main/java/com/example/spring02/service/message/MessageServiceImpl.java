package com.example.spring02.service.message;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring02.model.message.dao.MessageDAO;
import com.example.spring02.model.message.dao.PointDAO;
import com.example.spring02.model.message.dto.MessageDTO;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	MessageDAO messageDAO;
	
	@Inject
	PointDAO pointDao;
	
	//트랜잭션 처리 대상 메서드
	@Transactional
	@Override
	public void addMessage(MessageDTO dto) {
		messageDAO.create(dto);
		
		//메시지를 보낸 회원에서 10포인트 추가
		pointDao.updatePoint(dto.getSender(), 10);
		//에러가 나면 rollback
	}

	@Override
	public MessageDTO readMessage(String userid, int mid) {
		// TODO Auto-generated method stub
		return messageDAO.readMessage(mid);
	}

}
