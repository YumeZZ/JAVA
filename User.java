public class User {
    public static void main (String[] argv) {
        TV myTV = new TV();
        myTV.increaseChannel();
        myTV.decreaseChannel();
        myTV.setChannel(60);
        myTV = new LEDTV();
        // 父類別型態的reference可以指到子類別的物件
        // 所以這種reference可以指向多種子類別
        // 這稱為polymorphism
        myTV.increaseChannel();
        // if in line 11, LEDTV.increaseChannel will be called
        // which means determined by actual object tybe
        // then we call it "virtual function"
        // if TV.increaseChannel() will be called
        // which means determined by reference type
        // then we call it "non virtual funcition"
        myTV = new OLEDTV();
    }
}
