package com.example.demo1.Model;

public class Location {

		 private final double[] lnglat;
		 private final String description;
		 public Location(double[] lnglat, String description) {
		   this.lnglat = lnglat;
		   this.description = description;
		 }

		 public double[] getLnglat() {
		   return lnglat;
		 }

		 public String getDescription() {
		   return description;
		 }

		
}
