/**
 * Created by jhascall19 on 1/18/19.
 */
public class Stock {
    public static final String csvFile = "/Users/jhascall19/GitHub/StockSim/src/IVV.csv";
    private Info info;

    public Stock() {

        info = new Info(csvFile);

    }

    public double[] movingAvgPrice(){
        double[] array = new double[info.list.size()-1];
        double avg = info.getOpen(1);
        array[0] = avg;
        for (int i = 2; i < info.list.size()-1; i++) {
            for (int j = 0; j < 5; j++) {
                // TODO: 1/22/19 COMPARE TO THE 5 to the left and the 5 to the right 
            }
            avg = (((avg*(i-1))+info.getOpen(i))/i);
            array[i-1] = avg;

        }
        return array;
    }


    public static void main(String[] args) {
        Stock stock = new Stock();
        System.out.println(stock.movingAvgPrice()[500]);
    }
}
