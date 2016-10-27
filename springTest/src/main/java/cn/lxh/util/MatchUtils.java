package cn.lxh.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
* <p>Title: MatchUtils</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-9-28
*/
public class MatchUtils {

//	@Test
	public void firstNotNumber() {
		Pattern pattern = Pattern.compile("^[^0-9]");
		Matcher matcher = pattern.matcher("1");
		System.out.println(matcher.matches());
	}

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^[a-z][0-9]$");
		Matcher matcher = pattern.matcher("b52");
		System.out.println(matcher.matches());

		System.out.println("a\u0022.length() + \u0022b".length());
		System.out.println("a\".length()+\"b".length());
	}
}
