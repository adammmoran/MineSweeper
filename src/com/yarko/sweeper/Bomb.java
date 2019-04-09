package com.yarko.sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixBombsCount();
    }

    void start(){
        bombMap = new Matrix(Box.ZERO);
        for(int i = 0; i < totalBombs; i++){
            placeBomb();
        }
    }


    Box get(Coord coord){
        return bombMap.get(coord);
    }

    private void fixBombsCount(){
        int maxBombs = Ranges.getSize().getX() * Ranges.getSize().getY() / 2;
        if(totalBombs > maxBombs)
            totalBombs = maxBombs;
    }

    private void placeBomb(){
        while(true){
            Coord randomCoord = Ranges.getRandomCoord();
            if(Box.BOMB == bombMap.get(randomCoord))
                continue;
            bombMap.set(randomCoord, Box.BOMB);
            incNumbersAroundBomb(randomCoord);
            break;
        }
    }

    private void incNumbersAroundBomb(Coord coord){
        for (Coord around : Ranges.getCoordsAround(coord)) {
            if(Box.BOMB != bombMap.get(around))
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
        }
    }

    public int getTotalBombs() {
        return totalBombs;
    }
}
