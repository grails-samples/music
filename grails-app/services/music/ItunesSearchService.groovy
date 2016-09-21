package music

import grails.plugin.cache.Cacheable
import grails.plugins.rest.client.RestBuilder
import org.springframework.beans.factory.annotation.Value

class ItunesSearchService {

    @Value('${music.search.url}')
    String searchUrl

    @Cacheable('itunesSearchResults')
    List<Album> search(String searchTerm) {
        log.debug "Searching iTunes Store For [${searchTerm}]"
        def rb = new RestBuilder()

        log.debug "Search URL: ${searchUrl}"
        def resp = rb.get(searchUrl, [searchTerm: searchTerm])

        def json = resp.json
        def jsonResults = json.results

        jsonResults.collect { albumInfo ->
            createAlbum albumInfo
        }
    }

    protected Album createAlbum(json) {
        new Album(name: json.collectionName,
                  artistName: json.artistName,
                  url: json.collectionViewUrl)
    }
}
