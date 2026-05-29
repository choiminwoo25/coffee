package dao;

import domain.CafeMenu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CafeMenuDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public CafeMenuDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("MENU")
                .usingGeneratedKeyColumns("ID");
    }

    private final RowMapper<CafeMenu> menuRowMapper = (rs, rowNum) -> {
        CafeMenu cafeMenu = new CafeMenu();
        cafeMenu.setId(rs.getLong("ID"));
        cafeMenu.setMenuName(rs.getString("MENU_NAME"));
        cafeMenu.setCategory(rs.getString("CATEGORY"));
        cafeMenu.setPrice(rs.getInt("PRICE"));
        cafeMenu.setReleaseDate(rs.getDate("RELEASE_DATE").toLocalDate());
        return cafeMenu;
    };

    public Long insert(CafeMenu cafeMenu) {
        Map<String, Object> params = new HashMap<>();
        params.put("MENU_NAME", cafeMenu.getMenuName());
        params.put("CATEGORY", cafeMenu.getCategory());
        params.put("PRICE", cafeMenu.getPrice());
        params.put("RELEASE_DATE", cafeMenu.getReleaseDate());
        Number key = jdbcInsert.executeAndReturnKey(params);
        return key.longValue();
    }

    public List<CafeMenu> findAll() {
        return jdbcTemplate.query(
                "SELECT ID, MENU_NAME, CATEGORY, PRICE, RELEASE_DATE FROM MENU ORDER BY ID DESC",
                menuRowMapper);
    }

    public CafeMenu findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT ID, MENU_NAME, CATEGORY, PRICE, RELEASE_DATE FROM MENU WHERE ID = ?",
                menuRowMapper, id);
    }
}
