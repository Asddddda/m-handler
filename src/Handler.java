public abstract class Handler {
    Looper mLooper;
    public Handler(){
        mLooper = Looper.myLooper();
    }
    static int i=0;
    public void sendMessage(Message message){
        message.handler = this;
       if(mLooper == null) {
           i++;
           System.out.println(i);
       }
        if(mLooper!=null) {
            synchronized (mLooper){
                mLooper.queue.add(message);
            }
            synchronized (mLooper.currantThread) {
                mLooper.currantThread.notify();
                System.out.println("Notify data is: "+message.mData);
            }
        }
    }
    abstract void handleMessage(Message message);
}
