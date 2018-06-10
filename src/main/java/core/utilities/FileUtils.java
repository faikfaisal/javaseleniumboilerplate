package core.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

/**
 * File related utilities
 */
public class FileUtils {
    /**
     * Reads a yml file from resource folder and maps it to a DTO
     *
     * @param locationOfFile
     * @param dtoClass
     * @param <E>
     * @return mappedDto of type E
     * @throws IOException
     */
    public <E> E readYmlFile(
            String locationOfFile,
            Class<E> dtoClass
    ) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ClassLoader classLoader = getClass().getClassLoader();
        String pathToSettingsFile = classLoader.getResource(locationOfFile).getFile();
        File settingsFile = new File(pathToSettingsFile);
        return mapper.readValue(settingsFile, dtoClass);
    }
}
