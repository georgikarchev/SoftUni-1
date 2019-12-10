package ClassBox;

import java.security.InvalidParameterException;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length)  {
        this.validate("Length", length);
        this.length = length;
    }

    private  void setWidth(double width) {
        this.validate("Width", width);
        this.width = width;
    }

    private void setHeight(double height) {
        this.validate("Height", height);
        this.height = height;
    }

    private void validate(String fieldName, double number){
        if(number <= 0){
            throw new InvalidParameterException(fieldName + " cannot be zero or negative");
        }

    }

    public double calculateSurfaceArea(){
        double surfaceArea = 2 * this.length  * this.width + 2 * this.length * this.height +
                2 * this.width * this.height;

        return surfaceArea;
    }

    public double calculateLateralSurfaceArea(){
        double lateralSurfaceArea = this.calculateSurfaceArea() -  2 * this.length * this.width;
        return lateralSurfaceArea;
    }

    public double calculateVolume(){
        double volume = this.length * this.width *this.height;
        return  volume;
    }
}
