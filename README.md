# Grails 3 Music Search Sample App

This is a simple Grails 3 application which provides a browser interface for searching the iTunes music store.

The application may be run locally using the [Gradle](http://gradle.org/) `bootRun` task:

    ./gradlew bootRun
    
A [Docker](http://docker.com) image has been published which includes a version of this application.

    docker run -d -p 8086:8080 jeffscottbrown/music-search:0.1
    
Note that the argument after `-p` is a pair of port numbers.  The second number is the port inside the 
container and that needs to be 8080.  The first number is the port in the host environment that you would 
like mapped to the second port.  For example, if you use `-p 8086:8080` then port 8086 in your host
environment will be mapped to port 8080 in the container so http://localhost:8086/ could be used to
access the app in the host environment.
