package com.webapp.interceptor;

import java.io.Serializable;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/***
 * 
 * @author yanghongquan
 * @created 2012-1-17
 */
public class MyInterceptor extends EmptyInterceptor {
	private static final long serialVersionUID = 1L;

	public MyInterceptor() {

	}

	// 当调用删除数据时，将调用onDelete方法
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		for (int i = 0; i < propertyNames.length; i++) {
			if ("artSubject".equals(propertyNames[i])) {
				System.out.println("delete" + state[i]);
			}
		}
	}

	// 同步Session和数据库中的数据
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		// 每修改一次，修改的累加器加1
		for (int i = 0; i < propertyNames.length; i++) {
			if ("artAuthor".equals(propertyNames[i])) {
				currentState[i] = "yanghongquan";
				return true;
			}
		}
		return false;
	}

	// 加载持久化实例时调用该方法
	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		for (int i = 0; i < propertyNames.length; i++) {
			if ("artAuthor".equals(propertyNames[i])) {
				System.out.println(state[i]);
				state[i] = "blog";
				return true;
			}
		}

		return false;
	}

	// 当保存该持久化实例时，调用该方法
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		for (int i = 0; i < propertyNames.length; i++) {
			if ("artAuthor".equals(propertyNames[i])) {
				state[i] = "yanghongquan";
				return true;
			}
		}
		return false;
	}
}
