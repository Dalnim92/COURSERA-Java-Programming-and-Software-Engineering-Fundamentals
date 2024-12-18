
/**
 * Write a description of myFunction here.
 * 
 * @author (Ayten) 
 * @version (13/12/2024)
 */
public class Function{
    int f(int x, int y){
        if(x<y){
            System.out.println("x < y");
            return y+x;
        }
        else{
            System.out.println("x >= y");
            if(x > 8){
                return y+7;
            }
        }
        return x-2;
    }
    int g(){
        int a = f(9,4);
        int b = f(a,5);
        return b;
    }
}

