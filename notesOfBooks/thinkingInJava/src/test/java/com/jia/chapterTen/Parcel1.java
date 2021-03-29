package com.jia.chapterTen;

public class Parcel1 {
    private int i = 11;
    public int value(){
        return i;
    }

    //inner class
     class Destination{
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        public String readLabel(){
            return label;
        }
    }
    //Using inner class looks just like

    public void ship(String dest){
        Destination d  = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Beijing");
    }
}
