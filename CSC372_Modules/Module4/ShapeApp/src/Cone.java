public class Cone extends Shape {
    private final double radius;
    private final double height;

    // Constructor //
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Method to compute surface area //
    @Override
    public double surface_area() {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }

    // Method to compute volume //
    @Override
    public double volume() {
        return  Math.PI * Math.pow(radius,2) * height / 3;
    }

    // toString method //
    public String toString() {
        return "Cone:\n" + "Surface Area: " + surface_area() +
                "\nVolume: " + volume();
    }
}
