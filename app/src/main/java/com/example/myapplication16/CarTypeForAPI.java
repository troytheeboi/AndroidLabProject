package com.example.myapplication16;

public class CarTypeForAPI {
    private int id;
    private String type;

    public CarTypeForAPI(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public CarTypeForAPI() {

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

    @Override
    public String toString() {
        return "CarTypeForAPI{" + "\nid= " + id + "\ntype= " + type +'\n'+'}'+'\n';
    }

}
