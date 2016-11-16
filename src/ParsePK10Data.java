import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.lang.model.element.Element;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class ParsePK10Data {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String dateString = "20140101";
		
	while (!dateString.equalsIgnoreCase("20161116")) {
		ArrayList<CaiPiaoBaseModel> list = perdayData_pk10(dateString);
		int numbers = 0;
		for (int i = list.size()-1; i >-1; i--) {
			numbers++;
			CaiPiaoBaseModel caiPiaoBaseModel = list.get(i);
			caiPiaoBaseModel.setTime(String.valueOf(numbers));
			String string =caiPiaoBaseModel.getDate()+ " "+caiPiaoBaseModel.getTime()+ " " + caiPiaoBaseModel.getIssue()+" "+caiPiaoBaseModel.getNumbers().toString();
			System.out.println(string);
			DataOperation.writeContentToFile(caiPiaoBaseModel);
		}
//		AnalysisData.anaylyzeData(list, 10);
		dateString = DateHandler.nextDayString(dateString);
	}
	}

	public static ArrayList<CaiPiaoBaseModel> perdayData_pk10(String dateString) {
		ArrayList<CaiPiaoBaseModel> modelsList = new ArrayList<CaiPiaoBaseModel>();
//		Document document = null;
//		String urlString = UrlConstant.baseUrl_pk10 + dateString +".xml";
//		System.out.println(urlString);
//		try {
//			document = Jsoup.connect(urlString).get();
//			Elements links = document.getElementsByTag("pk10");
//			for (int i = 0; i < links.size(); i++) {
//				
//				org.jsoup.nodes.Element element = (org.jsoup.nodes.Element) links.get(i);
//				CaiPiaoBaseModel model = new CaiPiaoBaseModel();		
//			model.setIssue(element.attr("issue"));
//			
//			// 获取号码
//			String nums = element.attr("nums");
//			String[] numbers = nums.split(" ");
//			ArrayList<String> list = new ArrayList<String>();
//			Collections.addAll(list, numbers);
//			model.setNumbers(list);
//			
//			// 获取日期和时间
//			String time = element.attr("time");
//			String[] timeStrings = time.split(" ");
//			if (timeStrings.length>1) {
//				model.setDate(timeStrings[0]);
//				model.setTime(timeStrings[1]);
//			}
////			System.out.println(model.getTime());
//			// 添加到数组
////			modelsList.add(model);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch bloc		e.printStackTrace();
//			System.out.println("gwegw");
//		}
		if (modelsList.size()==0) {
			return BaiDuLeCaiDownloader.baiDuleCai_pk10(dateString);
		} else {
			return modelsList;
		}
	}
	
}
