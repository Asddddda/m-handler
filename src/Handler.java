public abstract class Handler {
    Looper mLooper;
    public Handler(){
        mLooper = Looper.myLooper();
    }
    public void sendMessage(Message message){
        message.handler = this;
        synchronized (mLooper){
            mLooper.queue.add(message);
        }
        synchronized (mLooper.currantThread) {
            mLooper.currantThread.notify();
        }
    }
    abstract void handleMessage(Message message);

}
