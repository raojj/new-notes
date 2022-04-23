```python
import openpyxl
from openpyxl.utils import get_column_letter, column_index_from_string
# 使用在包里的Excel文件
wb = openpyxl.load_workbook('example.xlsx')

# getting sheets of the workbook
# way1
print(wb.sheetnames)
# way2
for sheet in wb:
    print(sheet)

# creat sheet
wb.create_sheet('成员')
print(wb.sheetnames)

# 指定特定的表单
sheet1 = wb.get_sheet_by_name('学校')
sheet2 = wb['学院']

# getting cells from sheet
ws = wb.active
print(ws)
print(ws['A1'].value)
b=ws['B1']
print('Row{}, Column{} is {}'.format(b.row,b.column,b.value))
print('cell {} is {}'.format(b.coordinate, b.value))
print(ws.cell(row=1,column=1).value)

# 打印某一行或者某一列
for i in range(1,12):
    print(i,ws.cell(row=i,column=2).value)
colB = ws['B']
# 不能通过这种方式打印内容，colB为tuple
print(colB)
# colB[2] 为B3的内容
print(colB[2].value)
col_range=ws['A:B']
row_range=ws[1:12]
for col in col_range:
    for cell in col:
        print(cell.value)
for row in row_range:
    for cell in row:
        print(cell.value)
# 按行打印
for row in ws.iter_rows(min_row=1,max_row=12,max_col=2):
    for cell in row:
        print(cell.value)
# 通过单元格访问
cell_range = ws['A1:B12']
for rowOfCellObjects in cell_range:
    for cellOBj in rowOfCellObjects:
        print(cellOBj.coordinate,cellOBj.value)
    print('_________end_________')
# 输出表格有多少行多少列
print('{} * {}'.format(ws.max_row, ws.max_column))
# 将数字转化为字母编号
print(get_column_letter(47))
# 将自字母编号转化为数字
print(column_index_from_string('AAA'))

```



