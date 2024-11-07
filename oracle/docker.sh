docker run -d -p 1521:1521 -e ORACLE_PASSWORD=oracle -v $PWD/sql:/mnt/sql --name=oracle gvenzl/oracle-free
docker exec -it oracle bash -c "/opt/oracle/product/23ai/dbhomeFree/bin/sqlplus system/oracle @/mnt/sql/co_install.sql"
