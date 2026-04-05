import java.lang.reflect.Array;

public class ShapeArray {
    public static void main(String[] args) {

        Shape[] shapeArray = new Shape[3];

        shapeArray[0] = new Sphere(4);
        shapeArray[1] = new Cylinder(5, 6);
        shapeArray[2] = new Cone(3, 7);

        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
            System.out.println();
        }
    }
}
