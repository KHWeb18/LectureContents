# Create GitHub Space

```make
먼저 깃헙 저장소를 만들도록 합니다.
new를 누르고 저장소를 적당히 만들어줍니다.
Repo이름을 적당히 지정하고 public, README 체크, gitignore에 Python 설정을 하고 생성합니다.

다음으로 터미널을 켜서 d 드라이브로 이동합니다.
mkdir github
cd github
git clone repo만든URL
```

# PyCharm Environment Setting

```make
1) PyCharm을 실행하고 File > Open을 클릭하고 앞서 다운 받은 깃을 연결한다.
2) File > Settings를 클릭하고 Project: 프로젝트폴더명 > Python Interpreter를 클릭하고 Add를 누른다.
3) C:\Users\user2\anaconda3\python.exe 를 선택하도록 한다.
4) Apply 이후 OK를 누른다.
5) gitignore 파일을 열고 적당히 아무대나 venv/ 를 입력한다.
```

# 가상 환경에서 실행하기

```make
1) 프로젝트 위치로 이동한다.
2) venv/Scripts/activate.bat # 가상 환경 실행
3) pip list
4) deactivate # 가상 환경 종료
```

# Django Install

```make
1) pip install django
2) pip list
3) Check django version >= 3.0
```
