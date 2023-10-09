import java.util.HashMap;

public class Parkhaus {
    int max_autos;
    int aktuelle_autos=0;
    int insgesamt_geparkt=0;
    HashMap<String,Integer> autos_parkversuche =new HashMap<String,Integer>();
    public Parkhaus(int max_autos){
        this.max_autos=max_autos;
    }



    synchronized public boolean einparken(String name){
        this.autos_parkversuche.putIfAbsent(name,0);
        this.autos_parkversuche.put(name,this.autos_parkversuche.get(name)+1);
        if (this.aktuelle_autos<this.max_autos){
            this.insgesamt_geparkt++;
            System.out.printf("Eingeparkt. Aktuell %d Autos\n",++this.aktuelle_autos);
            return true;
        }
        System.out.printf("Nicht eingeparkt. Aktuell %d Autos\n",this.aktuelle_autos);
        return false;
    }
    synchronized public void ausparken(){
        System.out.printf("Ausgeparkt. Aktuell %d Autos\n",--this.aktuelle_autos);
    }
}
