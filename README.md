# kotlin-spring-security

## Request Login

```
POST http://localhost:8080/login
```

```
{
	"user": "diego@teste.com",
	"password": "123456"
}
```
## Response Login
```
Header Authorization : Barear eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWVnb0B0ZXN0ZS5jb20iLCJyb2xlIjpbeyJpZCI6MSwibmFtZSI6IlJFQUQiLCJhdXRob3JpdHkiOiJSRUFEIn0seyJpZCI6MiwibmFtZSI6IkFETSIsImF1dGhvcml0eSI6IkFETSJ9XSwiZXhwIjoxNjQ0Mjc2NzkxfQ.qTblg-G-K1AbqMiyWXTIa6St2TPBmm2XxfVIJwNMWgYCVTCUzz35H5ICYe6dfSprMEftdpI6hX_BGxBeQQ5zJg
```

## Request Users
```
POST http://localhost:8080/users
Header Authorization : Barear eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWVnb0B0ZXN0ZS5jb20iLCJyb2xlIjpbeyJpZCI6MSwibmFtZSI6IlJFQUQiLCJhdXRob3JpdHkiOiJSRUFEIn0seyJpZCI6MiwibmFtZSI6IkFETSIsImF1dGhvcml0eSI6IkFETSJ9XSwiZXhwIjoxNjQ0Mjc2NzkxfQ.qTblg-G-K1AbqMiyWXTIa6St2TPBmm2XxfVIJwNMWgYCVTCUzz35H5ICYe6dfSprMEftdpI6hX_BGxBeQQ5zJg
```

## Response Users
```
{
	"name": "Diego",
	"email": "diego@teste.com"
}
```