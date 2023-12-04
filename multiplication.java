class BuildingHotel {
    static int totalElectricityConsumption = 0;
    static boolean lightningStruck = false; // Variable to track if lightning has already struck

    public static void main(String[] args) {
        Hotel(7, 6);
        Time();
    }

    static void Time() {
        int hourPerDay = 24;
        int daysOfTheWeek = 7;

        for (int day = 1; day <= daysOfTheWeek; day++) {
            int dailyElectricityConsumption = 0;
            lightningStruck = false; // Reset the lightning variable for a new day

            for (int hour = 0; hour < hourPerDay; hour++) {
                System.out.println("Day: " + day + " Hour: " + hour + "h");
                Hotel(hourPerDay, daysOfTheWeek);
                dailyElectricityConsumption += ProbabiltyOfEachWindow();
            }

            System.out.println("Total electricity consumption for Day " + day + ": " + dailyElectricityConsumption);
            totalElectricityConsumption += dailyElectricityConsumption;
        }

        System.out.println("Overall total electricity consumption: " + totalElectricityConsumption);
    }

    public static int ProbabiltyOfEachWindow() {
        int MAXROWS = 7;
        int MAXCOLUMNS = 6;
        int electricityConsumption = 0;

        final String CLOSEROOM = "[ ]::";
        final String LIGHTON = "[*]::";
        final String LIGHTOFF = "[º]::";
        final String HITTHUNDER = "[X]::";
        final String FIXING = "[#]::";
        final String LIGHTNING = "[L]::";

        for (int totalRows = 0; totalRows < MAXROWS; totalRows++) {
            for (int totalColumns = 0; totalColumns < MAXCOLUMNS; totalColumns++) {
                boolean blindOpen = Math.random() < 0.6;
                boolean lightOn = Math.random() < 0.7;
                boolean thunder = Math.random() < 0.2;
                boolean fixing = Math.random() < 0.05;

                if (blindOpen) {
                    if (lightOn) {
                        System.out.print(LIGHTON);
                        electricityConsumption++;
                    } else {
                        System.out.print(LIGHTOFF);
                    }
                } else {
                    System.out.print(CLOSEROOM);
                }

                if (thunder) {
                    System.out.print(HITTHUNDER);
                    electricityConsumption++;
                } else if (!lightningStruck && Math.random() < 0.2) {
                    System.out.print(LIGHTNING);
                    electricityConsumption++;
                    lightningStruck = true; // Set the flag to true if lightning strikes
                } else {
                    System.out.print(FIXING);
                }
            }
            System.out.println("- P" + (totalRows + 1));
        }

        System.out.println("------------------------------------");
        System.out.println("Electricity consumption for the hour: " + electricityConsumption);
        return electricityConsumption;
    }

    static void Hotel(int maxRows, int maxColumns) {
        System.out.println("               __/\\__");
        System.out.println("  |    |    |  |####|  |    |    |  ");
        System.out.println("====================================");
        System.out.println("====================================");
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
