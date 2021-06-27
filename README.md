

# **welcome to the Flight-Remote-Joystick Android App!**

VERSION:
1.0.0

## *Description:*
In this app you will be able to connect to a flight simulator and fly a plane remotely.
you can connect to the filght simulator Flight-Gear by applying the IP address and PORT of the Flight-Gear server. 
If the data written wasn't correct you will see an error message on the screen and be able to try to reconnect. Also, you must
write both the PORT and IP address in order to connect, or else a different error message will be seen on the screen.
after successful connection, you can use the 2 sliders to change the values of the throttle and rudder of the plane.
Also, you can use the joystick component and change the values of the elevator and aileron. All the changed values will be
sent to the Flight-Gear simulator.
have fun and try to fly and land the plane safely :)





## *Demos:*
A link to the video of a demonstration:
[demo](http://a.com)

A link to the UML of the project:
[UML](https://github.com/liorlevi2299/FlightRemoteJoystick/blob/b0301d40a1cfb728cfc64a4a21d3df0fd35ea88d/UML-Flight-Remote-Joystick.jpg)



## *Technologies we used:*
Kotlin.

Flight-Gear - usage of filght simulator.

Main code was written in Kotlin, and XML.


## *Installation:*
Required:
1. Download Flight-Gear flight simulator from https://www.flightgear.org/  
2. Go to Flight-Gear settings, and insert the following line in additional settings:
 	```
	--telnet=socket,in,10,127.0.0.1,6400,tcp
	```
   You can also use a different available port (write it instead of 6400 above).
3. Click "fly" and wait until it's done loading.
4. Use one of the 2 options:
    1. Recommended: use the APK file and launch the app on your phone. file name: FlightRemoteJoystick.apk (in the main folder). 
    Remember to write the IP address of your network and the port you wrote in step 2.
    2. Download Android-Studio and download the folder given above and use the phone emulator.

Note:
When using the APK and running the application on your phone - if the phone is in hebrew the view might be reversed. In order
for it to work well, change in the settings the phone to english.


## *Contributors:*
Hila Levi, Lior Levi


