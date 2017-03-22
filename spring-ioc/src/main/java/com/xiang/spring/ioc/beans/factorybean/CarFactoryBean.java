package com.xiang.spring.ioc.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 
 * <p>ClassName:CarFactoryBean</p>
 * <p>Description: TODO</p>
 * <p></p>
 * @author hairui
 * @date 2017年3月10日 上午11:01:36
 */
public class CarFactoryBean implements FactoryBean<Car> {
	
	private String brand;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * 返回bean的对象
	 */
	@Override
	public Car getObject() throws Exception {
		return new Car(brand, 500000);
	}

	/**
	 * 返回bean 的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	/**
	 * 
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
