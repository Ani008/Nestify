package com.example.nestify_10;

public class Property {
    private String Name;
    private String Location;
    private String Price;
    private String SquareFeet;
    private String Area;
    private String Type;

    public Property() {
        // Default constructor required for Firebase
    }

    public Property(String name, String location, String price, String squareFeet, String area, String type) {
        Name = name;
        Location = location;
        Price = price;
        SquareFeet = squareFeet;
        Area = area;
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public String getPrice() {
        return Price;
    }

    public String getSquareFeet() {
        return SquareFeet;
    }

    public String getArea() {
        return Area;
    }

    public String getType() {
        return Type;
    }
}
