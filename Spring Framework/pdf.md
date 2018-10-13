# PDF 문서 만들기

1. itextpdf 라이브러리
- http://itextpdf.com
- API : http://developters.itextpdf.com/examples-itext5
- 한글 처리를 위해서 폰트 정보 필요

pom.xml - 외부라이브러리 설정

~~~xml
<!-- https://mvnrepository.com/artifact/com.itextpdf/itextpdf -->
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



service 부분 처리
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
