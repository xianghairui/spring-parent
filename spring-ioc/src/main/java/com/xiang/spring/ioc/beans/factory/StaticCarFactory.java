package com.xiang.spring.ioc.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>ClassName:StaticCarFactory</p>
 * <p>Description: 静态工厂方法：</p>
 * <p>直接调用某一个累的静态方法就可以返回bean的实例</p>
 * @author hairui
 * @date 2017年3月10日 上午10:24:12
 */
public class StaticCarFactory {
	
	private static Map<String, Car> cars = new HashMap<>();
	
	static {
		cars.put("audi", new Car("audi", 300000));
		cars.put("ford", new Car("ford", 500000));
	}
	
	//静态工厂方法
	public static Car getCar(String name){
		return cars.get(name);
	}
}
