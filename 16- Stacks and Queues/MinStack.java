public class MinStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 5;
    private int ptr = 0;
    private int minValue = Integer.MAX_VALUE;

    protected int[] minimum;
    

    public MinStack(){
        this(DEFAULT_SIZE);
    }
    public MinStack(int size){
        data = new int[size];
        minimum = new int[size];
    }


    public void push(int value){
        if(ptr == data.length){
            resize();
        }
        if(value < minValue){
            minValue = value;
        }
        minimum[ptr] = minValue;
        data[ptr] = value;
        ptr++;
        return;
    }

    public void pop() throws Exception{
        if(ptr == -1){
            throw new Exception("Cannot pop from an Empty stack");
        }   
        ptr--;
        if (ptr > 0) {
            minValue = minimum[ptr - 1];
        } else {
            minValue = Integer.MAX_VALUE;
        }
    }

    public int top() throws Exception{
        if(ptr == -1){
            throw new Exception("Cannot pop from an Empty stack");
        }
        int topIndex = ptr - 1;
        return data[topIndex];
    }

    public int getMin(){
        int index = ptr-1;
        return minimum[index];
    }

    private void resize(){
        int[] temp = new int[2*data.length];
        int[] temp2 = new int[2*minimum.length];

        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }
        for(int i=0; i<minimum.length; i++){
            temp2[i] = minimum[i];
        }
        data = temp;
        minimum = temp2;
    }

    public void display(){
        for(int i=0; i<ptr; i++){
            System.out.print(data[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception{
        MinStack stack = new MinStack();

        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        stack.display();
        System.out.println();

        System.out.println(stack.getMin());
        System.out.println();

        System.out.println(stack.top());
        

    }
}
