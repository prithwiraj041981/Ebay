package pages;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class yamlclass {
	String line;
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public static void main(String[] args) throws IOException {
		InputStream inputStream = new FileInputStream(new File("C:\\test\\yamlfile.yaml"));

		Yaml yaml = new Yaml();
		Map<String, Object> data = yaml.load(inputStream);
		System.out.println(data);
		String firstKey = data.keySet().iterator().next();
		System.out.println("First key: " + firstKey);
		Object firstValue =data.values().iterator().next();
		System.out.println("First value: " + firstValue);
		Object s = data.get("contactDetails");
		System.out.println("fourth key: " + s);
		//String name =data.get("contactDetails").toString().substring(7, 13);
		//System.out.println("fourth key100: " + name);
		final List<Map<String, Object>> module_name = (List<Map<String, Object>>) data.get("contactDetails");
	    System.out.println(module_name);
	    System.out.println(module_name.get(0).get("type"));
	    System.out.println(module_name.get(1).get("number"));
	    // The yaml fil content is below
		/*
		 * firstName: "John" lastName: "Doe" age: 31 contactDetails: - type: "mobile"
		 * number: 123456789 - type: "landline" number: 456786868 homeAddress: line:
		 * "Xyz, DEF Street" city: "City Y" state: "State Y" zip: 345657
		 */
		
		
	        

		

		
		
	}

}
