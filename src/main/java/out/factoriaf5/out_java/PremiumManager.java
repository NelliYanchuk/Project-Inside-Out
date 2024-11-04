package out.factoriaf5.out_java;

public class PremiumManager {
    private boolean isPremium;

    public PremiumManager() {
        this.isPremium = false;
    }

    public void activatePremium() {
        isPremium = true;
        System.out.println("Congratulations! You are now a premium user.");
    }

    public boolean isUserPremium() {
        return isPremium;
    }

    public void displayPremiumBenefits() {
        System.out.println("Premium Benefit:");
        System.out.println("- Add more than 20 moments.");
    }
}