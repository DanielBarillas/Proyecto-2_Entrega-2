import javax.swing.JOptionPane;



/**
 * view
 */
public class view {

    double peso, altura, imc, metros;

    public void IngresoDatos() {
        peso = Double.parseDouble( JOptionPane.showInputDialog("Ingrese el peso del usuario: "));
        altura = Double.parseDouble( JOptionPane.showInputDialog("Ingrese la altura del usuario: "));
        
    }
    public void fin() {
        Double metros = altura/100;
        Double imc = peso/(metros*metros); 
        JOptionPane.showMessageDialog(null, "Debajo de 18 Bajo peso"+ "\nDe 18 a 25 Rango Normal"+ "\nDe 25 a 30  Sobrepeso"+"\nArriba de 30 Obesidad"+"\nSu IMC es de: "+ imc);
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
    
 

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

   
}