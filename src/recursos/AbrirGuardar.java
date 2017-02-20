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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import superrolbattle.Principal;
import recursos.DataRecursos;
import static recursos.Recursos.guardarConfig;

/**
 *
 * @author Juan
 */
public class AbrirGuardar {

    File actual;
    public JFileChooser jfc;
    public boolean cambios = false;
    String name;

    public AbrirGuardar() {
        jfc = new JFileChooser(Principal.dataRecursos.getDirectorio_default());
        ExtensionFileFilter filter1 = new ExtensionFileFilter("Campo de Batalla", new String[]{"fld", "FLD"});
        jfc.setFileFilter(filter1);
    }

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

    public void GuardarFieldXML(CampoDeBatalla field) throws IOException {
        if (actual != null) {
            guardarXML(field, actual.getAbsolutePath());
        } else {
            GuardarComoFieldXML(field);
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

    public void GuardarComoFieldXML(CampoDeBatalla field) throws IOException {
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            if (f.getName().endsWith(".fld") || f.getName().endsWith(".FLD")) {
                actual = f;
            } else {
                actual = new File(f.getAbsolutePath() + ".fld");
            }

            try {
                guardarXML(field,actual.getAbsolutePath());
                System.out.println("Se guardo el Archivo\n" + field.toString());
                GuardarDir(actual.getAbsolutePath().replace(actual.getName(), ""));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(), "Error Abriendo Archivo", JOptionPane.ERROR_MESSAGE);
            }

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

    public CampoDeBatalla AbrirFieldXML() throws IOException, ClassNotFoundException {

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            actual = jfc.getSelectedFile();
            CampoDeBatalla obj1 = (CampoDeBatalla) cargarXML(actual.getAbsolutePath(), "CampoDeBatalla");

            GuardarDir(actual.getAbsolutePath().replace(actual.getName(), ""));
            System.out.println("Cargado Exitosamente");
            name = actual.getName().replace(".fld", "");
            return obj1;
        } else {
            return null;
        }
    }

    static public String directorio() throws IOException {
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
        /*ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Inicio.ini"));
        salida.writeObject(dir);
        salida.close();
        Principal.dataRecursos.setDirectorio_default(dir);
        */
        Principal.dataRecursos.setDirectorio_default(dir);
        guardarConfig(Principal.dataRecursos);
    }

    public String getName() {
        return name;
    }

    private static final String CDG_BKP_DAT_DIR = "Data\\bkp\\";

    public static void guardarXML(Object cdg, String path) {
        ;
        JAXBContext context;
        Marshaller marshaller = null;
        try {
            context = JAXBContext.newInstance(cdg.getClass());
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException ex) {
            Recursos.informar(ex.toString());
        }

        try {
            //Mostramos el documento XML generado por la salida estandar
            marshaller.marshal(cdg, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
            Recursos.informar(ex.toString());
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            marshaller.marshal(cdg, fos);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
            Recursos.informar(ex.toString());
        } catch (JAXBException ex) {
            Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
            Recursos.informar(ex.toString());
        } catch (IOException ex) {
            Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
            Recursos.informar(ex.toString());
        }
        //guardamos el objeto serializado en un documento XML

    }

    public static Object cargarXML(String path, String c) {
        JAXBContext context;
        Unmarshaller unmarshaller = null;
        Object objXml = null;

        try {
            if (c.equals("DataRecursos")) {
                context = JAXBContext.newInstance(DataRecursos.class);
            } else if (c.equals("CampoDeBatalla")) {
                context = JAXBContext.newInstance(CampoDeBatalla.class);
            } else {
                context = JAXBContext.newInstance(CampoDeBatalla.class);
            }
            Marshaller marshaller = context.createMarshaller();
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException ex) {
            Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //Deserealizamos a partir de un documento XML
            objXml = unmarshaller.unmarshal(new File(path));
        } catch (JAXBException ex) {
            Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objXml;

    }

}
