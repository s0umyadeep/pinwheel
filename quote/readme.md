# Quote of The Day

The front end was developed in angularjs, and server was in java spring boot. The spring boot uses an internal tomcat server, which is where the application will be deployed to. The layers/architecture is pretty much standard java webapp. The frontend written in angular calls java server to get the json object, transforms and presents it in the view. 

## Download
* [Download quote 0.0.1] (https://github.com/s0umyadeep/pinwheel/blob/master/quote/binary/quote-0.0.1.jar?raw=true)


## Installation

Because it is a simple spring boot application utilizing existing tomcat internal server, the application has been packaged in jar (rather than war). The steps to start the application are -

1. Check if you have java 8 installed. The easiest to check is run ```java -version``` from the command prompt/terminal. If you do not have java 8, please install it from oracle site before you proceed.

2. Download the application jar file (quote-0.0.1.jar) or save it from the email attachment.

3. After you are done installing and verifying (maybe by executing ```java -version```) java 8,  please execute the following command to start up the server on port 8080 -

```java -jar quote-0.0.1.jar```. 

If you do not want to run it on port 8080, execute the below command with the port number you want to run on.
 
```java -jar -Dserver.port=<portnumber> quote-0.0.1.jar```
 
For example,

```java -jar -Dserver.port=9000 quote-0.0.1.jar``` 

You can launch the application by hitting http://localhost:<port> (e.g. http://localhost:8080 ) on your browser. That is it. To stop the server, press control+c.
