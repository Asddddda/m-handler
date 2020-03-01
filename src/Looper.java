import java.util.ArrayDeque;

public class Looper {
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    static Looper myLooper(){
        return sThreadLocal.get();
    }
    Thread currantThread;
//    volatile ArrayDeque<Message> queue = new ArrayDeque<>();
    volatile MessageQueue queue = new MessageQueue();    
    static public void prepare(){
        if(sThreadLocal.get()!=null){
            throw new RuntimeException("一个线程只能有一个looper");
        }
        sThreadLocal.set(new Looper());
        sThreadLocal.get().currantThread = Thread.currentThread();
    }

    static public void loop(){
        while (true){
            if(!sThreadLocal.get().queue.isEmpty()){
                Message message;
                synchronized (sThreadLocal.get().queue) {
                    message = sThreadLocal.get().queue.poll();
                }
                message.handler.handleMessage(message);
            }else {
                //sleep
                try {
                    synchronized (sThreadLocal.get().currantThread){
                        sThreadLocal.get().currantThread.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("loop");

        }
    }

}
