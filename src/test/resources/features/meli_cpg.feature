#language: pt
Funcionalidade: Validar experiência de supermercado

	Como um usuário
	Gostaria ter a experiencia de supermercado ao comprar pelo marketplace

	Cenário: Deve aparcer a barra de intervenção
		Dado que estou acessando a aplicação não logado
		Quando faço uma busca por "arroz"
		Então visualizo o componente de intervenção com titulo "Compre em Supermercado" e link "Ir para o Supermercado" para home de super

