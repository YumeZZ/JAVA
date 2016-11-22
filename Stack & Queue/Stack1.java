import java.math.BigInteger;
import java.math.BigDecimal;//可寫小數
public class Stack{
    int top = 0; // object variable
    BigDecimal[] data = new BigDecimal[100]; // object variable
    public Stack(){
        
    }
    public void push(BigDecimal x) {
        // x is a local variable, and a parameter
        //data[top++] = x;
        this.data[this.top++] = x;
    }
    public BigDecimal pop() {
        return this.data[--top];
    } 

}