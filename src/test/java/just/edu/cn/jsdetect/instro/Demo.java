package just.edu.cn.jsdetect.instro;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Test;

import java.io.IOException;

/**
 * htmluint 使用测试
 *
 * @Author: chenpeng
 * @Datetime: 2020/5/25 10:55
 * @Version: V1.0
 */
public class Demo {

    /**
     * 自动填写体温提交代码（测试）
     *
     * @throws IOException
     */
    @Test
    public void submittingForm() throws IOException {
        final WebClient webClient = new WebClient();
        // 允许页面出错
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        // 取消 JS 支持
        webClient.getOptions().setJavaScriptEnabled(false);
        // 取消 CSS 支持
        webClient.getOptions().setCssEnabled(false);

        // 登录页面
        HtmlPage page1 = webClient.getPage("http://ids2.just.edu.cn/cas/login");
        if (page1 != null) {
            HtmlForm form = page1.getHtmlElementById("fm1");
            // 获取账号,密码输入框
            final HtmlTextInput usrname = form.getInputByName("username");
            final HtmlPasswordInput password = form.getInputByName("password");
            // 提交按钮
            final HtmlSubmitInput submitInput = form.getInputByName("submit");
            // 设置值
            usrname.setText("189070018"); // -> 改成你的账号
            password.setText("xxxx"); // -> 该成你的密码
            // 模拟提交登录
            final HtmlPage page2 = submitInput.click();


            // 允许js支持
            webClient.getOptions().setJavaScriptEnabled(true);
            // 请求填写表单
            final HtmlPage jiangkangxixnibiao = webClient.getPage("http://ehall.just.edu.cn/default/work/jkd/jkxxtb/jkxxcj.jsp");
            final HtmlForm form1 = jiangkangxixnibiao.getHtmlElementById("form");
            // 获取早上和昨晚体温输入框
            final HtmlTextInput m = form1.getInputByName("tw");
            final HtmlTextInput e = form1.getInputByName("zwtw");
            m.setValueAttribute("36.5"); // 今晨体温
            e.setValueAttribute("36.5"); // 昨晚体温
            // 获取提交按钮
            final HtmlButton subbutton = jiangkangxixnibiao.getHtmlElementById("post");
            // 提交表单
            final HtmlPage finalPage = subbutton.click();
        }
    }

}
