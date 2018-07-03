package music.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.MediaType;
import io.micronaut.jackson.codec.JsonStreamMediaTypeCodec;
import io.micronaut.runtime.ApplicationConfiguration;

import javax.inject.Singleton;

/**
 * This class is temporary, pending a resolution
 * to https://github.com/micronaut-projects/micronaut-core/issues/340
 */
@Singleton
public class JavascriptMediaType extends JsonStreamMediaTypeCodec {

    public static final MediaType JAVASCRIPT_MEDIA_TYPE = new MediaType("text/javascript");

    /**
     * @param objectMapper             To read/write JSON
     * @param applicationConfiguration The common application configurations
     */
    public JavascriptMediaType(ObjectMapper objectMapper, ApplicationConfiguration applicationConfiguration) {
        super(objectMapper, applicationConfiguration);
    }

    public MediaType getMediaType() {
        return JAVASCRIPT_MEDIA_TYPE;
    }
}
