package mfc;

public class Counter {
    int youngTotal, elderTotal, businessTotal;
    int youngQuit, elderQuit, businessQuit;

    public void addPupil(String category, boolean isQuit){
        switch (category){
            case "young":
                youngTotal++;
                if (isQuit) {
                    youngQuit++;
                }
                break;
            case "elder":
                elderTotal++;
                if (isQuit) {
                    elderQuit++;
                }
                break;
            case "business":
                businessTotal++;
                if (isQuit) {
                    businessQuit++;
                }
                break;
        }
    }

    public void printStats(){
        System.out.println("Young total: " + youngTotal + " which " + youngQuit + " of them is gone. Percentage stat: " + youngQuit * 100 / youngTotal  + "%");
        System.out.println("Elder total: " + elderTotal + " which " + elderQuit + " of them is gone. Percentage stat: " + elderQuit * 100 / elderTotal + "%");
        System.out.println("Young total: " + businessTotal + " which " + businessQuit + " of them is gone. Percentage stat: " + businessQuit * 100 / businessTotal + "%");
    }
}
