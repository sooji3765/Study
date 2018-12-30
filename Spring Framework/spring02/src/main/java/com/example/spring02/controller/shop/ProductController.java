package com.example.spring02.controller.shop;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.shop.dto.ProductDTO;
import com.example.spring02.service.shop.ProductService;

@Controller
@RequestMapping("/shop/product/*")
public class ProductController {
	
	@Inject
	ProductService productService;
	
	@RequestMapping("insert.do")
	public String insert(ProductDTO dto) {
		String filename ="-";
		if(!dto.getFile1().isEmpty()) {  // 첨부파일이 있으면
			filename = dto.getFile1().getOriginalFilename(); // 첨부파일 이름 추출
			try {	
				// 실제 스프링 파일 저장 루트, 개발 디렉토리 
				//String path="C:\\Users\\USER\\Documents\\workspace-sts-3.9.6.RELEASE\\spring02\\src\\main\\webapp\\WEB-INF\\views\\images\\"; // 업로드할 디렉토리
				
				//배포 디렉토리
				String path ="C:\\Users\\USER\\Documents\\workspace-sts-3.9.6.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
				
				// 디렉토리가 존재하지 않으면 첨부파일 이동
				new File(path).mkdir();
				// 임시 디렉로리에 파일을 지정된 파일로 이동
				dto.getFile1().transferTo(new File(path+filename));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		dto.setPicture_uri(filename);
		productService.insertProduct(dto);
		
		return "redirect:/shop/product/list.do";
	}
	
	
	@RequestMapping("list.do")
	public ModelAndView list() {
		return new ModelAndView("/shop/product_list","list",productService.listProduct());
	}
	
	@RequestMapping("detail/{product_id}")
	public ModelAndView detail(@PathVariable int product_id) {
		
		return new ModelAndView("/shop/product_detail","dto",
				productService.detailProduct(product_id));
	}
	
	@RequestMapping("write.do")
	public String write(){
		return "shop/product_write";
	}

	@RequestMapping("edit/{product_id}")
	public ModelAndView edit(@PathVariable("product_id") int product_id,
			ModelAndView mav) {
		mav.setViewName("shop/product_edit");
		mav.addObject("dto",productService.detailProduct(product_id) );
		return mav;
	}
	
	@RequestMapping("update.do")
	public String update(ProductDTO dto) {
		
		String filename ="-";
		if(!dto.getFile1().isEmpty()) {  // 첨부파일이 있으면
			filename = dto.getFile1().getOriginalFilename(); // 첨부파일 이름 추출
			try {	
				// 실제 스프링 파일 저장 루트, 개발 디렉토리 
				//String path="C:\\Users\\USER\\Documents\\workspace-sts-3.9.6.RELEASE\\spring02\\src\\main\\webapp\\WEB-INF\\views\\images\\"; // 업로드할 디렉토리
				
				//배포 디렉토리
				String path ="C:\\Users\\USER\\Documents\\workspace-sts-3.9.6.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
				
				// 디렉토리가 존재하지 않으면 첨부파일 이동
				new File(path).mkdir();
				// 임시 디렉로리에 파일을 지정된 파일로 이동
				dto.getFile1().transferTo(new File(path+filename));
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			dto.setPicture_uri(filename);
		}else { // 첨부파일 없을떄
			ProductDTO dto2 = productService.detailProduct(dto.getProduct_id());
			dto.setPicture_uri(dto2.getPicture_url());
		}
		
		productService.updateProduct(dto);
		
		return "redirect:/shop/product/list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int product_id) {
		
		String filename = productService.fileInfo(product_id);
		
		//첨부파일 삭제
		if(filename !=null && !filename.equals("-") ) {
			String path ="C:\\Users\\USER\\Documents\\workspace-sts-3.9.6.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
			File f = new File(path+filename);
			if(f.exists()) {
				f.delete();
			}
		}
		
		// 레코드 삭제
		productService.deleteProduct(product_id);
		return "redirect:/shop/product/list.do";
	}
}
