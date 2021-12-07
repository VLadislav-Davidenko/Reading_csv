import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Reader {
    public static void main(String[] args) {
       String split = ";";
        try {
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("order_1.csv"));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("order_2.csv"));
            ArrayList<ATB> shopsATB = new ArrayList<>();
            ArrayList<Silpo> shopsSilpo = new ArrayList<>();
            String line;
            while ((line = bufferedReader1.readLine()) != null){
                String[] value = line.split(split);
                if(value[0].equals("АТБ")){
                    double cost = Double.parseDouble(value[2]);
                    int amount = Integer.parseInt(value[3]);
                    shopsATB.add(new ATB(value[1], cost, amount));
                } else if(value[0].equals("Сильпо")){
                    double cost = Double.parseDouble(value[2]);
                    int amount = Integer.parseInt(value[3]);
                    shopsSilpo.add(new Silpo(value[1], cost, amount));
                }
            }
            while ((line = bufferedReader2.readLine()) != null){
                String[] value = line.split(split);
                if(value[0].equals("АТБ")){
                    double cost = Double.parseDouble(value[2]);
                    int amount = Integer.parseInt(value[3]);
                    shopsATB.add(new ATB(value[1], cost, amount));
                } else if(value[0].equals("Сильпо")){
                    double cost = Double.parseDouble(value[2]);
                    int amount = Integer.parseInt(value[3]);
                    shopsSilpo.add(new Silpo(value[1], cost, amount));
                }
            }

            HashMap<String, ATB> m1 = new HashMap<>();
            HashMap<String, Silpo> m2 = new HashMap<>();

            for (ATB atb : shopsATB) {
                ATB oldElem = m1.put(atb.getName(), atb);
                if (oldElem != null) {
                    atb.setAmount(atb.getAmount() + oldElem.getAmount());
                    atb.setCost((double) Math.round(atb.getCost() + oldElem.getCost())/2);
                }

            }
            for (Silpo silpo : shopsSilpo) {
                Silpo oldElem = m2.put(silpo.getName(), silpo);
                if (oldElem != null) {
                    silpo.setAmount(silpo.getAmount() + oldElem.getAmount());
                    silpo.setCost((double) Math.round(silpo.getCost() + oldElem.getCost())/2);
                }
            }

            try(FileWriter fileWriter1 = new FileWriter("atb_res.txt");
                FileWriter fileWriter2 = new FileWriter("silpo_res.txt")){
                for (ATB value : m1.values()) {
                    fileWriter1.write(value + "\n");
                }
                for (Silpo value : m2.values()) {
                    fileWriter2.write(value + "\n");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
