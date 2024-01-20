package com.example.myapplication16;

public class Car {
    private int id;
    private String type;
    private String Company;
    private int Price;
    private int Offer;
    private String Year;
    private String FuelType;
    private int Rating;
    private String Accident;
    private String Spare;
    private String Color;
    private int doors;

    private String ImageURL;

    public Car() {
    }

    public Car(int id, String type, String company, int price, int offer, String year, String fuelType, int rating, String accident, String spare, String color, int doors, String imageURL) {
        this.id = id;
        this.type = type;
        Company = company;
        Price = price;
        Offer = offer;
        Year = year;
        FuelType = fuelType;
        Rating = rating;
        Accident = accident;
        Spare = spare;
        Color = color;
        this.doors = doors;
        ImageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getOffer() {
        return Offer;
    }

    public void setOffer(int offer) {
        Offer = offer;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getAccident() {
        return Accident;
    }

    public void setAccident(String accident) {
        Accident = accident;
    }

    public String getSpare() {
        return Spare;
    }

    public void setSpare(String spare) {
        Spare = spare;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", Company='" + Company + '\'' +
                ", Price=" + Price +
                ", Offer=" + Offer +
                ", Year='" + Year + '\'' +
                ", FuelType='" + FuelType + '\'' +
                ", Rating=" + Rating +
                ", Accident='" + Accident + '\'' +
                ", Spare='" + Spare + '\'' +
                ", Color='" + Color + '\'' +
                ", doors=" + doors +
                ", ImageURL='" + ImageURL + '\'' +
                '}';
    }
}
