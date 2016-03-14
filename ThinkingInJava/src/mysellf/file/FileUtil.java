package mysellf.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 封装一个工具类，可以对文件进行操作，实现读取、重写、追加等功能。
 * 
 * @author Mr.Huang
 * 
 */
public class FileUtil {

	/**
	 * 文件内容读取
	 * 
	 * @param file
	 * @return
	 */
	public static String readFile(File file) {
		try {
			FileInputStream fileInput = new FileInputStream(file);
			BufferedInputStream bufInput = new BufferedInputStream(fileInput);
			StringBuffer strb = new StringBuffer();
			byte[] by = new byte[1024];
			while ((bufInput.read(by)) != -1) {
				strb.append(new String(by));
			}
			bufInput.close();
			fileInput.close();
			return strb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 重写
	 * 
	 * @param file
	 * @param content
	 */
	public static void write(File file, String content) {
		try {
			FileOutputStream fileOutput = new FileOutputStream(file);
			BufferedOutputStream bufOutput = new BufferedOutputStream(
					fileOutput);
			bufOutput.write(content.getBytes());
			bufOutput.close();
			fileOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 追加
	 * 
	 * @param file
	 * @param content
	 */
	public static void appendContent(File file, String content) {
		try {
			BufferedOutputStream bufOutput = new BufferedOutputStream(
					new FileOutputStream(file, true));
			bufOutput.write(content.getBytes());
			bufOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
