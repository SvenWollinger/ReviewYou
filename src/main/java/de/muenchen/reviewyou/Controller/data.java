//package de.muenchen.reviewyou.Controller;
//
//import java.time.LocalDate;
//
//public class data {
//    private String query1;
//    private int query1Points;
//    private String query2;
//    private int query2Points;
//    private String query3;
//    private int query3Points;
//    private String query4;
//    private int query4Points;
//    private String query5;
//    private int query5Points;
//    private String query6;
//    private int query6Points;
//    private String query7;
//    private int query7Points;
//    private String query8;
//    private int query8Points;
//    private String query9;
//    private int query9Points;
//    private String query10;
//    private int query10Points;
//    private String query11;
//    private int query11Points;
//    private String query12;
//    private int query12Points;
//    private String query13;
//    private int query13Points;
//    private String query14;
//    private int query14Points;
//    private String query15;
//    private int query15Points;
//    private String query16;
//    private int query16Points;
//    private String query17;
//    private int query17Points;
//    private String query18;
//    private int query18Points;
//    private String query19;
//    private int query19Points;
//
//
//
//    private String firstName, lastName, street, houseNumber, postalCode, location, course, intershipSection,
//            trainingArea, participationInCourses, traineesRating ,traineesSkills, traineesStrengths,
//            traineesDevelopmentFields, traineesPerspectives, traineesOtherRemarks;
//    private int vintage;
//    private double averageScore;
//    private LocalDate dateOfBirth, periodStart, periodEnd, periodOfEmployment, trainingPlan, internalTalk;
//
//
//    //Getter and Setter
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getlastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getStreet() {
//        return street;
//    }
//
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public String getHouseNumber() {
//        return houseNumber;
//    }
//
//    public void setHouseNumber(String houseNumber) {
//        this.houseNumber = houseNumber;
//    }
//
//    public String getPostalCode() {
//        return postalCode;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }
//
//    public String getIntershipSection() {
//        return intershipSection;
//    }
//
//    public void setIntershipSection(String intershipSection) {
//        this.intershipSection = intershipSection;
//    }
//
//    public String getTrainingArea() {
//        return trainingArea;
//    }
//
//    public void setTrainingArea(String trainingArea) {
//        this.trainingArea = trainingArea;
//    }
//
//    public String getParticipationInCourses() {
//        return participationInCourses;
//    }
//
//    public void setParticipationInCourses(String participationInCourses) {
//        this.participationInCourses = participationInCourses;
//    }
//
//    public String getTraineesRating() {
//        return traineesRating;
//    }
//
//    public void setTraineesRating(String traineesRating) {
//        this.traineesRating = traineesRating;
//    }
//
//    public String getTraineesSkills() {
//        return traineesSkills;
//    }
//
//    public void setTraineesSkills(String traineesSkills) {
//        this.traineesSkills = traineesSkills;
//    }
//
//    public String getTraineesStrengths() {
//        return traineesStrengths;
//    }
//
//    public void setTraineesStrengths(String traineesStrengths) {
//        this.traineesStrengths = traineesStrengths;
//    }
//
//    public String getTraineesDevelopmentFields() {
//        return traineesDevelopmentFields;
//    }
//
//    public void setTraineesDevelopmentFields(String traineesDevelopmentFields) {
//        this.traineesDevelopmentFields = traineesDevelopmentFields;
//    }
//
//    public String getTraineesPerspectives() {
//        return traineesPerspectives;
//    }
//
//    public void setTraineesPerspectives(String traineesPerspectives) {
//        this.traineesPerspectives = traineesPerspectives;
//    }
//
//    public String getTraineesOtherRemarks() {
//        return traineesOtherRemarks;
//    }
//
//    public void setTraineesOtherRemarks(String traineesOtherRemarks) {
//        this.traineesOtherRemarks = traineesOtherRemarks;
//    }
//
//    public int getVintage() {
//        return vintage;
//    }
//
//    public void setVintage(int vintage) {
//        this.vintage = vintage;
//    }
//
//    public double getAverageScore() {
//        return averageScore;
//    }
//
//    public void setAverageScore(double averageScore) {
//        this.averageScore = averageScore;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public LocalDate getPeriodStart() {
//        return periodStart;
//    }
//
//    public void setPeriodStart(LocalDate periodStart) {
//        this.periodStart = periodStart;
//    }
//
//    public LocalDate getPeriodEnd() {
//        return periodEnd;
//    }
//
//    public void setPeriodEnd(LocalDate periodEnd) {
//        this.periodEnd = periodEnd;
//    }
//
//    public LocalDate getPeriodOfEmployment() {
//        return periodOfEmployment;
//    }
//
//    public void setPeriodOfEmployment(LocalDate periodOfEmployment) {
//        this.periodOfEmployment = periodOfEmployment;
//    }
//
//    public LocalDate getTrainingPlan() {
//        return trainingPlan;
//    }
//
//    public void setTrainingPlan(LocalDate trainingPlan) {
//        this.trainingPlan = trainingPlan;
//    }
//
//    public LocalDate getInternalTalk() {
//        return internalTalk;
//    }
//
//    public void setInternalTalk(LocalDate internalTalk) {
//        this.internalTalk = internalTalk;
//    }
//
//
//
//    public String getQuery1() { return query1; }
//    public int getQuery1Points() { return query1Points; }
//
//    public String getQuery2() { return query2; }
//    public int getQuery2Points() { return query2Points; }
//
//    public String getQuery3() { return query3; }
//    public int getQuery3Points() { return query3Points; }
//
//    public String getQuery4() { return query4; }
//    public int getQuery4Points() { return query4Points; }
//
//    public String getQuery5() { return query5; }
//    public int getQuery5Points() { return query5Points; }
//
//    public String getQuery6() { return query6; }
//    public int getQuery6Points() { return query6Points; }
//
//    public String getQuery7() { return query7; }
//    public int getQuery7Points() { return query7Points; }
//
//    public String getQuery8() { return query8; }
//    public int getQuery8Points() { return query8Points; }
//
//    public String getQuery9() { return query9; }
//    public int getQuery9Points() { return query9Points; }
//
//    public String getQuery10() { return query10; }
//    public int getQuery10Points() { return query10Points; }
//
//    public String getQuery11() { return query11; }
//    public int getQuery11Points() { return query11Points; }
//
//    public String getQuery12() { return query12; }
//    public int getQuery12Points() { return query12Points; }
//
//    public String getQuery13() { return query13; }
//    public int getQuery13Points() { return query13Points; }
//
//    public String getQuery14() { return  query14; }
//    public int getQuery14Points() { return query14Points; }
//
//    public String getQuery15() { return query15; }
//    public int getQuery15Points() { return query15Points; }
//
//    public String getQuery16() { return query16; }
//    public int getQuery16Points() { return query16Points; }
//
//    public String getQuery17() { return query17; }
//    public int getQuery17Points() { return query17Points; }
//
//    public String getQuery18() { return query18; }
//    public int getQuery18Points() { return query18Points; }
//
//    public String getQuery19() { return query19; }
//    public int getQuery19Points() { return query19Points; }
//}
