package inc.star.usingspringsecuritywithdatabase.UserDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService, RowMapper<AppUser> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails;
        try {
            userDetails = jdbcTemplate.queryForObject("select * from user_table", this);
        } catch (Exception e){
            throw new UsernameNotFoundException("Nothing Found");
        }
        return userDetails;
    }

    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        String username = rs.getString(1);
        String password = rs.getString(2);

        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(password);

        return appUser;
    }
}
