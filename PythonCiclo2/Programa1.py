#Faça um programa que leia a idade de uma pessoa expressa em dias e
#mostre-a expressa em anos, meses e dias.

from datetime import datetime, timedelta

print()
print()
diasIdade = input('Informe sua idade em número de dias desde que nasceu: ')

data_atual = datetime.today()
data_nascimento = data_atual - timedelta(days=int(diasIdade))

def calcAnos(data_nascimento):
    anos_de_diferenca = data_atual.year - data_nascimento.year
    if(data_atual.month < data_nascimento.month):
        anos_de_diferenca -= 1
    elif(data_atual.month == data_nascimento.month):
        if(data_atual.day < data_nascimento.day):
            anos_de_diferenca -= 1
    return anos_de_diferenca

def calcMeses(data_nascimento):
    meses_de_diferenca = abs(data_atual.month - data_nascimento.month)
    if((data_atual.month > data_nascimento.month) & (data_atual.day < data_nascimento.day)):
        meses_de_diferenca -= 1
    elif((data_atual.month == data_nascimento.month) & (data_atual.day < data_nascimento.day)):
        meses_de_diferenca = 11
    elif(data_atual.month < data_nascimento.month):
        meses_de_diferenca = abs(12 - meses_de_diferenca)
        if(data_atual.day < data_nascimento.day):
            meses_de_diferenca -= 1
    return meses_de_diferenca

def calcDias(data_nascimento):
    dias_de_diferenca = abs((data_atual - data_atual.replace(day=data_nascimento.day)).days)
    mes_antecedente = data_atual.replace(day=data_nascimento.day, month=(data_atual.month - 1))
    if(data_atual.month > data_nascimento.month):
        if(data_atual.day < data_nascimento.day):
            dias_de_diferenca = abs((data_atual - mes_antecedente).days)
    elif(data_atual.month <= data_nascimento.month):
        if(data_atual.day == data_nascimento.day):
            dias_de_diferenca = 0
        elif(data_atual.day < data_nascimento.day):
            dias_de_diferenca = abs((data_atual - mes_antecedente).days)
    return dias_de_diferenca

anos = calcAnos(data_nascimento)
meses = calcMeses(data_nascimento)
dias = calcDias(data_nascimento)

print()
print()

print('*************************************')

print()
print()

print('Você possui ' + str(anos) + ' anos, ' + str(meses) + ' meses, ' + str(dias) + ' dias')
print('Você nasceu em ' + str(data_nascimento.day) + ' / ' + str(data_nascimento.month) + ' / ' + str(data_nascimento.year))


print()
print()

print('*************************************')

print()
print()
