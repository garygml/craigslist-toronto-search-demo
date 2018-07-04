# craigslist-toronto-search-demo

1) Extract the zip file to a location and navigate to its root folder.

2) Make sure you have maven installed, In a terminal or command prompt, do
```
mvn install
```
you should a target folder in the project root containing a .jar file. (The name should be craigslist-toronto-search-demo-0.0.1-SNAPSHOT.jar)

3) in the same project root folder, do
```
java -jar ./target/craigslist-toronto-search-demo-0.0.1-SNAPSHOT.jar
```
if the jar name is different for some reason please use the actual jar file name.
The java application will start shortly and will use port 8080 for the restful web service. Another way to run the application is to import the project to your IDE and run as a Spring Boot application.
Use an internet browser and navigate to
```
http://localhost:8080/search?query=apartment
```
You can change the query to any search string you need.
The API also provides pagination on the results by using a parameter skip, the url will look like:
```
http://localhost:8080/search?query=apartment&skip=1 
```
this will skip the first rows of results based on the number provided.
