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
		test.callList();//아이템 리스트 불러오기
		Vector <String> shoppinglist = new Vector();
		MakeShoppingList test1 = new MakeShoppingList(shoppinglist);
		test1.callShopping();//쇼핑 리스트 불러오기
		Vector <String> categoryname = new Vector();
		MakeCategoryName test3 = new MakeCategoryName(categoryname);
		test3.callList();//카레고리 불러오기
		Vector <String> category = new Vector();
		MakeCategory test2 = new MakeCategory(category);
		test2.callCategory();//카테고리 이름 불러오기
	
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
