package com.xiang.spring.jdbc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.xiang.spring.jdbc.DepatmentDao;
import com.xiang.spring.jdbc.TlUser;
import com.xiang.spring.jdbc.TlUserDao;

//@RunWith(value = SpringJUnit4ClassRunner.class)
//@ContextConfiguration(value = "classpath:applicationContext.xml")
public class JDBCTest {
	
	private ApplicationContext ctx = null;
	
	private JdbcTemplate jdbcTemplate;
	private TlUserDao tlUserDao;
	private DepatmentDao depatementDao;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		tlUserDao = (TlUserDao) ctx.getBean("tlUserDao");
		depatementDao = (DepatmentDao) ctx.getBean("depatmentDao");
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
	}
	
	@Test
	public void testDataSource(){
		DataSource dataSource =  ctx.getBean(DataSource.class);
		System.out.println(dataSource);
	}
	
	/**
	 * 执行INSERT
	 */
	@Test
	public void testInsert(){	
		String sql = "INSERT INTO TL_USER (username, gender, age, adress) value (?, ?, ?, ?)";
		jdbcTemplate.update(sql, "xiaoxiang", "男", 26, "河北石家庄");
	}
	
	/**
	 * 执行UPDATE
	 */
	@Test
	public void testUpdate(){
		String sql = "UPDATE TL_USER SET gender = ?, age = ?, adress = ? WHERE id = ?";
		jdbcTemplate.update(sql, "男", 24, "北京石景山", 6);
	}
	
	/**
	 * 执行批量UPDATE； INSERT; DELETE
	 */
	@Test
	public void testBatchUpdate(){
		String sql = "INSERT INTO TL_USER(username, gender, age, adress) VALUE(?,?,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{"AA", "男", 24, "北京石景山"});
		batchArgs.add(new Object[]{"BB", "男", 23, "北京石景山"});
		batchArgs.add(new Object[]{"CC", "男", 12, "北京石景山"});
		batchArgs.add(new Object[]{"DD", "男", 23, "北京石景山"});
		jdbcTemplate.batchUpdate(sql, batchArgs);
	}
	
	/**
	 * 从数据路获取一条记录，实际得到对应的一个对象
	 * 注意不调用 queryForObject(String sql, Class<TlUser> requiredType, Object... args)
	 * 而需要queryForObject(String sql, RowMapper<TlUser> rowMapper, Object... args) 
	 * 1. 其中的RowMapper 指定如何去映射结果集合，常用的实现类为 BeanPropertyRowMapper
	 * 2.使用 SQL 中的别名完成列明和类属性的映射， 例如 last_name lastName
	 * 3. 不支持级联属性
	 */
	@Test
	public void testQueryForObject(){
		String sql = "select id, username, gender, age, adress from tl_user where id = ?";
		RowMapper<TlUser> rowMapper = new BeanPropertyRowMapper<>(TlUser.class);
		TlUser user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(user.toString());
	}
	
	/**
	 * 查询到实体类的集合
	 * 注意不是 queryForList 方法
	 */
	@Test
	public void testQueryForList(){
		String sql = "select id, username, gender, age, adress from tl_user where id > ?";
		RowMapper<TlUser> rowMapper = new BeanPropertyRowMapper<>(TlUser.class);
		List<TlUser> list = jdbcTemplate.query(sql, rowMapper, 1);
		System.out.println(list);
	}
	
	@Test
	public void testQueryForObject2(){
		String sql = "select count(id) from tl_user";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	
	@Test
	public void testTlUserDao(){
		TlUser tlUser = tlUserDao.getTlUser(1);
		System.out.println(tlUser);
	}
	
	@Test
	public void testGetDepartment(){
		System.out.println(depatementDao.get(1));
	}
	
	/**
	 * 可以参数起名
	 * 1. 若有多个参数，则不再用对应为，直接对应参数，便于维护
	 * 2. 缺点，比较麻烦
	 */
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "insert into tl_user(username, gender, age, adress) values(:userName, :gender, :age, :adress)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userName", "相海瑞");
		paramMap.put("gender", "男");
		paramMap.put("age", 23);
		paramMap.put("adress", "北京石景山");
		namedParameterJdbcTemplate.update(sql, paramMap);
	}
	
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql = "insert into tl_user(username, gender, age, adress) values(:username, :gender, :age, :adress)";
		TlUser user = new TlUser();
		user.setUsername("相kkkk");
		user.setGender("男");
		user.setAge(33);
		user.setAdress("北京石景山");
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
}
