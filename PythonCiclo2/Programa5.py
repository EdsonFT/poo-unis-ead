print()
frase = input('Informe a frase para a reversão: ')

lista = frase.split()

result = ''
for i in lista:
    result += ' ' + i[::-1]
result = str(result)

print()
print('***************************')
print(' A nova frase é ... ')
print(result)
print('***************************')