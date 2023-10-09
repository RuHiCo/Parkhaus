public class Main {
    public static void main(String[] args) {
        Parkhaus parkhaus=new Parkhaus(10);
        Auto[] autos=new Auto[15];
        for(int i=0;i<15;i++){
            autos[i]=new Auto("Auto_"+i,parkhaus);
        }
        for(int i=0;i<15;i++){
            try {
                autos[i].join();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Insgesamt %d Parkvorgänge\n",parkhaus.insgesamt_geparkt);

        for(int i=0;i<parkhaus.autos_parkversuche.size();i++) {
            System.out.printf("%s hat %d mal versucht zu parken\n","Auto_"+i,parkhaus.autos_parkversuche.get("Auto_"+i));
        }
    }
}
