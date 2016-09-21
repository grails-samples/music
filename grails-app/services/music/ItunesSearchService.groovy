package music

import grails.plugin.cache.Cacheable
import grails.plugins.rest.client.RestBuilder
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import org.grails.web.json.JSONObject
import org.springframework.beans.factory.annotation.Value

@CompileStatic
class ItunesSearchService {

    @Value('${music.search.url}')
    String searchUrl

    @Cacheable('itunesSearchResults')
    List<Album> search(String searchTerm) {
        log.debug "Searching iTunes Store For [${searchTerm}]"
        def rb = new RestBuilder()

        log.debug "Search URL: ${searchUrl}"
        def queryParameters = [searchTerm: searchTerm] as Map<String, Object>
        def resp = rb.get(searchUrl, queryParameters)

        def json = (JSONObject)resp.json
        def jsonResults = json.results

        jsonResults.collect { albumInfo ->
            createAlbum albumInfo
        }
    }

    @CompileDynamic
    protected Album createAlbum(json) {
        new Album(name: json.collectionName,
                  artistName: json.artistName,
                  url: json.collectionViewUrl)
    }
}
