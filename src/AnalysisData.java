import java.util.ArrayList;
import java.util.HashMap;


public class AnalysisData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

}
	public static HashMap<String, Object> anaylyzeData(ArrayList<CaiPiaoBaseModel> caiPiaoModels,int totals) {
		
		Integer totalAppearNumbers = 0;
		// 返回结果集合
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		CaiPiaoBaseModel caiPiaoModel = caiPiaoModels.get(0);
		ArrayList<String> numberStrings = caiPiaoModel.getNumbers();
		
		ArrayList<ArrayList<Integer>> recordArray = new ArrayList<ArrayList<Integer>>();
		
		// 构建numberStrings.size) *4 的数组 ,大 小 单 双
		for (int i = 0; i < numberStrings.size(); i++) {
			ArrayList<Integer> arr  = new ArrayList<Integer>();
			for (int j = 0; j < 4; j++) {
				arr.add(0);
			}
			recordArray.add(arr);
		}
		
		for (int i = 0; i < caiPiaoModels.size(); i++) {
			CaiPiaoBaseModel caiPiaoData = caiPiaoModels.get(i);
			ArrayList<String> numbers = caiPiaoData.getNumbers();
			for (int j = 0; j < numbers.size(); j++) {
		
				Integer numberValue = Integer.valueOf(numbers.get(j));
			ArrayList<Integer> ar =	recordArray.get(j);
			
				if (numberValue>5)  //  大
				{ 			
				 	Integer v = ar.get(0);
					ar.set(0, ++v);
					
					ar.set(1, 0);

				} else // 小
				{
					Integer v = ar.get(1);
					ar.set(1, ++v);
					
					ar.set(0, 0);

				}
			
				if (!(numberValue%2==0))  // 单
				{
					Integer v = ar.get(2);
					ar.set(2, ++v);
					
					ar.set(3, 0);

				} 
			
				else 	// 双 
				{
					Integer v = ar.get(3);
					ar.set(3, ++v);
					
					ar.set(2, 0);
				}
			}
			
			for (int t = 0; t < recordArray.size(); t++) {
				for (int j = 0; j < 4; j++) {
				Integer templeNumber = recordArray.get(t).get(j);
				if (templeNumber==totals) {
					totalAppearNumbers++;
					recordArray.get(t).set(j, 0);
					System.out.println(caiPiaoData.getIssue()+" "+caiPiaoData.getNumbers().toString());
				}
				}
			}
			
		}
		System.out.println(totalAppearNumbers);
		return null;
	}
}
