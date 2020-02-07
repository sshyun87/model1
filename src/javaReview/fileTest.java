package javaReview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileTest {

	public static void main(String[] args) throws IOException {

		File file = new File("c:/Temp","abc.txt");
		// File file = new File("c:/Temp/abc.txt"); 두가지 형태로 사용 가능. 
		System.out.println("파일크기: "+file.length());
		System.out.println("파일크기: "+file.getFreeSpace());
		System.out.println("파일크기: "+file.getName());//파일이름
		System.out.println("파일크기: "+file.getParent());//폴더명
		
		//폴더 목록 읽기
		File dir = new File("D:\\dev\\eclipse");
		String[] list = dir.list();
		for(String temp : list) {
			System.out.println(temp);
		}
		
		//폴더생성
		File newFile = new File("c:/Temp/images");
		//newFile.mkdir();
						
		//파일삭제
		file.delete();
		
		//파일복사
			FileInputStream src = new FileInputStream("C:\\Users\\User\\Pictures\\images\\pic07.jpg");
			FileOutputStream des = new FileOutputStream("C:/Temp/images/복사.jpg");
		
		byte[] data = new byte[100];
		int size=0;
		while( (size=src.read(data)) > -1 ) {
			des.write(data);
		}
		src.close();
		des.close();
		
	}

}
