# PyBlog App

```make
1) venv\Scripts\activate.bat
2) python manage.py startapp blog
3) python manage.py startapp single_pages
```

## blog/models.py

```python
from django.db import models

class Post(models.Model):
  title = models.CharField(max_length = 30)
  content = models.TextField()
  
  created_at = models.DateTimeField()
```

## Apply Post Model

```make
python manage.py makemigrations
```

## settings.py

```make
~~~~
INSTALLED_APPS = [
  'django.contrib.admin',
  ~~~~,
  'blog',
  'single_pages'
]
```

## Re-Apply Post Model

```make
python manage.py makemigrations

실제 DB에 적용하기 위해선

python manage.py migrate
```

## Modify .gitignore

```make
migrations/ 추가
```

## blog/admin.py

```python
from django.db import models
from .models import Post

admin.site.register(Post)

class Post(models.Model):
  title = models.CharField(max_length = 30)
  content = models.TextField()
  
  created_at = models.DateTimeField()
```

## Timing (settings.py)

```make
LANGUAGE_CODE = 'en-us'
TIME_ZONE = 'Asia/Seoul'
...
USE_TZ = False
```

## When change model

```make
python manage.py makemigrations
python manage.py migrate
python manage.py runserver
```
