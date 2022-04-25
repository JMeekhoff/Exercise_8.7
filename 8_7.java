 * COSC211 Programming Exercise 8.7: "Find my nearest point"
 * 
 * James Meekhoff
 * 
 *This program basically finds the distance between two points on
 *a coordinate plane, as well as which points are the closest. This 
 *program contains methods for an array that contains the points, 
 *the equations that find the distances, and output and input statements 
 *guide the user along in the program.  
 */

package programming_exercises;

import java.util.Scanner;

public class exercise_8_7 {
  
       public static void main(String[]args) {
           Scanner input = new Scanner(System.in);
           double [][] points = inputArray(input);
           int[] closestIndexes = closestPoints(points);
           int p1 = closestIndexes[0];
           int p2 = closestIndexes[1];
           displayClosestPoints(p1, p2, points);
           
      }
 
// Here is where the array to store the points is created. 
       
       public static double [][]  inputArray(Scanner input) {
         System.out.print("Enter the number of points: ");
         int numberOfPoints = input.nextInt();
         
         // the array is created here:
         
         double [][] points = new double[numberOfPoints][3];
         System.out.print("Enter " + numberOfPoints + " points: ");
         for (int i = 0; i < points.length; i++) {
             points[i][0] = input.nextDouble();
             points[i][1] = input.nextDouble();
             points[i][2] = input.nextDouble();
       }
       return points; }
       
// Computes the distance between two points;
       
       public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
         return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) + ((z2 - z1) * (z2 - z1)));
     }
       
       public static void displayClosestPoints(int p1, int p2, double[][] points) {

// Display result of which two points are the closest to each other. 
         
         System.out.println("The closest two points are " + "(" + points[p1][0] + ", " + points[p1][1] + ", "
                 + points[p1][2] + ") and (" + points[p2][0] + ", " + points[p2][1] + ", " + points[p2][2] + ")");
     }
      
// This is where the distance between all of the points, and the shortest distance.  
       
       public static int[] closestPoints(double[][] points) {
          
         int p1 = 0, p2 = 1; // These are the initial points.
         double shortestDistance = distance(points[p1][0], points[p1][1], points[p1][2], points[p2][0], points[p2][1],
         points[p2][2]);
        
// Computes the distance between each of the two points. 
         
         for (int i = 0; i < points.length; i++) {
               for (int j = i + 1; j < points.length; j++) {
                   double distance = distance(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1],
                           points[j][2]);
         if (shortestDistance > distance) {
             p1 = i; // Update p1
                  p2 = j; // Update p2
                  shortestDistance = distance;
                  
       }
       
}
}
         return new int[] { p1, p2 };
}
}
