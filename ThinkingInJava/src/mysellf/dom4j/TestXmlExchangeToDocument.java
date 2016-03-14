package mysellf.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class TestXmlExchangeToDocument {

	public Document test() {
		Document doucument = DocumentHelper.createDocument();
		Element root = doucument.addElement("root");
		Element author = root.addElement("author")
				.addAttribute("name", "James").addAttribute("location", "UK")
				.addAttribute("langue", "English").addText("James StraChan");
		Element author2 = root.addElement("author2")
				.addAttribute("name", "Jacken").addAttribute("location", "CN")
				.addAttribute("langue", "Chinese").addText("Jacken KaijianLi");
		return doucument;
	}

	public void filePrint() {
		try {
			FileWriter fw = new FileWriter("foo1.xml");
			// System.out.println(test().toString());
			Document d = test();
			Iterator<Attribute> as = d.getRootElement().element("author")
					.attributeIterator();
			while (as.hasNext()) {
				System.out.println(as.next().getValue());
			}
			XMLWriter output = new XMLWriter(new FileWriter("foo1.xml"));
			output.write(d);
			System.out.println("Yes,file is excite");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] agrs) {
		TestXmlExchangeToDocument txetd = new TestXmlExchangeToDocument();
		txetd.filePrint();
	}

}