def testarPrimo(valor):
    if(valor%2 == 0 & valor != 2):
        return 'falso'
    elif(valor == 2):
        return 'verdadeiro'
    else:
        v = int(round(valor/2, 0))
        for i in range(2, v):
            if(valor % i == 0):
                return 'falso'
        return 'verdadeiro'


for key, value in enumerate(range(1,101)):
    print('O número =>',1+key,'é', testarPrimo(value))

print()


print('Verdadeiro para primo')
print('Falso para não primo')
print()
