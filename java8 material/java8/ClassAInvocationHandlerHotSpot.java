package com.java8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ClassAInvocationHandlerHotSpot implements InvocationHandler {
	
	private Object classAImpl;
	 
	public ClassAInvocationHandlerHotSpot(Object impl) {
	   this.classAImpl = impl;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	   
		if(Object.class  == method.getDeclaringClass()) {
	       String name = method.getName();
	       if("equals".equals(name)) {
	           return proxy == args[0];
	       } else if("hashCode".equals(name)) {
	           return System.identityHashCode(proxy);
	       } else if("toString".equals(name)) {
	           return proxy.getClass().getName() + "@" +
	               Integer.toHexString(System.identityHashCode(proxy)) +
	               ", with InvocationHandler " + this;
	       } else {
	           throw new IllegalStateException(String.valueOf(method));
	       }
	   }
	   
	   return method.invoke(classAImpl, args);
	}
}
