package protocol;

import java.io.StringWriter;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Style;

public abstract class AbstractHandler {

	abstract public String handle(String httpBody);

	@SuppressWarnings("unchecked")
	protected Object parseXML(String xml, Class myClass) {

		Serializer serializer = new Persister();

		try {

			System.out.println("Xml: " + xml);
			System.out.println("Class: " + myClass.getName());
			Object object = serializer.read(myClass, xml);

			return object;

		} catch (Exception ex) {

			System.out.println("serializer.read returns null");
			return null; // TODO

		}

	}

	protected String buildXML(Object object) {

		Style style = new HyphenStyle();
		Format format = new Format(style);

		Serializer serializer = new Persister(format);

		StringWriter writer = new StringWriter();

		try {
			serializer.write(object, writer);
			return writer.getBuffer().toString();

		} catch (Exception ex) {
			return null; // TODO handle Exception
		}

	}

}
