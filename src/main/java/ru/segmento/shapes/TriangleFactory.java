package ru.segmento.shapes;

/**
 * Factory returning random triangles.
 */
public interface TriangleFactory {
  /**
   * @return a triangle
   */
  Polygon getTriangle();
}
