package com.jia.table;

import org.apache.poi.xwpf.usermodel.IBodyElement;

import java.util.List;
import java.util.Map;

public interface WordParse {
    public Map<String, Object> parse(Map<String, Object> result,List<IBodyElement> elements, int index, int size);

    public Map<String, Object> parse(Map<String, Object> result,List<IBodyElement> elements, int index, int size, String nameRegex);
}
