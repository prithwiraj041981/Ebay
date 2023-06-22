package pages;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;




public class write_to_yaml {
	public static String contact='\n'+"contact Details:" +'\n'+"- type:"+ "mobile"+'\n'+"number: 123456789";

	public static void main(String[] args) throws IOException {
		DumperOptions options = new DumperOptions();
		options.setIndent(2);
		options.setPrettyFlow(true);
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("id", 19);
		dataMap.put("name", "John");
		dataMap.put("address", contact );
		dataMap.put("department", "Medical");
		
		// TODO Auto-generated method stub
		
		PrintWriter writer = new PrintWriter(new File("C:\\test\\yamlfile.yaml"));
		Yaml yaml = new Yaml();
		yaml.dump(dataMap, writer);
	

	}

}
