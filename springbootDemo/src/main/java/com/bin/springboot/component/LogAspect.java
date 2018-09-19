package com.bin.springboot.component;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect // 切面标识
@Component // 交给spring容器管理
public class LogAspect {

	@Pointcut("@annotation(com.bin.springboot.component.Log)")
	public void logPoincut() {
	}

	@Before(value = "logPoincut()")
	public void before(JoinPoint joinPoint) throws NoSuchMethodException {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();

		Log annotation = signature.getMethod().getAnnotation(Log.class);

		Map<String,Object> map =toMap(joinPoint.getArgs()[0]);

		System.out.println(map.get("id"));
		
		System.out.println(map.get("userName"));
		System.out.println("工序" + annotation.procedure());

		System.out.println("工序" + annotation.procedure());
		System.out.println("日志记录前");
	}

	@AfterReturning(value = "logPoincut()")
	public void afterReturning(JoinPoint joinPoint) {
		System.out.println("日志记录成功");
	}

	@AfterThrowing(value = "logPoincut()", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		System.out.println("出错咯" + e);
	}
	
	
	public String getOrdeNo(Map<String,Object> map){
		Object orderNo = map.get("orderNo");
		if(orderNo!=null){
			return orderNo.toString(); 
		}
		orderNo = map.get("orderCode");
		if(orderNo!=null){
			return orderNo.toString();
		}
		return null;
	}
	
	public String getWarehouseCode(Map<String,Object> map){
		Object warehouseCode = map.get("warehouseCode");
		if(warehouseCode!=null){
			return warehouseCode.toString();
		}
		return null;
	}
	

	
	

	public Map<String,Object> toMap(Object bean) {
		Class<? extends Object> clazz = bean.getClass();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equals("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = null;
					result = readMethod.invoke(bean, new Object[0]);
					if (null != propertyName) {
						propertyName = propertyName.toString();
					}
					if (null != result) {
						result = result.toString();
					}
					returnMap.put(propertyName, result);
				}
			}
		} catch (IntrospectionException e) {
			System.out.println("分析类属性失败");
		} catch (IllegalAccessException e) {
			System.out.println("实例化 JavaBean 失败");
		} catch (IllegalArgumentException e) {
			System.out.println("映射错误");
		} catch (InvocationTargetException e) {
			System.out.println("调用属性的 setter 方法失败");
		}
		return returnMap;
	}

	/*
	 * @Around(value="logPoincut()") public void around(ProceedingJoinPoint
	 * joinPoint) throws Throwable{ System.out.println("环绕通知1");
	 * joinPoint.proceed(); System.out.println("环绕通知2"); }
	 */

}
