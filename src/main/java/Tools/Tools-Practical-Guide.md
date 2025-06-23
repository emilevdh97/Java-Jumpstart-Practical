# Tools Practical Guide
The intent of the tools practical is just to ensure that you have everything required in order
to complete the rest of the practicals
## Step 1 : Is Java installed?
You can check if java is installed by running the below command in your terminal. *you can use the alt+F12 shortcut to open
the terminal*
<pre>Java --version </pre>
## Step 2: Are you able to use maven?
Once again, open up the terminal and use the below command to check the maven version
<pre>mvn -v</pre>
If you do not have maven installed, then there is no need for concern. This project is using a maven wrapper. 
In order to use the maven wrapper you have to use the below command
<pre>./mvnw -v</pre>
## Step 3: Perform a maven clean install
Run the below maven command to ensure that your project builds and compiles as expected. 
<pre>mvn clean install</pre>
If you are using the maven wrapper, the command would be:
<pre>./mvnw clean install</pre>
## Step 4: Have some fun
Play around with IntelliJ shortcuts and get familiar with your development environment. 