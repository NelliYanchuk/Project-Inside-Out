package out.factoriaf5.out_java;

public enum Emotion {
  JOY(1, "Joy"),
  SADNESS(2, "Sadness"),
  ANGER(3, "Anger"),
  DISGUST(4, "Disgust"),
  FEAR(5, "Fear"),
  ANXIETY(6, "Anxiety"),
  ENVY(7, "Envy"),
  SHAME(8, "Shame"),
  BOREDOM(9, "Boredom"),
  NOSTALGIA(10, "Nostalgia");

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
    return null; // Return a default message if not found
  }
}
