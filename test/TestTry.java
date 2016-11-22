public class TestTry {
    public static void myFun() throws Exception {
        int[] data = new int[100];
        // for (int i = 1; i <= data.length; i++)
        //         data[i] = i;
        // data = null;
        // data[100] = 10;
        //好想自己丟exception...成全你吧
        throw new Exception("我是自訂顯示訊息的例外");
    }
    public static void main(String[] argv) {
        try {
            myFun();
            } catch(ArrayIndexOutOfBoundsException er1) {
                System.out.println("陣列索引超過邊界錯誤");
                er1.printStackTrace();
            } catch(NullPointerException np) {
                System.out.println("搞啥，沒事亂指");
            } catch(Exception err) {
                System.out.println("出錯了");
                // System.out.println(err.toString());
                err.printStackTrace();
            }finally {
                System.out.println("不管有沒有錯，不管哪種錯，finally區塊一定會被執行");
            }
    }
}
