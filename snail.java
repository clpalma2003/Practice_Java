
import java.util.Random;

class SnailChallenge {

  private static final Random random = new Random();
  private static final int CAR_PROBABILITY = 10;
  private static final int RAIN_PROBABILITY = 5;

  public static void main(String[] args) {
    int originalDepth = 30;
    int snailPosition = originalDepth - 1;
    int floodedDepth = 0;
    int moveUp = 3;
    int moveDown = 2;
    int turn = 0;
    int stuckTurns = 0;
    
    boolean snailIsInside = snailPosition > 0;
    boolean snailIsNotStuck = stuckTurns < 10;

    boolean simulationIsRunning = snailIsInside && snailIsNotStuck;

    while (simulationIsRunning) {
      turn++;
      
      simulationIsRunning = checkSimulationStatus(snailPosition, stuckTurns);
     
      displayTurnStatus(turn, snailPosition, originalDepth, floodedDepth);
      
      int initialPosition = snailPosition;
      snailPosition = updateSnailPosition(snailPosition, moveUp, moveDown); 
      snailPosition = checkCarEffect(snailPosition);
      floodedDepth = updateFloodedDepth(floodedDepth, originalDepth, snailPosition);
      
      snailPosition = Math.min(originalDepth - 1, snailPosition);
      
      stuckTurns = updateStuckTurns(initialPosition, snailPosition, stuckTurns);
      System.out.println();
    }

    displayFinalStatus(stuckTurns, turn);
  }

  private static boolean checkSimulationStatus(int snailPosition, int stuckTurns) {
    boolean snailIsInside = snailPosition > 0;
    boolean snailIsNotStuck = stuckTurns < 10;
    
    return snailIsInside && snailIsNotStuck;
  }

  private static void displayTurnStatus(int turn, int snailPosition, int originalDepth, int floodedDepth) {
    System.out.println("Turn: " + turn);
    printWell(snailPosition, originalDepth, floodedDepth);
    System.out.println("Snail is at position: " + (originalDepth - snailPosition));
  }

  private static int updateSnailPosition(int snailPosition, int moveUp, int moveDown) {
    System.out.println("Snail climbed: " + moveUp + " units");
    System.out.println("Snail slid down: " + moveDown + " units");
    return snailPosition + (moveDown - moveUp); 
  }

  private static int checkCarEffect(int snailPosition) {
    if (carPassesBy()) {
      int fallValue = randomFallValue();
      System.out.println("A car passed by! Snail fell by: " + fallValue + " units");
      return snailPosition + fallValue;
    }
    return snailPosition;
  }

  private static boolean carPassesBy() {
    return random.nextInt(100) < CAR_PROBABILITY;
  }

  private static int randomFallValue() {
    return random.nextInt(5) + 1;
  }

  private static int updateFloodedDepth(int floodedDepth, int originalDepth, int snailPosition) {
    if (rainFalls()) {
      int floodValue = randomFloodValue();
      floodedDepth += floodValue;
      System.out.println("It rained! Well is flooded by: " + floodValue + " units");
      
      if (snailPosition > originalDepth - floodedDepth - 1) {
        return originalDepth - floodedDepth - 1;
      }
    }
    return floodedDepth;
  }

  private static boolean rainFalls() {
    return random.nextInt(100) < RAIN_PROBABILITY;
  }

  private static int randomFloodValue() {
    return random.nextInt(3) + 1;
  }

  private static int updateStuckTurns(int initialPosition, int snailPosition, int stuckTurns) {
    return (snailPosition == initialPosition) ? stuckTurns + 1 : 0;
  }

  private static void displayFinalStatus(int stuckTurns, int turn) {
    if (stuckTurns >= 10) {
      System.out.println("Snail is stuck and can't escape!");
    } else {
      System.out.println("Snail has climbed out in " + turn + " turns!");
    }
  }

  private static void printWell(int snailPos, int depth, int floodedDepth) {
    System.out.println("   ____   ");
    for (int i = 0; i < depth; i++) {
      if (i == snailPos) {
        System.out.println("  |@   |  ");
      } else if (i >= depth - floodedDepth) {
        System.out.println("  |~   |  ");
      } else {
        System.out.println("  |    |  ");
      }
    }
    System.out.println("  |____|  ");
  }
}
