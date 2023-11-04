package examples;

class SwitchExample {
  public static void main(String[] args) {
    int day = 4;
    String dayString;
    switch (day) {
      case 1:
        dayString = "Lunes";
        break;
      case 2:
        dayString = "Martes";
        break;
      case 3:
        dayString = "Miércoles";
        break;
      case 4:
        dayString = "Jueves";
        break;
      case 5:
        dayString = "Viernes";
        break;
      case 6:
        dayString = "Sábado";
        break;
      case 7:
        dayString = "Domingo";
        break;
      default:
        dayString = "Día inválido";
        break;
    }
    System.out.println(dayString);
  }
}
  
