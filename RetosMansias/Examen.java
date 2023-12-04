package RetosMansias;

class BuildingHotels {
    static int totalElectricityConsumption = 0;
    static boolean lightningStruck = false;
    static boolean maintenanceRequired = false;

    public static void main(String[] args) {
        Hotel(7, 6);
        Time();
    }

    static void Time() {
        int hourPerDay = 24;
        int daysOfTheWeek = 7;

        for (int day = 1; day <= daysOfTheWeek; day++) {
            int dailyElectricityConsumption = 0;
            lightningStruck = false;
            maintenanceRequired = false;

            for (int hour = 0; hour < hourPerDay; hour++) {
                System.out.println("Day: " + day + " Hour: " + hour + "h");
                Hotel(7, 6);
                dailyElectricityConsumption += ProbabiltyOfEachWindow();
            }

            System.out.println("CONSUMOS: D" + day + ": " + dailyElectricityConsumption + " | ");
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

                if (thunder && !lightningStruck) {
                    System.out.print(HITTHUNDER);
                    electricityConsumption++;
                    lightningStruck = true;
                } else if (fixing && !maintenanceRequired) {
                    System.out.print(FIXING);
                    maintenanceRequired = true;
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
