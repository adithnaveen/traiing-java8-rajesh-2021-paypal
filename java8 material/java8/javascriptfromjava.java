package com.java8;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class javascriptfromjava {
	public static void main(String args[]) {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine nas = sem.getEngineByName("nashorn");
		String name = "RKCP INFORMATION TECHNOLOGY";
		Integer result = null;
		try {
			nas.eval("print('" + name + "')");
			result = (Integer) nas.eval("155 + 45");
		} catch (ScriptException e) {
			System.out.println("Error executing script: " + e.getMessage());
		}
		System.out.println(result.toString());
	}
}
