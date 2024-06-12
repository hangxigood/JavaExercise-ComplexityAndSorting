package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import geometric_shape.Cone;
import geometric_shape.Cylinder;
import geometric_shape.EquilateralTrianglePrism;
import geometric_shape.OctagonalPrism;
import geometric_shape.PentagonPrism;
import geometric_shape.Pyramid;
import geometric_shape.Shape;
import geometric_shape.SquarePrism;
import utils.ShapeComparator;
import utils.Utility;

public class ShapeSorter {
	
    public static void main(String[] args) {
        // Command-line argument parsing variables
        String filename = null;
        String sortType = "h"; // Default to height
        String algorithm = "b"; // Default to bubble sort

        // Parse command-line arguments
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].toLowerCase().startsWith("-f")) {
                    filename = args[i].substring(2);
                    if (filename.isEmpty() && i + 1 < args.length) {
                        filename = args[++i];
                    } else if (filename.isEmpty()) {
                        throw new IllegalArgumentException("Expected filename after -f");
                    }
                } else if (args[i].toLowerCase().startsWith("-t")) {
                    sortType = args[i].substring(2);
                    if (sortType.isEmpty() && i + 1 < args.length) {
                        sortType = args[++i];
                    } else if (sortType.isEmpty()) {
                        throw new IllegalArgumentException("Expected sort type after -t");
                    }
                } else if (args[i].toLowerCase().startsWith("-s")) {
                    algorithm = args[i].substring(2);
                    if (algorithm.isEmpty() && i + 1 < args.length) {
                        algorithm = args[++i];
                    } else if (algorithm.isEmpty()) {
                        throw new IllegalArgumentException("Expected algorithm type after -s");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid or incomplete argument: " + args[i]);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (filename == null) {
            System.out.println("No file specified. Use -f or -F to specify the file.");
            return;
        }

        try {
            File file = new File("src/testData/" + filename);
            Scanner scanner = new Scanner(file);
            int numberOfShapes = scanner.nextInt();
            Shape[] shapes = new Shape[numberOfShapes];

            for (int i = 0; i < numberOfShapes; i++) {
                String shapeType = scanner.next();
                double height = scanner.nextDouble();
                double dimension = scanner.nextDouble();

                switch (shapeType) {
                    case "Cylinder":
                        shapes[i] = new Cylinder(height, dimension);
                        break;
                    case "Cone":
                        shapes[i] = new Cone(height, dimension);
                        break;
                    case "Pyramid":
                        shapes[i] = new Pyramid(height, dimension);
                        break;
                    case "SquarePrism":
                        shapes[i] = new SquarePrism(height, dimension);
                        break;
                    case "TriangularPrism":
                        shapes[i] = new EquilateralTrianglePrism(height, dimension);
                        break;
                    case "PentagonalPrism":
                        shapes[i] = new PentagonPrism(height, dimension);
                        break;
                    case "OctagonalPrism":
                        shapes[i] = new OctagonalPrism(height, dimension);
                        break;
                    default:
                        System.out.println("Unsupported shape type: " + shapeType);
                        return;
                }
            }
            scanner.close();

            // Sort shapes based on the selected algorithm and comparator
            ShapeComparator comparator = new ShapeComparator(sortType);
            long startTime = System.currentTimeMillis();
            switch (algorithm.toLowerCase()) {
                case "b":
                	Utility.bubbleSort(shapes, comparator);
                    break;
                case "i":
                	Utility.insertionSort(shapes, comparator);
                	break;
                case "s":
                	Utility.selectionSort(shapes, comparator);
                	break;
                case "m":
                	Utility.mergeSort(shapes, comparator);
                	break;
                case "q":
                	Utility.quickSort(shapes, comparator);
                	break;
                case "z":
                	Utility.heapSort(shapes, comparator);
                	break;
            }
            long endTime = System.currentTimeMillis();

            // Print sorted results and timing
            System.out.println("Sorting took: " + (endTime - startTime) + " milliseconds");
            printShapes(shapes);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    private static void printShapes(Shape[] shapes) {
        System.out.println("First shape: " + shapes[0]);
        for (int i = 1000; i < shapes.length; i += 1000) {
            if (i < shapes.length) {
                System.out.println("Shape " + i + ": " + shapes[i]);
            }
        }
        System.out.println("Last shape: " + shapes[shapes.length - 1]);
    }
}