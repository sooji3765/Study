package com.example.spring02.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.shop.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> listProduct() {
		return sqlSession.selectList("product.product_list");
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		
		return sqlSession.selectOne("product.product_detail",product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		
		sqlSession.update("product.update", dto);	
	}

	@Override
	public void deleteProduct(int product_id) {
		
		sqlSession.delete("product.delete", product_id);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		
		sqlSession.insert("product.insert", dto);
	}

	@Override
	public String fileInfo(int product_id) {
		
		return sqlSession.selectOne("product.fileInfo", product_id);
	}

}
