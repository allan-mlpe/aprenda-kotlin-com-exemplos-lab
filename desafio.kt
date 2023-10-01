enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.BASICO)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach { inscritos.add(it) }
    }
    
    infix fun possuiMatriculaDe(usuario: Usuario) : Boolean {
        return inscritos.contains(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("Joca")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("João")
    
    val portugol = ConteudoEducacional("Lógica de Programação")
    val java = ConteudoEducacional(nome = "Introdução a OO", nivel = Nivel.INTERMEDIARIO)
    val kotlin = ConteudoEducacional("Programação assíncrona", 120, Nivel.AVANCADO)
    
    val conteudos = listOf(portugol, java, kotlin)
    
    val formacao = Formacao("Linguagens da JVM", conteudos)
    
    formacao.matricular(usuario1, usuario2)
    
    println(formacao)
    
    println(formacao possuiMatriculaDe usuario1)
    println(formacao possuiMatriculaDe usuario2)
    println(formacao possuiMatriculaDe usuario3)
}
