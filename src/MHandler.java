public class MHandler extends Handler {
    @Override
    void handleMessage(Message message) {
        message.runnable.run();
    }
}
