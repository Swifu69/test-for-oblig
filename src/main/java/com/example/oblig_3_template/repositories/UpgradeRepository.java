package com.example.oblig_3_template.repositories;

import com.example.oblig_3_template.model.Upgrade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UpgradeRepository {
    private final JdbcTemplate jdbcTemplate;

    public UpgradeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    protected static final RowMapper<Upgrade> upgradeRowMapper = (rs, rowNum) ->
            new Upgrade(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("cost"),
                    rs.getString("title"),
                    rs.getDouble("cpsMulti"),
                    rs.getDouble("clickMulti")
            );
    public List<Upgrade> getAllUpgrades(){
        String sql = "SELECT * FROM upgrades";
        return jdbcTemplate.query(sql,upgradeRowMapper);
    }
    public void createUpgrade(Upgrade upgrade){
        String sql = "INSERT INTO enhancement(name,cost,title,cpsMulti,clickMulti) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,upgrade.getName(),upgrade.getCost(),upgrade.getTitle(),upgrade.getCpsMulti(),upgrade.getClickMulti());
    }
}
