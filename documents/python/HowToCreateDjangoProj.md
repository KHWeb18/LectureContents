# Create Django Project

```make
0) 프로젝트 위치로 이동
1) 가상환경 실행
2) django-admin startproject django_proj .
3) ls
```

# How to run Django Server

```make
1) python manage.py runserver
2) ImportError: DLL load failed while importing _sqlite3
3) https://www.sqlite.org/download.html로 이동
4) sqlite-dll-win64-x64-3360000.zip 다운로드
5) C:\Users\user2\anaconda3\DLLs에 다운 받은 내용 압축 해제
6) python manage.py migrate
7) ls를 하면 db.sqlite3를 볼 수 있음
8) python manage.py runserver
9) http://127.0.0.1:8000/
```

# How to create Admin Account

```make
1) python manage.py createsuperuser
2) username:
3) password:
4) password(again):
5) python manage.py runserver
6) http://127.0.0.1:8000/admin/
7) 접속해서 users를 보면 가입 아이디가 보임
```

# Pycharm Based Commit

```make
1) Pycharm Setting 열기
2) Language & Frameworks 누름
3) Django 클릭
4) Enable Django Support 체크
5) Django Project root 설정
6) Settings에 프로젝트 루트 내부의 settings.py 배치
```
