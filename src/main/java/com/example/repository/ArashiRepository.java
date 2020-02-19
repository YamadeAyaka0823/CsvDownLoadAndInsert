package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Arashi;

@Repository
public class ArashiRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Arashi> ARASHI_ROW_MAPPER = (rs,i) -> {
		Arashi arashi = new Arashi();
		arashi.setId(rs.getInt("id"));
		arashi.setName(rs.getString("name"));
		arashi.setEmail(rs.getString("email"));
		arashi.setDay(rs.getDate("day"));
		arashi.setCompanyId(rs.getInt("company_id"));
		return arashi;
	};
	
	/**
	 * 全件検索してcsvとしてダウンロードできるようにするためのリポジトリ.
	 * @return
	 */
	public List<Arashi> findAll(){
		String sql = "SELECT id, name, day, email, company_id FROM arashi";
		List<Arashi> arashiList = template.query(sql, ARASHI_ROW_MAPPER);
		return arashiList;
	}

}
