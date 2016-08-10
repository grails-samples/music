package music

class SearchController {

    ItunesSearchService itunesSearchService

    def index(String searchTerm) {
        if(searchTerm) {
             List<Album> searchResults = itunesSearchService.search(searchTerm)

            [searchTerm: searchTerm, searchResults: searchResults]
        }
    }
}
