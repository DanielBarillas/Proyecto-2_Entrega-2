import javax.swing.*;

public class Peso_ideal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String genero = "";
		
		do {
			
			genero = JOptionPane.showInputDialog("Introduce tu género (H/M): ");
			
		}while(genero.equalsIgnoreCase("H")==false && genero.equalsIgnoreCase("M")==false);
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en cm"));
		
		int Peso_Ideal = 0;
		
		if(genero.equalsIgnoreCase("H")) {
			
			Peso_Ideal = altura - 110;
		}
		
		else if(genero.equalsIgnoreCase("M")) {
			
			Peso_Ideal = altura - 120;
		}
		
		System.out.println("Tu peso  ideal es: "  + Peso_Ideal + " kg");
		
	}

}
