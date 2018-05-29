package wokao666.club.myapp.dao.withTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wokao666.club.myapp.model.MchtUser;
import wokao666.club.myapp.model.User;

@Service
public class TNoUpdate {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public void getAll() {

		// -------------------------------------   下面是对 mysql 的测试       ----------------------------------------
		// 首先查出一条记录
		/*String sql1 = "select * from user where NAME='0'";
		User user = jdbcTemplate.queryForObject(sql1, new User[] {},
				new BeanPropertyRowMapper<User>(User.class));
		System.err.println(user);
		
		// 此处打断点，在数据库手动修改NAME='0'的那条记录
		
		// 再次获取相同记录，通过打印，查看user和user1是否相等
		User user1 = jdbcTemplate.queryForObject(sql1, new User[] {},
				new BeanPropertyRowMapper<User>(User.class));
		System.err.println(user1);
		
		// 打印看 user1、user2、user 三者是否相等
		User user2 = jdbcTemplate.queryForObject(sql1, new User[] {},
				new BeanPropertyRowMapper<User>(User.class));
		System.err.println(user2);*/

		// -------------------------------------   下面是对 oracle 的测试       ----------------------------------------
		String sql =
				"select t.user_id,t.user_name from TBL_MCHT_USER t where MCHT_NO='001440395002090'";
		MchtUser user11 = jdbcTemplate.queryForObject(sql, new User[] {},
				new BeanPropertyRowMapper<MchtUser>(MchtUser.class));
		System.err.println(user11);

		MchtUser user12 = jdbcTemplate.queryForObject(sql, new User[] {},
				new BeanPropertyRowMapper<MchtUser>(MchtUser.class));
		System.err.println(user12);

		MchtUser user13 = jdbcTemplate.queryForObject(sql, new User[] {},
				new BeanPropertyRowMapper<MchtUser>(MchtUser.class));
		System.err.println(user13);

		/**
		 * 结论：
		 * 
		 * mysql
		 * 
		 *      1、加了事务，不加readonly，则同个事务内查询的数据都是一直的，mysql默认事务隔离级别为"可重复读"
		 * 			2、加上readOnly,则查询的数据依旧是一致的，无论你是否有修改，但是当你执行更新操作时，会报错Connection is read-only. Queries leading to data modification are not allowed.
		 * oracle
		 * 
		 * 			1、加了事务，不加readonly，则可以读到修改的数据
		 * 			2、加上readOnly，oracle查询的数据不一致，也就是说readonly对Oracle不生效，执行update也不会报错
		 * 
		 */
	}
}