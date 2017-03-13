package xml;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.event.TreeModelListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * This program displays an XML document as a tree.
 *
 * @version 1.0 2015/12/13
 * @author zjh
 *
 */
public class DomTreeViewer {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new DOMTreeFrame();
				frame.setTitle("TreeViewer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

/**
 * This frame contains a tree that displays the content of an XML document.
 *
 * @author zjh
 *
 */
class DOMTreeFrame extends JFrame {
	// 设置静态常量
	// set static constants
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HIGHT = 400;

	//
	private DocumentBuilder documentBuilder;

	public DOMTreeFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HIGHT);
		JMenu fileMenu = new JMenu("file");

		JMenuItem openItem = new JMenuItem("open");
		// 增加动作监听器
		// add the ActionListener
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openFile();
			}
		});
		fileMenu.add(openItem);

		JMenuItem exitItem = new JMenuItem("exit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}

	/**
	 * open a file and load the document.
	 */
	private void openFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("dom"));

		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "XML files";
			}

			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
			}
		});
		// 将dom树结构显示到打开的对话框中
		int result = chooser.showOpenDialog(this);
		if (result != JFileChooser.APPROVE_OPTION) {
			return;
		}
		final File file = chooser.getSelectedFile();

		new SwingWorker<Document, Void>() {

			@Override
			protected Document doInBackground() throws Exception {
				if (documentBuilder == null) {
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					documentBuilder = factory.newDocumentBuilder();
				}
				return documentBuilder.parse(file);
			}

			protected void done() {
				// get()是SwingWorker类提供的方法
				try {
					Document doc = get();
					JTree tree = new JTree(new DOMTreeModel(doc));
					tree.setCellRenderer(new DOMTreeCellRenderer());

					// 设置内容窗体
					setContentPane(new JScrollPane(tree));
					validate();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(DOMTreeFrame.this, e);
				}
			}
		}.execute();
	}
}

// DOM树模型
class DOMTreeModel implements TreeModel {
	private Document doc;

	public DOMTreeModel(Document doc) {
		this.doc = doc;
	}

	@Override
	public void addTreeModelListener(TreeModelListener arg0) {

	}

	@Override
	public Object getChild(Object parent, int index) {
		Node node = (Node) parent;
		NodeList nodeList = node.getChildNodes();
		return nodeList.item(index);
	}

	@Override
	public int getChildCount(Object parent) {
		Node node = (Node) parent;
		NodeList nodeList = node.getChildNodes();
		return nodeList.getLength();
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		Node parentNode = (Node) parent;
		NodeList nodeList = parentNode.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (getChild(parentNode, i) == child)
				return i;
		}
		return -1;
	}

	@Override
	public Object getRoot() {
		return doc.getDocumentElement();
	}

	@Override
	// 是否已经是叶了（不会再有分岔）
	public boolean isLeaf(Object node) {
		return getChildCount(node) == 0;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {

	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {

	}

}

class DOMTreeCellRenderer extends DefaultTreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object obj, boolean selected, boolean expanded,
												  boolean leaf, int row, boolean hasFocus) {
		Node node = (Node) obj;
		if (node instanceof Element) {
			return elementPanel((Element) node);
		}

		super.getTreeCellRendererComponent(tree, obj, selected, expanded, leaf, row, hasFocus);
		if (node instanceof CharacterData) {
			setText(characterString((CharacterData) node));
		} else {
			setText(node.getClass() + ":" + node.toString());
		}
		return this;
	}

	public static JPanel elementPanel(Element e) {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Element:" + e.getTagName()));
		final NamedNodeMap map = e.getAttributes();
		panel.add(new JTable(new AbstractTableModel() {

			@Override
			public Object getValueAt(int m, int n) {
				return n == 0 ? map.item(m).getNodeName() : map.item(m).getNodeValue();
			}

			@Override
			public int getRowCount() {
				return map.getLength();
			}

			@Override
			public int getColumnCount() {
				return 2;
			}
		}));
		return panel;
	}

	public static String characterString(CharacterData node) {
		StringBuilder builder = new StringBuilder(node.getData());
		for (int i = 0; i < builder.length(); i++) {
			if (builder.charAt(i) == '\r') {
				builder.replace(i, i + 1, "\\r");
				i++;
			}
			if (builder.charAt(i) == '\n') {
				builder.replace(i, i + 1, "\\n");
				i++;
			}
			if (builder.charAt(i) == '\t') {
				builder.replace(i, i + 1, "\\t");
				i++;
			}
		}
		if (node instanceof CDATASection) {
			builder.insert(0, "CDATASection: ");
		} else if (node instanceof Text) {
			builder.insert(0, "Text: ");
		} else if (node instanceof Comment) {
			builder.insert(0, "Comment: ");
		}

		return builder.toString();
	}

}
