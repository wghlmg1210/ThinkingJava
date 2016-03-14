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
		// 1.读取XML文件,获得document对象
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
		// 2.解析XML形式的文本,得到document对象.
		String text = "<csdn></csdn>";
		try {
			Document document = DocumentHelper.parseText(text);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void test3() {
		// 3.主动创建document对象.
		Document document = DocumentHelper.createDocument(); // 创建根节点
		Element root = document.addElement("csdn");
	}
}
