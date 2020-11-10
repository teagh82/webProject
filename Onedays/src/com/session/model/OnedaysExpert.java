package com.session.model;

import java.util.*;

public class OnedaysExpert {
	public List gatState(String state) {
		List func = new ArrayList();
		if(state.equals("user")) {
			func.add("클래스 둘러보기");
			func.add("관심사 월드컵 하기");
		}
		else {
			func.add("클래스 만들기");
			func.add("클래스 수정하기");
		}
		return (func);
	}
}
