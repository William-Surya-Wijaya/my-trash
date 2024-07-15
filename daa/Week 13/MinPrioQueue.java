//class MinPrioQueue {
//    private class Data {
//        int id;
//        int key;
//
//        Data(int id, int key) {
//            this.id = id;
//            this.key = key;
//        }
//    }
//
//    private Data[] heap;
//    private int[] position;
//    private int length;
//    private int size;
//
//    public MinPrioQueue(int length) {
//        this.length = length;
//        this.size = 0;
//        this.heap = new Data[length + 1];
//        this.position = new int[length + 1];
//    }
//
//    private int getLeft(int i) {
//        return i<<1;
//    }
//
//    private int getRight(int i) {
//        return (i<<1) | 1;
//    }
//
//    private int getParent(int i) {
//        return i>>1;
//    }
//
//    private void swap(int idx1, int idx2) {
//        Data temp = this.heap[idx1];
//        this.heap[idx1] = this.heap[idx2];
//        this.heap[idx2] = temp;
//
//        int id1 = this.heap[idx1].id;
//        int id2 = this.heap[idx2].id;
//
//        int temp2 = this.position[id1];
//        this.position[id1] = this.position[id2];
//        this.position[id2] = temp2;
//    }
//
//    public void decreaseKey(int id, int newKey) {
//        int curr = this.position[id];
//
//        if (curr==0) {
//            return;
//        }
//
//        if (this.heap[curr].key > newKey) {
//            Data temp = new Data(id, newKey);
//            this.heap[curr] = temp;
//
//            while(id > 1 && this.heap[getParent(id)].key > this.heap[curr].key) {
//                swap(getParent(id), id);
//                id = getParent(id);
//            }
//        }
//    }
//
//    public boolean insert(int id, int key) {
//        if (this.size==this.length) {
//            return false;
//        }else if (id <= 0 || id > this.length) {
//            return false;
//        }else if (this.position[id] != 0) {
//            return false;
//        }else {
//            Data temp = new Data(Integer.MAX_VALUE, Integer.MAX_VALUE);
//
//            size += 1;
//            this.heap[this.size] = temp;
//            this.position[id] = this.size;
//
//            decreaseKey(id, key);
//
//            return true;
//        }
//    }
//
//    public int[] extractMin() {
//        if (this.size == 0) {
//            return null;
//        }
//
//        this.swap(1, this.size);
//
//        Data d = this.heap[this.size];
//        this.position[d.id] = 0;
//        this.size--;
//        this.heapify(1);
//
//        int[] result = new int[2];
//        result[0] = d.id;
//        result[1] = d.key;
//
//        return result;
//    }
//
//    public void heapify(int i) {
//        int curr = i;
//        int l = getLeft(i);
//        int r = getRight(i);
//
//        if ((l <= size) && (this.heap[l].key < this.heap[curr].key)) {
//            curr = l;
//        }
//
//        if ((r <= size) && (this.heap[r].key < this.heap[curr].key)) {
//            curr = r;
//        }
//
//        if (curr != i) {
//            swap(i, curr);
//            heapify(curr);
//        }
//
//    }
//
//    public void print() {
//        System.out.println("Heap");
//        for (int i = 1; i <= this.size; i++) {
//            System.out.print("(" + this.heap[i].id + "," + this.heap[i].key + ")");
//        }
//
//        System.out.println("");
//
//        System.out.println("Position");
//        for (int i = 1; i <= this.length; i++) {
//            System.out.print(this.position[i] + " ");
//        }
//
//        System.out.println("");
//    }
//
//}
//
//class TesterPrioQueue {
//    public static void main(String[] args) {
//        MinPrioQueue pq = new MinPrioQueue(5);
//
//        pq.insert(1,4);
//        pq.insert(2,1);
//        pq.insert(3,5);
//        pq.insert(0,4);
//        pq.insert(6,4);
//        pq.insert(3,7);
//        pq.insert(4,2);
//
//        pq.print();
//
//        int[] res = pq.extractMin();
//
//        System.out.println("Min: " + res[0] + "," + res[1]);
//        pq.print();
//
//        res = pq.extractMin();
//        System.out.println("Min: " + res[0] + "," + res[1]);
//        pq.print();
//    }
//}
