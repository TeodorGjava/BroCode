package StaticWord;

public class Main {
    public static void main(String[] args) {
        Friends friend1 = new Friends("John");
        Friends friend2 = new Friends("Pesho");
        Friends friend3 = new Friends("Gosho");
        Friends friend4= new Friends("Ivan");
        //static variable NumOfFriend
        System.out.println(Friends.NumOfFriends);
        //static Method displayFriends
        Friends.displayFriends();


    }
}
