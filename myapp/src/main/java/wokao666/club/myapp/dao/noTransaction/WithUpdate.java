package wokao666.club.myapp.dao.noTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import wokao666.club.myapp.model.MchtUser;
import wokao666.club.myapp.model.User;

@Service
public class WithUpdate {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void getAll() {
		// 首先查出一条记录
		//		String sql1 = "select * from user where NAME='0'";
		//		User user = jdbcTemplate.queryForObject(sql1, new User[] {},
		//				new BeanPropertyRowMapper<User>(User.class));
		//		System.err.println(user);
		//
		//		// 此处在数据库手动修改NAME='0'的那条记录
		//
		//		// 再次获取相同记录，通过打印，查看user和user1是否相等
		//		User user1 = jdbcTemplate.queryForObject(sql1, new User[] {},
		//				new BeanPropertyRowMapper<User>(User.class));
		//		System.err.println(user1);
		//
		//		// 此处对记录进行修改，该修改为本事务内，而上面的手动修改为不同事务
		//		jdbcTemplate.update("update user set MOBILE='12' where NAME='0'");
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

		jdbcTemplate.update(
				"update TBL_MCHT_USER t set t.user_name='huangjiawei' where MCHT_NO='001440395002090'");

		MchtUser user13 = jdbcTemplate.queryForObject(sql, new User[] {},
				new BeanPropertyRowMapper<MchtUser>(MchtUser.class));
		System.err.println(user13);
	}
}
