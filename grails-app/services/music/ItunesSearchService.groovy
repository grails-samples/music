package music

import grails.plugin.cache.Cacheable
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

@CompileStatic
class ItunesSearchService {

    @Autowired
    ItunesClient itunesClient

//    @Cacheable('itunesSearchResults')
    List<Album> search(String searchTerm) {
        log.debug "Searching iTunes Store For [${searchTerm}]"

        SearchResult searchResult = itunesClient.search(searchTerm)
        searchResult.results
    }
}
