package music.json;

import io.micronaut.codec.CodecConfiguration;
import io.micronaut.http.MediaType;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is temporary, pending a resolution to some issues
 * surrounding https://github.com/micronaut-projects/micronaut-core/issues/340
 */
@Singleton
class TempCodecConfiguration extends CodecConfiguration {

    @Override
    public List<MediaType> getAdditionalTypes() {
        List<MediaType> types = new ArrayList<>();
        types.add(new MediaType("text/javascript"));
        return types;
    }
}
