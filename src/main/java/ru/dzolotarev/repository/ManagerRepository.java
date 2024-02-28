package ru.dzolotarev.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.dzolotarev.entities.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class ManagerRepository {

    private final String FIND_ALL = "SELECT * FROM public.managers";
    private final String FIND_BY_ID = "SELECT * FROM public.managers m WHERE m.id=?";
    private final String SAVE = "INSERT INTO public.managers(id, name, title, salary, hire_date, subordinates, department_id) " +
            "values (?,?,?,?,?,?,?)";

    private final JdbcTemplate jdbcTemplate;

    public List<Manager> findAll() {
        List<Manager> managerList = jdbcTemplate.query(FIND_ALL, this::mapRow);
        return managerList;
    }

    public Manager findById(Long id) {
        List<Manager> managers = jdbcTemplate.query(FIND_BY_ID, this::mapRow, id);
        return managers.isEmpty() ? null : managers.get(0);
    }

    public void save(Manager manager) {
        jdbcTemplate.update(SAVE, manager.getId(), manager.getName(),
                manager.getTitle(), manager.getSalary(), manager.getHireDate(),
                manager.getSubordinates(), manager.getDepartmentId());
    }

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
