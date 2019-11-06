def cal_area(a, b, c):
    semi_perimetro = (a + b + c) / 2
    p = semi_perimetro
    s = (p*(p-a)*(p-b)*(p-c))**(1/2)
    return s

def calcular(a, b, c):
    if((a < b + c) & (b < a + c) & (c < a + b)):
        result = 'Os valores informados formam um triângulo de área igual a %s %s!' % (cal_area(a, b, c), unidade)
    else:
        result = 'Os valores informados não formam um triângulo !'
    return result

print()
print()
print('VALIDADOR DE TRIÂNGULO')
a = int(input('Insira o primeiro valor: '))
b = int(input('Insira o segundo valor: '))
c = int(input('Insira o terceiro valor: '))
unidade = input('Qual a unidade de medida informada? \n')

resposta = calcular(a, b, c)

print()
print()
print()

print('***********************************')
print()
print(resposta)
print()
print('***********************************')