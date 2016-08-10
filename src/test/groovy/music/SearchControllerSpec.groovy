package music

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(SearchController)
class SearchControllerSpec extends Specification {

    void 'test with no searchTerm request parameter'() {
        setup:
        ItunesSearchService searchService = Mock()
        controller.itunesSearchService = searchService

        when:
        def model = controller.index()

        then:
        0 * searchService.search(_)
        model == null
    }

    void 'test with searchTerm request parameter'() {
        setup:
        ItunesSearchService searchService = Mock()
        searchService.search('Some Search Term') >> [new Album(), new Album()]
        controller.itunesSearchService = searchService

        when:
        params.searchTerm = 'Some Search Term'
        def model = controller.index()

        then:
        model.searchTerm == 'Some Search Term'
        model.searchResults.size() == 2
    }
}
