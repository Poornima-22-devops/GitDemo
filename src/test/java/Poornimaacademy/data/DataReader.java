package Poornimaacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
   here you can write a number

of utilities to make scan your JSON or, you know,

to retrieve the values based on your requirement.
 */
public class DataReader {
	
	/*public List<HashMap<String, String>> getJsonDataToHashMap() throws IOException
	{
 /*
  * 
In Java there is one method which will read file.i,e FileUtils

That means if you just pass JSON file,

it will scan the entire content of your JSON

and convert that into one string variable.
  */
		//read json to string
		//So basically in the new method as a second argument we have to give the encoding on how to convert it into string.So this is standard way of converting UTF 8.
		//String JsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir"+"//src//test//java//Poornimaacademy//data//Purchaseorder.json")),StandardCharsets.UTF_8);
		
		/*Some external utilities are there,

which can convert your JSON content to hash map. i,e new dependency called "Jackson data bind".

This is the one of the dependency which can help

you to convert the jsoncontent into hash map.*/
		//string to HashMap using JacksonDataBind \. we have to get it in mvn repo and stored on POM.xml
	
		//ObjectMapper mapper = new ObjectMapper();
		//we created object of this class called object mapper, right? So in this class there is
        //a method called read value which can read the string and convert that to hash map.
		//List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		//{map,map}
		//return data;*/
		/*
		 * we are asking to create hash maps based upon number

of indexes we have in that JSON and all hash maps put me in one list,

And give it back. So that list is written.

So now basically what this data stores?

This data is a list now with two arguments.

In the first argument you will have one hash map

and in another second argument you have another hash map.	
		
		 */
		
	
				
	
	
	}	

