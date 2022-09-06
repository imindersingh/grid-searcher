public class GridSearcher {

  private GridSearcher(){ }

  private static final String NO = "NO";
  private static final String YES = "YES";

  public static String search(final int[][] grid, final int[][] pattern, final int pRow, final int pColumn) {
    if (pattern.length > grid.length
        || pattern[0].length > grid[0].length ) {
      return NO;
    }

    if (grid.length == pattern.length
        || grid[0].length == pattern[0].length) {
      return NO;
    }

    if ((grid.length - pattern.length) < pattern.length
        || (grid[0].length - pattern[0].length) < pattern[0].length) {
      return NO;
    }

    boolean isMatch = true;
    String result = "";
    outerloop:
    for (int i = 0; i < pRow; i++) {
      for (int j = 0; j < pColumn; j++) {
        if (grid[pColumn + i][pRow + j] == pattern[i][j]) {
          continue;
        } else {
          isMatch = false;
          result = NO;
          break outerloop;
        }
      }
    }
    if(isMatch) {
      result = YES;
    }
    return result;
  }

}
