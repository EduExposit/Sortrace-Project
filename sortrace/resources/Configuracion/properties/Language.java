package main.resources.Configuracion.properties;

import java.io.IOException;
import java.util.Properties;
import main.resources.FilePath;


public class Language extends Properties {
    private static final long serialVersionUID = 1L;

    public Language(String language) {
        if (!language.equals("Español") && !language.equals("Spanish")) {
            this.getProperties("/main/resources/Configuracion/properties/ingles.properties");
        } else {
            this.getProperties("/main/resources/Configuracion/properties/español.properties");
        }

    }

    private void getProperties(String language) {
        try {
            this.load(FilePath.class.getResourceAsStream(language));
        } catch (IOException var3) {
            System.out.println("Excepcion: " + var3);
        }

    }
}
