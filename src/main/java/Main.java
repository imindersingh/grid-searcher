import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Main {

  public static void main (String[] args) {
    final Scanner scanner = new Scanner(System.in);

    //INITIALISE TESTS
    int tests = scanner.nextInt();

    List<String> resultList = new ArrayList<>();

    for (int k = 0; k < tests; k++) {
      //GRID ROW
      int gRow = scanner.nextInt();
      //GRID COLUMN
      int gColumn = scanner.nextInt();
      //INITIALISE GRID
      int[][] grid = CreateGrid.createGrid(scanner, gRow, gColumn);
      //PATTERN GRID ROW | COLUMN IN
      int pRow = scanner.nextInt();
      //PATTERN GRID COLUMN | ROWS DOWN
      int pColumn = scanner.nextInt();
      //INITIALISE PATTERN GRID
      int[][] pattern = CreateGrid.createGrid(scanner, pRow, pColumn);
      String result = GridSearcher.search(grid, pattern, pRow, pColumn);
      resultList.add(result);
    }

    for (String result : resultList) {
      System.out.println(result);
    }
  }
}