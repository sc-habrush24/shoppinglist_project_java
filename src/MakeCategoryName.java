import java.io.*;
import java.util.Vector;
public class MakeCategoryName {
	public static Vector <String> name;
	public int remove_number;
	public String remove_name;
	public int modify_number;
	MakeCategoryName(Vector <String> name){this.name=name;}
	public void callList() {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			name.clear();
			fin = new FileInputStream("CategoryNameList.txt");
			in = new InputStreamReader(fin,"MS949");
			int c;String i="";
			while ((c=in.read())!=-1) {
				String m = Character.toString((char)c);
				if(m.equals("/")){
					name.add(i);
					
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
	public void saveList() { 
		//벡터값 파일에 저장하기
		try {
			FileWriter fout = new FileWriter("CategoryNameList.txt");
			for(int i=0;i<name.size();i++) {
				String items = name.get(i);
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
