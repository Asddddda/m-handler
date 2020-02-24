public class Main {
    public static void main(String[] args) {
        Looper.prepare();
        Handler handler = new MHandler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0;i<1000;i++) {
                    handler.sendMessage(new Message(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread());
                        }
                    }));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.sendMessage(new Message(new Runnable() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                }));
            }
        }).start();
        Looper.loop();
    }
}
