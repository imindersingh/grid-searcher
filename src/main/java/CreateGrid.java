import java.util.Scanner;

public class CreateGrid {

  private CreateGrid(){ }

  public static int[][] createGrid(final Scanner scanner, final int rows, final int columns) {
    final int[][] grid = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      String row = scanner.next();
      for (int j = 0; j < columns; j++) {
        grid[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
      }
    }
    return grid;
  }

}
