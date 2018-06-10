# SMSAPI

Steps to run the project 
1. Install Play 
ref: https://www.playframework.com/documentation/2.6.x/Installing

2. Download the play project from github
 
3. Get inside the project top directory (where build.sbt is there) and execute sbt run command. 

4. Get a token from GET API (optional paramter username)
http://localhost:9000/sms/getToken?username=arpit

5. After this you can hit the GET API's 
/inbound/sms/ 
/outbound/sms/ 
with parameters and passing the token in header of the get request with "tok" key.



