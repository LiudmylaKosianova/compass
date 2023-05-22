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
        if(degrees < 0 || degrees > 360){
            degrees = adjustDegrees(degrees);
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
    private static int adjustDegrees(int degrees){
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
        return degrees;
    }

    public static Direction closestToDegrees(int degrees) {

        //throw new UnsupportedOperationException();
        if(degrees < 0 || degrees > 360){
            degrees = adjustDegrees(degrees);
        }
        if(degrees < 23 || degrees > 337){
            return Direction.N;
        }else if(degrees >= 23 && degrees <= 67){
            return Direction.NE;
        }else if(degrees > 67 && degrees <= 112){
            return Direction.E;
        }else if(degrees >112 && degrees <= 157){
            return Direction.SE;
        }else if(degrees >157 && degrees <= 202){
            return Direction.S;
        }else if(degrees >202 && degrees <= 247){
            return Direction.SW;
        }else if(degrees > 247 && degrees <= 292){
            return Direction.W;
        }else if(degrees > 292 && degrees <= 337){
            return Direction.NW;
        }
        return null;
    }

    public Direction opposite() {
        //throw new UnsupportedOperationException();
        if(this.equals(Direction.N)){
            return Direction.S;
        }else if(this.equals((Direction.NE))){
            return Direction.SW;
        }else if(this.equals((Direction.E))){
            return Direction.W;
        }else if(this.equals((Direction.SE))){
            return Direction.NW;
        }else if(this.equals((Direction.S))){
            return Direction.N;
        }else if(this.equals((Direction.SW))){
            return Direction.NE;
        }else if(this.equals((Direction.W))){
            return Direction.E;
        }else if(this.equals((Direction.NW))){
            return Direction.SE;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        //throw new UnsupportedOperationException();
        if(this.equals(direction)){
            return 0;
        }
        int thisDegrees = this.degrees;
        int directionDegrees = direction.degrees;
        int answer = thisDegrees - directionDegrees;
        if(answer<0){
            answer *= -1;
        }
        if(answer > 180){
        answer =  360 - answer;}
        return answer;
    }
}
