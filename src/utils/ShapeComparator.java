package utils;

import java.util.Comparator;
import geometric_shape.Shape;

public class ShapeComparator implements Comparator<Shape> {
	
    private String type;

    public ShapeComparator(String type) {
        this.type = type;
    }

    @Override
    public int compare(Shape shape1, Shape shape2) {
        switch (type) {
            case "v": // volume
                return Double.compare(shape2.getVolume(), shape1.getVolume());
            case "a": // area
                return Double.compare(shape2.getBaseArea(), shape1.getBaseArea());
            default: // height
                return shape1.compareTo(shape2);
        }
    }
}