package com.wildbober.Task2;

public class Task2 {

    static Point pointXY1 = new Point(4,5);
    static Point pointXY2 = new Point(-4,5);
    static Point pointXY3 = new Point(-6,-3);
    static Point pointXY4 = new Point(6,-3);
    static Point[] points = {pointXY1, pointXY2, pointXY3, pointXY4};

    public static boolean checkPoint1and3(int x, int y, Point point){
        int newX = Math.abs(point.getX());
        int newY = Math.abs(point.getY());

        if(newX >= Math.abs(x) && newY >= Math.abs(y) && (((x >=0)&&(y >=0)) || ((x <=0)&&(y <=0)))  )
            return true;
        else
            return false;
    }

    public static boolean checkPoint2(int x, int y, Point point){
        int newX = point.getX();
        int newY = point.getY();

        if(newX <= x && newY >= y && x <=0)
            return true;
        else
            return false;
    }

    public static boolean checkPoint4(int x, int y, Point point){
        int newX = point.getX();
        int newY = point.getY();

        if(newX >= x && newY <= y && y<=0)
            return true;
        else
            return false;
    }


    public static boolean checkPosition(int x, int y){

        if(checkPoint1and3(x,y,pointXY1) == true){
           return true;
        }

        if(checkPoint1and3(x,y,pointXY3) == true){
            return true;
        }

        if(checkPoint2(x,y,pointXY2) == true){
            return true;
        }

//         if(checkPoint4(x,y,pointXY4) == true){
//            System.out.println("4");
//            return true;
//         }



        return false;
    }
}
