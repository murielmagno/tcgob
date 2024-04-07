package tcgob.enums;

import lombok.Getter;

@Getter
public enum EnumTitulos {

    BENEMERITO(25, "Benemérito da Ordem", "<p>É com grande alegria que lhe parabenizamos por alcançar o prestigioso título de Benemérito após 25 anos de dedicação à sua Oficina!</p>\n <p>Sua longa e distinta carreira maçônica é uma fonte de orgulho para todos nós, e sua devoção à Ordem é verdadeiramente digna de reconhecimento.</p>\n<p>Seu legado na Maçonaria é imensurável, e suas contribuições ao longo dos anos ajudaram a moldar e fortalecer nossa instituição.</p>\n<p>Que esta honra seja um reflexo do seu comprometimento e sacrifício pela causa maçônica, e que inspire outros a seguir seus nobres passos.</p>\n<p>Que o Grande Arquiteto do Universo continue a abençoá-lo ricamente em sua jornada maçônica.</p>\n"),
    GRANDE_BENEMERITO(30, "Grande Benemérito da Ordem", "<p>É com grande alegria que lhe parabenizamos por alcançar o prestigioso título de Grande Benemérito da Ordem após 30 anos de dedicado serviço à sua Oficina!</p>\nSeu comprometimento e lealdade ao longo dos anos são um testemunho do seu profundo amor pela Maçonaria e seus ideais.</p>\n<p>Sua contribuição para o enriquecimento da nossa Ordem é inestimável, e sua sabedoria e experiência são fontes de inspiração para todos nós.</p>\n<p>Que sua jornada maçônica continue a ser repleta de sucesso, realização e crescimento pessoal.</p>\n<p>Que a Luz do Grande Arquiteto do Universo continue a iluminar seu caminho e guiar seus passos.</p>\n"),
    ESTRELA_DA_DISTINCAO(35, "Estrela da Distinção Maçônica", " É com grande alegria que lhe parabenizamos por alcançar o prestigioso título de Estrela da Distinção Maçônica após 35 anos de dedicado serviço à sua Oficina!</p>\nSua dedicação e comprometimento ao longo dos anos são um exemplo para todos nós, inspirando-nos a alcançar novos patamares de excelência maçônica.</p>\n<p>Sua jornada maçônica é marcada por inúmeras realizações e contribuições significativas para o bem da Ordem e da humanidade.</p>\n<p>Que sua estrela continue a brilhar intensamente, iluminando o caminho daqueles que buscam a verdade e a justiça.</p>\n<p>Que o Grande Arquiteto do Universo continue a abençoá-lo em sua jornada maçônica.</p>\n"),
    CRUZ_DA_PERFEICAO(40, "Cruz da Perfeição Maçônica", "É com grande alegria que lhe parabenizamos por alcançar o prestigioso título de Cruz da Perfeição Maçônica após 40 anos de dedicado serviço à sua Oficina!</p>\nSua jornada maçônica é uma história de excelência e comprometimento, marcada por inúmeras contribuições para o fortalecimento e crescimento da Ordem.</p>\n<p>Sua busca pela perfeição maçônica é verdadeiramente admirável, e sua sabedoria e experiência são fontes de inspiração para todos nós.</p>\n<p>Que sua cruz continue a ser um símbolo de sua dedicação e devoção à Maçonaria, e que seu exemplo inspire outros a seguir seus passos.</p>\n<p>Que o Grande Arquiteto do Universo continue a guiá-lo e abençoá-lo em sua jornada.</p>\n"),
    ORDEM_DO_MERITO_D_PEDRO_I(45, "Comenda da Ordem do Mérito de D. Pedro I", "É com grande alegria e honra que lhe parabenizamos por alcançar o prestigioso título da Comenda da Ordem do Mérito de D. Pedro I após 50 anos de fiel e dedicado serviço à sua Oficina!</p>\nSua longa e distinta carreira maçônica é uma fonte de orgulho para todos nós, e sua devoção à Ordem é verdadeiramente digna de reconhecimento.</p>\n<p>Seu legado na Maçonaria é imensurável, e suas contribuições ao longo dos anos ajudaram a moldar e fortalecer nossa instituição.</p>\n<p>Que esta honra seja um reflexo do seu comprometimento e sacrifício pela causa maçônica, e que inspire outros a seguir seus nobres passos.</p>\n<p>Que o Grande Arquiteto do Universo continue a abençoá-lo ricamente em sua jornada maçônica.</p>\n");

    private final int anos;
    private final String descricao;
    private final String mensagem;

    EnumTitulos(int anos, String descricao, String mensagem) {
        this.anos = anos;
        this.descricao = descricao;
        this.mensagem = mensagem;
    }

}