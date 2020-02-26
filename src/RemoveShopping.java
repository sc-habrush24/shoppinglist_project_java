import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
public class RemoveShopping extends JFrame{
	RemoveShopping(){}
	RemoveShopping(int k){
		Vector <String> shoppinglist = new Vector();
		MakeShoppingList test1 = new MakeShoppingList(shoppinglist);
		test1.callShopping();
		
		JPanel remove = new JPanel();
		setContentPane(remove);
		remove.setBackground(Color.gray);
		JLabel m =new JLabel("선택한 물품 :"+shoppinglist.get(k));
		m.setFont(new Font("폰트",Font.BOLD,23));
		m.setForeground(Color.white);
		remove.add(m);
		JButton buttonremove = new JButton("REMOVE");
		buttonremove.setFont(new Font("Serif",Font.BOLD,23));
		buttonremove.setForeground(Color.white);
		buttonremove.setBackground(Color.gray);
		buttonremove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shoppinglist.remove(k);
				test1.saveShopping();
				dispose();
			}
		});
		JButton exit = new JButton("EXIT");
		exit.setFont(new Font("Serif",Font.BOLD,23));
		exit.setForeground(Color.white);
		exit.setBackground(Color.gray);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		remove.add(buttonremove);remove.add(exit);
		
		setVisible(true);
		setSize(300,200);
		
	}
	public Vector<String> getItemList(){
		Vector <String> shoppinglist = new Vector();
		MakeShoppingList k = new MakeShoppingList(shoppinglist);
		k.callShopping();
		return shoppinglist;
	}	
}
