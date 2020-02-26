import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
public class ItemClick extends JFrame {
	static int k;
	ItemClick(){
		Vector <String> itemlist = new Vector();
		MakeItemList test = new MakeItemList(itemlist);
		test.callList();
		
		Vector <String> category = new Vector();
		MakeCategory test3 = new MakeCategory(category);
		test3.callCategory();
		
		Vector <String> shoppinglist = new Vector();
		MakeShoppingList test1 = new MakeShoppingList(shoppinglist);
		test1.callShopping();//아이템 리스트 불러오기
		
		setTitle("Modify ItemList");
		JPanel modifyitem = new JPanel();
		setContentPane(modifyitem);
		modifyitem.setBackground(Color.orange);
		JLabel title = new JLabel("Modify ItemList");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Serif",Font.BOLD,40));
		JPanel tit = new JPanel();
		tit.setBackground(Color.orange);
		tit.add(title);
		modifyitem.add(tit,BorderLayout.NORTH);//item 수정창에 title 추가
		
		JPanel mitem = new JPanel();
		JList list = new JList(itemlist);
		DefaultListCellRenderer lay = (DefaultListCellRenderer) list.getCellRenderer();
		lay.setHorizontalAlignment(SwingConstants.CENTER);
		list.setFont(new Font ("폰트",Font.BOLD,23));
		JScrollPane lis = new JScrollPane(list);
		lis.setPreferredSize(new Dimension(400,500));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				k = list.locationToIndex(e.getPoint());
				
			}
		});
		
		
		
		JPanel buttons = new JPanel(new FlowLayout());
		JTextField inputscreen = new JTextField(20);
		inputscreen.setText("추가 혹은 수정할 아이템명 입력");
		inputscreen.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				inputscreen.setText("");
			}
		});
		JButton buttonadd = new JButton("ADD");
		buttonadd.setFont(new Font("Serif",Font.BOLD,20));
		buttonadd.setForeground(Color.white);
		buttonadd.setBackground(Color.orange);
		buttonadd.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				test.callList();
				if(!itemlist.contains(inputscreen.getText().toString())) {
					itemlist.add(inputscreen.getText().toString());
					category.add("미정");
				}
				test3.saveCategory();
				inputscreen.setText("추가 혹은 수정할 아이템명 입력");
				test.saveList();
				test.callList();
				list.updateUI();
				DefaultListCellRenderer lay = (DefaultListCellRenderer) list.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				mitem.revalidate();
				mitem.repaint();
			}
		});
		
		
		JPanel buttons1 = new JPanel();
		buttons.add(inputscreen);
		buttons.setBackground(Color.orange);
		
		JPanel c = new JPanel(new FlowLayout());
		c.setBackground(Color.white);

		JButton Modify = new JButton("MODIFY");
		Modify.setForeground(Color.white);
		Modify.setFont(new Font("Serif",Font.BOLD,20));
		Modify.setBackground(Color.orange);
		
		JButton buttonremove = new JButton("REMOVE");
		buttonremove.setFont(new Font("Serif",Font.BOLD,20));
		buttonremove.setForeground(Color.white);
		buttonremove.setBackground(Color.orange);
		buttonremove.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				test.callList();
				String m = itemlist.get(k);
				for(int i=0;i<shoppinglist.size();i++) {
					if(shoppinglist.get(i).equals(m)) {
						shoppinglist.remove(i);break;
					}
					
				}
				itemlist.remove(k);
				category.remove(k);
				test.saveList();
				test.callList();
				test1.saveShopping();
				list.updateUI();
				DefaultListCellRenderer lay = (DefaultListCellRenderer) list.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				mitem.revalidate();
				mitem.repaint();
			}
		});
		
		c.add(buttonadd);
		c.add(Modify);
		c.add(buttonremove);
		Modify.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				test.callList();
	            itemlist.set(k, inputscreen.getText().toString());
	            inputscreen.setText("추가 혹은 수정할 아이템명 입력");
	            test.saveList();
	            test.callList();
	            list.updateUI();
	            DefaultListCellRenderer lay = (DefaultListCellRenderer)list.getCellRenderer();
	            lay.setHorizontalAlignment(SwingConstants.CENTER);
	            mitem.revalidate();
	            mitem.repaint();
	         }
			
		});
    c.setBackground(Color.orange);
	setSize(600,100);
		buttons1.setLayout(new BorderLayout());
		buttons1.add(buttons,BorderLayout.NORTH);
		buttons1.add(c,BorderLayout.SOUTH);
		mitem.setBackground(Color.orange);
				
		mitem.add(lis,BorderLayout.CENTER);
		modifyitem.add(mitem,BorderLayout.CENTER);
		modifyitem.add(buttons1,BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(600,750);
		setResizable(false);
	}
	public Vector<String> getItem(){
		Vector<String> itemlist = new Vector();
		MakeItemList k = new MakeItemList(itemlist);
		k.callList();
		return itemlist;
	}


}
