

public class controller {
    public static void main(String[] args) {
        
        view v = new view();

        v.IngresoDatos();
        System.out.println(v.getAltura());
        System.out.println(v.getPeso());
        
    }
}
