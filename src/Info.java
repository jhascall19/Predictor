import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * Created by jhascall19 on 1/18/19.
 */
public class Info {
    public ArrayList<ArrayList<String>> list;

    public Info(String csvFile){
        list = new ArrayList<>();
        String data = csvFile;
        File file = new File(data);
        int counter = 0;
        int minute = 0;

        try{
            Scanner inputStream = new Scanner(file);

            while (inputStream.hasNext()){

                ArrayList<String> list1 = new ArrayList();
                while (list1.size()< 7) {
                    list1.add(inputStream.next());
                    //System.out.println(list1);
                    if (list1.size() == 7){
                        list.add(list1);
                    }
                }
            }

            inputStream.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

    public ArrayList<String> getMinute(int minute){
        return list.get(minute);
    }


    public ArrayList<ArrayList<String>> getList() {
        return list;
    }


    public int getVolume(int minute){
if (minute == 0){
    System.out.println("error");
    return 0;
}else{

    return Integer.parseInt(list.get(minute).get(6));

}
    }

    public String getDate(int minute){
        if (minute == 0){
            return "Error does not exist";
        }else{

            return list.get(minute).get(0);

        }

    }
    public int getTime(int minute){
        if (minute == 0){
            System.out.println("error");
            return 0;
        }else{

            return Integer.parseInt(list.get(minute).get(1));

        }

    }
    public double getOpen(int minute){
        if (minute == 0){
            System.out.println("error");
            return 0;
        }else{

            return Double.parseDouble(list.get(minute).get(2));

        }
    }
    public double getClose(int minute){
        if (minute == 0){
            System.out.println("error");
            return 0;
        }else{

            return Double.parseDouble(list.get(minute).get(5));

        }

    }
    public int getLow(int minute){
        if (minute == 0){
            System.out.println("error");
            return 0;
        }else{

            return Integer.parseInt(list.get(minute).get(4));

        }

    }
    public int getHigh(int minute){
        if (minute == 0){
            System.out.println("error");
            return 0;
        }else{

            return Integer.parseInt(list.get(minute).get(3));

        }

    }

    public ArrayList<Double> getAllVolumes(){
        ArrayList<Double> volumes = new ArrayList<>();
        for (int i = 1; i < list.size()-1 ; i++) {
            volumes.add(Double.parseDouble(list.get(i).get(6)));
        }
        return volumes;
    }
    public ArrayList<Double> getAllOpens(){
        ArrayList<Double> opens = new ArrayList<>();
        for (int i = 1; i < list.size()-1 ; i++) {
            opens.add(Double.parseDouble(list.get(i).get(2)));
        }
        return opens;
    }
    public ArrayList<Double> getAllCloses(){
        ArrayList<Double> closes = new ArrayList<>();
        for (int i = 1; i < list.size()-1 ; i++) {
            closes.add(Double.parseDouble(list.get(i).get(5)));
        }
        return closes;
    }

    public ArrayList<Double> getAllHighs(){
        ArrayList<Double> highs = new ArrayList<>();
        for (int i = 1; i < list.size()-1 ; i++) {
            highs.add(Double.parseDouble(list.get(i).get(3)));
        }
        return highs;
    }
    public ArrayList<Double> getAllLows(){
        ArrayList<Double> lows = new ArrayList<>();
        for (int i = 1; i < list.size()-1 ; i++) {
            lows.add(Double.parseDouble(list.get(i).get(4)));
        }
        return lows;
    }



    public double getMaxPrice(){
       ArrayList<Double> maxs = getAllHighs();
        double max = 1;
        for (int i = 0; i <maxs.size(); i++) {
            if (maxs.get(i) > max){
                max = maxs.get(i);
            }
        }

        return max;
    }



    public double getMinPrice(){
        ArrayList<Double> mins = getAllLows();
        double min = 9999999;
        for (int i = 0; i < mins.size(); i++) {
            if (mins.get(i) < min){
                min = mins.get(i);
            }
        }

        return min;
    }

    public double getMinVolume(){
        ArrayList<Double> volumes = getAllVolumes();
        double min = 9999999;
        for (int i = 0; i < volumes.size(); i++) {
            if (volumes.get(i) < min){
                min = volumes.get(i);
            }
        }

        return min;
    }

    public double getMaxVolume(){
        ArrayList<Double> volumes = getAllVolumes();
        double min = 1;
        for (int i = 0; i < volumes.size(); i++) {
            if (volumes.get(i) > min){
                min = volumes.get(i);
            }
        }

        return min;
    }

    public double[] getAllClosesPrim(){
        double[] closes = new double[list.size()];
        for (int i = 1; i < list.size()-1 ; i++) {
            closes[i] += (Double.parseDouble(list.get(i).get(5)));
        }
        return closes;
    }
    public static void main(String[] args) {
        String data = "/Users/jhascall19/GitHub/StockSim/src/IVV.csv";
        Info info = new Info(data);
        System.out.println(info.getMaxPrice());
        System.out.println(info.getMinPrice());
        System.out.println("Joey is a nerd!");
    }
}
