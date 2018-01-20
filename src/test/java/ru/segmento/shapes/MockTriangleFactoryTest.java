package ru.segmento.shapes;

import org.junit.Assert;
import org.junit.Test;
import ru.segmento.shapes.libs.matrix.MatrixOperations;
import java.lang.reflect.Method;

public class MockTriangleFactoryTest {

    private final MockTriangleFactory mockTriangleFactory = new MockTriangleFactory();
    private final Polygon triangle = mockTriangleFactory.getTriangle();

    @Test
    public void checkThatFactoryObjectHasMethodGetTriangle() {

        boolean hasMethod = false;
        Method[] methods = mockTriangleFactory.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().equals("getTriangle")) {
                hasMethod = true;
                break;
            }
        }
        Assert.assertTrue(hasMethod);
    }

    @Test
    public void checkThatFactoryClassImplementsTriangleFactoryInterface() {

        Assert.assertTrue(mockTriangleFactory instanceof TriangleFactory);
    }

    @Test
    public void checkThatPolygonNotNull() {

        Assert.assertNotNull("ERROR: Polygon object can't be null", triangle);
    }

    @Test
    public void checkThatTriangleVerticesNotNull() {

        Assert.assertTrue("ERROR: Triangle vertices can't be null",
                triangle.vertices[0] != null &
                        triangle.vertices[1] != null &
                        triangle.vertices[2] != null);
    }

    @Test
    public void checkThatTriangleHasThreeVertices() {

        Assert.assertEquals("ERROR: The triangle must have 3 vertices",
                3, triangle.vertices.length);
    }

    @Test
    public void checkThatTriangleVerticesNotLieOnOneAxis() {

        boolean isParallel = false;
        if (triangle.vertices[0].x == triangle.vertices[1].x & triangle.vertices[0].x == triangle.vertices[2].x ||
                triangle.vertices[0].y == triangle.vertices[1].y & triangle.vertices[0].y == triangle.vertices[2].y) {
            isParallel = true;
        }

        Assert.assertFalse("ERROR: The sides of the triangle lie on one axis", isParallel);
    }

    @Test
    public void checkThatTriangleNotHaveSameVertices() {

        boolean isSameVertices = false;
        if (triangle.vertices[0].equals(triangle.vertices[1]) ||
                triangle.vertices[0].equals(triangle.vertices[2]) ||
                triangle.vertices[1].equals(triangle.vertices[2])) {
            isSameVertices = true;
        }

        Assert.assertFalse("ERROR: The triangle must not have same vertices", isSameVertices);
    }

    @Test
    public void checkThatTriangleAreaIsNotZero() {
        double determinant;
        double x[][] = {
                {1, triangle.vertices[0].x, triangle.vertices[0].y},
                {1, triangle.vertices[1].x, triangle.vertices[1].y},
                {1, triangle.vertices[2].x, triangle.vertices[2].y}
        };

        determinant = MatrixOperations.matrixDeterminant(x);
        double triangleArea = 0.5 * determinant;
        boolean isZero = false;
        if (triangleArea == 0) {
            isZero = true;
        }
        Assert.assertFalse("ERROR: area of triangle can't be 0", isZero);
    }
}