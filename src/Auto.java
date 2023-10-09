import java.util.Random;

public class Auto extends Thread {
    String name;
    Parkhaus garage;

    public Auto(String name, Parkhaus garage){
        this.name=name;
        this.garage=garage;
        this.start();
    }

    public void warten(int zeit){
        try {
            sleep(zeit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        int geparkt=0;
        Random rd=new Random();
        while (geparkt<20){
            if(this.garage.einparken(this.name)){
                this.warten(rd.nextInt(100));
                geparkt++;
                this.garage.ausparken();
            }
            this.warten(rd.nextInt(10));
        }
        System.out.printf("%s ist fertig\n",this.name);
    }
}
