/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import instancias.CampoDeBatalla;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class AbrirGuardar {

    File actual;
    public JFileChooser jfc;
    public boolean cambios = false;
    String name;
    public static String directorio = "";
    

    public void GuardarField(CampoDeBatalla field) throws IOException {
        if (actual != null) {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(actual));
            salida.writeObject(field);
            System.out.println("Se supone que se guardo bien\n" + field);

            salida.close();
        } else {
            GuardarComoField(field);
        }
    }

    public void GuardarComoField(CampoDeBatalla field) throws IOException {
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            if (f.getName().endsWith(".fld") || f.getName().endsWith(".FLD")) {
                actual = f;
            } else {
                actual = new File(f.getAbsolutePath() + ".fld");
            }
            ObjectOutputStream salida = null;
            try {
                salida = new ObjectOutputStream(new FileOutputStream(actual));
                salida.writeObject(field);
                System.out.println("Se supone que se guardo bien\n" + field);
                GuardarDir(actual.getAbsolutePath().replace(actual.getName(), ""));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error Abriendo Archivo", JOptionPane.ERROR_MESSAGE);
            }
            salida.close();
        }
    }

    public CampoDeBatalla AbrirField() throws IOException, ClassNotFoundException {

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            actual = jfc.getSelectedFile();
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(actual));
            CampoDeBatalla obj1 = (CampoDeBatalla) entrada.readObject();
            entrada.close();
            GuardarDir(actual.getAbsolutePath().replace(actual.getName(), ""));
            System.out.println("Cargado Exitosamente");
            name = actual.getName().replace(".fld", "");
            return obj1;
        } else {
            return null;
        }
    }

    public AbrirGuardar() {
        jfc = new JFileChooser(directorio);
        ExtensionFileFilter filter1 = new ExtensionFileFilter("Campo de Batalla", new String[]{"fld", "FLD"});
        jfc.setFileFilter(filter1);
    }

    static public  String directorio() throws IOException {
        File f = new File("Inicio.ini");
        ObjectInputStream entrada = null;
        String dir = null;
        try {
            entrada = new ObjectInputStream(new FileInputStream(f));
            dir = (String) entrada.readObject();
            entrada.close();
        } catch (Exception ex) {
            GuardarDir("");
        }

        System.out.println("Cargado Exitosamente");
        return dir;
    }

    public static void GuardarDir(String dir) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Inicio.ini"));
        salida.writeObject(dir);
        salida.close();
        directorio =dir;

    }

    public String getName() {
        return name;
    }

    
}
