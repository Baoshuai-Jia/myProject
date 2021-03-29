package com.jia.ChapterEighteen;


public class Apply {

    public static void process(Processor p, Object input){
        System.out.println("using processor : "+ p.name());
        System.out.println(p.process(input));

    }

    public static String s = "Disagreement with beliefs is by definition incorrect ";
    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Downcase(),s);
    }
}

class Processor{
    public String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){
        return input;
    }
}

class Upcase extends Processor{
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor{
    @Override
    Object process(Object input) {
        return ((String)input).toLowerCase();
    }
}


