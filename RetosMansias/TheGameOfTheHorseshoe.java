package RetosMansias;

class TheGameOfTheHorseshoe {

    static final double HOLE_1 = 0.1;
    static final double HOLE_2 = 0.12;
    static final double HOLE_3 = 0.78;

    final static int MAX_POINTS = 50;

    public static void main(String[] args) {

        int numberOfPointArmad = 0;
        int numberOfPointNaneh = 0;
        boolean continuePlaying = true;

        while (continuePlaying) {

            System.out.println("turno de armand");
            numberOfPointArmad = throwBall(numberOfPointArmad);

            System.out.println("turno de naneh");
            numberOfPointNaneh = throwBall(numberOfPointNaneh);

            continuePlaying = continuePlaying(numberOfPointArmad, numberOfPointNaneh);
        }

        System.out.println("fin del juego");
        System.out.println("puntos de armand" + numberOfPointArmad);
        System.out.println("puntos de naneh" + numberOfPointNaneh);

    }

    private static boolean continuePlaying(int numberOfPointArmad, int numberOfPointNaneh) {
        return numberOfPointArmad <= MAX_POINTS || numberOfPointNaneh <= MAX_POINTS;
    }

    private static int throwBall(int currenPoints) {
        int pointsOfTurn = 0;
        int selectedHole = (int) (Math.random() * 3) + 1;

        switch (selectedHole) {
            case 1:
                if (Math.random() < HOLE_1) {
                    pointsOfTurn = 5;
                }
                break;
            case 2:
                if (Math.random() < HOLE_2) {
                    pointsOfTurn = 3;
                }
                break;
            case 3:
                if (Math.random() < HOLE_3) {
                    pointsOfTurn = 1;
                }
                break;
        }

        return currenPoints += pointsOfTurn;
    }
}