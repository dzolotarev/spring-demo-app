package ru.dzolotarev.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.dzolotarev.entities.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Denis Zolotarev on 20.02.2024
 */

public class ManagerMapper implements RowMapper<Manager> {

    @Override
    public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Manager.builder()
                .id(rs.getLong(1))
                .name(rs.getString(2))
                .title(rs.getString(3))
                .salary(rs.getInt(4))
                .hireDate(rs.getDate(5).toLocalDate())
                .subordinates(rs.getInt(6))
                .departmentId(rs.getInt(7)).build();
    }
}
