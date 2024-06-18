package pl.matiz22.cocktailapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform