package AccessModifyers.Package1;
import AccessModifyers.Package2.*;
public class A {
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.publicMsg);
    }
}
