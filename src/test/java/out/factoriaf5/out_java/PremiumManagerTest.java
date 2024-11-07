package out.factoriaf5.out_java;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PremiumManagerTest {

    @Test
    @DisplayName("Activa la cuenta premium")
    void testActivatePremium() {
        PremiumManager premiumManager = new PremiumManager();
        premiumManager.activatePremium();

        assertTrue(premiumManager.isUserPremium());
        }
        
    @Test
    @DisplayName("Verificar los beneficios")
    void testDisplayPremiumBenefits() {
        PremiumManager premiumManager = new PremiumManager();
        premiumManager.displayPremiumBenefits();
    }
}
