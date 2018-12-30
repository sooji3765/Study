# PDF 문서 만들기

1. itextpdf 라이브러리
- http://itextpdf.com
- API : http://developters.itextpdf.com/examples-itext5
- 한글 처리를 위해서 폰트 정보 필요

pom.xml - 외부라이브러리 설정

~~~xml
		<dependency>
		    <groupId>com.itextpdf</groupId>
		    <artifactId>itextpdf</artifactId>
		    <version>5.5.13</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.itextpdf/itext-pdfa -->
		<dependency>
		    <groupId>com.itextpdf</groupId>
		    <artifactId>itext-pdfa</artifactId>
		    <version>5.5.13</version>
		    <scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.itextpdf/itext-xtra -->
		<dependency>
		    <groupId>com.itextpdf</groupId>
		    <artifactId>itext-xtra</artifactId>
		    <version>5.5.13</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.itextpdf.tool/xmlworker -->
		<dependency>
		    <groupId>com.itextpdf.tool</groupId>
		    <artifactId>xmlworker</artifactId>
		    <version>5.5.13</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.itextpdf/itext-asian -->
		<dependency>
		    <groupId>com.itextpdf</groupId>
		    <artifactId>itext-asian</artifactId>
		    <version>5.2.0</version>
		</dependency>
~~~



@Service 부분 처리

~~~java
package com.example.spring02.service.pdf;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.dto.CartDTO;
import com.example.spring02.service.shop.CartService;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfServiceImpl implements PdfService {

	@Inject
	CartService cartService;

	@Override
	public String createPdf() {

		String result="";

		try {

			Document document = new Document(); // pdf 문서 객체 생성

			// 저장 위치
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/upload/simple.pdf"));
			// 문서 열기
			document.open();

			// 한글 지원 폰트 지정
			BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf",BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);

			Font font = new Font(baseFont,12); // 폰트 크기
			PdfPTable table = new PdfPTable(4); // 4컬럼 테이블
			Chunk chunk = new Chunk("장바구니", font); // 출력 내용

			Paragraph ph = new Paragraph(chunk);//문단

			ph.setAlignment(Element.ALIGN_CENTER); // 가운데 정렬
			document.add(ph);//

			document.add(Chunk.NEWLINE); // 줄바꿈 처리
			document.add(Chunk.NEWLINE);

			//  페이지 나누기 :document.add(Chunk.NEXTPAGE);

			// 테이블터이틀 행 생성
			PdfPCell cell1 = new PdfPCell(new Phrase("상품명", font));
			// 정렬 가운데
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			// 테이블에 셀 추가
			table.addCell(cell1);

			PdfPCell cell2 = new PdfPCell(new Phrase("단가", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell2);

			PdfPCell cell3 = new PdfPCell(new Phrase("수량", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Phrase("금액", font));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell4);

			List<CartDTO> items = cartService.listCart("tnwl");

			for(int i=0;i<items.size();i++) {
				CartDTO dto = items.get(i);
				PdfPCell cellProductName = new PdfPCell(new
						Phrase(dto.getProduct_name(),font));
				table.addCell(cellProductName);

				PdfPCell cellPrice = new PdfPCell(new
						Phrase(""+dto.getPrice(),font));
				table.addCell(cellPrice);

				PdfPCell cellAmount = new PdfPCell(new
						Phrase(""+dto.getAmount(),font));
				table.addCell(cellAmount);

				PdfPCell cellMoney = new PdfPCell(new
						Phrase(""+dto.getMoney(),font));
				table.addCell(cellMoney);


				/*날짜 처리를 원하는 경우
				Date date = dto.getRegDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String strDate = sdf.format(date);
				 */				

			}

			//document에 추가
			document.add(table);
			document.close();

			result ="pdf 파일이 생성되었습니다.";
		} catch (Exception e) {
			result ="pfd 파일 생성 실패...";
			e.printStackTrace();
		}
		return result;
	}

}

~~~


- `servlet-context.xml` 파일에 업로드 파일 설정

~~~xml
	<!-- 파일업로드를 위한 디렉토리 설정 -->
	<!-- String uploadPath=new String("d:/upload"); -->
	<beans:bean class="java.lang.String" id="uploadPath">
	<beans:constructor-arg value="c:/upload"/>
	</beans:bean>
~~~


- googleService

~~~java
package com.example.spring02.service.chart;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.dto.CartDTO;
import com.example.spring02.service.shop.CartService;

@Service
public class GoogleChartServiceImpl implements GoogleService {

	// 장바구니 서비스 , db 정보 가져오기
	@Inject
	CartService cartService;

	@Override
	public JSONObject getChartData() {

		List<CartDTO> items=cartService.cartMoney();
		//리턴할 최종 json 객체
		JSONObject data=new JSONObject();
		//컬럼을 정의할 json 객체
		JSONObject col1=new JSONObject();
		JSONObject col2=new JSONObject();
		JSONArray title=new JSONArray();

		col1.put("label", "상품명");
		col1.put("type", "string");
		col2.put("label", "금액");
		col2.put("type", "number");
		// json 배열에 json 객체 추가
		title.add(col1);
		title.add(col2);
		data.put("cols", title);
		//json의 rows 객체구성
		JSONArray body=new JSONArray();
		for(CartDTO dto : items) {
			JSONObject name=new JSONObject();
			name.put("v", dto.getProduct_name());
			JSONObject money=new JSONObject();
			money.put("v", dto.getMoney());
			JSONArray row=new JSONArray();
			row.add(name);
			row.add(money);
			JSONObject cell=new JSONObject();
			cell.put("c", row);
			body.add(cell);
		}
		data.put("rows", body);

		return data;
	}


}
~~~

- JFreeCharService : 그래프를 그려주는 서비스

~~~java
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

~~~



- JFreeChartController : 그래프 컨트롤러
~~~java
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

~~~

- GoogleChartController

~~~java
package com.example.spring02.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.service.chart.GoogleService;

@RestController
@RequestMapping("/chart/*")
public class GoogleChartController {

	@Inject
	GoogleService googleService;

	@RequestMapping("chart1.do")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart1");
	}

	@RequestMapping("chart2.do")
	public ModelAndView chart2() {

		return new ModelAndView("chart/chart2");
	}

	//json 리턴
	@ResponseBody
	@RequestMapping("cart_money_list.do")
	public JSONObject cart_money_list() {
		return googleService.getChartData();
	}
}

~~~


-chart01.jsp

~~~xml

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- views/chart/chart01.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<%-- <%@ include file="../include/session_check.jsp" %> --%>

<!-- 구글 차트 호출을 위한 js 파일 -->
<script type="text/javascript"
src="https://www.google.com/jsapi"></script>
<script>
	//구글 차트 라이브러리 로딩
	google.load("visualization","1", {
		"packages":["corechart"]
	});
	//라이브러리 로딩이 완료되면 drawChart 함수 호출
	google.setOnLoadCallback(drawChart);
	function drawChart(){
		//차트 그리기에 필요한 json 데이터 로딩
		var jsonData=$.ajax({
			url: "${path}/json/sampleData.json",
			dataType: "json",
			async: false
		}).responseText;
		console.log(jsonData);
		//json => 데이터테이블
		var data=new google.visualization.DataTable(jsonData);
		console.log("데이터 테이블:"+data);
/* 		var chart=new google.visualization.PieChart(
				document.getElementById("chart_div")); */
/* 		var chart=new google.visualization.LineChart(
				document.getElementById("chart_div")); */
			var chart=new google.visualization.ColumnChart(
					document.getElementById("chart_div"));				
// curveType: "function" => 곡선 처리				
		chart.draw(data, {
			title: "차트 예제",
			//curveType: "function",
			width: 600,
			height: 440
		});
	}
</script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<div id="chart_div"></div>
<button id="btn" type="button" onclick="drawChart()">
refresh</button>
</body>
</html>
~~~


- chart2.jsp

~~~xml
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript"
src="https://www.google.com/jsapi"></script>
<script>
	//구글 차트 라이브러리 로딩
	google.load("visualization","1", {
		"packages":["corechart"]
	});
	//라이브러리 로딩이 완료되면 drawChart 함수 호출
	google.setOnLoadCallback(drawChart);
	function drawChart(){
		//차트 그리기에 필요한 json 데이터 로딩
		var jsonData=$.ajax({
			url: "${path}/chart/cart_money_list.do",
			dataType: "json",
			async: false
		}).responseText;
		console.log(jsonData);
		//json => 데이터테이블
		var data=new google.visualization.DataTable(jsonData);
		console.log("데이터 테이블:"+data);
/* 		var chart=new google.visualization.PieChart(
				document.getElementById("chart_div")); */
/* 		var chart=new google.visualization.LineChart(
				document.getElementById("chart_div")); */
			var chart=new google.visualization.ColumnChart(
					document.getElementById("chart_div"));				
// curveType: "function" => 곡선 처리				
		chart.draw(data, {
			title: "차트 예제",
			//curveType: "function",
			width: 600,
			height: 440
		});
	}
</script>

</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<div id=chart_div></div>
<button id="btn" type="button" onclick="drawChart">refresh</button>
</body>
</html>
~~~
