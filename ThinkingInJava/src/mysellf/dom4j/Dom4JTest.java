package mysellf.dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4JTest {

	public void test1() {
		// 1.��ȡXML�ļ�,���document����
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File("csdn.xml"));
			List<Element> eles = document.getRootElement().elements();
			for(Element obj: eles) {
				System.out.println(obj.elementIterator());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void test2() {
		// 2.����XML��ʽ���ı�,�õ�document����.
		String text = "<csdn></csdn>";
		try {
			Document document = DocumentHelper.parseText(text);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void test3() {
		// 3.��������document����.
		Document document = DocumentHelper.createDocument(); // �������ڵ�
		Element root = document.addElement("csdn");
	}
}
