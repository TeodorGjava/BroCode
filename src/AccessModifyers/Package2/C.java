package AccessModifyers.Package2;
import AccessModifyers.Package1.*;
// public modifier for the class makes the class visible for other classes, without public modifier
// class C will be visible to other classes only in the class C !
public class C {
    // defaultMsg is accessable and visible only within that package !
    String defaultMsg = "This is the default";
    // PUBLIC makes the publicMsg accessable and visible from other classes in other packages
    public String publicMsg = "This is public";
}
