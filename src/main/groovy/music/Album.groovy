package music

import com.fasterxml.jackson.annotation.JsonProperty

class Album {
    String artistName

    @JsonProperty('collectionName')
    String name

    @JsonProperty('collectionViewUrl')
    String url
}
