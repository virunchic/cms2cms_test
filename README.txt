------------
How to Build
------------
Windows - Run the batch file followed by build 

ex.    gradlew build     

Linux   - Run the shell script followed by build

ex.    ./gradlew build   


This will pull down all the dependencies needed for the Selenium tests. 

----------
How to run
----------

	Windows - Download and install Firefox (https://download.mozilla.org/?product=firefox-stub&os=win&lang=en-US)
		- Download and install the Java jdk if you do not already have it (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
		- Create a new Enviroment Variable called JAVA_HOME. (Right click This PC -> properties -> Advanced System Settings -> Enviroment Variables) 
		- Set the JAVA_HOME variable to the folder where your JDK is installed. For instance my JAVA_HOME is set to (D:\Program Files\Java\jdk1.8.0_25)
		- Set the PATH variable to where the Firefox executable is (the folder itself not the actual executable)
		- Download Gecko Driver (https://github.com/mozilla/geckodriver/releases), save it inside current folder and put path to it into gradle\config.properties - path_to_gecko property
		- Restart Windows
		- cd to root of Gradle folder (cd \path\to\root)
		- Go to root of Gradle project and do "gradlew test"
		- Firefox window will pop up and run the test

	Linux   - Download and install Firefox (sudo apt-get install firefox)
		- If you do not have it already install the java-jdk ("sudo apt-get install default-jdk")
		- Download Gecko Driver (https://github.com/mozilla/geckodriver/releases), save it inside current folder and put path to it into gradle/config.properties - path_to_gecko property
		- cd to root of Gradle folder (cd /path/to/root)
		- In the root of the Gradle folder run "./gradlew test"
		- Firefox window will pop up and run the test
