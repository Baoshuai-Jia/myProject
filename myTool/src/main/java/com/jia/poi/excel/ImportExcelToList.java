package com.jia.poi.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ImportExcelToList extends ImportExcel<ArrayList<ArrayList<String>>>{

    @Override
    public void readExcel(String path) {
        try {
            fileInputStream = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            parseToObject(workbook);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ArrayList<ArrayList<String>> parseToObject(Workbook workbook) {
        ArrayList< ArrayList<String>> results = new ArrayList<ArrayList<String>>();
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {//循环sheet页
            XSSFSheet sheetAt = (XSSFSheet) workbook.getSheetAt(i);
            String sheetName = sheetAt.getSheetName();
            ArrayList<String> result = null;
            int lastRowNum = sheetAt.getLastRowNum();
            for (int j = 0; j < lastRowNum; j++) {//循环行
                result = new ArrayList<>();
                XSSFRow row = sheetAt.getRow(j);
                short lastCellNum = row.getLastCellNum();
                for (int k = 0; k < lastCellNum; k++) {
                    result.add(row.getCell(k).toString());
                }
                results.add(result);
            }
        }
        return results;
    }
}
