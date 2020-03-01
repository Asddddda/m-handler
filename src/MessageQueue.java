public class MessageQueue {
    //先从最基础的数组试试
    Message[] queue = new Message[10];
    static int index = 0;

    public void add(Message message) {
        queue[index++] = message;
    }

    public boolean isEmpty() {
        for (int i = 0; i < index; i++) {
            if (queue[i] != null) {
                return false;
            }
        }
        return true;
    }

    public Message poll(){
        Message firstMsg = firstMessage();
        for(int i = 1; i < index; i++) {
            queue[i-1] = queue[i];
        }
        return firstMsg;
    }

    public Message firstMessage(){
        return queue[0];
    }
}
