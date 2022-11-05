// Librerias para leer el contenido del archivo
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

// Importar ArrayList
import java.util.ArrayList;

public class AbrirArchivos {

    // Atributos <-----------------------------------------------------------------------------      
    private String header;
    
    public ArrayList<Usuario> readFileContent(String ruta){
        ArrayList<Usuario> dataUsuarios = new ArrayList<Usuario>();
        BufferedReader bf;

        try {
            bf = new BufferedReader(new FileReader(ruta));
            String temp = "";
            String bfRead;

            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead + "\n";
            }

            // El temp tendrá la información del archivo
            // Ahora vamos a preparar y adaptar la informacion
            String[] lines = temp.split("\n"); // Separar contenido por lineas

            header = lines[0];

            for (int i = 1; i < lines.length; i++) {
                // Separar el contenido de la linea por comas para obtener los datos individualmente
                String[] estudentData = lines[i].split(",");

                String name = estudentData[0];
                int edad = Integer.parseInt(estudentData[1]);
                String dpi = estudentData[2];
                int altura = Integer.parseInt(estudentData[3]);
                int peso = Integer.parseInt(estudentData[4]);

                // data.add(new DataStudent(carne, name, notes)); // Agregar nuevo estudiante con sus respectivos datos
                dataUsuarios.add(new Usuario(name, edad, dpi, altura, peso));
            }
                        
        } catch (Exception e) {
            dataUsuarios = null;
        }

        return dataUsuarios;
    }   

    private String paraSobreescribirDatos(Usuario usuario){
        return usuario.getNombres()  + "," + usuario.getEdad() + "," + usuario.getDPI() + "," + usuario.getAltura() + "," + usuario.getPeso(); 
    }

    public String saveChanges(ArrayList<Usuario> dataUsuarios, String file){
        String information = "";
        
        // Vamos a preparar toda la informacion
        int numLineas = dataUsuarios.size() + 1; // Tamaño de la cantidad de elementos en el array más el encabezado
        String[] lineas = new String[numLineas]; // Definir tamaño para almacenar las lineas correctas y exactas
        lineas[0] = header; // Regresar el encabezado de nuevo
        
        for (int i = 1; i < lineas.length; i++) { // Empezamos desde 1 para evitar sobreescribir en el encabezado
            Usuario usuario = dataUsuarios.get(i - 1); // Restamos uno para obtener el estudiante correcto
            lineas[i] = paraSobreescribirDatos(usuario);
        }
        
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

            // Escribimos linea a linea en el documento
			for (String linea : lineas) {
				try {
					out.write(linea + "\n");
				} catch (IOException ex) {
                    information = "\n-> ERROR: Se presento un inconveniente en la escritura";
				}
			}

            out.close();
            System.out.println("Se cerro con exito");
            information = "\n-> DATOS GUARDADOS CON EXITO";
        } catch (Exception e) {
            information = "\n-> ERROR: No se encontro el archivo";
        }

        return information;
    }
}
