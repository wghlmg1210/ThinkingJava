package mysellf.dom4j;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	public static void main(String[] args) {
		SAXReader read = new SAXReader();
		try {
			File file = new File("src/mysellf/dom4j/NewFile.xml");
			Document doc = read.read(file);
			Element eleRoot = doc.getRootElement();

			Element eleRes = eleRoot.element("Result");
			getAttrs(eleRes);
			Iterator<Element> eles = eleRes.element("ResultData")
					.element("Table1").elementIterator("Item");
			while (eles.hasNext()) {
				getAttrs(eles.next());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private static void getAttrs(Element eleRes) {
		System.out.print(eleRes.getName());
		Iterator<Attribute> attrs = eleRes.attributeIterator();
		while (attrs.hasNext()) {
			Attribute attr = attrs.next();
			System.out.print("	" + attr.getName() + ":" + attr.getValue());
		}
		System.out.println();
		if ("Item".equals(eleRes.getName())) {
			getChildren(eleRes);
		}
	}

	private static void getChildren(Element eleRes) {
		Iterator<Element> eles = eleRes.elementIterator();
		while (eles.hasNext()) {
			Element ele = eles.next();
			System.out.println("	" + ele.getName() + " : " + ele.getText());
		}
	}

}
