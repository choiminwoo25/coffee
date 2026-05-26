package dao;

import domain.Menu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public MenuDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("MENU")
                .usingGeneratedKeyColumns("ID");
    }

    private final RowMapper<Menu> menuRowMapper = (rs, rowNum) -> {
        Menu menu = new Menu();
        menu.setId(rs.getLong("ID"));
        menu.setMenuName(rs.getString("MENU_NAME"));
        menu.setCategory(rs.getString("CATEGORY"));
        menu.setPrice(rs.getInt("PRICE"));
        menu.setReleaseDate(rs.getDate("RELEASE_DATE").toLocalDate());
        return menu;
    };

    public Long insert(Menu menu) {
        Map<String, Object> params = new HashMap<>();
        params.put("MENU_NAME", menu.getMenuName());
        params.put("CATEGORY", menu.getCategory());
        params.put("PRICE", menu.getPrice());
        params.put("RELEASE_DATE", menu.getReleaseDate());
        Number key = jdbcInsert.executeAndReturnKey(params);
        return key.longValue();
    }

    public List<Menu> findAll() {
        return jdbcTemplate.query(
                "SELECT ID, MENU_NAME, CATEGORY, PRICE, RELEASE_DATE FROM MENU ORDER BY ID DESC",
                menuRowMapper);
    }

    public Menu findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT ID, MENU_NAME, CATEGORY, PRICE, RELEASE_DATE FROM MENU WHERE ID = ?",
                menuRowMapper, id);
    }
}
