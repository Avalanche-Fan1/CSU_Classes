import java.lang.reflect.Array;

public class ShapeArray {
    public static void main(String[] args) {

        // Create Array with 3 place holders //
        Shape[] shapeArray = new Shape[3];

        // Add one of each shape type to the array //
        shapeArray[0] = new Sphere(4);
        shapeArray[1] = new Cylinder(5, 6);
        shapeArray[2] = new Cone(3, 7);

        // For each shape call the toString method to print out each shape //
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
            System.out.println();
        }
    }
}
