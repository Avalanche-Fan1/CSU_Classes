public class Cylinder extends Shape {

    private final double radius;
    private final double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Method to compute surface area
    @Override
    public double surface_area() {
        return 2 * Math.PI * radius * height + 2 * Math.PI * Math.pow(radius, 2);
    }

    // Method to compute volume
    @Override
    public double volume() {
        return  Math.PI * Math.pow(radius,2) * height;
    }

    // toString method
    public String toString() {
        return "Cylinder:\n" + "Surface Area: " + surface_area() +
                "\nVolume: " + volume();
    }

}

