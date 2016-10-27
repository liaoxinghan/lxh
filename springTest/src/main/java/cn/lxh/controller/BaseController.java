package cn.lxh.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.code.kaptcha.Constants;

import cn.lxh.result.ServerError;
import cn.lxh.util.ConversionCode;

@Controller
@RequestMapping("/base")
public class BaseController {

	private static Logger logger = Logger.getRootLogger();

	@RequestMapping("/error")
	public String getPeople(Model model, String errorCode) {
		ServerError.errorCode escapeError = ConversionCode.escapeError(errorCode);
		model.addAttribute("errorMsg", escapeError.getMsg());
		return "error";
	}

	@RequestMapping("/main")
	public String toMain() {
		return "main";
	}

	@RequestMapping(value = "check", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request, @RequestParam(value = "kaptcha", required = true) String kaptchaReceived) {
		//用户输入的验证码的值  
		String kaptchaExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		//校验验证码是否正确  
		if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {
			return "error";//返回验证码错误  
		}
		return "index"; //校验通过返回成功  
	}

}
