package com.example.oblig_3_template.repositories;

import com.example.oblig_3_template.model.AutoClicker;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AutoClickerRepository {
    private final JdbcTemplate jdbcTemplate;

    public AutoClickerRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    protected static final RowMapper<AutoClicker> autoclickerRowMapper = (rs, rowNum) ->
            new AutoClicker(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("cost"),
                    rs.getInt("cps"),
                    rs.getString("title")
            );
    public List<AutoClicker> getAllAutoClickers(){
        String sql = "SELECT * FROM auto_clicker";
        return jdbcTemplate.query(sql,autoclickerRowMapper);
    }
    public void createAutoClicker(AutoClicker autoClicker){
        String sql = "INSERT INTO auto_clicker(name,cost,cps,title) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,autoClicker.getName(),autoClicker.getCost(),autoClicker.getCps(),autoClicker.getTitle());
    }
    public int updateAutoClicker(Long id, AutoClicker autoClicker){
        String sql = "UPDATE auto_clicker SET name =?,cost=?,cps=?,title=?WHERE id = ?";
        return jdbcTemplate.update(sql,autoClicker.getName(),autoClicker.getCost(),autoClicker.getCps(),autoClicker.getTitle());
    }

    public void deleteAutoClicker(Long id) {
        String sql = "DELETE FROM auto_clicker WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Optional<AutoClicker> getAutoClickerById(Long id) {
        String sql = "SELECT * FROM auto_clicker WHERE id = ?";
        return jdbcTemplate.query(sql, autoclickerRowMapper, id).stream().findFirst();
    }
}
