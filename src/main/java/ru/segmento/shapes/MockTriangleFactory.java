package ru.segmento.shapes;

public class MockTriangleFactory implements TriangleFactory {

    @Override
    public Polygon getTriangle() {

        Vertex vertex1 = new Vertex(0, 0);
        Vertex vertex2 = new Vertex(10, 0);
        Vertex vertex3 = new Vertex(0, 10);

        return new Polygon(vertex1, vertex2, vertex3);
    }
}
