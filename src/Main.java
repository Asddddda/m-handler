import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputData;
        Scanner scanner = new Scanner(System.in);
        inputData = scanner.nextLine();

        new Thread(new Runnable() {
           @Override
           public void run() {
               Looper.prepare();
               Handler handler = new MHandler();
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       for(int i = 0;i<3;i++) {
                           int finalI = i;
                           handler.sendMessage(new Message(new Runnable() {
                               @Override
                               public void run() {
                                   System.out.println("No."+ finalI +": "+Thread.currentThread());
                               }
                           },inputData));
                           try {
                               Thread.sleep(1000);
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                       handler.sendMessage(new Message(new Runnable() {
                           @Override
                           public void run() {
                               System.exit(0);
                           }
                       },inputData));
                   }
               }).start();
               Looper.loop();
           }
       }).start();
    }
}
