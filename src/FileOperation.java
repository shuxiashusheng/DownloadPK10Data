
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileOperation {
	

	public static String directoryPath = "/data/";


	// ��ȡ��ǰ���̵�·��
	public static String currentProjectPath() throws IOException {
		File directory = new File("");//�趨Ϊ��ǰ�ļ��� 
		try{ 
		    System.out.println(directory.getCanonicalPath());//��ȡ��׼��·�� 
		    System.out.println(directory.getAbsolutePath());//��ȡ����·�� 
		}catch(Exception e){} 
		return directory.getCanonicalPath();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/Users/bss/Desktop/SSB'S Files/�Ǻӽ��ƽ̨�ļ���/fe/hutz.txt");
		try {
			createFile(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * �����ļ�
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean createFile(File fileName) throws Exception {
		boolean flag = false;
		try {
			if (!fileName.exists()) {
				fileName.createNewFile();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * ��TXT�ļ�����
	 * 
	 * @param fileName
	 * @return
	 */
	public static String readTxtFile(File fileName) throws Exception {
		String result = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			try {
				String read = null;
				while ((read = bufferedReader.readLine()) != null) {
					result = result + read + "\r\n";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		System.out.println("��ȡ�������ļ������ǣ�" + "\r\n" + result);
		return result;
	}

	public static boolean writeTxtFile(String content, File fileName)
			throws Exception {
		RandomAccessFile mm = null;
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName);
			o.write(content.getBytes("GBK"));
			o.close();
			// mm=new RandomAccessFile(fileName,"rw");
			// mm.writeBytes(content);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (mm != null) {
				mm.close();
			}
		}
		return flag;
	}

	public static void contentToTxt(String filePath, String content) {
		String str = new String(); // ԭ��txt����
		String s1 = new String();// ���ݸ���
		try {
			File f = new File(filePath);
			if (f.exists()) {
				System.out.print("�ļ�����");
			} else {
				System.out.print("�ļ�������");
				f.createNewFile();// �������򴴽�
			}
			BufferedReader input = new BufferedReader(new FileReader(f));

			while ((str = input.readLine()) != null) {
				s1 += str + "\n";
			}
//			System.out.println(s1);
			input.close();
			s1 += content;

			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(s1);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	// ���в���
	public static void writeContentToFile(String filePath,String content) {
	    FileWriter fw = null;
        try {
            fw = new FileWriter(filePath,true);
            fw.write(content+"\n");
            fw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("д��ʧ��");
            System.exit(-1);
        }
    }
//	 //���ж�ȡ�ı�
//
//	 public static final void readF1(String filePath) throws IOException {      
//	         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
//	         for (String line = br.readLine(); line != null; line = br.readLine()) {
//	                            System.out.println(line);               
//
//	         }
//	         br.close();
//	     }



}