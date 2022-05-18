package ArrayOfObjects;

public class Main {
    public static void main(String[] args) {
        //Food[] refrigerator = new Food[3]; way 1

        //creating the objects and give them name(attribute)
        Food food1 = new Food("pizza",2.50);
        Food food2 = new Food("cheese",7.79);
        Food food3 = new Food("hotdog",6.36);
        //Way 2
        Food[] refrigerator = {food1,food2,food3};

        //adding objects to the array ; way 1
       // refrigerator[0] = food1;
       // refrigerator[1] = food2;
       // refrigerator[2]= food3;
        for (int i = 0; i < refrigerator.length ; i++) {
            System.out.println(refrigerator[i].name+ " "+ refrigerator[i].price);
        }
        System.out.println(refrigerator[0].name+" "+refrigerator[0].price);
        System.out.println(refrigerator[1].name);
        System.out.println(refrigerator[2].name);
    }
}
