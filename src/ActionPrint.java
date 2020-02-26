import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;

import javax.swing.*;

import java.util.Scanner;
import java.util.Vector;
public class ActionPrint extends JFrame{
	ActionPrint(){
		Vector <String> itemlist = new Vector();
		MakeItemList test = new MakeItemList(itemlist);
		test.callList();//������ ����Ʈ �ҷ�����
		Vector <String> shoppinglist = new Vector();
		MakeShoppingList test1 = new MakeShoppingList(shoppinglist);
		test1.callShopping();//���� ����Ʈ �ҷ�����
		Vector <String> categoryname = new Vector();
		MakeCategoryName test3 = new MakeCategoryName(categoryname);
		test3.callList();//ī���� �ҷ�����
		Vector <String> category = new Vector();
		MakeCategory test2 = new MakeCategory(category);
		test2.callCategory();//ī�װ� �̸� �ҷ�����
	
		String line ="ITEM LIST\n";
		for(int j=0;j<itemlist.size();j++) {
			line += itemlist.get(j);
			line +="\n";
		}
		
		line+="SHOPPING LIST \n";
		for(int k=0;k<shoppinglist.size();k++) {
			line +=shoppinglist.get(k)+"\n";
		}
	
		JEditorPane pane = new JEditorPane("text/plain", line);
		try {
			pane.print();
		}
		catch (PrinterException e) {
			e.printStackTrace();
		}
	}
	
}
