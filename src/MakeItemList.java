import java.io.*;
import java.util.*;

public class MakeItemList {
	public Vector<String> item;
	MakeItemList(Vector <String> item){
		this.item=item;
	}
	
	public void callList() {//���Ͽ� �ִ� ������ ���Ϳ� �����ϱ�
		InputStreamReader in = null;
		FileInputStream fin =null;
		try {
			item.clear();
			fin = new FileInputStream("ItemList.txt");
			in = new InputStreamReader(fin,"MS949");
			int c; String i="";
			while ((c=in.read())!=-1) {
				String m = Character.toString((char)c);
				if(m.equals("/")){
					item.add(i);i="";
				}
				else
					i+=m;
			}
			in.close();
			fin.close();
		}
		catch (IOException e) {
			System.out.println("����� ����");
		}
		
	}
	
	public void saveList() { //���Ͱ� ���Ͽ� �����ϱ�
		try {
			FileWriter fout = new FileWriter("ItemList.txt");
			for(int i=0;i<item.size();i++) {
				String items = item.get(i);
				fout.write(items,0,items.length());
				fout.write("/");
			}
			fout.close();
		}
		catch(IOException e) {
			System.out.println("����� ����");
		}
	}
}
