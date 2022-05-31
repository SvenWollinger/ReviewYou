package de.muenchen.reviewyou.excelhandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Azubi {
   private final String name;
   private final LocalDate birthday;
   private final String address;
   private final int year;
   private final String course;
   private final LocalDateTime allocationPeriodFrom;
   private final LocalDateTime allocationPeriodTo;

   public Azubi(String name, LocalDate birthday, String address, int year, String course, LocalDateTime allocationPeriodFrom, LocalDateTime allocationPeriodTo) {
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

   public LocalDateTime getAllocationPeriodFrom() {
      return allocationPeriodFrom;
   }

   public LocalDateTime getAllocationPeriodTo() {
      return allocationPeriodTo;
   }
}
