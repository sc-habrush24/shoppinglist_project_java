import javax.swing.*;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
public class AddShopping extends JFrame{
	AddShopping(){}
	AddShopping(int k){
		Vector <String> itemlist = new Vector();
		MakeItemList test = new MakeItemList(itemlist);
		test.callList();
		Vector <String> shoppinglist = new Vector();
		MakeShoppingList test1 = new MakeShoppingList(shoppinglist);
		test1.callShopping();
		
		JPanel addshopping = new JPanel();
		setContentPane(addshopping);
		JLabel ask = new JLabel("선택 아이템명 :"+itemlist.get(k));
		ask.setForeground(Color.white);
		ask.setFont(new Font("폰트",Font.BOLD,23));
		addshopping.add(ask);
		JButton buttonadd = new JButton("ADD to SHOPPING LIST");
		buttonadd.setForeground(Color.BLACK);
		buttonadd.setFont(new Font("Serif",Font.BOLD,23));
		buttonadd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if((shoppinglist.contains(itemlist.get(k)))) {
					dispose();
				}	
				else {
					shoppinglist.add(itemlist.get(k));
					test1.saveShopping();
					dispose();
				}
			}
		});
		JButton buttonskip = new JButton("EXIT");
		buttonskip.setForeground(Color.BLACK);
		buttonskip.setFont(new Font("Serif",Font.BOLD,23));
		buttonskip.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		addshopping.setBackground(Color.GRAY);
		buttonadd.setBackground(Color.gray);
		buttonskip.setBackground(Color.gray);
		addshopping.add(buttonadd);addshopping.add(buttonskip);
		
		setVisible(true);
		setSize(300,200);
	}

}
