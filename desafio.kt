enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO, EXPERT, GALAXYONE }

data class Usuario(val id:Int, val nome:String, val email:String? = null, val idade: Int = 0)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("${usuario.nome} já está matriculado na formação '$nome'.")
        } else {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado com sucesso na formação '$nome'.")
        }
    }
}

fun main() {
    
    val gitHub = ConteudoEducacional("Fundamentos de GitHub", 40)
    val kotlin = ConteudoEducacional("Kotlin Básico", 30)
    val poo = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val android = ConteudoEducacional("Fundamentos de Android", 100)
    
     // Criando uma formação
    val formacaoAndroid = Formacao(
        nome = "Formação Android Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(gitHub, kotlin, poo, android)
    )
    
    val formacaoGitHub = Formacao(
        nome = "Formação Git Hub das Galaxias",
        nivel = Nivel.GALAXYONE,
        conteudos = listOf(gitHub, kotlin, android)
    )
    
    // Criando usuários (alunos)
    val aluno1 = Usuario(1, "Belarmino", "belarmino@bnms.com.br", 10)
    val aluno2 = Usuario(2, "Nicolau", "nicolau@bnms.com.br", 20)
    val aluno3 = Usuario(3, "Monteiro", "monteiro@bnms.com.br", 30)
    val aluno4 = Usuario(4, "Simão", "simao@bnms.com.br", 40)

    // Simulando matrículas
    formacaoAndroid.matricular(aluno1)
    formacaoGitHub.matricular(aluno1)
    formacaoAndroid.matricular(aluno2) // teste duplicado
    formacaoAndroid.matricular(aluno2) // teste duplicado
    formacaoAndroid.matricular(aluno1) 
    formacaoAndroid.matricular(aluno3)
    formacaoAndroid.matricular(aluno4)
    formacaoGitHub.matricular(aluno4)

    // Exibindo resultados
    println("\nFormação: ${formacaoAndroid.nome}")
    println("Nível: ${formacaoAndroid.nivel}")
    println("Conteúdos:")
    formacaoAndroid.conteudos.forEach { println(" - ${it.nome} (${it.duracao} min)") }
    println("\nAlunos matriculados:")
    formacaoAndroid.inscritos.forEach { println(" - ${it.nome}") }
    println("\nFormação: ${formacaoGitHub.nome}")
    println("Nível: ${formacaoGitHub.nivel}")
    println("Conteúdos:")
    formacaoGitHub.conteudos.forEach { println(" - ${it.nome} (${it.duracao} min)") }
    println("\nAlunos matriculados:")
    formacaoGitHub.inscritos.forEach { println(" - ${it.nome}") }
}