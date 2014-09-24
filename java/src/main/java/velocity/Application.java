package velocity;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Application {
	public static void main(String[] args) throws IOException {
		String data = args[0];

		String templateFile = args[1];

		JSONObject d = JSON.parseObject(data);

		try {
			VelocityContext context = new VelocityContext();

			for (String key : d.keySet()) {
				String value = d.getString(key);
				context.put(key , value);
			}

			Properties prop = new Properties();
			prop.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH,
					"/Volumes/os/");

			VelocityEngine engine = new VelocityEngine();
			engine.init(prop);

			Template template = engine.getTemplate(templateFile);

			StringWriter writer = new StringWriter();
			template.merge(context, writer);

			System.out.println(writer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
