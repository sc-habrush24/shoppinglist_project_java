import java.io.*;
import java.util.*;

public class MakeItemList {
	public Vector<String> item;
	MakeItemList(Vector <String> item){
		this.item=item;
	}
	
	public void callList() {//파일에 있는 아이템 백터에 저장하기
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
			System.out.println("입출력 에러");
		}
		
	}
	
	public void saveList() { //벡터값 파일에 저장하기
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
			System.out.println("입출력 오류");
		}
	}
}
