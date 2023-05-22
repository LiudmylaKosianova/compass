package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90),
    SE(135), S(180), SW(225),
    W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {

        //throw new UnsupportedOperationException();
        if(degrees < 0){
            degrees = 360 + degrees;
        }

        if(degrees > 360){
                //find how many circles
                int circles = 360;
                while (degrees - circles > 361){
                    circles += 360;
                }
                degrees -= circles;
        }

        switch (degrees){
            case 0: Direction n = Direction.N;
            return n;
            case 45: Direction ne = Direction.NE;
            return ne;
            case 90: Direction e = Direction.E;
            return e;
            case 135: Direction se = Direction.SE;
            return se;
            case 180: Direction s = Direction.S;
            return s;
            case 225: Direction sw = Direction.SW;
            return sw;
            case 270: Direction w = Direction.W;
            return w;
            case 315: Direction nw = Direction.NW;
            return nw;
            case 360: Direction n360 = Direction.N;
            return n360;

        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        throw new UnsupportedOperationException();
    }

    public Direction opposite() {
        throw new UnsupportedOperationException();
    }

    public int differenceDegreesTo(Direction direction) {
        throw new UnsupportedOperationException();
    }
}
