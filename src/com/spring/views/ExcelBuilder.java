package com.spring.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.spring.domain.PropertyBld;;

public class ExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> arg0, HSSFWorkbook arg1, HttpServletRequest arg2,
			HttpServletResponse arg3) throws Exception {
		// get data model which is passed by the spring controller
		List<PropertyBld> prptLst = (List<PropertyBld>) arg0.get("prptLst");
		
		//create a new excel sheet
		HSSFSheet sheet = arg1.createSheet("Property List");
		sheet.setDefaultColumnWidth(30);
		
		//create a style for the header row
		Font font = arg1.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		
		CellStyle style = arg1.createCellStyle();
		style.setFillBackgroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(font);
		
		//create header row
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Propterty Name");
		header.getCell(0).setCellStyle(style);
		header.createCell(1).setCellValue("Address");
		header.getCell(1).setCellStyle(style);
		header.createCell(2).setCellValue("Property Type");
		header.getCell(2).setCellStyle(style);
		header.createCell(3).setCellValue("Mobile");
		header.getCell(3).setCellStyle(style);
		header.createCell(4).setCellValue("Comment");
		header.getCell(4).setCellStyle(style);		
		//
		int rowCount = 1;
		for(PropertyBld property : prptLst) {
			HSSFRow row = sheet.createRow(rowCount);
			row.createCell(0).setCellValue(property.getPropertyName());
			row.createCell(1).setCellValue(property.getAddress().getAddress() + " " + property.getAddress().getPostcode());
			row.createCell(2).setCellValue(property.getRent_sale());
			row.createCell(3).setCellValue(property.getpAgt().getMobile());
			row.createCell(4).setCellValue(property.getComment());
			rowCount++;
		}
	}

	
}
