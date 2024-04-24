# Projeto Marvel Teste

Este é um projeto que consiste na utilização da API Marvel (https://developer.marvel.com/documentation/getting_started), utilizando a chamada de personagens (Characters).

## Descrição

O projeto foi pensado para ser de fácil manutenção. A estrutura do projeto consiste em várias pastas, cada uma com um propósito específico:

Pasta Repository: Define uma interface CharactersRepository para obter quadrinhos e fornece uma implementação concreta CharactersRepositoryImpl utilizando uma fonte de dados CharactersDataSource. Isso promove modularidade e desacoplamento no código, facilitando a substituição de implementações sem afetar o código cliente.

Pasta Response: Contém uma classe responsável por obter quadrinhos de uma API externa e convertê-los para um formato utilizável internamente no aplicativo. O uso de um fluxo (Flow) com operações assíncronas, onde os personagens (characters) são emitidos conforme disponíveis.

Pasta Usecase: Encapsula a lógica de obtenção de personagens (characters) em um caso de uso (UseCase), seguindo o princípio de responsabilidade única. Para tornar o código organizado, modular e fácil de testar, com a lógica de negócios isolada em um único componente.

Pasta Model e Mappers: A pasta Model define parâmetros como imagem, título e subtítulo. O Mapper converte uma instância de ResultModel em uma instância de Character (personagens), como parte de um processo de mapeamento de dados na aplicação.

Pasta Di: Configura a aplicação para utilizar a injeção de dependências com o Koin, fornecendo implementações específicas para os diferentes componentes da arquitetura, como casos de uso, repositórios e fontes de dados, além de configurar a comunicação com a API utilizando Retrofit. O uso do Koin facilita a configuração da injeção de dependências na aplicação, enquanto o Retrofit simplifica o consumo de APIs, permitindo que o desenvolvedor se concentre mais na lógica de negócios da aplicação, em vez de lidar com detalhes de implementação de baixo nível. Ambas as bibliotecas contribuem para um código mais limpo, modular e fácil de manter.

Pasta Domain (UseCase): Encapsula a lógica de negócios relacionada à obtenção de personagens da API. A interface CharactersUseCase define um contrato para esta funcionalidade, enquanto a classe GetCharactersUseCaseImpl implementa essa funcionalidade, utilizando o repositório de personagens (CharactersRepository) para obter os dados.

## Instalação

Pasta Presentation (Scenes): Apresenta as telas da aplicação utilizando a Main como ponto de partida seguindo os Fragments em arquitetura MVVM, que utiliza componentes do Jetpack Android, sendo eles LiveData, ViewModel, Data Binding e Navigation.

## Uso

A aplicação foi pensada para ser simples, sem muita poluição ou informação na tela, sendo objetiva em mostrar a lista e, ao selecionar o item da lista, mostrar os detalhes de forma intuitiva, como a breve mensagem de saudação e uma descrição do que o usuário irá encontrar e logo em seguida fornecendo a lista. A tela de detalhe do personagem inicialmente fiz um projeto de UI/UX que vou fornecer aqui (https://www.canva.com/design/DAGDAEfSSr4/kbvoIe22v4XpktFaqnk97A/edit), porém por contratempos não pude realizar como planejei.

## Adendos

Recomendo o uso de celular para rodar, o emulador virtual que o android fornece vaza as fotos de suas bordas porem isso não ocorro em dispositivos fisicos.
O projeto deveria ter uma branch master e dela vir branches com partes separadas do código e commits especificando se é uma fix, chore, feat ou refactor, porém com problemas internos do meu setup, não pude organizar melhor.
Esse projeto não contém testes unitários por contratempos pessoais e devido a falhas do meu setup que atrapalharam a entrega no prazo.

## Contato

Email: lya.freire0607@gmail.com
Linkedin: https://www.linkedin.com/in/lyandra-freire-7456a8176/
