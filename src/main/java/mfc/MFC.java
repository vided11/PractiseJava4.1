package mfc;

import java.util.Random;

public class MFC {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Window window1 = new Window("young", counter);
        Window window2 = new Window("elder", counter);
        Window window3 = new Window("business", counter);

        int totalFolks = 15;

        for (int i = 0; i < totalFolks; i++){
            try {
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            int random = new Random().nextInt(3);

            String currentType = "";
            Window currentWindow = null;

            switch (random){
                case 0:
                    currentType = "young";
                    currentWindow = window1;
                    break;
                case 1:
                    currentType = "elder";
                    currentWindow = window2.ifBusy() ? window1 : window2;
                    break;
                case 2:
                    currentType = "business";
                    currentWindow = window3.ifBusy() ? window1 : window3;
                    break;
            }
            Client citizen = new Client(currentType, currentWindow, counter);
            Thread thread = new Thread(citizen);
            thread.start();
        }
        Thread.sleep(5000);
        counter.printStats();
    }
}
