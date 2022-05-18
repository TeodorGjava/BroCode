package SuperKeyword;

public class Person {
    String name;
    int age;
    Person(String name,int age){
        this.name=name;
        this.age =age;
    }
    public String toString(){
        //this will be passed to the subclass(child) with super.toString
        return this.name + " "+ this.age +" ";
    }
}
