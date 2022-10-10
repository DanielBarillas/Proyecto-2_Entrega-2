import javax.swing.JOptionPane;



/**
 * view
 */
public class view {

    double peso, altura;

    public void IngresoDatos() {
        peso = Double.parseDouble( JOptionPane.showInputDialog("Ingrese el peso del usuario: "));
        altura = Double.parseDouble( JOptionPane.showInputDialog("Ingrese la altura del usuario: "));

    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}