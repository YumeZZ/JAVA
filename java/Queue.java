public class Queue {
    private int[] data = new int[100];
    int head, tail, size;
    public synchronized void add(int x) {
        while (size == data.length) {
            try {
                // sleep until other thread notify
                wait();
            } catch (Exception err) {
            }
        }
        data[tail++] = x;
        size++;
        tail = tail % data.length;
        if(size == 1) {
            notifyAll();
        }
    }
    public synchronized int delete() {
        while (size == 0) {
            try {
                // sleep until other thread notify
                wait();
            } catch (Exception err) {
            }

        }
        int tmp = data[head++];
        size--;
        head = head % data.length;
        //if any thread needs me to notigy
        //if befer
        if(size == data.length - 1)
            notifyAll();
        return tmp;
    }
    // public synchronized boolean isEmpty() {
    //     return size == 0;
    // }
}
