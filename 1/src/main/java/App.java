
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ArrayList a = new ArrayList(2) ;
        a.add(0, "karim");
        a.add(1, "object1");
        a.add(2, "object2");
        
        System.out.println(a);
        a.remove("object1") ; 
        System.out.println(a);

        
    }
}
