package com.example.spring02.controller.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.memo.dto.MemoDto;
import com.example.spring02.service.memo.MemoService;

@Controller
@RequestMapping("/memo/*")
public class MemoController {
	
	@Inject
	MemoService memoService;
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
	
		List<MemoDto> items = memoService.list();	
		mav.setViewName("memo/memo_list"); // 포워딩할 뷰 이름
		mav.addObject("list",items); // 전달할 데이터
		
		return mav;
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemoDto dto) {
		memoService.insert(dto);
		return "redirect:/memo/list.do";
	}

	
	@RequestMapping("view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		
		return new ModelAndView("memo/view","dto",memoService.memo_view(idx));
	}
	
	@RequestMapping("update/{idx}")
	public String update(@PathVariable int idx, @ModelAttribute MemoDto dto) {
		
		memoService.update(dto);
		return "redirect:/memo/list.do";
	}
	
	@RequestMapping("delete/{idx}")
	public String delete(@PathVariable int idx) {

		memoService.delete(idx);
		return "redirect:/memo/list.do";
	}
}
