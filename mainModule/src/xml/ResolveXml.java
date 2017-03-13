package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * This program shows how to parse a document to get it's content.
 *
 * @version 1.0 2015-12-13
 * @author zjh
 *
 */
public class ResolveXml {
	public static void main(String args[]) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			//File file = new File("c:\\test.xml");
			//如果这样只指定待解析的文件的文件名，那么test.xml文件就必须放在工程的根目录下，与src平级
			File file = new File("test.xml");
			Document doc = builder.parse(file);
			// 获取文档的根元素
			Element root = doc.getDocumentElement();
			// 得到根元素的子结点的集合
			NodeList childNodeList = root.getChildNodes();
			// 一种遍历子节点集合的方法
			for (int i = 0; i < childNodeList.getLength(); i++) {
				Node childNode = childNodeList.item(i);
				// 空白字符也被解析器当成了节点！需要对其进行处理
				// 判断childNode是元素节点还是空白节点
				if (childNode instanceof Element) {
					Element childElement = (Element) childNode;
					System.out.print("this is the number " + (i + 1) + " element:");
					System.out.println(childElement);
					Text textNode = (Text) childElement.getFirstChild();
					// 调用trim方法将文本数据前后的空白字符删掉
					String text = textNode.getData().trim();
					if (childElement.getTagName().equals("name")) {
						System.out.println("The content of element 'name' is:" + text);
					} else if (childElement.getTagName().equals("size")) {
						System.out.println("The content of element 'size' is:" + text);
					}
				}
			}
			System.out.print("\n\n");

			// 另一种遍历子节点集合的方法
			for (Node childNode = root.getFirstChild(); childNode != null; childNode = childNode.getNextSibling()) {
				System.out.println("<----------");
				System.out.println("this is one node");
				// 判断childNode是元素节点还是空白节点
				if (childNode instanceof Element) {
					Element childElement = (Element) childNode;
					Text textNode = (Text) childElement.getFirstChild();
					String text = textNode.getData().trim();
					if (childElement.getTagName().equals("name")) {
						System.out.println("THE CONTENT OF ELEMENT 'NAME' IS:" + text);
					} else if (childElement.getTagName().equals("size")) {
						System.out.println("THE CONTENT OF ELEMENT 'SIZE' IS:" + text);
					}
					// 枚举元素节点的属性
					NamedNodeMap attributesNodeMap = childElement.getAttributes();
					System.out.println("the count for the element's attributes is:" + attributesNodeMap.getLength());
					for (int i = 0; i < attributesNodeMap.getLength(); i++) {
						Node attributesNode = attributesNodeMap.item(i);
						String name = attributesNode.getNodeName();
						String value = attributesNode.getNodeValue();
						System.out.println("the name-value couple is:" + name + "     " + value);
					}
				}
				System.out.println("---------->");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
