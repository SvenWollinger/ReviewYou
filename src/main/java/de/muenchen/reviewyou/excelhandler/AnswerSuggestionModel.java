package de.muenchen.reviewyou.excelhandler;

public class AnswerSuggestionModel {
    private int gender;
    private int grade;
    String recommendend;



    public AnswerSuggestionModel(double id1, double id2, String recommendend){
        this.gender = (int)id1;
        this.grade = (int)id2;
        this.recommendend = recommendend;
    }
    public double getGender() {
        return gender;
    } //points

    public double getGrade() {
        return grade;
    } //question

    @Override
    public String toString() {
        return "AnswerSuggestionModel{" +
                "id1=" + gender +
                ", id2=" + grade +
                ", recommendend='" + recommendend + '\'' +
                '}';
    }

    public String getRecommended(){
        return this.recommendend;
    }
}
