package out.factoriaf5.out_java;

public class showAllMoments {
    public void showAllMomentos() {
        if (momentos.isEmpty()) {
            System.out.println("No hay momentos para mostrar.");
        } else {
            for (Momento momento : momentos) {
                System.out.println(momento);
            }
        }
    }

}
