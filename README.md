# tobuyns
我想买一台Nintendo Switch


2018-04-09  实现bebetter、user应用相关接口
1.bebetterme

1.1分页查询每日报告信息(GET)
http://localhost:8080/tobuyns/bebetterme/getReportsByPageIndex?pageIndex=1

1.2新增报告(POST)
http://localhost:8080/tobuyns/bebetterme/saveReport
{
    "cola": 1,
    "fattyfood": 1,
    "snacks": 1,
    "badword": 1,
    "complain": 1,
    "stayuplate": 1,
    "readbook": 1,
    "learnskills": 1,
    "developskills": 1,
    "running": 10.3,
    "keep": 1,
    "breakfast": 1,
    "lunch": 1,
    "otherfood": 1
}


1.3根据id删除报告(DELETE)

http://localhost:8080/tobuyns/bebetterme/deleteReport?id=106


1.4修改报告(POST)
http://localhost:8080/tobuyns/bebetterme/updateReport
{
    "id":108,
    "cola": 0,
    "fattyfood": 1,
    "snacks": 1,
    "badword": 1,
    "complain": 1,
    "stayuplate": 1,
    "readbook": 1,
    "learnskills": 1,
    "developskills": 1,
    "running": 0,
    "keep": 1,
    "breakfast": 1,
    "lunch": 1,
    "otherfood": 1
}

1.5根据id查询报告(GET)
http://localhost:8080/tobuyns/bebetterme/findReportById?id=108



2.user
2.1分页查询所有用户信息(GET)
http://localhost:8080/tobuyns/user/getUsersByPageIndex?pageIndex=1

2.2新增用户信息(POST)
http://localhost:8080/tobuyns/user/saveUser

{
    "userName": "gmluo@126.com",
    "password": "11111",
    "email": "gmluo@126.com",
    "birthday": "2018-01-11",
    "gender": 1
}


2.3根据id删除用户信息(DELETE)
http://localhost:8080/tobuyns/user/deleteUser?id=82

2.4修改用户信息(POST)
http://localhost:8080/tobuyns/user/updateUser

{
    "id": 83,
    "userName": "111gmluo@126.com",
    "password": "11111",
    "email": "gmluo@126.com",
    "birthday": "2018-01-11",
    "gender": 1
}

2.5根据id查询用户信息(GET)
http://localhost:8080/tobuyns/user/findUserById?id=83












