<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>
<div class="search-results">
    <g:form action="index" name="search">
        <div class="form-group">
            <div class="input-group">
                <g:textField name="searchTerm" class="form-control" placeholder="Artist Name"/>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Search iTunes</button>
    </g:form>
    <g:if test="${searchResults}">
        <H2>Search Results For ${searchTerm}</H2>

        <table class="table table-striped">
            <tr>
                <td>Artist</td>
                <td>Album</td>
            </tr>
            <g:each in="${searchResults}" var="album">
                <tr>
                    <td>${album.artistName}</td>
                    <td><g:link target="_blank" url="${album.collectionViewUrl}">${album.collectionName}</g:link> </td>
                </tr>
            </g:each>
        </table>
    </g:if>
</div>
</body>
</html>