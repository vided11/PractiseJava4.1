package mfc;

import java.util.Random;

public class Window {

    private final String category;
    private boolean isBusy = false;

    private final Counter counter;

    public Window(String category, Counter counter){
        this.category = category;
        this.counter = counter;
    }
    public synchronized boolean ifBusy(){
        return isBusy;
    }
    public synchronized void setBusy(boolean condition){
        isBusy = condition;
    }
    public void serveCitizen(Client client){
        setBusy(true);
        System.out.println("Client "+ client.getCategory() +" is entered window " + category);
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Client "+ client.getCategory() +" is left the window " + category);
        counter.addPupil(client.getCategory(),false);
        setBusy(false);
    }


}