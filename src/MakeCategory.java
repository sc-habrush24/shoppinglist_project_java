import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class MakeCategory {
	public Vector <String> category;
	MakeCategory(Vector <String> category){this.category = category;}
	public void callCategory() {
		InputStreamReader in = null;
		FileInputStream fin =null;
		try {
			category.clear();
			fin = new FileInputStream("CategoryList.txt");
			in = new InputStreamReader(fin,"MS949");
			int c; String i="";
			while ((c=in.read())!=-1) {
				String m = Character.toString((char)c);
				if(m.equals("/")){
					category.add(i);
					i="";
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
	
	public void saveCategory() {
		try {
			FileWriter fout = new FileWriter("CategoryList.txt");
			for(int i=0;i<category.size();i++) {
				String items = category.get(i);
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
