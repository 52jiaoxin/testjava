package com.psx;

import java.util.Objects;

/**
 * @author psx
 * @date 2021/2/28 8:32
 */
class GeometricObject {
    protected String color;
    protected double weight;

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double findArea(){
        return 0;
    }
}
class Circle extends GeometricObject{
    private double radius;

    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI*radius*radius;
    }
}
class MyRectangle extends GeometricObject{
    private double width;
    private double height;
    public MyRectangle(double width,double height,String color, double weight) {
        super(color, weight);
        this.width=width;
        this.height=height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double findArea(){
        return width*height;
    }


}

public class GeometricTest{
    public static void main(String[] args) {
        GeometricTest geometricTest=new GeometricTest();
        Circle c1=new Circle(1.0,"white",1.2);
        geometricTest.displayGeometricObject(c1);

    }


    public boolean equalsArea(GeometricObject o1,GeometricObject o2){
        return o1.findArea()==o2.findArea();

    }
    public  void displayGeometricObject(GeometricObject o1) {
        System.out.println(o1.findArea());
    }
}
