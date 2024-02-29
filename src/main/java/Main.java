import models.Tenista;
import mappers.TenistaMapper;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        // Declara un objeto Path que representa la ruta del fichero de origen tenistas.csv
        Path path = Paths.get("src/main/resources/tenistas.csv");

        // Lee el contenido del fichero tenistas.csv y lo muestra por consola
        for (Tenista tenista : TenistaMapper.leerTenistasCsv(path)) {
            System.out.println(tenista);
        }

        // Declara un objeto Path que representa la ruta del fichero de destino tenistas_lista.json
        Path pathJson = Paths.get("src/main/resources/tenistas_lista.json");

        // Escribe el contenido del fichero tenistas.csv en el fichero de destino tenistas_lista.json
        TenistaMapper.escribirListaTenistasJson(TenistaMapper.leerTenistasCsv(path), pathJson);
    }
}