package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import co.yedam.appboard.BoardDAO;
import co.yedam.appboard.BoardDTO;

public class BoardDAOClient {
	public static void main(String[] args) throws IOException {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.selectOne(5);
		
		byteArrayConvertToImageFile(dto.getFile());
	}
	public static void byteArrayConvertToImageFile(byte[] imageByte) throws IOException 
	{
	  ByteArrayInputStream inputStream = new ByteArrayInputStream(imageByte);
	  BufferedImage bufferedImage = ImageIO.read(inputStream);

	  ImageIO.write(bufferedImage, "jpg", new File("C://Temp/image.jpg")); //저장하고자 하는 파일 경로를 입력합니다.
	  
	}
}
