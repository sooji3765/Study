package com.example.spring02.controller.chart;

import java.io.FileOutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.service.chart.JFreeChartService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping("/jchart/*")
public class JFreeChartController {

	@Inject
	JFreeChartService jFreeChartService;
	
	@RequestMapping("chart1.do")
	public void createChart1(HttpServletResponse response) {
		try {
			JFreeChart chart = jFreeChartService.createChart();
		
			//차트를 png로 export
			//write(출력스트림, 차트객체, 가로, 세로)
			ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 900, 550);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("chart2.do")
	public ModelAndView createChart2(HttpServletResponse response) {
		
		String message ="";
		try {
			JFreeChart chart = jFreeChartService.createChart();
			
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("c:/upload/test.pdf"));
			
			document.open();
			Image png = Image.getInstance(ChartUtilities.encodeAsPNG(chart.createBufferedImage(500, 500)));
			
			document.add(png);
			document.close();
			message ="pdf파일이 생성되었습니다.";
		} catch (Exception e) {
			message ="pdf파일 생성 실패.";
			e.printStackTrace();
		}
		return new ModelAndView("chart/jchart02","message",message);
	}
}
