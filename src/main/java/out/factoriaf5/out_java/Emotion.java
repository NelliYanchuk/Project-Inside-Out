package out.factoriaf5.out_java;

public enum Emotion {
  JOY(1, "Joy"),
  SAD(2, "Sadness"),
  ANG(3, "Anger"),
  DIS(4, "Disgust"),
  FEA(5, "Fear"),
  ANX(6, "Anxiety"),
  ENV(7, "Envy"),
  SHA(8, "Shame"),
  BOR(9, "Boredom"),
  NOS(10, "Nostalgia");

  private String name;
  private int number;

  Emotion(int num, String string) {
    this.number = num;
    this.name = string;
  }

  public String getName() {
    return name;
  }

  public int getNumber() {
    return number;
  }

  // Method to get the name by number
  public static String getNameByNumber(int num) {
    for (Emotion emotion : Emotion.values()) {
      if (emotion.getNumber() == num) {
        System.out.println("Your emothion is " + emotion.getName());
        return emotion.getName();
      }
    }
    // If incorrect number
    return null;
  }
}
