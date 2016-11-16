import java.io.File;


public class DataOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void writeContentToFile(CaiPiaoBaseModel caiPiaoBaseModel) {
		String numberString = caiPiaoBaseModel.getNumbers().get(0);
		for (int i = 1; i < caiPiaoBaseModel.getNumbers().size(); i++) {
			numberString +=","+caiPiaoBaseModel.getNumbers().get(i);
		}
		String content =caiPiaoBaseModel.getDate()+ " "+caiPiaoBaseModel.getTime()+ " " + caiPiaoBaseModel.getIssue() +" "+numberString;
		try {
			FileOperation.writeContentToFile(FileOperation.currentProjectPath()+"/data/"+"pk10.txt",content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
