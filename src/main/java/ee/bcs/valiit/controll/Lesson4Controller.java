package ee.bcs.valiit.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@RestController
public class Lesson4Controller {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("lesson4/account/{kontoNr}/{kontoOmanikuNimi}")
    public String addBankAccount(@PathVariable("kontoNr") String kontoNr,
                                 @PathVariable("kontoOmanikuNimi") String kontoOmanikuNimi) {
        String sql = "INSERT INTO accounts (account_nr, account_owner, balance, locked_status)" +
                "VALUES (:kontoNr, :kontoOmanikuNimi, :balanss, :kasLukustatud)";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontoNr", kontoNr);
        paramMap.put("kontoOmanikuNimi", kontoOmanikuNimi);
        paramMap.put("balanss", 0);
        paramMap.put("kasLukustatud", false);
        jdbcTemplate.update(sql, paramMap);
        return "Konto loodud.";
    }

    @GetMapping("lesson4/account/{kontoNr}/balance")
    public String getAccountBalance(@PathVariable("kontoNr") String account_nr) {
        String sql = "SELECT balance FROM accounts WHERE account_nr = :account_nr";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", account_nr);
        Integer currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return "Kontol " + account_nr + " on " + currentBalance + " rahaühikut.";
    }

    @PutMapping("lesson4/account/{kontoNr}/lock")
    public String accLock(@PathVariable("kontoNr") String kontoNr) {
        String sql = "UPDATE accounts SET locked_status = 'true' WHERE account_nr = :account_nr";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", kontoNr);
        jdbcTemplate.update(sql, paramMap);
        return kontoNr + " konto on lukustatud.";
    }

    @PutMapping("lesson4/account/{kontoNr}/unlock")
    public String accUnlock(@PathVariable("kontoNr") String kontoNr) {
        String sql = "UPDATE accounts SET locked_status = 'false' WHERE account_nr = :account_nr";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", kontoNr);
        jdbcTemplate.update(sql, paramMap);
        return kontoNr + " konto on avatud.";
    }

    @DeleteMapping("lesson4/account/{kontoNr}/delete")
    public String deleteAcc(@PathVariable("kontoNr") String kontoNr) {
        String sql = "DELETE FROM accounts WHERE account_nr = :account_nr";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", kontoNr);
        jdbcTemplate.update(sql, paramMap);
        return "Kasutaja " + kontoNr + " on kustutatud.";
    }

    @GetMapping("lesson4/accounts")
    public List<Account> getAllAccounts() {
        String sql = "SELECT * FROM accounts";
        HashMap<String, Object> paramMap = new HashMap<>();
        List<Account> result = jdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return result;
    }

    private class AccountRowMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account result = new Account();
            result.setKontoNr(resultSet.getString("account_nr"));
            result.setKontoOmanikuNimi(resultSet.getString("account_owner"));
            result.setBalanss(resultSet.getInt("balance"));
            result.setKasLukustatud(resultSet.getBoolean("locked_status"));
            return result;
        }
    }

    @GetMapping("lesson4/accounts/{kontoNr}")
    public String getAccountInfo(@PathVariable("kontoNr") String kontoNr) {
        String sql = "SELECT * FROM accounts WHERE account_nr = :kontoNr";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontoNr", kontoNr);
        Account accountDto = jdbcTemplate.queryForObject(sql, paramMap, new AccountRowMapper());
        if (accountDto.getKasLukustatud()) {
            System.out.println("Konto on lukustatud.");
        }
        return accountDto.getKontoOmanikuNimi();
    }

    @PutMapping("lesson4/account/{kontoNr}/deposit/{moneySum}")
    public String depositToAccount(@PathVariable("kontoNr") String kontoNr,
                                   @PathVariable("moneySum") int moneySum) {
        String lockCheckSql = "SELECT locked_status FROM accounts WHERE account_nr = :account_nr";
        HashMap<String, Object> paramMapCheck = new HashMap<>();
        paramMapCheck.put("account_nr", kontoNr);
        boolean ifLocked = jdbcTemplate.queryForObject(lockCheckSql, paramMapCheck, boolean.class);
        if (!ifLocked) {
            if (moneySum > 0) {
                String sql = "SELECT balance FROM accounts WHERE account_nr = :account_nr";
                HashMap<String, Object> paramMap = new HashMap<>();
                paramMap.put("account_nr", kontoNr);
                Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
                int newBalance = balance + moneySum;
                String sql2 = "UPDATE accounts SET balance = :newBalance WHERE account_nr = :account_nr";
                HashMap<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("account_nr", kontoNr);
                paramMap2.put("newBalance", newBalance);
                jdbcTemplate.update(sql2, paramMap2);

                String sql3 = "INSERT INTO history (account_nr, history) VALUES (:kontoNr, :history)";
                HashMap<String, Object> paramMap3 = new HashMap<>();
                paramMap3.put("kontoNr", kontoNr);
                paramMap3.put("history", moneySum);
                jdbcTemplate.update(sql3, paramMap3);

                return "Kontole " + kontoNr + " on lisatud " + moneySum
                        + " rahaühikut. Uus balanss on " + newBalance + ".";
            } else {
                return "Ülekantav summa peab olema positiivne number!";
            }
        } else {
            return "Konto lukustatud.";
        }
    }

    @PutMapping("lesson4/account/{kontoNr}/withdraw/{moneySum}")
    public String withdrawFromAccount(@PathVariable("kontoNr") String kontoNr,
                                      @PathVariable("moneySum") int moneySum) {
        String lockCheckSql = "SELECT locked_status FROM accounts WHERE account_nr = :account_nr";
        HashMap<String, Object> paramMapCheck = new HashMap<>();
        paramMapCheck.put("account_nr", kontoNr);
        boolean ifLocked = jdbcTemplate.queryForObject(lockCheckSql, paramMapCheck, boolean.class);
        String sql = "SELECT balance FROM accounts WHERE account_nr = :account_nr";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", kontoNr);
        Integer currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        if (!ifLocked) {
            if (moneySum < 0) {
                return "Ülekantav summa peab olema positiivne number!";
            } else if (currentBalance < moneySum) {
                return "Kontol pole piisavalt raha.";
            } else {
                int newBalance = currentBalance - moneySum;
                String sql2 = "UPDATE accounts SET balance = :newBalance WHERE account_nr = :account_nr";
                HashMap<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("account_nr", kontoNr);
                paramMap2.put("newBalance", newBalance);
                jdbcTemplate.update(sql2, paramMap2);

                String sql3 = "INSERT INTO history (account_nr, history) VALUES (:kontoNr, :history)";
                HashMap<String, Object> paramMap3 = new HashMap<>();
                paramMap3.put("kontoNr", kontoNr);
                paramMap3.put("history", -(moneySum));
                jdbcTemplate.update(sql3, paramMap3);

                return "Kontolt " + kontoNr + " ära kantud " + moneySum + " rahaühikut. Uus balanss on " + newBalance + ".";
            }
        } else {
            return "Konto lukustatud.";
        }
    }

    @PutMapping("lesson4/transfer/{kontoNrKust}/{moneySum}/{kontoNrKuhu}")
    public String transferFromToAccount(@PathVariable("kontoNrKust") String kontoNrKust, @PathVariable("kontoNrKuhu") String kontoNrKuhu, @PathVariable("moneySum") int moneySum) {
        String sql1 = "SELECT * FROM accounts WHERE account_nr = :kontoNrKust";
        HashMap<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("kontoNrKust", kontoNrKust);
        Account accountDto1 = jdbcTemplate.queryForObject(sql1, paramMap1, new AccountRowMapper());
        String sql2 = "SELECT * FROM accounts WHERE account_nr = :kontoNrKuhu";
        HashMap<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("kontoNrKuhu", kontoNrKuhu);
        Account accountDto2 = jdbcTemplate.queryForObject(sql2, paramMap2, new AccountRowMapper());
        if (!accountDto1.getKasLukustatud() && !accountDto2.getKasLukustatud()) {
            if (moneySum <= 0) {
                return "Ülekantav summa pea olema positiivne number!";
            } else if (accountDto1.getBalanss() < moneySum) {
                return "Kontol pole piisavalt raha.";
            } else {
                int newFromAccSum = accountDto1.getBalanss() - moneySum;
                String sql11 = "UPDATE accounts SET balance = :newFromAccSum WHERE account_nr = :kontoNrKust";
                HashMap<String, Object> paramMap11 = new HashMap<>();
                paramMap11.put("kontoNrKust", kontoNrKust);
                paramMap11.put("newFromAccSum", newFromAccSum);
                jdbcTemplate.update(sql11, paramMap11);

                String sql3 = "INSERT INTO history (account_nr, history) VALUES (:kontoNrKust, :history)";
                HashMap<String, Object> paramMap3 = new HashMap<>();
                paramMap3.put("kontoNrKust", kontoNrKust);
                paramMap3.put("history", -(moneySum));
                jdbcTemplate.update(sql3, paramMap3);

                int newToAccSum = accountDto2.getBalanss() + moneySum;
                String sql22 = "UPDATE accounts SET balance = :newToAccSum WHERE account_nr = :kontoNrKuhu";
                HashMap<String, Object> paramMap22 = new HashMap<>();
                paramMap22.put("kontoNrKuhu", kontoNrKuhu);
                paramMap22.put("newToAccSum", newToAccSum);
                jdbcTemplate.update(sql22, paramMap22);

                String sql4 = "INSERT INTO history (account_nr, history) VALUES (:kontoNrKuhu, :history)";
                HashMap<String, Object> paramMap4 = new HashMap<>();
                paramMap4.put("kontoNrKuhu", kontoNrKuhu);
                paramMap4.put("history", moneySum);
                jdbcTemplate.update(sql4, paramMap4);

                return "Kontolt " + kontoNrKust + " kanti üle " + moneySum + " rahaühikut kontole " + kontoNrKuhu + ".";
            }
        } else {
            return "Konto lukustatud.";
        }
    }

    @GetMapping("lesson4/accounts/{kontoNr}/history")
    public Object getAccountHistory(@PathVariable("kontoNr") String kontoNr) {
        String sql = "SELECT * FROM history WHERE account_nr = :kontoNr";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontoNr", kontoNr);
        List<AccHistory> accountDto = jdbcTemplate.query(sql, paramMap, new AccountsRowMapper());
//        if (accountDto.getKasLukustatud()) {
//            System.out.println("Konto on lukustatud.");
//        }
        return accountDto;
    }

    @GetMapping("lesson4/accounts/history")
    public List<AccHistory> getHistory() {
        String sql = "SELECT * FROM history";
        HashMap<String, Object> paramMap = new HashMap<>();
        List<AccHistory> result = jdbcTemplate.query(sql, paramMap, new AccountsRowMapper());
        return result;
    }

    private class AccountsRowMapper implements RowMapper<AccHistory> {

        @Override
        public AccHistory mapRow(ResultSet resultSet, int i) throws SQLException {
            AccHistory result = new AccHistory();
            result.setKontoNr(resultSet.getString("account_nr"));
            result.setHistory(resultSet.getInt("history"));
            return result;
        }
    }



}
