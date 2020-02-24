public class Message {
    Handler handler;
    Runnable runnable;
    public Message(Runnable runnable){
        this.runnable = runnable;
    }
}

