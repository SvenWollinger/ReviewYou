package de.muenchen.reviewyou.excelhandler;

import java.time.LocalDate;

public class Azubi {
   private String name;
   private LocalDate birthday;
   private String address;
   private int year;
   private String course;
   private LocalDate allocationPeriodFrom;
   private LocalDate allocationPeriodTo;

   public Azubi(String name, LocalDate birthday, String address, int year, String course, LocalDate allocationPeriodFrom, LocalDate allocationPeriodTo) {
      this.name = name;
      this.birthday = birthday;
      this.address = address;
      this.year = year;
      this.course = course;
      this.allocationPeriodFrom = allocationPeriodFrom;
      this.allocationPeriodTo = allocationPeriodTo;
   }

   @Override
   public String toString() {
      return name;
   }



   public String getName() {
      return name;
   }

   public LocalDate getBirthday() {
      return birthday;
   }

   public String getAddress() {
      return address;
   }

   public int getYear() {
      return year;
   }

   public String getCourse() {
      return course;
   }

   public LocalDate getAllocationPeriodFrom() {
      return allocationPeriodFrom;
   }

   public LocalDate getAllocationPeriodTo() {
      return allocationPeriodTo;
   }
}
