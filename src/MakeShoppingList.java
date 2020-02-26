import java.util.*;
import java.io.*;
public class MakeShoppingList {
	public Vector<String> shopping;
	MakeShoppingList(Vector<String> shopping){this.shopping=shopping;}
	public void callShopping() {
		InputStreamReader in = null;
		FileInputStream fin =null;
		try {
			shopping.clear();
			fin = new FileInputStream("ShoppingList.txt");
			in = new InputStreamReader(fin,"MS949");
			int c; String i="";
			while ((c=in.read())!=-1) {
				String m = Character.toString((char)c);
				if(m.equals("/")){
					shopping.add(i);i="";
				}
				else
					i+=m;
			}
			in.close();
			fin.close();
		}
		catch (IOException e) {
			System.out.println("입출력 에러");
		}
	}
	
	
	public void saveShopping() {
		try {
			FileWriter fout = new FileWriter("ShoppingList.txt");
			for(int i=0;i<shopping.size();i++) {
				String items = shopping.get(i);
				fout.write(items,0,items.length());
				fout.write("/");
			}
			fout.close();
		}
		catch(IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
