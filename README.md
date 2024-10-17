# multitenant-ro-rw

Demonstration project for showing how to use annotations to select a tenant in Quarkus REST.

First install a postgres database and configure it:

```shell script
$ sudo apt install postgresql-16
$ sudo su - postgres
$ createuser -P quarkus
Enter password for new role: quarkus
Enter it again: quarkus
$ createdb --owner quarkus --encoding=utf8 multitenant
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

## Testing

This endpoint will use the read-only database connection to read the number of entities: http://localhost:8080/read-only/read

This endpoint will use the read-only database connection to write, and will cause an exception: http://localhost:8080/read-only/write

This endpoint will use the read-write database connection to read the number of entities: http://localhost:8080/read-write/read

This endpoint will use the read-write database connection to add an entity: http://localhost:8080/read-write/write
