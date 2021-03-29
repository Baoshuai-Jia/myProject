package com.jia.table;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordParseToTemplate implements WordParse{

    @Override
    public Map<String, Object> parse(Map<String, Object> result ,List<IBodyElement> elements,  int index, int size) {
        return parse(result, elements, index, size,"");
    }

    @Override
    public Map<String, Object> parse(Map<String, Object> result, List<IBodyElement> elements, int index, int size, String nameRegex) {
        IBodyElement element =elements.get(index);
        if ("PARAGRAPH".equals(element.getElementType().toString()) && "TABLE".equals(elements.get(index+1).getElementType().toString()) ){
            String templateName = ((XWPFParagraph) elements.get(index)).getText();
            if (nameRegex != null && (!"".equals(nameRegex))){
                WordFilterImpl wordFilter = new WordFilterImpl();
                boolean accept = wordFilter.accept(nameRegex, templateName);
                if (!accept){
                    return result;
                }
            }
            XWPFTable table = (XWPFTable) elements.get(index + 1);
            result.put(templateName,tableToMap(table));
        }
        return result;    }

    public  LinkedList<Object> tableToMap(XWPFTable table){
        LinkedList<Object> templateCols = new LinkedList<Object>();
        LinkedList<String> templateCol = null;
        for (int i = 1; i< table.getRows().size(); i ++){
            XWPFTableRow row = table.getRow(i);
            templateCol = new LinkedList<String>();
            for (int j = 0; j < row.getTableCells().size(); j ++){
                templateCol.add(row.getCell(j).getText());
            }
            templateCols.add(templateCol);
        }
        return templateCols;
    }
}
