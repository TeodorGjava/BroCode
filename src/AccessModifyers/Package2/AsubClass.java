package AccessModifyers.Package2;

import AccessModifyers.Package1.*;

public class AsubClass extends A {


    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.defaultMsg);
    }
}
