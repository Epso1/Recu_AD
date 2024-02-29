package mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import models.Tenista;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TenistaMapper {

    /**
     * Lee el contenido del fichero tenistas.csv y lo devuelve como una lista de objetos Tenista
     *
     * @param rutaCsv
     * @return List<Tenista>
     */
    public static List<Tenista> leerTenistasCsv(Path rutaCsv) {
        List<Tenista> tenistas = new ArrayList<>();

        try (Stream<String> contenidoFichero = Files.lines(rutaCsv)) {
            List<List<String>> contenidoFicheroLista = contenidoFichero
                    .map(linea -> Arrays.asList(linea.split(";")))
                    .skip(1)
                    .toList();

            contenidoFicheroLista.forEach(linea -> {
                tenistas.add(new Tenista(linea.get(0), linea.get(1), Integer.parseInt(linea.get(2)), LocalDate.parse(linea.get(3)), Integer.parseInt(linea.get(4)), Integer.parseInt(linea.get(5)), Integer.parseInt(linea.get(6)), linea.get(7), linea.get(8), linea.get(9), new ArrayList<>(Arrays.asList(linea.get(10).split(","))), Integer.parseInt(linea.get(11)), Long.parseLong(linea.get(12))));
            });

        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
        return tenistas;
    }

    /**
     * Escribe el contenido de una lista de tenistas en el fichero de destino tenistas_lista.json
     * @param tenistas
     * @param ruta
     */
    public static void escribirListaTenistasJson(List<Tenista> tenistas, Path ruta) {
        try {
            Files.deleteIfExists(ruta);
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.registerModule(new JavaTimeModule());
            jsonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonMapper.writeValue(ruta.toFile(), tenistas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
