package com.jia;

import com.jia.table.WordParseToTemplate;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordTest {
    private String path = "/Users/jia/Downloads/XML节点TAG.docx";

    @Test
    public void readAndWriterTest3Doc() throws IOException {
        File file = new File("C:\\Users\\tuzongxun123\\Desktop\\aa.doc");
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument doc = new HWPFDocument(fis);
            String doc1 = doc.getDocumentText();
            System.out.println(doc1);
            StringBuilder doc2 = doc.getText();
            System.out.println(doc2);
            Range rang = doc.getRange();
            String doc3 = rang.text();
            System.out.println(doc3);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readAndWriterTest4Docx() throws IOException {
        File file = new File(path);
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            List<IBodyElement> elements = xdoc.getBodyElements();
            WordParseToTemplate parse = new WordParseToTemplate();
            int elementSize = elements.size();
            Map<String, Object> result = new HashMap<String, Object>();
            for (int index = 0; index < elementSize-1; index++){
                parse.parse(result, elements, index, elementSize);
            }
            //生成sql

            System.out.println(result.size());
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
