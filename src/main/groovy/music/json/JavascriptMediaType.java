package music.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.codec.CodecConfiguration;
import io.micronaut.http.MediaType;
import io.micronaut.jackson.codec.JsonStreamMediaTypeCodec;
import io.micronaut.runtime.ApplicationConfiguration;

import javax.annotation.Nullable;
import javax.inject.Singleton;

/**
 * This class is temporary, pending a resolution to some issues
 * surrounding https://github.com/micronaut-projects/micronaut-core/issues/340
 */
@Singleton
public class JavascriptMediaType extends JsonStreamMediaTypeCodec {

    public static final MediaType JAVASCRIPT_MEDIA_TYPE = new MediaType("text/javascript");

    /**
     * @param objectMapper             To read/write JSON
     * @param applicationConfiguration The common application configurations
     * @param codecConfiguration       The configuration for the codec
     */
    public JavascriptMediaType(ObjectMapper objectMapper, ApplicationConfiguration applicationConfiguration, @Nullable CodecConfiguration codecConfiguration) {
        super(objectMapper, applicationConfiguration, codecConfiguration);
    }

    public MediaType getMediaType() {
        return JAVASCRIPT_MEDIA_TYPE;
    }
}
