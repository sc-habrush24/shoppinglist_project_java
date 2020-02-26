import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
public class ShoppingClick extends JFrame{
	static int index;
	static Vector shoppinglist;
	ShoppingClick(){
		Vector <String> itemlist = new Vector();
		MakeItemList test = new MakeItemList(itemlist);
		test.callList();
		
		
		Vector <String> shoppinglist = new Vector();
		MakeShoppingList test1 = new MakeShoppingList(shoppinglist);
		test1.callShopping();
		JPanel main = new JPanel();
		setContentPane(main);	
		JPanel Title = new JPanel();
		JLabel title = new JLabel("MAKE SHOPPING LIST");
		title.setForeground(Color.black);
		title.setFont(new Font("Serif",Font.BOLD,40));
		Title.add(title,BorderLayout.NORTH);
		Title.setBackground(Color.orange);
		main.setBackground(Color.orange);
		

		JLabel text = new JLabel("				Item List");
		text.setFont(new Font("Serif",Font.BOLD,30));
		text.setForeground(Color.black);
		text.setBackground(Color.gray);
		JLabel text1 = new JLabel("				Shopping List");
		text1.setFont(new Font("Serif",Font.BOLD,30));
		text1.setForeground(Color.black);
		text1.setBackground(Color.gray);
		
		JPanel itemlists = new JPanel(new FlowLayout());
		
		JList item = new JList(itemlist);
		JList shopping = new JList(shoppinglist);
		DefaultListCellRenderer lay = (DefaultListCellRenderer)	item.getCellRenderer();
		lay.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultListCellRenderer lay1 = (DefaultListCellRenderer) shopping.getCellRenderer();
		lay1.setHorizontalAlignment(SwingConstants.CENTER);
		item.setFont(new Font ("폰트",Font.BOLD,23));
		JScrollPane items = new JScrollPane(item);
		items.setPreferredSize(new Dimension(400,500));
		shopping.setFont(new Font ("폰트",Font.BOLD,23));
		JScrollPane shoppings = new JScrollPane(shopping);
		shoppings.setPreferredSize(new Dimension(400,500));
		item.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		item.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				index = item.locationToIndex(e.getPoint());
				new AddShopping(index);
				test1.callShopping();
				shopping.updateUI();
				DefaultListCellRenderer lay = (DefaultListCellRenderer) shopping.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				shopping.revalidate();
				shopping.repaint();
			}
		});
		shopping.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shopping.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				index = shopping.locationToIndex(e.getPoint());
				new RemoveShopping(index);
				test1.callShopping();
				shopping.updateUI();
				DefaultListCellRenderer lay = (DefaultListCellRenderer) shopping.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				shopping.revalidate();
				shopping.repaint();
			}
		});
		itemlists.setLayout(new BorderLayout());
		itemlists.add(text,BorderLayout.NORTH);itemlists.add(items,BorderLayout.CENTER);
		JPanel shoppinglists = new JPanel();
		shoppinglists.setLayout(new BorderLayout());
		shoppinglists.add(text1,BorderLayout.NORTH);shoppinglists.add(shoppings,BorderLayout.CENTER);
		main.setLayout(new BorderLayout());
		main.add(Title,BorderLayout.NORTH);
		JPanel main1 = new JPanel();
		main1.setBackground(Color.orange);
		itemlists.setBackground(Color.orange);shoppinglists.setBackground(Color.orange);
		main1.add(itemlists);main1.add(shoppinglists);
		main.add(main1,BorderLayout.CENTER);
		
		
		
		setResizable(false);
		setVisible(true);
		setSize(1000,700);
	}
	public Vector<String> getItem(){
		Vector <String> shoppinglist = new Vector();
		MakeShoppingList m = new MakeShoppingList(shoppinglist);
		m.callShopping();
		return shoppinglist;
	}
}
