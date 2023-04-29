package com.example.secondhandcars.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class SecondHandCars {
		 @Id
	      private int sno;
	      private String brand;
	      private String model;
	      private int year_of_manufacturing;
	      private int km_driven;
	      private String fuel_type;
	      private String accidental;
	      private String transmission;
	      private String colour;
	      private String rate;
		public int getSno() {
			return sno;
		}
		public void setSno(int sno) {
			this.sno = sno;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getYear_of_manufacturing() {
			return year_of_manufacturing;
		}
		public void setYear_of_manufacturing(int year_of_manufacturing) {
			this.year_of_manufacturing = year_of_manufacturing;
		}
		public int getKm_driven() {
			return km_driven;
		}
		public void setKm_driven(int km_driven) {
			this.km_driven = km_driven;
		}
		public String getFuel_type() {
			return fuel_type;
		}
		public void setFuel_type(String fuel_type) {
			this.fuel_type = fuel_type;
		}
		public String getAccidental() {
			return accidental;
		}
		public void setAccidental(String accidental) {
			this.accidental = accidental;
		}
		public String getTransmission() {
			return transmission;
		}
		public void setTransmission(String transmission) {
			this.transmission = transmission;
		}
		public String getColour() {
			return colour;
		}
		public void setColour(String colour) {
			this.colour = colour;
		}
		public String getRate() {
			return rate;
		}
		public void setRate(String rate) {
			this.rate = rate;
		}
		
}
