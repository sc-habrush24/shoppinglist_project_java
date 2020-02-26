import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Vector;

public class CategoryClick extends JFrame{
	static int choose;
	static int k;
	static int l;
	static int n;
	static int i;
	static int r;
	CategoryClick(){
		Vector <String> itemlist = new Vector();
		MakeItemList test = new MakeItemList(itemlist);
		test.callList();
		
		Vector <String> category = new Vector();
		MakeCategory test3 = new MakeCategory(category);
		test3.callCategory();
		
		Vector <String> categoryname = new Vector();
		MakeCategoryName test4 = new MakeCategoryName(categoryname);
		test4.callList();
		
		JPanel main = new JPanel();
		setContentPane(main);
		main.setPreferredSize(new Dimension(700,700));
		main.setBackground(Color.orange);
		main.setLayout(new BorderLayout());
		
		JPanel title = new JPanel();
		JLabel Title = new JLabel("MODIFY CATEGORY");
		Title.setBackground(Color.orange);
		Title.setFont(new Font("Serif",Font.BOLD,40));
		Title.setForeground(Color.black);
		title.add(Title);
		
		JPanel list1 = new JPanel(new BorderLayout());//가장 왼쪽 판낼
		JPanel list1_1 = new JPanel();//카데고리 이름 리스트
		JList namelist = new JList(categoryname);
		JScrollPane choosing = new JScrollPane(namelist);
		namelist.setBackground(Color.lightGray);
		namelist.setForeground(Color.white);
		DefaultListCellRenderer lay = (DefaultListCellRenderer) namelist.getCellRenderer();
		lay.setHorizontalAlignment(SwingConstants.CENTER);
		choosing.setPreferredSize(new Dimension(400,500));
		namelist.setFont(new Font ("폰트",Font.BOLD,23));
		list1_1.add(choosing);
		
		JTextField addcategory = new JTextField(16);
		addcategory.setFont(new Font("폰트",Font.BOLD,13));
		addcategory.setText("추가할 카테고리명을 입력하세요");
		addcategory.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				addcategory.setText("");
			}
		});
		
		JPanel list1_2 = new JPanel();//왼쪽 아래 입력창, 버튼 판넬
		JPanel b = new JPanel();
		b.setBackground(Color.orange);
		JPanel c = new JPanel();
		c.setBackground(Color.orange);
		JButton remove = new JButton("REMOVE");
		remove.setBackground(Color.orange);
		remove.setFont(new Font("Serif",Font.BOLD,15));
		list1_2.add(addcategory);
		list1_2.add(remove);
		JButton addbutton = new JButton("ADD");
		list1_2.add(addbutton);
		list1_2.setPreferredSize(new Dimension(400,100));
		addbutton.setBackground(Color.orange);
		addbutton.setFont(new Font("Serif",Font.BOLD,15));
		
		
		JLabel cname = new JLabel("Current Category");
		cname.setForeground(Color.black);
		cname.setFont(new Font("Serif",Font.BOLD,30));
		cname.setBackground(Color.orange);
		list1.add(cname,BorderLayout.NORTH);
		list1.add(list1_1,BorderLayout.CENTER);
		list1.add(list1_2,BorderLayout.SOUTH);
		Vector <String> items = new Vector();
		list1.setBackground(Color.orange);
		list1_1.setBackground(Color.orange);
		list1_2.setBackground(Color.orange);
		
		
		JPanel list2 = new JPanel(new BorderLayout());//가운데 판넬
		list2.setBackground(Color.orange);
		
		JLabel citem = new JLabel("Chosen Category Item");
		citem.setForeground(Color.BLACK);
		citem.setFont(new Font("Serif",Font.BOLD,30));
		citem.setBackground(Color.orange);
		list2.add(citem,BorderLayout.NORTH);
		
		JList getItem = new JList(items);//가운데 리스트
		JScrollPane list2_1 = new JScrollPane(getItem);
		list2_1.setPreferredSize(new Dimension(400,500));
		JPanel a = new JPanel();
		a.setPreferredSize(new Dimension (400,100));
		a.setBackground(Color.orange);
		list2.add(a,BorderLayout.SOUTH);
		DefaultListCellRenderer lay1 = (DefaultListCellRenderer) getItem.getCellRenderer();
		lay1.setHorizontalAlignment(SwingConstants.CENTER);
		getItem.setFont(new Font("폰트",Font.BOLD,23));
		list2.add(list2_1,BorderLayout.CENTER);
		
		JPanel list3 = new JPanel(new BorderLayout());//가장 오른쪽 판넬
		list3.setBackground(Color.orange);
		JLabel mname = new JLabel("Change Category");
		mname.setForeground(Color.black);
		mname.setFont(new Font("Serif",Font.BOLD,30));
		mname.setBackground(Color.orange);
		list3.add(mname,BorderLayout.NORTH);
		
		JList list3_ = new JList(categoryname);
		DefaultListCellRenderer lay2 = (DefaultListCellRenderer) list3_.getCellRenderer();
		lay2.setHorizontalAlignment(SwingConstants.CENTER);
		list3_.setFont(new Font("폰트",Font.BOLD,23));
		JScrollPane list3_1 = new JScrollPane(list3_);
		list3.add(list3_1,BorderLayout.CENTER);
		JPanel y = new JPanel(new BorderLayout());
		y.setBackground(Color.orange);
		y.setPreferredSize(new Dimension(400,100));
		JButton modify = new JButton("CHANGE CATEGORY");
		modify.setBackground(Color.orange);
		modify.setFont(new Font("Serif",Font.BOLD,15));
		modify.setPreferredSize(new Dimension(150,50));
		y.add(modify,BorderLayout.CENTER);
		list3.add(y,BorderLayout.SOUTH);
		
		namelist.addMouseListener(new MouseAdapter() {//왼쪽 리스트 클릭 시 실행
			public void mouseClicked(MouseEvent e) {
				test3.callCategory();
				test.callList();
				k = namelist.locationToIndex(e.getPoint());
				items.removeAllElements();
				main.add(list2,BorderLayout.CENTER);
				for(i=0 ;i<itemlist.size();i++) {
					if(category.get(i).equals(categoryname.get(k))) {
						items.add(itemlist.get(i));
					}
				}
				test3.saveCategory();
				test4.saveList();
				namelist.updateUI();
				list3_.updateUI();
				getItem.updateUI();
				DefaultListCellRenderer lay = (DefaultListCellRenderer) namelist.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				DefaultListCellRenderer lay1 = (DefaultListCellRenderer) getItem.getCellRenderer();
				lay1.setHorizontalAlignment(SwingConstants.CENTER);
				DefaultListCellRenderer lay2 = (DefaultListCellRenderer) list3_.getCellRenderer();
				lay2.setHorizontalAlignment(SwingConstants.CENTER);
				list1.revalidate();list2.revalidate();list3.revalidate();
				list2.repaint();list1.repaint();list3.repaint();
				
			}
		});
		
		remove.addMouseListener(new MouseAdapter() {//선택한 카테고리를 제거하고 그 안의 항목들을 다 미정으로 옮김
			public void mouseClicked(MouseEvent e) {
				test3.callCategory();
				test4.callList();
				for(int i=0;i<category.size();i++) {
					System.out.println(category.get(i));
					if(category.get(i).equals(categoryname.get(k))) {
						category.set(i,"미정");
					}
				}
				categoryname.remove(k);
				test3.saveCategory();
				test4.saveList();
				namelist.updateUI();
				list3_.updateUI();
				list3.validate();list3.repaint();
				DefaultListCellRenderer lay = (DefaultListCellRenderer) namelist.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				DefaultListCellRenderer lay1 = (DefaultListCellRenderer) getItem.getCellRenderer();
				lay1.setHorizontalAlignment(SwingConstants.CENTER);
				DefaultListCellRenderer lay2 = (DefaultListCellRenderer) list3_.getCellRenderer();
				lay2.setHorizontalAlignment(SwingConstants.CENTER);
				list1_1.validate();
				list1_1.repaint();
			}
			
		});
		getItem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				l = getItem.locationToIndex(e.getPoint());
			}
		});
		list3_.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				n=list3_.locationToIndex(e.getPoint());
			}
		});
		modify.addMouseListener(new MouseAdapter() {//선택한 아이템의 카테고리 수정 후 저장
			public void mouseClicked(MouseEvent e) {
				for(i=0;i<itemlist.size();i++) {
					if(itemlist.get(i).equals(items.get(l)))
						break;
				}
				category.set(i,categoryname.get(n));
				test3.saveCategory();
				test4.saveList();
				list3_.updateUI();
				getItem.updateUI();
				namelist.updateUI();
				DefaultListCellRenderer lay = (DefaultListCellRenderer) namelist.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				DefaultListCellRenderer lay1 = (DefaultListCellRenderer) getItem.getCellRenderer();
				lay1.setHorizontalAlignment(SwingConstants.CENTER);
				DefaultListCellRenderer lay2 = (DefaultListCellRenderer) list3_.getCellRenderer();
				lay2.setHorizontalAlignment(SwingConstants.CENTER);
				list1.revalidate();list2.revalidate();list3.revalidate();
				list1.repaint();list2.repaint();list3.repaint();
				
			}
		});
		
		JButton exit = new JButton ("EXIT");
		exit.setBackground(Color.orange);
		exit.setFont(new Font ("Serif",Font.BOLD,20));
		main.add(exit,BorderLayout.SOUTH);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				test3.saveCategory();
				test4.saveList();
				dispose();
			}
			
		});
		
		addbutton.addMouseListener(new MouseAdapter() {//카테고리 이름 추가하기
			public void mouseClicked(MouseEvent e) {
				if(!categoryname.contains(addcategory.getText().toString())) {
					categoryname.add(addcategory.getText().toString());
					test4.saveList();
				}
				test4.callList();
				test3.saveCategory();
				test4.saveList();
				namelist.updateUI();
				list3_.updateUI();
				list3.validate();list3.repaint();
				DefaultListCellRenderer lay = (DefaultListCellRenderer) namelist.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				DefaultListCellRenderer lay2 = (DefaultListCellRenderer) list3_.getCellRenderer();
				lay2.setHorizontalAlignment(SwingConstants.CENTER);
				list1_1.validate();
				list1_1.repaint();
				addcategory.setText("추가할 카테고리명을 입력하세요");
			}
		});
		
		title.setBackground(Color.orange);
		main.add(title,BorderLayout.NORTH);
		main.add(list1,BorderLayout.WEST);
		main.add(list3,BorderLayout.EAST);
		setSize(1300,750);
		setVisible(true);
		setResizable(false);
	}
}
