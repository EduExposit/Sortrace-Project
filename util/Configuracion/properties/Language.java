package util.Configuracion.properties;

import java.io.IOException;
import java.util.Properties;
import util.FilePath;


public class Language extends Properties {
    private static final long serialVersionUID = 1L;

    public Language(String language) {
        if (!language.equals("ESPAÑOL") && !language.equals("SPANISH")) {
            this.getProperties("/util/Configuracion/properties/ingles.properties");
        } else {
            this.getProperties("/util/Configuracion/properties/español.properties");
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
