package RetosMansias;

class ChallengeASCII {

    public static void main(String[] args) {

        int timesToImprint;

        for (timesToImprint = 1; timesToImprint <= 5; timesToImprint++) {

            String icon = "*".repeat(6);
            System.out.println(icon);
        }

        for (timesToImprint = 1; timesToImprint <= 1; timesToImprint++) {
            String icon = "**  ".repeat(3);
            System.out.println(icon);
            System.out.println(icon);

            String iconTwo = "  **".repeat(2);
            System.out.println(iconTwo);
            System.out.println(iconTwo);
        }
        for (timesToImprint = 1; timesToImprint <= 1; timesToImprint++) {
            String icon = "**  ".repeat(3);
            System.out.println(icon);
            System.out.println(icon);
        }

        for (timesToImprint = 1; timesToImprint <= 2; timesToImprint++) {

            String plusLine = "-".repeat(24);
            String onlyPlus = "+";
            System.out.println(onlyPlus + plusLine + onlyPlus);

            for (timesToImprint = 1; timesToImprint <= 1; timesToImprint++) {

                String lineIconThree = "** ".repeat(8);
                String onlyLine = "|";
                System.out.println(onlyLine + lineIconThree + onlyLine);
                System.out.println(onlyLine + lineIconThree + onlyLine);
            }

            for (timesToImprint = 1; timesToImprint <= 2; timesToImprint++) {

                String lineIconFour = " **".repeat(8);
                String onlyLine = "|";
                System.out.println(onlyLine + lineIconFour + onlyLine);
            }
            for (timesToImprint = 1; timesToImprint <= 1; timesToImprint++) {

                String lineIconThree = "** ".repeat(8);
                String onlyLine = "|";
                System.out.println(onlyLine + lineIconThree + onlyLine);
                System.out.println(onlyLine + lineIconThree + onlyLine);
            }

            for (timesToImprint = 1; timesToImprint <= 2; timesToImprint++) {

                String lineIconFour = " **".repeat(8);
                String onlyLine = "|";
                System.out.println(onlyLine + lineIconFour + onlyLine);
            }

            System.out.println(onlyPlus + plusLine + onlyPlus);

        }

    }
}
