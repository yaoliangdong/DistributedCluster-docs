/app/software/mysql-group/NDB_MGMD/bin/ndb_mgmd --configdir=/app/software/mysql-group/NDB_MGMD -f /app/software/mysql-group/NDB_MGMD/config.ini

/app/software/mysql-group/MYSQLD-8001/bin/ndbd
/app/software/mysql-group/MYSQLD-8001/bin/ndbd

/app/software/mysql-group/MYSQLD-8001/support-files/mysql.server start
/app/software/mysql-group/MYSQLD-8002/support-files/mysql.server start
