public class Message {
    Handler handler;
    Runnable runnable;
    String mData;
    public Message(Runnable runnable ,String data){
        this.runnable = runnable;
        this.mData = data;
    }
}

