package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.stereotype.Component;



import feign.hystrix.FallbackFactory;

import java.util.ArrayList;
import java.util.List;

@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
	@Override
	public DeptClientService create(Throwable throwable)
	{
		return new DeptClientService() {
			@Override
			public Dept get(long id)
			{ Dept dept=new Dept("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                 dept.setDeptno(id);
                 dept.setDb_source("no this database in MySQL");
                 dept.setDname("该ID：" + id + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
				return dept;
			}

			@Override
			public List<Dept> list()
			{
				Dept dept=new Dept("没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
				dept.setDeptno(null);
				dept.setDb_source("no this database in MySQL");
				dept.setDname("该ID：" + null+ "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
				List<Dept> depts=new ArrayList<Dept>();
				depts.add(dept);
				return depts;
			}

			@Override
			public boolean add(Dept dept)
			{
				return false;
			}
		};
	}
}
