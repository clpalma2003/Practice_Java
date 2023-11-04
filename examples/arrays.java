package examples;

class arrays {
  public static void main(String[] args) {
    int[] array = new int[5]; 
    array[0] = 1;
    array[1] = 2;
    array[2] = 3;
    array[3] = 4;
    array[4] = 5;

    String[] stringArray = {"Hello", "World", "!"};

    System.out.println(array[0]);
    System.out.println(array[1]);
    System.out.println(array[2]);
    System.out.println(array[3]);
    System.out.println(array[4]);

    System.out.println(stringArray[0]);
    System.out.println(stringArray[1]);
    System.out.println(stringArray[2]);

    System.out.println(array.length);
    System.out.println(stringArray.length);

    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }

    for (int i = 0; i < stringArray.length; i++) {
      System.out.println(stringArray[i]);
    }

    for (int i : array) {
      System.out.println(i);
    }

    for (String i : stringArray) {
      System.out.println(i);
    }

    int[][] matrix = new int[2][2];
    matrix[0][0] = 1;
    matrix[0][1] = 2;
    matrix[1][0] = 3;
    matrix[1][1] = 4;

    System.out.println(matrix[0][0]);
    System.out.println(matrix[0][1]);
    System.out.println(matrix[1][0]);
    System.out.println(matrix[1][1]);
    
    System.out.println(matrix.length);
    System.out.println(matrix[0].length);
    System.out.println(matrix[1].length);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.println(matrix[i][j]);
      }
    }
    
    for (int[] i : matrix) {
      for (int j : i) {
        System.out.println(j);
      }
    }

    int[][][] cube = new int[2][2][2];
    cube[0][0][0] = 1;
    cube[0][0][1] = 2;
    cube[0][1][0] = 3;
    cube[0][1][1] = 4;
    cube[1][0][0] = 5;
    cube[1][0][1] = 6;
    cube[1][1][0] = 7;
    cube[1][1][1] = 8;

    
  }
}
