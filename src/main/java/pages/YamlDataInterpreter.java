package pages;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;



public class YamlDataInterpreter {
	
	public static void main(String[] args) {
        YamlDataInterpreter intepreter = new YamlDataInterpreter();
        intepreter.interpretYaml();
    }

    public void interpretYaml() {
        InputStream stream = this.getClass().getClassLoader()
            .getResourceAsStream("C:\\test\\yamlfile.yml");
        System.out.println("this 1");

        Yaml yaml = new Yaml();
        Result res = yaml.loadAs(stream, Result.class);
        System.out.println("this 2");
        System.out.println(res.getPlayer().getRandie().getScore());
    }

}
