package gorev2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.List;

@SpringBootApplication
public class BayramGorevTanimApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		SpringApplication.run(BayramGorevTanimApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String sql="SELECT * FROM STAJ";
		List<model.gorev>gorevList=jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(model.gorev.class));

	}
}
