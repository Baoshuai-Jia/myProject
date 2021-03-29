package com.jia.table;

import java.util.regex.Pattern;

public class WordFilterImpl implements WordFilter{

    @Override
    public boolean accept(String regex,String name) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(name).matches();
    }
}
