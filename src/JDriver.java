import java.awt.*;
import javax.swing.*;

public class JDriver extends JPanel {

    private int index;
    private static Info info;
    private static Stock stock;

    public JDriver() {
info = new Info("/Users/jhascall19/GitHub/StockSim/src/IVV.csv");
        stock = new Stock();
    }

    public void paint(Graphics g) {
int minutes = info.getList().size()-1;
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double range = (info.getMaxPrice() - info.getMinPrice());
        double max = info.getMaxPrice();
        double min = info.getMinPrice();
        for (int i = 1; i < minutes; i++) {
            int x = i;
            double price = info.getClose(i);
            int y = (int)(300*((max-price)/range));

            //maxheight divided by the percent of the max price that it is
            //max = 1, min = 0, need to set it to relative heights based on percent of max or min.. double = range/(max-(value I want)) (should always be less
            // than 1 or 1 so a value thats distance is half the range should be .5

            double diff;
            if (((info.getOpen(i) >= info.getClose(i)))){
                diff = ((info.getOpen(i)-info.getClose(i)));
            }else{
                diff = ((info.getClose(i)-info.getOpen(i)));
            }

            int height = (int)(300*diff);

            g2d.drawRect(x, y, 1,height);

        }
        for (int i = 0; i < stock.movingAvgPrice().length; i++) {
double[] array = stock.movingAvgPrice();
            int x = i;
            double price = array[i];
            int y = (int)(300*((max-price)/range));
            g2d.drawOval(x,y,5,5);

        }


    }



    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("StockChart");
        JDriver jDriver = new JDriver();
        // TODO: 1/20/19 FIXTHESCROLLBAR
        JScrollPane scroll = new JScrollPane(jDriver,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scroll);
        // TODO: 1/21/19 Keep those constant and format X to fit the screen
        frame.setSize(290,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
