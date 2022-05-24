package de.muenchen.reviewyou.excelhandler;

import java.util.ArrayList;
import java.util.List;

public class AnswerSuggestionModel {
    int id1;
    int id2;
    String recommendend;



    public AnswerSuggestionModel(double id1, double id2, String recommendend){
        this.id1 = (int)id1;
        this.id2 = (int)id2;
        this.recommendend = recommendend;
    }

    public  List<AnswerSuggestionModel> specificListForQuestion(GradingCatalogue a, QuestionCatalogue b, List<AnswerSuggestionModel> list){
        List<AnswerSuggestionModel> specificList = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i).getId1() == a.ordinal() && list.get(i).getId2() == b.ordinal()){
                specificList.add(list.get(i));
            }
        }
        return specificList;
    }


    public double getId1() {
        return id1;
    }

    public double getId2() {
        return id2;
    }

    public String getRecommendend() {
        return recommendend;
    }

    @Override
    public String toString() {
        return "AnswerSuggestionModel{" +
                "id1=" + id1 +
                ", id2=" + id2 +
                ", recommendend='" + recommendend + '\'' +
                '}';
    }

    public String getRecommended(){
        return this.recommendend;
    }


}
