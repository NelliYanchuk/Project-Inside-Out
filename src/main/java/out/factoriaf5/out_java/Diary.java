package out.factoriaf5.out_java;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    
    public void showAllMoments() {
        if (moment.isEmpty()) {
            System.out.println("No hay momentos para mostrar.");
        } else {
            for (Moment moment : moment) {
                System.out.println(moment);
            }
        }
    }
    public List<Moment> filterByEmotion(String emocion) {
        List<Moment> result = new ArrayList<>();
        for (Moment moment : moment) {
            if (moment.getEmocion().equalsIgnoreCase(emocion)) {
                result.add(moment);
            }
        }
        return result;
    }    
}

