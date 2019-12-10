import wx
import pymysql


class JanelaImc(wx.Frame):
    def __init__(self):
        super(JanelaImc, self).__init__(None, -1, 'Cálculo do IMC - Índice de Massa Corporal', size=(560, 250))

        self.nome = None
        self.endereco = None
        self.altura = None
        self.peso = None
        self.result = None

        self.panel = wx.Panel(self)
        self.panel.SetBackgroundColour('#99ff99')

        self.painel_resposta = wx.Panel(self.panel, -1, pos=(195, 70), size=(335, 100), style=wx.BORDER_DOUBLE)
        self.painel_resposta.SetBackgroundColour('#ffffff')

        l_nome = wx.StaticText(self.panel, -1, 'Nome do Paciente: ', pos=(5, 15), name='id_nome')
        l_endereco = wx.StaticText(self.panel, -1, 'Endereço Completo: ', pos=(5, 45), name='id_endereco')
        l_altura = wx.StaticText(self.panel, -1, 'Altura(cm): ', pos=(5, 75), name='id_altura')
        l_peso = wx.StaticText(self.panel, -1, 'Peso(Kg): ', pos=(5, 105), name='id_peso')

        self.campo_nome = wx.TextCtrl(self.panel, pos=(130, 10), size=(400, 25))
        self.campo_endereco = wx.TextCtrl(self.panel, pos=(130, 40), size=(400, 25))
        self.campo_altura = wx.TextCtrl(self.panel, pos=(130, 70), size=(50, 25))
        self.campo_peso = wx.TextCtrl(self.panel, pos=(130, 100), size=(50, 25))

        self.result = 'RESULTADO'

        self.resposta = wx.StaticText(self.painel_resposta, -1, self.result, size=(335, 100), style=wx.ALIGN_CENTER_HORIZONTAL)

        calcula = wx.Button(self.panel, 1, label='Calcular', pos=(130, 175))
        reinicia = wx.Button(self.panel, 2, label='Reiniciar', pos=(230, 175))
        historico = wx.Button(self.panel, 4, label='Historico', pos=(330, 175))
        sai = wx.Button(self.panel, 3, label='Sair', pos=(444, 175))

        calcula.Bind(wx.EVT_BUTTON, self.processar, id=1)
        reinicia.Bind(wx.EVT_BUTTON, self.resset, id=2)
        sai.Bind(wx.EVT_BUTTON, self.on_quit, id=3)
        historico.Bind(wx.EVT_BUTTON, self.exibir, id=4)

        self.Center()
        self.Show(True)

    @classmethod
    def calcular_IMC(self, altura, massa):
        altura /= 100
        return massa/(altura*altura)

    @classmethod
    def calcular_situacao(self, imc):
        if imc < 17:
            return 'Muito abaixo do peso'
        elif (imc >= 17) & (imc <= 18.49):
            return 'Abaixo do peso'
        elif (imc >= 18.50) & (imc <= 24.99):
            return 'Peso normal'
        elif (imc >= 25.00) & (imc <= 29.99):
            return 'Acima do peso'
        elif (imc >= 30.00) & (imc <= 34.99):
            return 'Obesidade I'
        elif (imc >= 35.000) & (imc <= 39.99):
            return 'Obesidade II (severa)'
        elif imc >= 40:
            return 'Obesidade III (mórbida)'

    @classmethod
    def responder(self, imc, situacao):
        return '\n  Resultado \n\n  IMC: %.2f \n  CONDIÇÃO: %s' % (imc, situacao)

    def on_quit(self, e):
        self.Close()

    def processar(self, e):
        self.nome = self.campo_nome.GetValue()
        self.endereco = self.campo_endereco.GetValue()
        self.altura = float(self.campo_altura.GetValue())
        self.peso = float(self.campo_peso.GetValue())

        imc = self.calcular_IMC(self.altura, self.peso)
        self.result = self.responder(imc, self.calcular_situacao(imc))
        self.resposta.SetLabel(self.result)
        sql = "INSERT INTO registros (nome, endereco, altura, peso, imc, situacao) VALUES (%s,%s,%s,%s,%s,%s)"
        cursor.execute(sql,
                       (self.nome, self.endereco, self.altura, self.peso, imc, self.calcular_situacao(imc)))
        conexao.commit()

    def resset(self, e):
        self.resposta.SetLabel('RESULTADO')
        self.campo_altura.SetLabel('')
        self.campo_peso.SetLabel('')

    def exibir(self, e):
        frame = JanelaRegistro()
        frame.Show()

class JanelaRegistro(wx.Frame):
    def __init__(self):
        super(JanelaRegistro, self).__init__(None, -1, 'Histórico de Consultas ao IMC', size=(560, 560))
        self.panel = wx.Panel(self)
        tmp = ""
        sql = "SELECT nome, altura, peso, imc, situacao FROM registros"
        cursor.execute(sql)

        for valor in cursor.fetchall():
            tmp += "%s => Altura: %d Peso: %.0f IMC: %.2f -- %s \n\r \n\r" % \
                  (valor[0], valor[1], valor[2], valor[3], valor[4])

        self.registro_linha = wx.TextCtrl(self.panel, -1, tmp, style=wx.TE_MULTILINE, size=(550, 525))

        self.Center()
        self.Show(True)


def main():
    app = wx.App()
    frame = JanelaImc()
    frame.Show()
    app.MainLoop()


# Abrindo conexão com banco de dados:
conexao = pymysql.connect(db='imc', user='imc', passwd='123456')

# Cria um cursor:
cursor = conexao.cursor()

main()
conexao.close()





