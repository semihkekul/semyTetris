package com.semih;

public class Location {
    int x;
    int y;
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return String.valueOf(x) + " " + String.valueOf(y);
    }
}
