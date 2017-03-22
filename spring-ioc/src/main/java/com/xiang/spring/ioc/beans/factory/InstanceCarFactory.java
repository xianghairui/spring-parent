package com.xiang.spring.ioc.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>ClassName:InstanceCarFactory</p>
 * <p>Description: 实例工厂方法</p>
 * <p>需要</p>
 * @author hairui
 * @date 2017年3月10日 上午10:56:11
 */
public class InstanceCarFactory {

	private Map<String, Car> cars = null;
	
	
	public InstanceCarFactory(){
		cars = new HashMap<String, Car>();
		cars.put("audi", new Car("audi", 300000));
		cars.put("ford", new Car("ford", 500000));
	}
	
	public Car getCar(String brand){
		return cars.get(brand);
	}
	
}
