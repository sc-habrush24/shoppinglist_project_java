import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Vector;

public class LayoutMain extends JFrame{
	public static Vector <String>itemlist;
	public static Vector <String>shoppinglist;
	public static Vector <String>category;
	public static Vector <String>categoryname;
	
	public LayoutMain(){
		Scanner scanner = new Scanner(System.in);
		itemlist = new Vector();
		MakeItemList test = new MakeItemList(itemlist);
		test.callList();//아이템 리스트 불러오기
		shoppinglist = new Vector();
		MakeShoppingList test1 = new MakeShoppingList(shoppinglist);
		test1.callShopping();//쇼핑 리스트 불러오기
		category = new Vector();
		MakeCategory test2 = new MakeCategory(category);
		test2.callCategory();//카테고리 리스트 불러오기
		categoryname = new Vector();
		MakeCategoryName test3 = new MakeCategoryName(categoryname);
		test3.callList();//카테고리 이름 리스트 불러오기
		
		setTitle("ShoppingList Layout-2019/안예선,최솔");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container main = getContentPane();//실행하면 뜨는 첫 화면 main
		main.setBackground(Color.gray);//첫 화면 배경색 밝은 회색으로 지정
		main.setLocation(1500,1500);
		JPanel Title = new JPanel();
		JLabel title = new JLabel("2019 JAVA PROJECT");
		title.setFont(new Font("Serif",Font.BOLD,40));//Font이용해 글씨 설정하기
		title.setForeground(Color.black);
		Title.add(title);
		Title.setBackground(Color.orange);
		main.add(Title,BorderLayout.NORTH);//main에 타이틀 판넬 추가
		
		JPanel buttons = new JPanel(); //옆에 아이템, 쇼핑, 카케고리 버튼 만들기
		GridLayout grid = new GridLayout(5,1);
		buttons.setLayout(grid);
		grid.setVgap(90);
		buttons.setBackground(Color.gray);
		
		JButton buttonitem	= new JButton("Item"); // buttons에 넣을 아이템 버튼
		buttonitem.setFont(new Font("Serif",Font.BOLD,20));
		buttonitem.setForeground(Color.WHITE);
		buttonitem.setBackground(Color.gray);
		
		JButton buttonshopping = new JButton("Shopping"); // buttons에 넣을 쇼핑 버튼
		buttonshopping.setFont(new Font("Serif",Font.BOLD,20));
		buttonshopping.setForeground(Color.WHITE);
		buttonshopping.setBackground(Color.gray);
		
		JButton buttoncategory = new JButton("Category"); // buttons에 넣을 category 버튼
		buttoncategory.setFont(new Font("Serif",Font.BOLD,20));
		buttoncategory.setForeground(Color.WHITE);
		buttoncategory.setBackground(Color.gray);
		
		buttons.add(new JLabel(""));//buttons의 레이아웃
		buttons.add(buttonitem);
		buttons.add(buttonshopping);
		buttons.add(buttoncategory);
		buttons.add(new JLabel(""));
		main.add(buttons,BorderLayout.WEST);//main에 들어갈 버튼 세개 판넬 왼쪽에 넣음
		
		buttonitem.addActionListener(new ActionListener() {//buttonitem을 클릭시 ItemClick() 실행
			@Override
			public void actionPerformed(ActionEvent e) {
				new ItemClick();
			}
		});
		buttonshopping.addActionListener(new ActionListener() {//buttonshopping클릭 시 ShoppingClick() 실행
			@Override
			public void actionPerformed(ActionEvent e) {
				new ShoppingClick();
			}
		});
		buttoncategory.addActionListener(new ActionListener() { //buttoncategory클릭 시 CategoryClick() 실행
			@Override
			public void actionPerformed(ActionEvent e) {
				new CategoryClick();
			}
		});
		
		JList ta = new JList(itemlist); //JList ta에 itemlist를 넣는다.
		DefaultListCellRenderer lay = (DefaultListCellRenderer)ta.getCellRenderer();
		lay.setHorizontalAlignment(SwingConstants.CENTER);
		JPanel itemList = new JPanel();
		ta.setFont(new Font ("폰트",Font.BOLD,23));
		
		JScrollPane list1 = new JScrollPane(ta);
		list1.setPreferredSize(new Dimension(400,500));
		JPanel list = new JPanel(new FlowLayout());
		list.add(list1);
		
		JLabel text = new JLabel("Item List"); 
		text.setFont(new Font("Serif",Font.BOLD,30));
		text.setForeground(Color.white);
		text.setBackground(Color.gray);
		
		JLabel text1 = new JLabel("Shopping List");
		text1.setFont(new Font("Serif",Font.BOLD,30));
		text1.setForeground(Color.white);
		text1.setBackground(Color.gray);
		
		JPanel text2 = new JPanel(new FlowLayout());
		text2.setBackground(Color.gray);
		text2.add(text);text2.add(new JLabel("                            "
				+ "                                                          "));text2.add(text1);
		itemList.add(text2,BorderLayout.NORTH);
		
		JList ta1 = new JList(shoppinglist); //JList ta1에 shoppinglist를 넣는다.
		DefaultListCellRenderer lay1 = (DefaultListCellRenderer)ta1.getCellRenderer();
		lay1.setHorizontalAlignment(SwingConstants.CENTER);
		ta1.setFont(new Font ("폰트",Font.BOLD,23));
		JScrollPane shoppings = new JScrollPane(ta1);
		shoppings.setPreferredSize(new Dimension(400,500));
		list.add(shoppings);
		
		itemList.add(list,BorderLayout.CENTER);
		itemList.setBackground(Color.gray);
	
		JButton refresh = new JButton("REFRESH"); //새로고침
		refresh.setFont(new Font("Serif",Font.BOLD,20));
		refresh.setBackground(Color.gray);
		refresh.setForeground(Color.WHITE);
		refresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				list.removeAll();
				ItemClick m= new ItemClick();
				ShoppingClick n = new ShoppingClick();
				Vector <String> itemlist = m.getItem();
				Vector <String> shoppinglist = n.getItem();
				m.dispose();
				n.dispose();
				JList ta1 = new JList(shoppinglist);
				JList ta = new JList(itemlist);
				DefaultListCellRenderer lay = (DefaultListCellRenderer) ta.getCellRenderer();
				lay.setHorizontalAlignment(SwingConstants.CENTER);
				DefaultListCellRenderer lay1 = (DefaultListCellRenderer) ta1.getCellRenderer();
				lay1.setHorizontalAlignment(SwingConstants.CENTER);
				ta.setFont(new Font("폰트",Font.BOLD,23));
				ta1.setFont(new Font("폰트",Font.BOLD,23));
				JScrollPane list1 = new JScrollPane(ta);
				JScrollPane list2 = new JScrollPane(ta1);
				list1.setPreferredSize(new Dimension(400,500));
				list2.setPreferredSize(new Dimension(400,500));
				list.add(list1);
				list.add(list2);
				list.revalidate();
				list.repaint();	
				}
		});
		
		JButton reset = new JButton("RESET");//모든 내용 삭제하기
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				itemlist.clear();
				category.clear();
				shoppinglist.clear();
				
				list.updateUI();
				list.revalidate();
				list.repaint();
				test.saveList();
				test1.saveShopping();
				test2.saveCategory();
				
			}
		});
		reset.setForeground(Color.white);
		reset.setBackground(Color.gray);
		reset.setFont(new Font("Serif",Font.BOLD,20));
		
		JButton print = new JButton("PRINT"); //종이에 인쇄하기
		print.setForeground(Color.white);
		print.setBackground(Color.gray);
		print.setFont(new Font("Serif",Font.BOLD,20));
		print.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ActionPrint();
			}
		});
		itemList.add(reset);
		itemList.add(refresh);
		itemList.add(print);
		main.add(itemList,BorderLayout.CENTER);//reset, refresh, print 버튼 추가
		
		JPanel empty = new JPanel(); //가장 아래 공백
		empty.setBackground(Color.gray);
		main.add(empty,BorderLayout.EAST);
		
		setSize(1000,750);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String []args) {
		new LayoutMain();
	}
}