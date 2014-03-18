package cn.cwnu.cs.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {

	public static void createHtml(ServletContext context,
			Map<String, Object> data, String ftlPath, String htmlPath) {
		// 初始化设置
		Configuration cfg = new Configuration();
		cfg.setServletContextForTemplateLoading(context, "/templates/");
		cfg.setEncoding(Locale.getDefault(), "UTF-8");

		try {
			// 模板路径及设置
			Template template = cfg.getTemplate(ftlPath, "UTF-8");
			template.setEncoding("UTF-8");

			// Html 页面路径及设置
			htmlPath = context.getRealPath("/") + htmlPath;
			Writer out = new OutputStreamWriter(new FileOutputStream(htmlPath),
					"UTF-8");

			// 处理数据
			template.process(data, out);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
