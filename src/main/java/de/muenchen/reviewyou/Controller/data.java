package de.muenchen.reviewyou.Controller;

public class data {
    private String name;



    private String frage1;
    private int frage1Punkte;
    private String frage2;
    private int frage2Punkte;
    private String frage3;
    private int frage3Punkte;
    private String frage4;
    private int frage4Punkte;
    private String frage5;
    private int frage5Punkte;

    //TODO: Of course we have more Strings, add them + Getter/Setter later!

    //TODO: They also make a rating bar, we have to safe it aswell

    //Setter and Getter
    public String getName() {
        return name;
    }





    public String getFrage1() { return frage1; }
    public int getFrage1Punkte() { return frage1Punkte; }

    public String getFrage2() { return frage2; }
    public int getFrage2Punkte() { return frage2Punkte; }

    public String getFrage3() { return frage3; }
    public int getFrage3Punkte() { return frage3Punkte; }

    public String getFrage4() { return frage4; }
    public int getFrage4Punkte() { return frage4Punkte; }

    public String getFrage5() { return frage5; }
    public int getFrage5Punkte() { return frage5Punkte; }










    public void setName(String name) {
        this.name = name;
    }
}
