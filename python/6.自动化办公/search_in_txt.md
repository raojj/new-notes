```python
# -*- codeing = utf-8 -*-
# @Time : 2022/4/22 19:30
# @Author : RaoJian
# @File : search_in_txt.py
# @Software : PyCharm
import openpyxl

wb = openpyxl.load_workbook('example.xlsx')
sheet = wb['小组']

with open('C:/Users/LENOVO/Desktop/rj/before/论文/开题报告/开二/1.txt',mode='r') as f:
    text=f.read()
# 将文本内容按照“.”分割，并储存在列表中
text = text.replace('\n','').split('.')

def main():
    search_in_text("functional",text)

def search_in_text(key,text):
    i=0
    for sentence in text:
        if key in sentence:
            i = i + 1
            sheet.cell(row=i, column=1, value=sentence)


# 程序执行入口
if __name__ == "__main__":
    main()
    wb.save(filename='example.xlsx')
```

