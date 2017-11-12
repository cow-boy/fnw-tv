package com.fnwtvdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FnwTvDemoApplicationTests {

	private static Logger LOGGER = LoggerFactory.getLogger(FnwTvDemoApplicationTests.class);

	@Test
	public void test(){
		/*Map<String,Integer> map=new HashMap<>();
		map.put("derek",24 );
		map.put("dad", 51);
		map.put("mom", 46);
		List<Map.Entry<String, Integer>> list=new ArrayList<>();
		list.addAll(map.entrySet());
		Collections.sort(list,(m1, m2) ->m1.getValue()-m2.getValue());
		*//*list.forEach(m -> System.out.println(m.getKey()));*//*
		System.out.println(map);*/
		/*List<String> items =
				Arrays.asList("apple", "apple", "banana",
						"apple", "orange", "banana", "papaya");

		Map<String, Long> result =
				items.stream().collect(
						Collectors.groupingBy(
								Function.identity(), Collectors.counting()
						)
				);
		System.out.println(result);*/

		Map<String,String> result=new HashMap<>();
		result.put("13", "derek");
		result.put("37","dad");
		result.put("22","mom");

		Map<String, String> finalMap = new TreeMap<>();

		//Sort a map and add to finalMap
		result.entrySet().stream()
				.sorted(Map.Entry.<String, String>comparingByKey()
						.reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);
	}

	@Test
	public void contextLoads() {
		AEntity a1 = new AEntity();
		a1.setId("111");
		a1.setName("name1");
		AEntity a2 = new AEntity();
		a2.setId("222");
		a2.setName("name");
		AEntity a3 = new AEntity();
		a3.setId("111");
		a3.setName("name3");
		AEntity a4 = new AEntity();
		a4.setId("222");
		a4.setName("name");
		AEntity a5 = new AEntity();
		a5.setId("2223");
		a5.setName("name3");

		List<AEntity> list = new ArrayList<AEntity>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);

		System.out.println("list分组前为：" + list);
		Map<String, List<AEntity>> map = new HashMap<String, List<AEntity>>();
		listGroup2Map(list, map, AEntity.class, "getName");// 输入方法名
		System.out.println("分组完成，分组后的map为：" + map);
	}

	/**
	 * 将List<V>按照V的某个方法返回值（返回值必须为K类型）分组，合入到Map<K, List<V>>中<br>
	 * 要保证入参的method必须为V的某一个有返回值的方法，并且该返回值必须为K类型
	 *
	 * @param list 待分组的列表
	 * @param map 存放分组后的map
	 * @param method 方法
	 */
	public static <K, V> void listGroup2Map(List<V> list, Map<K, List<V>> map, Method method) {
		// 入参非法行校验
		if (null == list || null == map || null == method) {
			return;
		}

		try {
			// 开始分组
			Object key;
			List<V> listTmp;
			for (V val : list) {
				key = method.invoke(val);
				listTmp = map.get(key);
				if (null == listTmp) {
					listTmp = new ArrayList<V>();
					map.put((K) key, listTmp);
				}
				listTmp.add(val);
			}
		} catch (Exception e) {
			LOGGER.error("分组失败！", e);
		}
	}

	/**
	 * 根据类和方法名，获取方法对象
	 *
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	public static Method getMethodByName(Class<?> clazz, String methodName) {
		Method method = null;
		// 入参不能为空
		if (null == clazz) {   // || StringUtils.isBlank(methodName)
			LOGGER.error("CommonUtils.getMethodByName 入参错误，clazz：" + clazz + " ；methodName："
					+ methodName);
			return method;
		}

		try {
			method = clazz.getDeclaredMethod(methodName);
		} catch (Exception e) {
			LOGGER.error("类获取方法失败！", e);
		}

		return method;
	}

	/**
	 * 将List<V>按照V的methodName方法返回值（返回值必须为K类型）分组，合入到Map<K, List<V>>中<br>
	 * 要保证入参的method必须为V的某一个有返回值的方法，并且该返回值必须为K类型
	 *
	 * @param list 待分组的列表
	 * @param map 存放分组后的map
	 * @param clazz 泛型V的类型
	 * @param methodName 方法名
	 */
	public static <K, V> void listGroup2Map(List<V> list, Map<K, List<V>> map, Class<V> clazz, String methodName) {
		// 入参非法行校验
		if (null == list || null == map || null == clazz) {   // || StringUtils.isBlank(methodName)
			LOGGER.error("CommonUtils.listGroup2Map 入参错误，list：" + list + " ；map：" + map
					+ " ；clazz：" + clazz + " ；methodName：" + methodName);
			return;
		}

		// 获取方法
		Method method = getMethodByName(clazz, methodName);
		// 非空判断
		if (null == method) {
			return;
		}

		// 正式分组
		listGroup2Map(list, map, method);
	}

}
