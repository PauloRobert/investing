package br.com.investing.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import br.com.investing.config.hooks;

public class Runner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(hooks.class);
		System.out.println("\nResultado dos Testes: " +  result.getRunCount());

	}
}
