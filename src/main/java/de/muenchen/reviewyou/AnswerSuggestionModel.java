package de.muenchen.reviewyou;

public class AnswerSuggestionModel {
    double id1;
    double id2;
    String recommendend;

    public AnswerSuggestionModel(double id1, double id2, String recommendend){
        this.id1 = id1;
        this.id2 = id2;
        this.recommendend = recommendend;
    }


    @Override
    public String toString() {
        return "AnswerSuggestionModel{" +
                "id1=" + id1 +
                ", id2=" + id2 +
                ", recommendend='" + recommendend + '\'' +
                '}';
    }
}
