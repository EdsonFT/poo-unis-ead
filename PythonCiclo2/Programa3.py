print()
print()
print('Informa o menor dos números')
print()

a = int(input('Insira o primeiro valor: '))
b = int(input('Insira o segundo valor: '))
c = int(input('Insira o terceiro valor: '))

lista = [a, b, c]

lista.sort()

resposta = '%d é menor valor!' % (lista.pop(0))

print()
print()
print()

print('***********************************')
print()
print(resposta)
print()
print('***********************************')
