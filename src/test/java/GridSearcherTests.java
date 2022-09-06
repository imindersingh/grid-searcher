import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridSearcherTests {

  private static final String NO = "NO";
  private static final String YES = "YES";

  @Test
  void testCannotPerformSearchWhenGridAndPatternColumnSameSize() {
    final int[][] testGrid = {
        {7, 2, 9, 9, 0},
        {8, 0, 7, 8, 7},
        {7, 2, 9, 9, 0},
        {8, 0, 7, 8, 7},
        {7, 2, 9, 9, 0},
        {8, 0, 7, 8, 7},
    };

    final int[][] testPattern = {
        {8, 8, 0, 5, 0},
        {3, 5, 4, 5, 0},
        {3, 5, 7, 5, 0},
        {8, 8, 0, 5, 0},
        {3, 5, 4, 5, 0}
    };

    String actualResult = GridSearcher.search(testGrid, testPattern, 5, 5);
    assertEquals(NO, actualResult);
  }

  @Test
  void testCannotPerformSearchWhenGridAndPatternRowsSameSize() {
    final int[][] testGrid = {
        {7, 2, 9, 9, 0},
        {8, 0, 7, 8, 7},
        {7, 2, 9, 9, 0},
        {8, 0, 7, 8, 7},
        {7, 2, 9, 9, 0},
        {8, 0, 7, 8, 7},
    };

    final int[][] testPattern = {
        {8, 8, 0, 5, 0},
        {3, 5, 4, 5, 0},
        {3, 5, 7, 5, 0},
        {8, 8, 0, 5, 0},
        {3, 5, 4, 5, 0},
        {8, 0, 7, 8, 7}
    };

    String actualResult = GridSearcher.search(testGrid, testPattern, 6, 5);
    assertEquals(NO, actualResult);
  }

  @Test
  void testCannotPerformSearchWhenSearchWillExceedGridSize() {
    final int[][] testGrid = {
        {7, 2, 9, 9, 0, 1},
        {8, 0, 7, 8, 7, 2},
        {7, 2, 9, 9, 0, 3},
        {8, 0, 7, 8, 7, 3},
        {7, 2, 9, 9, 0, 3},
        {8, 0, 7, 8, 7, 3},
    };

    final int[][] testPattern = {
        {0, 8, 0, 5},
        {3, 5, 4, 5},
    };
    String actualResult = GridSearcher.search(testGrid, testPattern, 2, 4);
    assertEquals(NO, actualResult);
  }

  @Test
  void testWhenPatternIsFoundResultIsYes() {
    final int[][] testGrid = {
        {7, 2, 8, 3, 4, 5, 5, 8, 6, 4},
        {6, 7, 3, 1, 1, 5, 8, 6, 1, 9},
        {8, 9, 8, 8, 2, 4, 2, 6, 4, 3},
        {3, 8, 3, 0, 5, 8, 9, 3, 2, 4},
        {2, 2, 2, 8, 8, 0, 5, 8, 1, 3},
        {5, 6, 3, 3, 5, 4, 5, 3, 7, 4},
        {6, 4, 7, 3, 5, 3, 0, 2, 9, 3},
        {7, 0, 5, 3, 1, 1, 6, 6, 0, 1},
        {0, 8, 3, 4, 2, 8, 2, 9, 5, 6},
        {4, 6, 0, 7, 9, 2, 4, 1, 3, 7},
    };

    final int[][] testPattern = {
        {8, 8, 0, 5},
        {3, 5, 4, 5},
        {3, 5, 3, 0},
    };

    String actualResult = GridSearcher.search(testGrid, testPattern, 3, 4);
    assertEquals(YES, actualResult);
  }

  @Test
  void testWhenPatternNotFoundResultIsNo() {
    final int[][] testGrid = {
        {7, 2, 8, 3, 4, 5, 5, 8, 6, 4},
        {6, 7, 3, 1, 1, 5, 8, 6, 1, 9},
        {8, 9, 8, 8, 2, 4, 2, 6, 4, 3},
        {3, 8, 3, 0, 5, 8, 9, 3, 2, 4},
        {2, 2, 2, 8, 8, 0, 5, 8, 1, 3},
        {5, 6, 3, 3, 5, 4, 5, 3, 7, 4},
        {6, 4, 7, 3, 5, 3, 0, 2, 9, 3},
        {7, 0, 5, 3, 1, 1, 6, 6, 0, 1},
        {0, 8, 3, 4, 2, 8, 2, 9, 5, 6},
        {4, 6, 0, 7, 9, 2, 4, 1, 3, 7},
    };

    final int[][] testPattern = {
        {8, 8, 0, 5},
        {3, 5, 4, 5},
        {3, 5, 3, 1},
    };

    String actualResult = GridSearcher.search(testGrid, testPattern, 3, 4);
    assertEquals(NO, actualResult);
  }

  @Test
  void testPatternGridColumnsAreLargerThanSearchGrid() {
    final int[][] testGrid = {
        {7, 2, 9},
        {8, 0, 7}
    };

    final int[][] testPattern = {
        {8, 8, 0, 5},
        {3, 5, 4, 5},
    };

    String actualResult = GridSearcher.search(testGrid, testPattern, 3, 4);
    assertEquals(NO, actualResult);
  }

  @Test
  void testPatternGridRowsAreLargerThanSearchGrid() {
    final int[][] testGrid = {
        {7, 2},
        {8, 0}
    };

    final int[][] testPattern = {
        {8, 8, 0, 5},
        {3, 5, 4, 5},
        {3, 5, 3, 0}
    };

    String actualResult = GridSearcher.search(testGrid, testPattern, 3, 4);
    assertEquals(NO, actualResult);
  }
}
