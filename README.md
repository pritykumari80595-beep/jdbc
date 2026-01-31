mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| college            |
| hotel              |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
6 rows in set (0.17 sec)

mysql> use hotel;
Database changed
mysql> show tables;
+-----------------+
| Tables_in_hotel |
+-----------------+
| guest           |
+-----------------+
1 row in set (0.06 sec)

mysql> select * from guest;
+-------+-----------+------------+-----------+---------------------+
| regid | Guestname | contactno  | Address   | created_at          |
+-------+-----------+------------+-----------+---------------------+
|     1 | ram       | 8899977665 | Bihar     | 2026-01-31 08:29:16 |
|     2 | Ruhi      | 9999977665 | Jharkhand | 2026-01-31 08:29:45 |
|     3 | Amit      | 9933977665 | Patna     | 2026-01-31 08:30:33 |
|     4 | Aditya    | 9229977665 | Kanpur    | 2026-01-31 08:31:29 |
|     5 | Shourya   | 9229979965 | UP        | 2026-01-31 08:32:15 |
+-------+-----------+------------+-----------+---------------------+
5 rows in set (0.06 sec)
