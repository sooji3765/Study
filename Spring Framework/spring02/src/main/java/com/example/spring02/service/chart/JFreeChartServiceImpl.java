package com.example.spring02.service.chart;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.inject.Inject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.dao.CartDAO;
import com.example.spring02.model.shop.dto.CartDTO;


@Service
public class JFreeChartServiceImpl implements JFreeChartService {

	@Inject
	CartDAO cartDao;
	
	@Override
	public JFreeChart createChart() {
		
		// 장바구니 상품 목록
		List<CartDTO> items = cartDao.cartMoney();
		
		
		// 차트에 입력할 데이터셋 객체
		DefaultPieDataset dataset =
				new DefaultPieDataset();
		
		for(CartDTO dto : items) {
			dataset.setValue(dto.getProduct_name(), dto.getMoney());
		}
		
		//차트 객체
		JFreeChart chart = null;
		String title = "장바구니 통계";
		
		try {
			
			chart = ChartFactory.createPieChart(title, dataset,
					true, true, false);
			
			//한글 처리, 차트 제목 폰트
			chart.getTitle().setFont(new Font("돋움", Font.BOLD, 15));
			
			//범례 폰트 처리
			chart.getLegend().setItemFont(new Font("돋움",Font.PLAIN,10));
			
			Font font = new Font("돋움",Font.PLAIN,12);
			Color color = new Color(0, 0, 0); //black
			
			StandardChartTheme chartTheme = (StandardChartTheme)
					org.jfree.chart.StandardChartTheme.createJFreeTheme();
			
			// 세부적으로 지정
			chartTheme.setExtraLargeFont(font);
			chartTheme.setLargeFont(font);
			chartTheme.setRegularFont(font);
			chartTheme.setSmallFont(font);
			chartTheme.setAxisLabelPaint(color);
			chartTheme.setLegendItemPaint(color);
			chartTheme.setItemLabelPaint(color);
			//폰트, 컬러 적용
			chartTheme.apply(chart);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return chart;
	}

}
