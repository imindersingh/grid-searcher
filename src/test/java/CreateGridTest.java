import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CreateGridTest {
  final static String INPUT = "1231\n8963\n1231\n8963";
  Scanner scanner;

  @BeforeEach
  void setUp(){
    System.setIn(new ByteArrayInputStream(INPUT.getBytes()));
    scanner = new Scanner(System.in);
  }

  @Test
  void canCreateGrid(){
    final int[][] grid = CreateGrid.createGrid(scanner, 4, 4);
    assertEquals(4, grid.length);
    assertEquals(4, grid[0].length);
  }

  @Test
  void whenInputArrayBiggerThanInputRowThenArrayRowIsEqualToInputRow(){
    final int[][] grid = CreateGrid.createGrid(scanner, 2, 4);
    assertEquals(2, grid.length);
    assertEquals(4, grid[0].length);
  }

  @Test
  void whenInputArrayBiggerThanInputColumnThenArrayColumnIsEqualToInputColumn(){
    final int[][] grid = CreateGrid.createGrid(scanner, 4, 2);
    assertEquals(4, grid.length);
    assertEquals(2, grid[0].length);
  }

}