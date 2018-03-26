import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sun.xml.internal.ws.developer.SerializationFeature;

import java.io.IOException;

public class JSONMapper extends ObjectMapper {
    private static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static <T> T toObject(Object data, Class<T> aClass) throws IOException {
        return mapper().readValue((String) data, aClass);
    }
}
