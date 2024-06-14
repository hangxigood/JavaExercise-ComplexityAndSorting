Welcome to the Java Sorting Program!

This program is designed to sort geometric shapes based on various attributes such as height, volume, and base area using different sorting algorithms including Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort, and a Heap Sort algorithm.

# Installation Instructions

1. **Prerequisites:**
   - Ensure you have Java Development Kit (JDK) installed on your machine. This program requires JDK 8 or later. You can download it from: https://www.oracle.com/java/technologies/javase-jdk8-downloads.html

2. **Download:**
   - Download the latest version of the sorting program from the Releases section of our GitHub repository at: https://github.com/hangxigood/JavaExercise-ComplexityAndSorting

3. **Extract Files:**
   - If the downloaded file is compressed (ZIP), extract it to a directory of your choice.

# How to Build the Executable JAR File

- After downloading and extracting the files, open it in IDE and export a JAR File.

# Adding Test Data

- Place your test data files(.txt) inside the `testData` folder located in the root directory of the project. Ensure that each file is formatted correctly according to the specifications required by the program.
- The first value in the data file contains the number of shapes in that file.

- A shape in the file is represented as follows (all values are separated by spaces):
	
	* One of: Cylinder, Cone, Prism or Pyramid
	* Cylinders and Cones are followed by a double value representing the height and another double value representing radius. e.g., Cylinder 9431.453 4450.123 or Cone 674.2435 652.1534
	* Pyramids are followed by a double value representing the height and another double value representing edge length. e.g., Pyramid 6247.53 2923.456
	* Prisms are specified by the type of base polygon (SquarePrism, TrianglarPrism, PentagonalPrism, OctagonalPrism), a double value representing the height and another double value representing edge length. e.g., SquarePrism 8945.234 3745.334

# Running the Program

1. **Using Command Line:**
   - Open your command line interface (CLI).
   - Navigate to the directory where you have the `sort.jar` file. You can do this with the `cd` command. For example:
     ```
     cd path/to/your/sort.jar
     ```
   - To run the program, use the following syntax:
     ```
     java -jar sort.jar -f [filename] -t [sortType] -s [sortAlgorithm]
     ```
   - Parameters:
     - `-f [filename]`: Specifies the path to the text file containing shapes data.
     - `-t [sortType]`: Specifies the type of sort (e.g., 'v' for volume, 'h' for height, 'a' for area).
     - `-s [sortAlgorithm]`: Specifies the sorting algorithm ('b' for Bubble, 's' for Selection,'i' for Insertion, 'm' for Merge, 'q' for Quick, 'h' for Heap).

   Example: java -jar sort.jar -f testData/polyfor1.txt -t v -s b
   This command sorts the shapes in `testData/polyfor1.txt` by volume using Bubble Sort.

# Additional Information

- **Documentation:**
  Full API documentation can be found in the `doc` directory after installing. Open `index.html` in a web browser to view it.

- **Support:**
  If you encounter any issues or have questions, please file them in the issues section of our GitHub repository.

Thank you for using our Java Sorting Program. Happy sorting!