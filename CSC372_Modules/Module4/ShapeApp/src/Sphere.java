public class Sphere extends Shape {

    private final double radius;

    // Constructor //
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Method to compute surface area
    @Override
    public double surface_area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Method to compute volume
    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // toString method
    public String toString() {
        return "Sphere:\n" + "Surface Area: " + surface_area() +
                "\nVolume: " + volume();
    }

}
