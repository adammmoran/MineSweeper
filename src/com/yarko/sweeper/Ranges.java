package com.yarko.sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoords;
    private static Random random = new Random();

    protected static void setSize(Coord _size){
        size = _size;
        allCoords = new ArrayList<Coord>();
        for(int y = 0; y < size.getY(); y++){
            for(int x = 0; x < size.getX(); x++){
                allCoords.add(new Coord(x, y));
            }
        }
    }

    public static Coord getSize(){
        return size;
    }

    public static ArrayList<Coord> getAllCoords(){
        return allCoords;
    }

    static boolean inRange(Coord coord){
        return coord.getX() >= 0 && coord.getX() < size.getX() &&coord.getY() >= 0 && coord.getY() < size.getY();
    }

    static Coord getRandomCoord(){
        return new Coord(random.nextInt(size.getX()),random.nextInt(size.getY()));
    }

    static ArrayList<Coord> getCoordsAround(Coord coord){
        Coord around;
        ArrayList<Coord> coords = new ArrayList<>();
        for(int i = coord.getX() - 1; i <= coord.getX() +1; i++){
            for(int j = coord.getY() - 1; j <= coord.getY() +1; j++){
                around = new Coord(i,j);
                if(inRange(around)){
                    if(!around.equals(coord))
                        coords.add(around);
                }
            }
        }
        return coords;
    }
}

