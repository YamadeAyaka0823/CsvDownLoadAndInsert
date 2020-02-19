package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Arashi;
import com.example.service.ArashiService;

@Controller
@RequestMapping("/csv")
public class CsvDwonLoadController {
	
	@Autowired
	private ArashiService arashiService;
	
	/**
	 * ダウンロード初期画面.
	 * @return
	 */
	@RequestMapping("")
	public String index() {
		return "download";
	}
	
	@RequestMapping("/download")
	public void downLoad(HttpServletResponse response) throws IOException {
		//setContentTypeメソッドでレスポンスされる文字のタイプを指定する
		response.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE + ";charset=utf-8");
		//setHeaderは指定された名称で指定された値を持つレスポンスヘッダを設定する。
		response.setHeader("Content-Disposition", "attachment; filename=\"arashiDownLoad.csv\"");
		
		//try-with-resources文を使うことでclose処理を自動化
		try(PrintWriter pw = response.getWriter()){
			List<Arashi> arashiList = arashiService.findAll();
			for(int i = 0; i < arashiList.size(); i++) {
				Integer id = arashiList.get(i).getId();
				String name = arashiList.get(i).getName();
				Date day = arashiList.get(i).getDay();
				String email = arashiList.get(i).getEmail();
				Integer companyId = arashiList.get(i).getCompanyId();
				
				//CSVファイル内部に記載する形式で文字列を設定
				String outPut = id + "," + name + "," + day + "," + email + "," + companyId + "\r\n";
				pw.print(outPut);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
