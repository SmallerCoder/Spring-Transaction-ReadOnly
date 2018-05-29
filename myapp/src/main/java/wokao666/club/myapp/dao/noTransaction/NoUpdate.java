package wokao666.club.myapp.dao.noTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import wokao666.club.myapp.model.MchtUser;
import wokao666.club.myapp.model.User;

/**
 * 
 * The class NoTransaction.
 *
 * Description:没有事务的情况
 *
 * @author: huangjiawei
 * @since: 2018年5月29日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
@Service
public class NoUpdate {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void getAll() {
		// -------------------------------------   下面是对 mysql 的测试       ----------------------------------------
		// 首先查出一条记录
		//		String sql1 = "select * from user where NAME='0'";
		//		User user = jdbcTemplate.queryForObject(sql1, new User[] {},
		//				new BeanPropertyRowMapper<User>(User.class));
		//		System.err.println(user);
		//
		//		// 此处打断点，在数据库手动修改NAME='0'的那条记录
		//
		//		// 再次获取相同记录，通过打印，查看user和user1是否相等
		//		User user1 = jdbcTemplate.queryForObject(sql1, new User[] {},
		//				new BeanPropertyRowMapper<User>(User.class));
		//		System.err.println(user1);
		//
		//		// 打印看 user1、user2、user 三者是否相等
		//		User user2 = jdbcTemplate.queryForObject(sql1, new User[] {},
		//				new BeanPropertyRowMapper<User>(User.class));
		//		System.err.println(user2);

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
		 *      1、什么事务都不加，则可以读到修改的数据
		 * 			2、由于没有加事务，执行更新操作没问题
		 * 	
		 * oracle
		 * 
		 * 			1、什么事务都不加，则可以读到修改的数据
		 * 			2、可以执行更新操作
		 * 
		 */
	}
}
