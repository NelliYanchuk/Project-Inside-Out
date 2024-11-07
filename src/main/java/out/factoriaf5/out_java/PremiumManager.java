package out.factoriaf5.out_java;

public class PremiumManager {
    private boolean isPremium;
    private static PremiumManager premiumManager;

    public static void initialize(PremiumManager manager) {
        premiumManager = manager;
    }

    public PremiumManager() {
        this.isPremium = false;
    }

    // ----------- ACTIVATE PREMIUM ----------
    public static void activatePremium() {
        if (premiumManager != null) {
            premiumManager.displayPremiumBenefits();
            System.out.println("\nCongratulations! You are a premium user now.");
        } else {
            System.out.println("PremiumManager not initialized.");
        }
    }

    public boolean isUserPremium() {
        return isPremium;
    }

    // Getter method for testing
    public boolean isPremiumActive() {
        return isPremium;
    }

    public void displayPremiumBenefits() {
        System.out.println("Premium Benefit:");
        System.out.println("- Add more than 20 moments.");
    }

}
