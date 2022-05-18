package StaticWord;

public class Friends {
    String name;
    static int NumOfFriends;
    Friends(String name){
        this.name = name;
        NumOfFriends++;
    }
    static void displayFriends(){
        System.out.println("You have "+ NumOfFriends + " friends");
    }
}
