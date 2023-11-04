package examples;

class Ternary {
  public static void main(String[] args) {

    int number = 10;
    String message = (number > 0) ? "Positive number" : "Non-positive number";
    System.out.println(message);

    //

    int a = 10;
    int b = 20;
    int max = (a > b) ? a : b;
    System.out.println(max);

    //nested ternary
    int x = 10;
    int y = 20;
    int z = 30;

    int max2 = (x > y) ? ((x > z) ? x : z) : ((y > z) ? y : z);
    System.out.println(max2);
  }
}
