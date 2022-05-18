package SuperKeyword;

public class Hero extends Person{
    String power;
    Hero(String name, int age, String power){
        super(name,age);
        //super(attributes from parent class passed)
        this.power=power;
    }
    public String toString(){
        //passing a method with the super keyword and then add the superpower
        return super.toString()  +this.power;
    }
}
