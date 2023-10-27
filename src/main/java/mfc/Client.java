package mfc;

public class Client implements Runnable {
    private final String category;
    private final Window window;
    private final Counter counter;

    public Client(String category, Window window, Counter counter) {
        this.counter = counter;
        this.category = category;
        this.window = window;
    }

    public String  getCategory() {
        return category;
    }

    @Override
    public void run(){
        if(!window.ifBusy()){
            window.serveCitizen(this);
        }
        else{
            System.out.println(this.getCategory()+"-guy is left the game");
            counter.addPupil(this.getCategory(),true);
        }
    }
}
