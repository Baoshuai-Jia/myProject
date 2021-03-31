package com.jia.poi.excel;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;

public abstract class ImportExcel<T> {

    protected FileInputStream fileInputStream;

    public abstract void readExcel(String path);

    public abstract T parseToObject(Workbook workbook);

}
